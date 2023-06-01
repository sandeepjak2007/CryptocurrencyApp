package code.sandeep.cryptocurrency.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import code.sandeep.cryptocurrency.domain.use_case.get_coins.GetCoinsUseCase
import code.sandeep.cryptocurrency.presentation.coin_list.CoinListState
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
                is code.sandeep.cryptocurrency.common.Resource.Success -> {
                    _state.value = CoinListState(
                        isLoading = false, coins = result.data ?: emptyList()
                    )

                }
                is code.sandeep.cryptocurrency.common.Resource.Error -> {
                    _state.value = CoinListState(
                        isLoading = false, error = result.message ?: "An unexpected error occurred"
                    )
                }
                is code.sandeep.cryptocurrency.common.Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)

                }
            }
        }.launchIn(viewModelScope)
    }
}