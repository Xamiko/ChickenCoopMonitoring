package com.example.cura.compose.homescreen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cura.R
import com.example.cura.compose.CardChickenCoopList


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
fun HomeScreen(
    modifier: Modifier = Modifier,
navigateToInfo:(Int) -> Unit,
    page: Array<CuraPage> = CuraPage.values()
) {

val pagerState = rememberPagerState(pageCount = {page.size} )

    Scaffold(
        topBar = {



            TopAppBar(title = { Text("Your chicken coops") })
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

        }
    }
}
@Composable
fun HomePagerScreen(
    onCuraClick:() -> Unit,
    pagerState: PagerState,
    page: Array<CuraPage>,
    modifier: Modifier
){
Column(modifier= Modifier) {  }

}