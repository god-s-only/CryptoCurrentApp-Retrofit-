package com.example.cryptoapplication.data.repository

import com.example.cryptoapplication.data.remote.CoinPaprikaApi
import com.example.cryptoapplication.data.remote.dto.CoinDTO
import com.example.cryptoapplication.data.remote.dto.CoinDetailDTO
import com.example.cryptoapplication.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository{
    override suspend fun getCoins(): List<CoinDTO> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDTO {
        return api.getCoinById(coinId)
    }

}