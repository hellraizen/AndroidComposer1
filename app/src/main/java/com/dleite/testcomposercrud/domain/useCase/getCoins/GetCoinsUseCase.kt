package com.dleite.testcomposercrud.domain.useCase.getCoins

import com.dleite.testcomposercrud.common.Resource
import com.dleite.testcomposercrud.data.remote.dto.toCoin
import com.dleite.testcomposercrud.domain.model.Coin
import com.dleite.testcomposercrud.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "Erro ocorreu, tente novamente mais tarde!"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Não foi possivel acessar o servidor, Tente novamente mais tarde!"))
        }

    }
}