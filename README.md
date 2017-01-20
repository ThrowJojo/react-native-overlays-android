
# react-native-overlays-android

Just a library to request permissions for drawing overlays in Android. 

## Getting started

`$ npm install react-native-overlays-android --save`

### Automatic installation

`$ react-native link react-native-overlays-android`

### Manual installation


#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.throwjojo.overlaysandroid.RNOverlaysAndroidPackage;` to the imports at the top of the file
  - Add `new RNOverlaysAndroidPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-overlays-android'
  	project(':react-native-overlays-android').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-overlays-android/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-overlays-android')
  	```


## Usage
```javascript
import { OverlaysAndroid } from 'react-native-overlays-android';

async function tryRequestOverlay() {
  let granted = await OverlaysAndroid.requestOverlayPermissions();
  // do something with granted
}

```
  
## A note about before Marshmallow
If the device is pre-Marshmallow granted will come back as true without opening the request intent window. If you request the overlay permission and have it in your manifest Android versions before Marshmallow grant it automatically.
