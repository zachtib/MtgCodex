package com.zachtib.mtgcodex.ui.search

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.airbnb.mvrx.*
import com.zachtib.mtgcodex.R
import com.zachtib.mtgcodex.framework.BaseFragment
import com.zachtib.mtgcodex.framework.onTextChanged
import kotlinx.android.synthetic.main.search_fragment.*
import timber.log.Timber

class SearchView : BaseFragment(R.layout.search_fragment) {
    private val viewModel: SearchViewModel by fragmentViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchField.onTextChanged { viewModel.onSearchStringChanged(it) }
    }

    override fun invalidate() = withState(viewModel) { state ->
        val message = when (state.results) {
            Uninitialized -> "Uninitialized"
            is Loading -> "Loading"
            is Success -> "Got back ${state.results()?.size ?: 0} cards"
            is Fail -> {
                Timber.e(state.results.error)
                "Got an error"
            }
        }
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}