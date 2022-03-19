package com.dleite.testcomposercrud.domain.useCase.getCoin

import com.dleite.testcomposercrud.common.Resource
import com.dleite.testcomposercrud.data.remote.dto.CoinDetailDto
import com.dleite.testcomposercrud.data.remote.dto.toCoinDetail
import com.dleite.testcomposercrud.domain.model.CoinDetail
import com.dleite.testcomposercrud.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(
                Resource.Error<CoinDetail>(
                    e.localizedMessage ?: "Erro ocorreu, tente novamente mais tarde!"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Não foi possivel acessar o servidor, Tente novamente mais tarde!"))
        }

    }
}