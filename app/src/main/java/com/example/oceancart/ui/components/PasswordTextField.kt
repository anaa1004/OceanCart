package com.example.oceancart.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.oceancart.R
import com.example.oceancart.ui.theme.DarkBlue

@Composable

fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    visible: Boolean,
    onToggleVisibility: () -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text("Password")
        },

        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.lock_outline),
                contentDescription = null
            )
        },

        trailingIcon = {
            IconButton(onClick = onToggleVisibility) {
                Icon(
                    painter = painterResource(
                        if (visible) R.drawable.fitur_hide
                        else R.drawable.fitur_hide_off
                    ),
                    contentDescription = null
                )
            }
        },

        visualTransformation =
            if (visible) VisualTransformation.None
            else PasswordVisualTransformation(),

        shape = RoundedCornerShape(50.dp),

        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = DarkBlue,
            unfocusedBorderColor = DarkBlue
        ),

        singleLine = true
    )
}