package code.sandeep.cryptocurrencyappyt.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import code.sandeep.cryptocurrencyappyt.common.Resource
import com.sandeep.cryptocurrencyappyt.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is code.sandeep.cryptocurrencyappyt.common.Resource.Success -> {
                    _state.value = CoinListState(
                        isLoading = false, coins = result.data ?: emptyList()
                    )

                }
                is code.sandeep.cryptocurrencyappyt.common.Resource.Error -> {
                    _state.value = CoinListState(
                        isLoading = false, error = result.message ?: "An unexpected error occurred"
                    )
                }
                is code.sandeep.cryptocurrencyappyt.common.Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)

                }
            }
        }.launchIn(viewModelScope)
    }
}