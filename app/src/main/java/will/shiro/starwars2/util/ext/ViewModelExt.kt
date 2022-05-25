package will.shiro.starwars2.util.ext

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.toLive(): LiveData<T> {
    return this
}