
# react-native-overlays-android

## Getting started

`$ npm install react-native-overlays-android --save`

### Mostly automatic installation

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
import RNOverlaysAndroid from 'react-native-overlays-android';

// TODO: What do with the module?
RNOverlaysAndroid;
```
  