package com.example.plantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp
import com.example.plantapp.model.Plant
import com.example.plantapp.ui.theme.PlantAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            PlantAppTheme {
                // A surface container using the 'background' color from the theme
                DisplayPlants {
                    //Toast.makeText(this, it.name,Toast.LENGTH_LONG).show()
                    startActivity(InfoActivity.intent(this,it))
                }
            }
        }
    }


@Composable
fun ScrollableColumnDemo(){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        for (i in 1..100) {
            Text(
                "Plant Name $i",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(10.dp)
            )
            Divider(color = Color.Black, thickness = 5.dp)
        }
    }
}
@Composable
fun LazyColumnDemo(){
    LazyColumn {
        items(100) {
            Text(
                "Plant Name $it",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(10.dp)
            )
            Divider(color = Color.Black, thickness = 5.dp)
        }
    }
}
@Composable
fun LazyColumnDemo2(selectedItem: (String) -> (Unit)) {
    LazyColumn {
        items(100) {
            Text(
                "Plant Name $it",
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable { selectedItem("$it Selected") }
            )
            Divider(color = Color.Black, thickness = 5.dp)
        }
    }
}

@Composable
fun DisplayPlants(selectedItem:(Plant)->Unit){
    val plants = remember { PlantList.plants}
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp,vertical = 8.dp)){
        items(items = plants,
        itemContent = {
            ShowPlantList(plant = it, selectedItem = selectedItem)
        })
    }

}

