import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun Listas() {
    var selectedColor by remember { mutableStateOf(Color.Gray) }
    var selectedFont by remember { mutableStateOf("Monospace") }
    var isColorMenuExpanded by remember { mutableStateOf(false) }
    var isFontMenuExpanded by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("Escribe aquí...") }


    val colors = listOf(Color.Gray, Color.Blue, Color.Cyan, Color.Red, Color.Yellow)
    val colorNames = listOf("Gray", "Blue", "Cyan", "Red", "Yellow")


    val fonts = listOf("Monospace", "SansSerif", "Serif", "Default", "Cursive")
    val fontFamilies = mapOf(
        "Monospace" to FontFamily.Monospace,
        "SansSerif" to FontFamily.SansSerif,
        "Serif" to FontFamily.Serif,
        "Default" to FontFamily.Default,
        "Cursive" to FontFamily.Cursive
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Selecciona un color:",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            ),
            modifier = Modifier.align(Alignment.Start)
        )

        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .clip(RoundedCornerShape(8.dp))) {

            Text(
                text = "Color: ${colorNames[colors.indexOf(selectedColor)]}",
                modifier = Modifier
                    .clickable { isColorMenuExpanded = true }
                    .padding(16.dp)
            )

            DropdownMenu(
                expanded = isColorMenuExpanded,
                onDismissRequest = { isColorMenuExpanded = false },
                modifier = Modifier.background(Color(0xFFF0F0F0))
            ) {
                colors.forEachIndexed { index, color ->
                    DropdownMenuItem(
                        text = { Text(text = colorNames[index]) },
                        onClick = {
                            selectedColor = color
                            isColorMenuExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Selecciona una tipografía:",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            ),
            modifier = Modifier.align(Alignment.Start)
        )

        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .clip(RoundedCornerShape(8.dp))) {

            Text(
                text = "Tipografía: $selectedFont",
                modifier = Modifier
                    .clickable { isFontMenuExpanded = true }
                    .padding(16.dp)
            )

            DropdownMenu(
                expanded = isFontMenuExpanded,
                onDismissRequest = { isFontMenuExpanded = false },
                modifier = Modifier.background(Color(0xFFF0F0F0))
            ) {
                fonts.forEach { font ->
                    DropdownMenuItem(
                        text = { Text(text = font) },
                        onClick = {
                            selectedFont = font
                            isFontMenuExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Escribe algo:",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            ),
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            BasicTextField(
                value = text,
                onValueChange = { text = it },
                textStyle = TextStyle(
                    color = selectedColor,
                    fontFamily = fontFamilies[selectedFont] ?: FontFamily.SansSerif,
                    fontSize = 16.sp
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

