package com.example.cleanarchitecturegraphqlwithcompose.ui.countries

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cleanarchitecturegraphqlwithcompose.R
import com.example.cleanarchitecturegraphqlwithcompose.data.model.CountryUI

@Composable
fun CountriesCompose(countryList: List<CountryUI>?, loadingState: Boolean) {

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        if (loadingState) {

            CircularProgressIndicator(color = colorResource(id = R.color.gradient_start))

        } else {

            countryList?.let {

                Text(
                    text = "Ülkeler",
                    Modifier.padding(top = 15.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    color = Color.Black,
                )

                LazyColumn(Modifier.padding(top = 10.dp)) {

                    items(countryList) { country ->
                        CountryCardItem(country)
                    }
                }
            }
        }
    }
}

@Composable
fun CountryCardItem(countryUI: CountryUI) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { },
        elevation = 10.dp,
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color.Transparent
    ) {
        Box(modifier = Modifier.background(Brush.horizontalGradient(listOf(colorResource(R.color.gradient_start),
            colorResource(R.color.gradient_end))))) {

            Column(
                modifier = Modifier.padding(15.dp)
            ) {

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {

                    Text(
                        text = countryUI.name ?: "",
                        fontSize = 16.sp,
                        color = Color.Black
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Text(modifier = Modifier.padding(end = 5.dp),
                            text = countryUI.emoji ?: "",
                            fontSize = 22.sp,
                            color = Color.Black
                        )

                        Text(
                            text = if (countryUI.languages.isNullOrEmpty()) "" else countryUI.languages.first().name ?: "",
                            fontSize = 12.sp,
                            color = Color.Black
                        )
                    }
                }

                Text(modifier = Modifier.padding(start = 15.dp),
                    text = countryUI.capital ?: "",
                    fontSize = 12.sp,
                    color = Color.DarkGray
                )

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
                    .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {

                    IconWithText(
                        icon = Icons.Rounded.Phone,
                        text = countryUI.phone,
                        iconSize = 15,
                        textSize = 15)

                    IconWithText(
                        icon = Icons.Rounded.AttachMoney,
                        text = countryUI.currency,
                        iconSize = 18,
                        textSize = 15)
                }
            }
        }
    }
}

@Composable
fun IconWithText(icon: ImageVector, text: String?, iconSize: Int, textSize: Int) {

    Row(verticalAlignment = Alignment.CenterVertically) {

        Icon(icon, contentDescription = "",
            Modifier
                .padding(end = 6.dp)
                .size(iconSize.dp), tint = Color.White)

        Text(
            text = text ?: "",
            fontSize = textSize.sp,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun PreviewCountries() {
    CountriesCompose(
        countryList = listOf(
            CountryUI("Türkiye",
                null,
                "90",
                "Ankara",
                listOf(),
                null)),
        loadingState = false)
}