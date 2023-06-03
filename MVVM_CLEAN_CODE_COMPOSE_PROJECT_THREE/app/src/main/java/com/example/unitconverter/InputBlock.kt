package com.example.unitconverter

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.ui.theme.UnitConverterTheme

@Composable
fun InputBlock(
    conversion: Conversion,
    inputText: MutableState<String>,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier.padding(0.dp,20.dp,0.dp,0.dp)) {
        Row(modifier = modifier.fillMaxWidth()) {
            TextField(
                value = inputText.value,
                onValueChange = {
                    inputText.value = it
                },
                modifier = modifier.fillMaxWidth(0.65F),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Number
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.3F)
                ),
                textStyle = TextStyle(color = Color.DarkGray, fontSize = 30.sp)
            )
            Text(
                text = conversion.convertFrom,
                fontSize = 24.sp,
                modifier = modifier.padding(10.dp,30.dp,0.dp,0.dp)
                    .fillMaxWidth(0.35F)
            )
        }
    }
}