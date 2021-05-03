package pro.labster.rxextensions

import io.reactivex.rxjava3.core.CompletableEmitter
import io.reactivex.rxjava3.core.FlowableEmitter
import io.reactivex.rxjava3.core.MaybeEmitter
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.core.SingleEmitter

/**
Copyright (C) 2020 Artem Smirnov @ Labster.PRO

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
inline fun <T> SingleEmitter<T>.ifNotDisposed(block: () -> Unit) {
    if (!isDisposed) {
        block()
    }
}

inline fun <T> MaybeEmitter<T>.ifNotDisposed(block: () -> Unit) {
    if (!isDisposed) {
        block()
    }
}

inline fun CompletableEmitter.ifNotDisposed(block: () -> Unit) {
    if (!isDisposed) {
        block()
    }
}

inline fun <T> ObservableEmitter<T>.ifNotDisposed(block: () -> Unit) {
    if (!isDisposed) {
        block()
    }
}

inline fun <T> FlowableEmitter<T>.ifNotDisposed(block: () -> Unit) {
    if (!isCancelled) {
        block()
    }
}

fun <T> SingleEmitter<T>.safeOnSuccess(element: T) {
    ifNotDisposed {
        element?.let(::onSuccess)
    }
}

fun <T> SingleEmitter<T>.safeOnError(t: Throwable) {
    ifNotDisposed {
        onError(t)
    }
}

fun <T> MaybeEmitter<T>.safeOnSuccess(element: T) {
    ifNotDisposed {
        element?.let(::onSuccess)
    }
}

fun <T> MaybeEmitter<T>.safeOnComplete() {
    ifNotDisposed {
        onComplete()
    }
}

fun <T> MaybeEmitter<T>.safeOnError(t: Throwable) {
    ifNotDisposed {
        onError(t)
    }
}

fun <T> ObservableEmitter<T>.safeOnComplete() {
    ifNotDisposed {
        onComplete()
    }
}

fun <T> ObservableEmitter<T>.safeOnNext(element: T) {
    ifNotDisposed {
        element?.let(::onNext)
    }
}

fun <T> ObservableEmitter<T>.safeOnError(t: Throwable) {
    ifNotDisposed {
        onError(t)
    }
}

fun <T> FlowableEmitter<T>.safeOnComplete() {
    ifNotDisposed {
        onComplete()
    }
}

fun <T> FlowableEmitter<T>.safeOnNext(element: T) {
    ifNotDisposed {
        element?.let(::onNext)
    }
}

fun <T> FlowableEmitter<T>.safeOnError(t: Throwable) {
    ifNotDisposed {
        onError(t)
    }
}

fun CompletableEmitter.safeOnComplete() {
    ifNotDisposed {
        onComplete()
    }
}

fun CompletableEmitter.safeOnError(t: Throwable) {
    ifNotDisposed {
        onError(t)
    }
}