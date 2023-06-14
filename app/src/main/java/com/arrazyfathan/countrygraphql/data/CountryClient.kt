package com.arrazyfathan.countrygraphql.data

import com.apollographql.apollo3.ApolloClient
import com.arrazyfathan.CountriesQuery
import com.arrazyfathan.CountryQuery
import com.arrazyfathan.countrygraphql.domain.ICountryClient
import com.arrazyfathan.countrygraphql.domain.model.Country
import com.arrazyfathan.countrygraphql.domain.model.DetailCountry

/**
 * Created by Ar Razy Fathan Rabbani on 14/06/23.
 */
class CountryClient(
    private val apolloClient: ApolloClient

) : ICountryClient {
    override suspend fun getCountries(): List<Country>? {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailCountry()
    }
}