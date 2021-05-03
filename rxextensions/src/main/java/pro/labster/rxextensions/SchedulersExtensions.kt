package pro.labster.rxextensions

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

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

fun <T> Single<T>.schedulersIoToMain(): Single<T> {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Single<T>.schedulersIoToSingle(): Single<T> {
    return subscribeOn(Schedulers.io()).observeOn(Schedulers.single())
}

fun <T> Single<T>.schedulersSingleToMain(): Single<T> {
    return subscribeOn(Schedulers.single()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Single<T>.schedulersComputationToMain(): Single<T> {
    return subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.schedulersIoToMain(): Observable<T> {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.schedulersIoToSingle(): Observable<T> {
    return subscribeOn(Schedulers.io()).observeOn(Schedulers.single())
}

fun <T> Observable<T>.schedulersSingleToMain(): Observable<T> {
    return subscribeOn(Schedulers.single()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.schedulersComputationToMain(): Observable<T> {
    return subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Flowable<T>.schedulersIoToMain(): Flowable<T> {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Flowable<T>.schedulersIoToSingle(): Flowable<T> {
    return subscribeOn(Schedulers.io()).observeOn(Schedulers.single())
}

fun <T> Flowable<T>.schedulersSingleToMain(): Flowable<T> {
    return subscribeOn(Schedulers.single()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Flowable<T>.schedulersComputationToMain(): Flowable<T> {
    return subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Maybe<T>.schedulersIoToMain(): Maybe<T> {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Maybe<T>.schedulersIoToSingle(): Maybe<T> {
    return subscribeOn(Schedulers.io()).observeOn(Schedulers.single())
}

fun <T> Maybe<T>.schedulersSingleToMain(): Maybe<T> {
    return subscribeOn(Schedulers.single()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Maybe<T>.schedulersComputationToMain(): Maybe<T> {
    return subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())
}

fun Completable.schedulersIoToMain(): Completable {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun Completable.schedulersIoToSingle(): Completable {
    return subscribeOn(Schedulers.io()).observeOn(Schedulers.single())
}

fun Completable.schedulersSingleToMain(): Completable {
    return subscribeOn(Schedulers.single()).observeOn(AndroidSchedulers.mainThread())
}

fun Completable.schedulersComputationToMain(): Completable {
    return subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())
}