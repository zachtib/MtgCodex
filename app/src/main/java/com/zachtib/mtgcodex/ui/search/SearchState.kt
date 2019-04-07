package com.zachtib.mtgcodex.ui.search

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.Uninitialized
import com.zachtib.mtgcodex.framework.State
import com.zachtib.mtgcodex.scryfall.ScryfallCard

data class SearchState(
    val results: Async<List<ScryfallCard>> = Uninitialized
) : State