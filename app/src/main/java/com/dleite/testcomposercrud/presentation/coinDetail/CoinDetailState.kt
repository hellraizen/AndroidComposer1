package com.dleite.testcomposercrud.presentation.coinDetail

import com.dleite.testcomposercrud.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
