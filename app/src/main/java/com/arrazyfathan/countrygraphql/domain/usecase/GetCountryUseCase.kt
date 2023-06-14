package com.arrazyfathan.countrygraphql.domain.usecase

import com.arrazyfathan.countrygraphql.domain.ICountryClient
import com.arrazyfathan.countrygraphql.domain.model.Country
import com.arrazyfathan.countrygraphql.domain.model.DetailCountry

/**
 * Created by Ar Razy Fathan Rabbani on 14/06/23.
 */
class GetCountryUseCase(
    private val countryClient: ICountryClient
) {

    suspend fun execute(code: String): DetailCountry? {
        return countryClient.getCountry(code)
    }
}