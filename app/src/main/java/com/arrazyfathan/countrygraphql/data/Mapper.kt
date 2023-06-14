package com.arrazyfathan.countrygraphql.data

import com.arrazyfathan.CountriesQuery
import com.arrazyfathan.CountryQuery
import com.arrazyfathan.countrygraphql.domain.model.Country
import com.arrazyfathan.countrygraphql.domain.model.DetailCountry

/**
 * Created by Ar Razy Fathan Rabbani on 14/06/23.
 */


fun CountryQuery.Country.toDetailCountry(): DetailCountry {
    return DetailCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No Capital",
        currency = currency ?: "No Currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toCountry(): Country {
    return Country(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No Capital"
    )
}