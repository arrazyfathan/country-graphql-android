package com.arrazyfathan.countrygraphql.domain.usecase

import com.arrazyfathan.countrygraphql.domain.ICountryClient
import com.arrazyfathan.countrygraphql.domain.model.Country

/**
 * Created by Ar Razy Fathan Rabbani on 14/06/23.
 */
class GetCountriesUseCase(
    private val countryClient: ICountryClient
) {

    suspend fun execute(): List<Country> {
        return countryClient.getCountries()?.sortedBy { it.name } ?: emptyList()
    }
}