package code.sandeep.cryptocurrency.domain.repository

import code.sandeep.cryptocurrency.data.remote.dto.CoinDetailDto
import code.sandeep.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinsById(coinId: String): CoinDetailDto
}