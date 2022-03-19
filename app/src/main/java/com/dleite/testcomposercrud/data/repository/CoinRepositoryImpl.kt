package com.dleite.testcomposercrud.data.repository

import com.dleite.testcomposercrud.data.remote.CoinPaprikaApi
import com.dleite.testcomposercrud.data.remote.dto.CoinDetailDto
import com.dleite.testcomposercrud.data.remote.dto.CoinDto
import com.dleite.testcomposercrud.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> = api.getCoin()

    override suspend fun getCoinById(coinId: String): CoinDetailDto = api.getCoinById(coinId)
}