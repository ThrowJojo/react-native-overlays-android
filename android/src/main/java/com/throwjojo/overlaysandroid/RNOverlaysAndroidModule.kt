package com.throwjojo.overlaysandroid

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.util.Log
import com.facebook.react.bridge.*

class RNOverlaysAndroidModule : ReactContextBaseJavaModule, ActivityEventListener {

    val reactContext: ReactApplicationContext
    val REQUEST_CODE_OVERLAYS = 239232
    var permissionPromise: Promise? = null

    constructor(reactContext: ReactApplicationContext) : super(reactContext) {
        this.reactContext = reactContext
        this.reactContext.addActivityEventListener(this)
    }

    @ReactMethod
    fun requestOverlayPermissions(promise: Promise) {
        if (overlaysGranted()) {
            promise.resolve(true)
        } else {
            permissionPromise = promise
            val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:${reactContext.packageName}"))
            reactContext.startActivityForResult(intent, REQUEST_CODE_OVERLAYS, null)
        }
    }

    @ReactMethod
    fun overlaysGranted(promise: Promise) {
        promise.resolve(overlaysGranted())
    }

    fun overlaysGranted(): Boolean {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) Settings.canDrawOverlays(reactContext) else true
    }

    override fun onActivityResult(activity: Activity?, requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_OVERLAYS) {
            permissionPromise?.resolve(overlaysGranted())
            permissionPromise = null
        }
    }

    override fun onNewIntent(intent: Intent?) {}

    override fun getName(): String {
        return "RNOverlaysAndroid"
    }

}