# Kotlin Multiplatform Benchmarks

## Project structure

* [app-ios] - iOS project/tests
    * [multiplatform][app-ios-multiplatform] - uses frameworks produced by [app-shared]
    * [standalone][app-ios-standalone] - pure vanilla iOS code that uses SPM frameworks
* [app-android] - Android project/tests
* [app-shared] - Kotlin Multiplatform module that's being used by [app-ios] & [app-android] (includes modules from [shared])
* [json-data] - JSON files for remote access
* [shared] - Kotlin Multiplatform modules
    * [networking][shared-networking]
        * [api-client][shared-networking-api-client]
    * [serialization][shared-serialization]
        * [model][shared-serialization-model]


[app-ios]: app-ios
[app-ios-multiplatform]: app-ios/multiplatform
[app-ios-standalone]: app-ios/standalone

[app-android]: app-android
[app-shared]: app-shared
[json-data]: json-data
[shared]: shared
[shared-networking]: shared/networking
[shared-networking-api-client]: shared/networking/api-client
[shared-serialization]: shared/serialization
[shared-serialization-model]: shared/serialization/model