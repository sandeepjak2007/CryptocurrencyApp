package code.sandeep.cryptocurrency.data.repository

import code.sandeep.cryptocurrency.data.remote.dto.CoinDetailDto
import code.sandeep.cryptocurrency.data.remote.dto.CoinDto
import code.sandeep.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: code.sandeep.cryptocurrency.data.remote.CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinsById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}