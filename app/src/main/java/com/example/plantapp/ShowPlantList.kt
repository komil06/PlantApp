package com.example.plantapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.plantapp.model.Plant

@Composable
fun ShowPlantList(plant: Plant, selectedItem:(Plant)-> Unit){
   Card(modifier = Modifier
       .padding(10.dp)
       .fillMaxWidth(),
       elevation = 10.dp,
       shape = RoundedCornerShape(corner = CornerSize(10.dp))
   ){

       Row(
           modifier = Modifier
               .padding(5.dp)
               .fillMaxWidth()
               .clickable { selectedItem(plant) },
           verticalAlignment = Alignment.CenterVertically
       ) {
           ShowPlant(plant = plant)
           Column {
               Text(text = plant.name, style = MaterialTheme.typography.h5)
               Spacer(modifier = Modifier.height(4.dp))
               Text(
                   text = plant.descrption,
                   style = MaterialTheme.typography.body1,
                   maxLines = 3,
                   overflow = TextOverflow.Ellipsis
               )
               Spacer(modifier = Modifier.height(8.dp))


           }
       }
   }
}