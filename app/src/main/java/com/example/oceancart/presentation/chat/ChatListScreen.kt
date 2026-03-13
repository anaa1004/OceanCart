package com.example.oceancart.presentation.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancart.data.model.ChatItem
import com.example.oceancart.data.model.chatItems


@Composable
fun ChatListScreen(
    chatItems: List<ChatItem>,
    onChatClick: (ChatItem) -> Unit
) {

    Column {

        Text(
            text = "Pesan",
            fontSize = 22.sp,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn {

            items(chatItems) { chat ->

                ChatListItem(
                    chat = chat,
                    onClick = { onChatClick(chat) }
                )
            }
        }
    }
}