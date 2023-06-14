package com.arrazyfathan.countrygraphql.domain.model

/**
 * Created by Ar Razy Fathan Rabbani on 14/06/23.
 */
data class Country(
    val code: String,
    val name: String,
    val emoji: String,
    val capital: String
)