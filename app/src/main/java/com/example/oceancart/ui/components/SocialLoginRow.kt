package com.example.oceancart.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.oceancart.R

@Composable

fun SocialLoginRow(
    onGoogleClick: () -> Unit,
    onFacebookClick: () -> Unit,
    onWhatsappClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = onFacebookClick
        ) {
            Icon(
                painter = painterResource(R.drawable.icons_facebook),
                contentDescription = "Facebook",
                tint = Color.Unspecified
            )
        }

        IconButton(
            onClick = onGoogleClick
        ) {
            Icon(
                painter = painterResource(R.drawable.icons_google),
                contentDescription = "Google",
                tint = Color.Unspecified
            )
        }

        IconButton(
            onClick = onWhatsappClick
        ) {
            Icon(
                painter = painterResource(R.drawable.icons_whatsapp),
                contentDescription = "Whatsapp",
                tint = Color.Unspecified
            )
        }
    }
}