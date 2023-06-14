package com.arrazyfathan.countrygraphql.domain

import com.arrazyfathan.countrygraphql.domain.model.Country
import com.arrazyfathan.countrygraphql.domain.model.DetailCountry

/**
 * Created by Ar Razy Fathan Rabbani on 14/06/23.
 */
interface ICountryClient {
    suspend fun getCountries(): List<Country>?
    suspend fun getCountry(code: String): DetailCountry?
}