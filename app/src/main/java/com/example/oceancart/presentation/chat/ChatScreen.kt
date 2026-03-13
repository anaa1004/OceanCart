package com.example.oceancart.presentation.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.oceancart.data.model.Sender
import com.example.oceancart.data.model.chatMessages
import com.example.oceancart.presentation.chat.BuyerBubble
import com.example.oceancart.presentation.chat.ChatDateLabel
import com.example.oceancart.presentation.chat.ChatTopBar
import com.example.oceancart.presentation.chat.SellerBubble
import com.example.oceancart.presentation.chat.SellerImageBubble


@Composable
fun ChatScreen(
    onBackClick: () -> Unit
) {

    Column(Modifier.fillMaxSize()) {

        ChatTopBar(onBackClick)

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {

            item {
                ChatDateLabel("Hari ini")
            }

            items(chatMessages) { message ->

                when {

                    message.sender == Sender.BUYER -> {
                        BuyerBubble(
                            message = message.text ?: "",
                            time = message.time
                        )
                    }

                    message.sender == Sender.SELLER && message.image != null -> {
                        SellerImageBubble(
                            text = message.text ?: "",
                            time = message.time
                        )
                    }

                    message.sender == Sender.SELLER -> {
                        SellerBubble(
                            message = message.text ?: "",
                            time = message.time
                        )
                    }
                }
            }
        }
    }
}