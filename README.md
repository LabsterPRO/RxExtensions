# RxExtensions

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/pro.labster/rxextensions/badge.svg)](https://maven-badges.herokuapp.com/maven-central/pro.labster/rxextensions)

RxExtensions is a library with different useful RxJava3 extensions.

## Requirements

- RxJava 3.x
- RxAndroid 3.x if you plan to use `AndroidSchedulers.mainThread()`

## Installation

Add dependency to your module's (usually `app/build.gradle`) `build.gradle` and sync:

```groovy
implementation 'pro.labster.rxextensions:(insert latest version)'
```

## Set up

No set up needed — just import the extensions or functions you need

## Schedulers extensions

Extensions helping to make `subscribeOn` and `observeOn` chains a bit shorter.

Extension name is `schedulers%subscribeOn%to%observeOn%`, for example `schedulersIoToMain` = `subscribe on Schedulers.io(), observe on AndroidSchedulers.mainThread()`.

Available extensions: 

- `schedulersIoToMain`
- `schedulersIoToSingle`
- `schedulersSingleToMain`
- `schedulersComputationToMain`

These extensions are available for:

- `Single`
- `Maybe`
- `Observable`
- `Flowable`
- `Completable`

## Emitters extensions

These extensions are useful for disposed-safe operations.

For example, you can use `ifNotDisposed` to execute a code block if not disposed:

```kotlin
Completable.create { emitter -> 
    // ...
    emitter.ifNotDisposed {
        // This block would be called only if not disposed
    }
}
```

There are also extensions for `onComplete`, `onError`, `onNext` etc methods.

Let's take `Observable` for example, it has 3 methods:

- `safeOnComplete`
- `safeOnNext`
- `safeOnError`

Usage examples:

```kotlin
Observable.create { emitter ->
    // ...
    
    if (/** condition **/) {
        emitter.safeOnNext(element) // Would be called only if not disposed
    }
    
    if (/** condition **/) {
        emitter.safeOnComplete() // Would be called only if not disposed
    }

    if (/** condition **/) {
        emitter.safeOnError(Throwable("SNAFU")) // Would be called only if not disposed
    }
}
```

These extensions are available for:

- `SingleEmitter`
  - `safeOnSuccess`
  - `safeOnError`
- `MaybeEmitter`
  - `safeOnSuccess`
  - `safeOnComplete`
  - `safeOnError`
- `ObservableEmitter`
  - `safeOnComplete`
  - `safeOnNext`
  - `safeOnError`
- `FlowableEmitter`
  - `safeOnComplete`
  - `safeOnNext`
  - `safeOnError`
- `CompletableEmitter`
  - `safeOnComplete`
  - `safeOnError`
  
## Misc

`maybeOfNullable` function accepts an object and returns `Maybe.just()` result if object is not `null` or `Maybe.empty` if it is

`Single.withMinTimeExecution` zips with a single and completes only after `interval` amount of time passed.

`Single.onErrorResumeNextIfInstance()` resumes with a result of a code block if error type is the given type, otherwise it'll propagate the initial throwable

Usage example:

```kotlin
Single
  .create { 
      // ...
  }
  .onErrorResumeNextIfInstance<IOException> {
      NetworkError()
  }
```

## Contributions

Any contributions, including translations, are highly appreciated.

Please, report any issues [here](https://github.com/LabsterPRO/RxExtensions/android-smart-rate/issues).

## Credits

Author: [Artem Smirnov](https://smirnov.page) at [Labster.PRO](https://labster.pro)

## License

```
Copyright (C) 2021 Artem Smirnov @ Labster.PRO

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```