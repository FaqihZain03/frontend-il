package com.example.tugasil

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasil.R


data class FoodCategory(
    val name: String,
    val imageRes: Int
)


val foodCategories = listOf(
    FoodCategory("Makanan Cepat Saji", R.drawable.fast_food),
    FoodCategory("Makanan Penutup", R.drawable.dessert),
    FoodCategory("Makanan Sehat", R.drawable.healthy_food),
    FoodCategory("Makanan India", R.drawable.india_food),
    FoodCategory("Makanan China", R.drawable.chinese_food),
    FoodCategory("Minuman", R.drawable.drinks)
)

@Composable
fun CategoryMenu(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
    ) {
        MainTopBar()
        Spacer(modifier = Modifier.height(16.dp))
        FoodCategoryScreen()
    }
}

@Composable
fun MainTopBar(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Row(
            modifier = modifier.width(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                modifier = modifier
                    .widthIn(min = 220.dp),
                value = "",
                onValueChange = {},
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = null
                    )
                },
                placeholder = { Text(text = "Search here") }
            )
            Icon(
                imageVector = Icons.Outlined.Email,
                contentDescription = null,
                modifier = modifier.size(24.dp)
            )
            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = null,
                modifier = modifier.size(24.dp)
            )
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = null,
                modifier = modifier.size(24.dp)
            )
            Icon(
                imageVector = Icons.Outlined.Menu,
                contentDescription = null,
                modifier = modifier.size(24.dp)
            )
        }
        Row(
            modifier = modifier.padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.LocationOn,
                contentDescription = null,
                modifier = modifier.size(18.dp)
            )
            Text(text = stringResource(R.string.txt_dummy_address), fontSize = 12.sp)
            Text(
                text = stringResource(R.string.txt_dummy_username),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowDown,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Composable
fun FoodCategoryScreen() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(foodCategories) { category ->
            FoodCategoryItem(category)
        }
    }
}

@Composable
fun FoodCategoryItem(category: FoodCategory) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image: Painter = painterResource(id = category.imageRes)
        Image(
            painter = image,
            contentDescription = category.name,
            modifier = Modifier
                .size(100.dp)
        )
        Text(
            text = category.name,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}


@Preview(showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
fun CategoryMenuPreview() {
    CategoryMenu()
}
