package code.sandeep.cryptocurrencyappyt.data.repository

import code.sandeep.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import code.sandeep.cryptocurrencyappyt.data.remote.dto.CoinDto
import code.sandeep.cryptocurrencyappyt.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: code.sandeep.cryptocurrencyappyt.data.remote.CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinsById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}