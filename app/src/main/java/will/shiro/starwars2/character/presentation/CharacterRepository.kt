package will.shiro.starwars2.character.presentation

import io.reactivex.Single
import will.shiro.starwars2.character.data.entity.Character

interface CharacterRepository {
    fun getCharacters(): Single<List<Character>>
}