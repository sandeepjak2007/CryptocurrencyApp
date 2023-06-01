package code.sandeep.cryptocurrency.presentation.coin_list

import code.sandeep.cryptocurrency.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
