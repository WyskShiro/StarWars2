package will.shiro.starwars2.util.network

import android.util.Log
import io.reactivex.Single
import retrofit2.Response

const val TAG = "WYSKSHIRO"

fun <T> Single<Response<T>>.handleResponse(): Single<T> {
    return map {
        if (it.isSuccessful) it.body()!!
        else {
            Log.d(TAG, it.errorBody().toString())
            throw RuntimeException(it.errorBody().toString())
        }
    }
}
