package com.example.rxkotlintest

import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy

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
  /*  doWork("Never With doOnSubscribe"){
        val subscription = CompositeDisposable()
        val observable: Observable<Any> = Observable.never()
        val x = observable.doOnSubscribe {
            println("disposed")
        }
        subscription.add(x.subscribe { println(it) })
    }
   */
  /*  doWork("PublishSubject"){
        val publishSubject = PublishSubject.create<Int>()
        val subscriberOne = publishSubject.subscribe {
            println(it)
        }
        publishSubject.onNext(10)
        publishSubject.onNext(20)
        val subjectTwo = publishSubject.subscribe {
            println(it)
        }
        publishSubject.onNext(30)
        subscriberOne.dispose()
        subscriberTwo.dispose()
    }
   */
  /*  doWork("BehaviourSubject"){
        val subscription = CompositeDisposable()
        val behaviorSubject = BehaviorSubject.createDefault("Default value")
        val subscriberOne = behaviorSubject.subscribeBy(
            onNext = {println(it)},
            onError = {println("error")}
        )
        behaviorSubject.onNext("One")
        subscription.add(behaviorSubject.subscribeBy(
            onNext = {println("Two")},
            onError = {println("error")}
        ))
    }
   */
  /*  doWork("Behaviour Subject State"){
        val subscriptions = CompositeDisposable()
        val behaviorSubject = BehaviorSubject.createDefault(0)
        println(behaviorSubject.value)
        subscriptions.add(behaviorSubject.subscribeBy{
            println(it)
        })
        behaviorSubject.onNext(1)
        println(behaviorSubject.value)
        subscriptions.dispose()
    }
   */
   /* doWork("ReplaySubject"){
        val subscriptions = CompositeDisposable()
        val replaySubject = ReplaySubject.createWithSize<Int>(2)
        replaySubject.onNext(1)
        replaySubject.onNext(2)
        replaySubject.onNext(3)
        subscriptions.add(replaySubject.subscribeBy(
            onNext = {println(it)},
            onError = {println(it.message)}
        ))
        subscriptions.add(replaySubject.subscribeBy(
            onNext = {println(it)},
            onError = { println(it.message)}
        ))
        replaySubject.onNext(4)
        replaySubject.onNext(5)
    }
    */
   /* doWork("AsyncSubject"){
        val subscription = CompositeDisposable()
        val asyncSubject = AsyncSubject.create<Int>()
        subscription.add(asyncSubject.subscribeBy(
            onNext = {println(it)},
            onError = {println(it.message)}
        ))
        asyncSubject.onNext(0)
        asyncSubject.onNext(1)
        asyncSubject.onNext(2)
        asyncSubject.onNext(3)
        asyncSubject.onComplete()
        subscription.dispose()
    }
    */
 /*   doWork("RxRelay"){
        val subscription = CompositeDisposable()
        val rxRelay = PublishRelay.create<Int>()
        subscription.add(rxRelay.subscribeBy(
            onNext = {println(it)}
        ))
        rxRelay.accept(1)
        rxRelay.accept(2)
        rxRelay.accept(3)
        subscription.dispose()
    }
  */
    println("\uD83C\uDCA1")

}

fun doWork(name: String, action: () -> Unit){
    println("Now i do $name")
    action()
}