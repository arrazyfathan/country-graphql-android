# Android GraphQL Implementation with Apollo GraphQL

This project provides a step-by-step guide on how to implement GraphQL in an Android project using the Apollo GraphQL library. Apollo GraphQL is a popular client library that simplifies the process of consuming GraphQL APIs in Android applications.

## Prerequisites
Before starting with this implementation guide, ensure that you have the following:

- Basic knowledge of Android development
- Android Studio installed on your system
- An existing Android project

## Getting Started
Follow the steps below to integrate Apollo GraphQL into your Android project:

1. **Configure Apollo Code Generation**

   In your module-level `build.gradle.kts` file, add the following code:

   ```kotlin
   plugins {
    id("com.apollographql.apollo3").version("3.7.3")
   }

   android {
       // Other configurations
   }

   apollo {
    service("service") {
        packageName.set("com.arrazyfathan")
    }
   }
   ```

2. **Create a GraphQL Schema File**

   Create a file with a `.graphql` extension in your project's `src/main/graphql` directory. This file will contain your GraphQL schema, queries, mutations, and subscriptions. Here's an example schema file named `Countries.graphql`:

   ```graphql
   query Countries {
    countries {
        name
        capital
        code
        emoji
    }
   }
   ```

3. **Build the Project**

   Build your project using the Gradle sync option in Android Studio or by running the following command in your project directory:

   ```
   ./gradlew build
   ```

   This triggers the Apollo code generation process and generates the necessary Java/Kotlin classes based on your GraphQL schema.

4. **Initialize Apollo Client**

   Initialize the Apollo Client (example: Initialize in AppModule using dagger hilt):

   ```kotlin
    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient
            .Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }
   ```

   Replace `"https://countries.trevorblades.com/graphql"` with the actual URL of your GraphQL server.

5. **Perform GraphQL Queries**

   You can now start using the Apollo Client to perform GraphQL queries, mutations, and subscriptions. Here's an example of querying the API provided by `https://countries.trevorblades.com/graphql`:

   ```kotlin
   override suspend fun getCountries(): List<Country>? {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toCountry() }
            ?: emptyList()
    }
   ```

   Customize the query/mutation based on your GraphQL schema and API requirements.


## References

Here are some additional resources and references for further learning:

- [Apollo Android Documentation](https://www.apollographql.com/docs/android/): Official documentation for Apollo Android, providing detailed information on various topics related to Apollo GraphQL implementation in Android projects.

- [GraphQL](https://graphql.org/): Official GraphQL documentation, which provides a comprehensive understanding of the GraphQL query language and its concepts.

- [Apollo GraphQL GitHub Repository](https://github.com/apollographql/apollo-android): The official GitHub repository for the Apollo Android library. You can find examples, issues, and the latest updates in this repository.

- [Apollo GraphQL YouTube Tutorial](https://www.youtube.com/watch?v=ME3LH2bib3g): A YouTube tutorial on implementing GraphQL with Apollo GraphQL in Android projects. This tutorial provides a step-by-step walkthrough and visual explanations.

It's recommended to explore these resources to deepen your understanding of GraphQL and Apollo GraphQL in the context of Android development.


## Conclusion
Congratulations! You have successfully implemented Apollo GraphQL in your Android project. With Apollo, you can now easily consume GraphQL APIs and leverage the benefits of strongly-typed queries and responses.

For more information and advanced usage of Apollo GraphQL, refer to the official documentation: [Apollo Android Documentation](https://www.apollographql.com/docs/android/)

Remember to update the dependencies and follow any future updates to the Apollo GraphQL library to ensure the best performance and compatibility
