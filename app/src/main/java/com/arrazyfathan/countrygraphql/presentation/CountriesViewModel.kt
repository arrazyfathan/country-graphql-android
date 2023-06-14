package com.arrazyfathan.countrygraphql.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arrazyfathan.countrygraphql.domain.usecase.GetCountriesUseCase
import com.arrazyfathan.countrygraphql.domain.usecase.GetCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Ar Razy Fathan Rabbani on 14/06/23.
 */

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getCountryUseCase: GetCountryUseCase
) : ViewModel() {

    private var _state = MutableStateFlow(CountiesUiState())
    val state: StateFlow<CountiesUiState> get() = _state.asStateFlow()

    init {
        getCountries()
    }

    private fun getCountries() {
        viewModelScope.launch {
            _state.update { state -> state.copy(isLoading = true) }
            _state.update { state ->
                state.copy(
                    countries = getCountriesUseCase.execute(),
                    isLoading = false
                )
            }
        }
    }

    fun getSelectedCountry(code: String) {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(
                    selectedCountry = getCountryUseCase.execute(code)
                )
            }
        }
    }

    fun dismissCountryDialog() {
        _state.update { state ->
            state.copy(selectedCountry = null)
        }
    }
}