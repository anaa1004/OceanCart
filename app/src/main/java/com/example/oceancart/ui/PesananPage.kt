package com.example.oceancart.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.oceancart.ui.components.HeaderBar

@Composable
fun PesananPage (){
    Scaffold() {
        innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            HeaderBar(
                title = "Pesanan Saya"
            )
        }
    }
}


