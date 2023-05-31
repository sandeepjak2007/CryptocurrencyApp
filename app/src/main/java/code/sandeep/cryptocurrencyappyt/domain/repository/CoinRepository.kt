package code.sandeep.cryptocurrencyappyt.domain.repository

import code.sandeep.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import code.sandeep.cryptocurrencyappyt.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinsById(coinId: String): CoinDetailDto
}