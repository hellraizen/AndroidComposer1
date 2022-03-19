package com.dleite.testcomposercrud.domain.repository

import com.dleite.testcomposercrud.data.remote.dto.CoinDetailDto
import com.dleite.testcomposercrud.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}