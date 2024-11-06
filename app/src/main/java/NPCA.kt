import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.Normalizer.Form

data class FormState(
    var nama: String = "",
    var NoHandphone: String = "",
    var memilihAQ: String = ""
)


@Preview(showBackground = true)
@Composable
fun NPCA(modifier: Modifier = Modifier) {
    var formState by remember { mutableStateOf(FormState()) }
    val listJK = listOf("Laki-Laki", "Perempuan")
    var savedForm by remember { mutableStateOf(FormState()) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Yuk lengkapi data dirimu !",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Image(
            painter = painterResource(id = R.drawable.images),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )

        TextField(
            value = formState.nama,
            onValueChange = { formState = formState.copy(nama = it) },
            label = { Text(text = "Nama") },
            placeholder = { Text(text = "Isi nama anda") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            listJK.forEach { selectedGender ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = formState.memilihAQ == selectedGender,
                        onClick = { formState = formState.copy(memilihAQ = selectedGender) }
                    )
                    Text(text = selectedGender)
                }
            }
        }

        TextField(
            value = formState.NoHandphone,
            onValueChange = { formState = formState.copy(NoHandphone = it) },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Isi email anda") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Button(onClick = { savedForm = formState }) {
            Text(text = "Simpan")
        }

        DetailMessage(param = "Nama", argum = savedForm.nama)
        DetailMessage(param = "Email", argum = savedForm.NoHandphone)

    }

}

@Composable
fun DetailMessage(param: String, argum: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = param, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = argum, modifier = Modifier.weight(2f))
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}





