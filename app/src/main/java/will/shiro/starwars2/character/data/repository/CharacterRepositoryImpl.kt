package will.shiro.starwars2.character.data.repository

import io.reactivex.Single
import will.shiro.starwars2.character.data.api.CharacterApi
import will.shiro.starwars2.character.data.entity.Character
import will.shiro.starwars2.character.presentation.CharacterRepository
import will.shiro.starwars2.util.network.handleResponse
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterApi: CharacterApi
): CharacterRepository{

    override fun getCharacters(): Single<List<Character>> {
        return characterApi.getCharacters().handleResponse()
    }
}