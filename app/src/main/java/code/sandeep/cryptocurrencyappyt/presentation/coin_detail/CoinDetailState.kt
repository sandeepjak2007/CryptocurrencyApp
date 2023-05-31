package code.sandeep.cryptocurrencyappyt.presentation.coin_detail

import code.sandeep.cryptocurrencyappyt.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
