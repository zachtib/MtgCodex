package com.zachtib.mtgcodex.ui.search

import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.zachtib.mtgcodex.framework.BaseFragment

class SearchView : BaseFragment() {
    private val viewModel: SearchViewModel by fragmentViewModel()

    override fun invalidate() = withState(viewModel) { state ->

    }
}