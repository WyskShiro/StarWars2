package will.shiro.starwars2.util.ext

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import will.shiro.starwars2.util.scheduler.SchedulerProvider

fun <T> Single<T>.observeIOToUI(
    schedulerProvider: SchedulerProvider,
    onSuccess: (T) -> Unit,
    onError: (Throwable) -> Unit
): Disposable {
    return subscribeOn(schedulerProvider.io())
        .observeOn(schedulerProvider.ui())
        .subscribe(onSuccess, onError)
}

fun Disposable.addTo(disposables: CompositeDisposable) {
    disposables.add(this)
}