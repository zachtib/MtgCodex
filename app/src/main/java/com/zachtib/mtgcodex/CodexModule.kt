package com.zachtib.mtgcodex

import com.zachtib.mtgcodex.scryfall.ScryfallApi
import com.zachtib.mtgcodex.service.CardsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class CodexModule {
    @Singleton
    @Provides
    fun provideScryfallApi(): ScryfallApi = Retrofit.Builder()
        .baseUrl("https://api.scryfall.com/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create()

    @Singleton
    @Provides
    fun provideCardsService(scryfallApi: ScryfallApi): CardsService = CardsService(scryfallApi)
}