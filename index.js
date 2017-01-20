
import { NativeModules } from 'react-native';

const { RNOverlaysAndroid } = NativeModules;

class OverlaysAndroid {

    static async requestOverlayPermissions() {
        return await RNOverlaysAndroid.requestOverlayPermissions();
    }

}

module.exports.OverlaysAndroid = OverlaysAndroid;