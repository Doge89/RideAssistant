package com.example.rideassistant.components.lists

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.rideassistant.classes.data.SimpleListData

@Composable
fun SimpleList(data: List<SimpleListData>) {
    Log.d("DEBUG", data.toString())
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        data.forEach {
            SimpleListItem(header = it.header, content = it.content)
        }
    }
}

@Composable
private fun SimpleListItem(header: String, content: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = header,
            fontWeight = FontWeight.SemiBold,
            fontSize = TextUnit(21F, TextUnitType.Sp)
        )
        Spacer(modifier = Modifier.padding(0.dp, 8.dp))
        Text(text = content, color = Color.DarkGray)

    }
}