package com.zachtib.mtgcodex

import com.zachtib.mtgcodex.scryfall.ScryfallApi
import com.zachtib.mtgcodex.service.CardsService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CodexModule::class])
interface CodexComponent {
    fun scryfallApi(): ScryfallApi
    fun cardsService(): CardsService
}
