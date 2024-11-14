import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasil.R

@Composable
fun ProfileScreen(
    profileImage: Painter,
    name: String,
    email: String,
    university: String,
    major: String,
    about: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Foto Profil
        Image(
            painter = profileImage,
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .aspectRatio(1f)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nama
        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Email
        Text(
            text = email,
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Perguruan Tinggi
        Text(
            text = "University: $university",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Jurusan
        Text(
            text = "Major: $major",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(16.dp))

        //About
        Text(
            text = " About: $about",
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            color = Color.Black
        )

    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    ProfileScreen(
        profileImage = painterResource(id = R.drawable.foto_profile),
        name = "Faqih Zain",
        email = "faqihzain2003@gmail.com",
        university = "Sekolah Tinggi Terpadu Nurul Fikri",
        major = "Teknik Informatika",
        about = "Saya mahasiswa Teknik Informatika Sekolah Tinggi Terpadu Nurul Fikri, " +
                "Hobi saya bermain mobile legends dan akhir - akhir ini saya sering melakukan olahraga."
    )
}

