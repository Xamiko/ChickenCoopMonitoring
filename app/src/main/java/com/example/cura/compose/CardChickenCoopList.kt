package com.example.cura.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cura.data.primaryCoop


@Composable
fun CardChickenCoopList() {
    val selectedСhickenCoopIndex = remember { mutableStateOf(-1) }
    LazyColumn {
        itemsIndexed(primaryCoop) { index, chickenCoop ->
            СardChickenCoop(
                primaryCoop = chickenCoop,
                isSelected = index == selectedСhickenCoopIndex.value,
                onClick = { selectedСhickenCoopIndex.value = index }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardChickenCoopListPreview() {
    val selectedСhickenCoopIndex = remember { mutableIntStateOf(-1) }
    LazyColumn {
        itemsIndexed(primaryCoop) { index, chickenCoop ->
            СardChickenCoop(
                primaryCoop = chickenCoop,
                isSelected = index == selectedСhickenCoopIndex.value,
                onClick = { selectedСhickenCoopIndex.value = index }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
