package com.example.cura.compose.mainscreen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cura.R
import com.example.cura.compose.AbioticFactorsList
import com.example.cura.compose.CardChickenCoopList
import com.example.cura.data.abioticData


enum class CuraPage(
    @StringRes val titleId: Int,
    @DrawableRes val imageId: Int
)
{
    MY_CURA(R.string.app_name, R.drawable.kuryatnik_iz_brusa_foto),
    GRAPHIC(R.string.app_name, R.drawable.kuryatnik_iz_brusa_foto)
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MonitorScreen(modifier: Modifier = Modifier,
                  navigateToInfo:(Int) -> Unit,
                  page: Array<CuraPage> = CuraPage.values()) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Мониторинг") })
        }
    ) {

            padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CardChickenCoopList(navigateToInfo)

            Text("Temperature: 25°C", fontSize = 24.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Humidity: 60%", fontSize = 24.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(24.dp))

        }
    }
}
