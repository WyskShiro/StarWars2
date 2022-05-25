package will.shiro.starwars2.character.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import will.shiro.starwars2.character.data.api.CharacterApi
import will.shiro.starwars2.character.data.repository.CharacterRepositoryImpl
import will.shiro.starwars2.character.presentation.CharacterRepository

@Module
@InstallIn(SingletonComponent::class)
object CharacterModuleProvides {

    @Provides
    fun providesCharacterApi(retrofit: Retrofit): CharacterApi {
        return retrofit.create(CharacterApi::class.java)
    }


}

@Module
@InstallIn(SingletonComponent::class)
abstract class CharacterModuleBinds {
    @Binds
    abstract fun bindsCharacterRepository(
        characterRepositoryImpl: CharacterRepositoryImpl
    ): CharacterRepository
}