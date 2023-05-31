package code.sandeep.cryptocurrencyappyt.presentation.coin_list

import code.sandeep.cryptocurrencyappyt.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
