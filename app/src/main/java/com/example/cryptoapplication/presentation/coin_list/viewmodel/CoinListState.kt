package com.example.cryptoapplication.presentation.coin_list.viewmodel

import com.example.cryptoapplication.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
