package com.example.cryptoapplication.presentation.coin_detail.viewmodel

import com.example.cryptoapplication.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
