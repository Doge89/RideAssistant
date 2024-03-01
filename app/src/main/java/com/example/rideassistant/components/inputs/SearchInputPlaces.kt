package com.example.rideassistant.components.inputs

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.rideassistant.R
import com.example.rideassistant.constants.FROM_REQUEST_CODE
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode

@Composable
fun SearchInputPlaces(
    onClickResult: () -> Unit,
) {
    var place by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    TextField(
        value = place,
        onValueChange = {value ->
            place = value
        },
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .fillMaxWidth(0.9F)
            .background(Color.White)
            .border(1.dp, Brush.linearGradient(listOf(Color.LightGray, Color.LightGray)), RoundedCornerShape(50))
            .clickable {
                context.startActivity(prepareAutocompleteIntent(context))
            },
        trailingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = stringResource(id = R.string.search_field),
                tint = Color.Gray
            )
        },
        placeholder = {
            Text(text = stringResource(id = R.string.search_field_placeholder))
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedContainerColor = Color.White,
            unfocusedTextColor = Color.DarkGray,
        ),
    )
}

fun prepareAutocompleteIntent(context: Context): Intent {
    val fields = listOf<Place.Field>(Place.Field.ID, Place.Field.NAME)
    return Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields).build(context)

}