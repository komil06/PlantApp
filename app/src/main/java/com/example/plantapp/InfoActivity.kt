package com.example.plantapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.plantapp.model.Plant

class InfoActivity: ComponentActivity() {
    companion object{
     private const val PlantId  = "plantid"
    fun intent(context: Context, plant: Plant)=
        Intent(context,InfoActivity::class.java).apply {
            putExtra(PlantId,plant)
        }
}

    private val plant : Plant by lazy {
         intent?.getSerializableExtra(PlantId) as Plant
    }


override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
        ViewMoreInfo(plant = plant)
    }
}
}

@Composable
fun ViewMoreInfo(plant: Plant) {
    val scrollState = rememberScrollState()
    Card(
        modifier = Modifier.padding(10.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = plant.img),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = plant.name,
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = plant.descrption,
                style = MaterialTheme.typography.h5
            )


        }
    }
}