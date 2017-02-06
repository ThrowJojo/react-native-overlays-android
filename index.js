
import { NativeModules } from 'react-native';

const { RNOverlaysAndroid } = NativeModules;

class OverlaysAndroid {

    static async requestOverlayPermissions() {
        return await RNOverlaysAndroid.requestOverlayPermissions();
    }

    static async overlaysGranted() {
        return await RNOverlaysAndroid.overlaysGranted();
    }

}

module.exports.OverlaysAndroid = OverlaysAndroid;