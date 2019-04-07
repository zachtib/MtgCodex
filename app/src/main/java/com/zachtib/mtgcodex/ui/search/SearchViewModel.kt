package com.zachtib.mtgcodex.ui.search

import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.zachtib.mtgcodex.MtgCodexApp
import com.zachtib.mtgcodex.framework.BaseViewModel
import com.zachtib.mtgcodex.service.CardsService

class SearchViewModel(private val service: CardsService) : BaseViewModel<SearchState>(SearchState()) {

    fun onSearchStringChanged(searchString: String) {
        service.search(searchString)
            .map { it.data }
            .execute {
                copy(results = it)
            }
    }

    companion object : MvRxViewModelFactory<SearchViewModel, SearchState> {
        override fun create(viewModelContext: ViewModelContext, state: SearchState): SearchViewModel? {
            val cardsService = viewModelContext.app<MtgCodexApp>().component.cardsService()
            return SearchViewModel(cardsService)
        }
    }
}