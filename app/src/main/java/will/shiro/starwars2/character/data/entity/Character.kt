package will.shiro.starwars2.character.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import will.shiro.starwars2.util.entity.Nameable

@JsonClass(generateAdapter = true)
data class Character(
    @Json(name = "films")
    val films: List<String>? = emptyList(),
    @Json(name = "name")
    val name: String
): Nameable {

    override fun getEntityName(): String {
        return name
    }
}