package com.zachtib.mtgcodex.ui.search

import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.zachtib.mtgcodex.R
import com.zachtib.mtgcodex.framework.BaseFragment

class SearchView : BaseFragment(R.layout.search_fragment) {
    private val viewModel: SearchViewModel by fragmentViewModel()

    override fun invalidate() = withState(viewModel) { state ->

    }
}