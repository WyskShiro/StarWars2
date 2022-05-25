package will.shiro.starwars2.character.data.api

import com.serjltt.moshi.adapters.Wrapped
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import will.shiro.starwars2.character.data.entity.Character


interface CharacterApi {

    @GET("people")
    @Headers("Accept: application/json")
    @Wrapped(path = ["results"])
    fun getCharacters(): Single<Response<List<Character>>>

}