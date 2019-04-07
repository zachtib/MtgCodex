package com.zachtib.mtgcodex.service

import com.zachtib.mtgcodex.scryfall.ScryfallApi
import io.reactivex.schedulers.Schedulers

class CardsService(private val scryfallApi: ScryfallApi) {
    fun search(query: String) = scryfallApi.search(query)
        .subscribeOn(Schedulers.io())
}