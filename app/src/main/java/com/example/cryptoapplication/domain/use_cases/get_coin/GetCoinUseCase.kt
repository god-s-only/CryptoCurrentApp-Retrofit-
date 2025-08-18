package com.example.cryptoapplication.domain.use_cases.get_coin

import com.example.cryptoapplication.common.Resource
import com.example.cryptoapplication.data.remote.dto.toCoin
import com.example.cryptoapplication.domain.model.CoinDetail
import com.example.cryptoapplication.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try{
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoin()
            emit(Resource.Success<CoinDetail>(coin))
        }catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Could not reach our servers, please check internet connection."))
        }

    }
}