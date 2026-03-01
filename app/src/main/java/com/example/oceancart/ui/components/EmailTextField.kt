package com.example.oceancart.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.oceancart.R
import com.example.oceancart.ui.theme.DarkBlue
import kotlin.math.sin

@Composable

fun EmailTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth(),
        placeholder = {Text("Email/Username")},
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.person_rounded),
                contentDescription = null
            )
        },
        shape = RoundedCornerShape(50.dp),

        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = DarkBlue,
            unfocusedBorderColor = DarkBlue
        ),
        singleLine = true
    )
}