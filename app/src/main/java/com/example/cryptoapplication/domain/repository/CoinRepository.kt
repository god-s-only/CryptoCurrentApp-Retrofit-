package com.example.cryptoapplication.domain.repository

import com.example.cryptoapplication.data.remote.dto.CoinDTO
import com.example.cryptoapplication.data.remote.dto.CoinDetailDTO

interface CoinRepository {
    suspend fun getCoins(): List<CoinDTO>

    suspend fun getCoinById(coinId: String): CoinDetailDTO
}