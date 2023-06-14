package com.arrazyfathan.countrygraphql.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arrazyfathan.countrygraphql.domain.model.Country
import com.arrazyfathan.countrygraphql.domain.model.DetailCountry
import com.arrazyfathan.countrygraphql.presentation.components.CountryDialog

/**
 * Created by Ar Razy Fathan Rabbani on 14/06/23.
 */

@Composable
fun MainScreen(
    state: CountiesUiState,
    onSelectedCountry: (code: String) -> Unit,
    onDismissCountryDialog: () -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.countries) { country ->
                    CountryItem(country = country, modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSelectedCountry(country.code) }
                        .padding(16.dp)
                    )
                }
            }
        }

        if (state.selectedCountry != null) {
            CountryDialog(
                country = state.selectedCountry,
                onDismiss = onDismissCountryDialog,
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(5.dp)
                    )
                    .background(Color.White)
                    .padding(16.dp)
            )
        }
    }

}

@Composable
fun CountryItem(
    country: Country,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = country.emoji, fontSize = 30.sp)
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = country.name, fontSize = 24.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = country.capital)
        }
    }
}