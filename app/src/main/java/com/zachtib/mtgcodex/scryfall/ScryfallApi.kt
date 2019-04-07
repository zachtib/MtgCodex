package com.zachtib.mtgcodex.scryfall

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ScryfallApi {
    @GET("/cards/search")
    fun search(@Query("q") q: String): Single<ScryfallResponse<List<ScryfallCard>>>
}