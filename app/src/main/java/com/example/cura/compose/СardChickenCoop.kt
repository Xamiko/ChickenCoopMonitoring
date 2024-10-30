import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cura.R
import com.example.cura.data.ChickenCoop
import kotlin.math.round

@Composable
fun СardChickenCoop(
    modifier: Modifier = Modifier,
    primaryCoop: ChickenCoop,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) Color.Gray else Color.White

      Column(
        modifier = modifier
            .padding(2.dp, 2.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .background(backgroundColor),
    ) {
        Image(
            painter = painterResource(id = primaryCoop.image),
            contentDescription = primaryCoop.nickname,
            contentScale = ContentScale.Crop,
            modifier = Modifier.run {

                     fillMaxWidth()
                    .height(150.dp)
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
          Text(
              text = primaryCoop.nickname,
              fontSize = 20.sp,
              fontWeight = FontWeight.Bold,
              color = Color.Black,
              textAlign = TextAlign.Unspecified,
              modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
          )
        Text(
            text = primaryCoop.description,
            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun CardChickenCoopPreview() {
    val sampleCoop = ChickenCoop(
        nickname = "Coop 1",
        description = "A cozy chicken coop.",
        image = R.drawable.kuryatnik_iz_brusa_foto 
    )

    СardChickenCoop(
        primaryCoop = sampleCoop,
        isSelected = false,
        onClick = {}
    )
}