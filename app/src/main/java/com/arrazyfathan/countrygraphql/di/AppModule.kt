package com.arrazyfathan.countrygraphql.di

import com.apollographql.apollo3.ApolloClient
import com.arrazyfathan.countrygraphql.data.CountryClient
import com.arrazyfathan.countrygraphql.domain.ICountryClient
import com.arrazyfathan.countrygraphql.domain.usecase.GetCountriesUseCase
import com.arrazyfathan.countrygraphql.domain.usecase.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Ar Razy Fathan Rabbani on 14/06/23.
 */


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient
            .Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient): ICountryClient {
        return CountryClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(countryClient: ICountryClient): GetCountriesUseCase {
        return GetCountriesUseCase(countryClient)
    }

    @Provides
    @Singleton
    fun provideGetCountryUseCase(countryClient: ICountryClient): GetCountryUseCase {
        return GetCountryUseCase(countryClient)
    }
}