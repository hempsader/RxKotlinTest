package com.example.rxkotlintest

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import java.io.File
import java.io.FileNotFoundException
import java.nio.charset.Charset
import kotlin.math.roundToInt

fun main(){
/*   doWork("just"){
        val observer: Observable<List<Int>> = Observable.just(listOf(1,2,3), listOf(4,5,6))
        observer.subscribe {
            println(it)
        }
    }

 */
  /*  doWork("empty"){
        val emptyObserver: Observable<Unit> = Observable.empty()
        emptyObserver.subscribeBy(
// 1
            onNext = { println(it) },
// 2
            onComplete = { println("Completed") }
        )
    }

   */
  /*  doWork("never"){
        val observer: Observable<Any> = Observable.never()
        observer.subscribeBy(
            onNext = {println(it)},
            onComplete = {println("Completed")}
        )
    }
   */
  /*  doWork("range"){
        val observable: Observable<Int> = Observable.range(1,2000000)
        observable.subscribe{
            val n = it.toDouble()
            val fibbonacci = ((Math.pow(1.61803,n)) - Math.pow(0.61803,n)/2.23606).roundToInt()
            print(fibbonacci)
            println()
        }
    }
 */
  /*  doWork("CompositeDisposable"){
        val subscription = CompositeDisposable()
        val observable = Observable.just(1,2,3).subscribe {
            println(it)
        }
        subscription.add(observable)
    }
   */
  /*  doWork("Create"){
        val disposable = CompositeDisposable()
        val observable = Observable.create<String> {
            it.onNext("One")
            it.onNext("Two")
            it.onNext("Three")
            it.onComplete()
        }.subscribeBy(
            onNext = {println(it)}
        )
        disposable.add(observable)
    }
   */
  /*  doWork("Defer"){
        val disposable = CompositeDisposable()
        var flip = true
        val factory: Observable<Int> = Observable.defer {
            flip = !flip
            if (flip){
                Observable.just(1,2,3)
            }else{
                Observable.just(4,5,6)
            }
        }
            disposable.add(factory.subscribe {
                print(it)
            })
        disposable.dispose()
    }
   */
   /* doWork("Single"){
        val subscription = CompositeDisposable()
        fun loadText(filename: String): Single<String> {
            return Single.create create@{
                val file = File(filename)
                if(!file.exists()){
                    it.onError(FileNotFoundException("Can't find the file $filename"))
                    return@create
                }
                val contents = file.readText(Charsets.UTF_8)
                it.onSuccess(contents)
            }
        }
        val observer = loadText("DowloadText.txt").subscribeBy(
            onSuccess = {println(it)},
            onError = {println(it.message)},
        )
        subscription.add(observer)
    }
    */
    doWork("Never With doOnSubscribe"){
        val subscription = CompositeDisposable()
        val observable: Observable<Any> = Observable.never()
        val x = observable.doOnSubscribe {
            println("disposed")
        }
        subscription.add(x.subscribe { println(it) })
    }
}

fun doWork(name: String, action: () -> Unit){
    println("Now i do $name")
    action()
}