package com.arrazyfathan.countrygraphql.presentation

import com.arrazyfathan.countrygraphql.domain.model.Country
import com.arrazyfathan.countrygraphql.domain.model.DetailCountry

/**
 * Created by Ar Razy Fathan Rabbani on 14/06/23.
 */

data class CountiesUiState(
    val countries: List<Country> = emptyList(),
    val isLoading: Boolean = false,
    val selectedCountry: DetailCountry? = null
)