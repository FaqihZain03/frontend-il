
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.tugasil.ui.theme.TugasILTheme
import com.example.tugasil.R

data class Food(
    val name: String,
    val description: String,
    val price: String,
    val gambar: Int
)

val sampleFoodList = listOf(
    Food("Nasi Goreng", "Nasi goreng khas Indonesia", "Rp 20.000", R.drawable.nasi_goreng),
    Food("Sate Ayam", "Sate ayam dengan bumbu kacang", "Rp 25.000", R.drawable.sate_ayam),
    Food("Mie Ayam", "Mie ayam dengan kuah kaldu gurih", "Rp 15.000", R.drawable.mie_ayam),
    Food("Ayam Bakar", "Ayam bakar dengan rempah-rempah", "Rp 30.000", R.drawable.ayam_bakar),
    Food("Soto Ayam", "Soto ayam dengan rempah-rempah", "Rp 22.000", R.drawable.soto_ayam),
    Food("Ikan Bakar", "Ikan bakar dengan rempah-rempah", "Rp 35.000", R.drawable.ikan_bakar),
    Food("Nasi Padang", "Nasi padang dengan berbagai macam makanan", "Rp 40.000", R.drawable.nasi_padang),
    Food("Nasi Kuning", "Nasi kuning dengan berbagai macam makanan", "Rp 35.000", R.drawable.nasi_kuning),

)

@Composable
fun MainMenu(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .horizontalScroll(rememberScrollState())

    ) {
        MainTopBar()
        Spacer(modifier = Modifier.height(16.dp))
        MenuFood(foodList = sampleFoodList)
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
fun MenuFood(foodList: List<Food>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(foodList) { food ->
            FoodItem(food)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun FoodItem(food: Food) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = food.gambar),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .padding(end = 8.dp)
        )
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = food.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = food.description,
                fontSize = 16.sp,
                color = Color.Gray
            )
            Text(
                text = food.price,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewFoodMenuScreen() {
//    TugasILTheme {
//        MenuFood(foodList = sampleFoodList)
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun MainTopBarPreview() {
//    TugasILTheme {
//        MainTopBar()
//    }
//}

@Preview(showBackground = true)
@Composable
fun MainMenuPreview() {
    TugasILTheme {
        MainMenu()
    }
}
