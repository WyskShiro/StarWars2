package will.shiro.starwars2.character.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import will.shiro.starwars2.character.data.entity.Character
import will.shiro.starwars2.util.ext.addTo
import will.shiro.starwars2.util.ext.toLive
import will.shiro.starwars2.util.network.TAG
import will.shiro.starwars2.util.scheduler.SchedulerProvider
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val schedulerProvider: SchedulerProvider,
    private val characterRepository: CharacterRepository
) : ViewModel() {

    private val _characters = MutableLiveData<List<Character>>()

    val characters = _characters.toLive()

    private val disposables = CompositeDisposable()

    fun getCharacters() {
        characterRepository.getCharacters()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe({
                _characters.postValue(it)
                Log.d(TAG, "Get Characters Success")
            }) {
                Log.d(TAG, "Get Characters Error: $it")
            }
            .addTo(disposables)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}