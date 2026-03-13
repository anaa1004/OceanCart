package com.example.oceancart.data.model

import com.example.oceancart.R

data class ChatMessage(
    val id: Int,
    val text: String? = null,
    val image: Int? = null,
    val time: String,
    val sender: Sender
)

enum class Sender {
    BUYER,
    SELLER
}

val chatMessages = listOf(
    ChatMessage(
        id = 1,
        text = "Halo Kak, ada yang bisa dibantu? 😊",
        time = "09.50",
        sender = Sender.SELLER
    ),
    ChatMessage(
        id = 2,
        text = "Pak, cumi segarnya masih ada?",
        time = "09.50",
        sender = Sender.BUYER
    ),
    ChatMessage(
        id = 3,
        text = "Ini foto stok pagi ini Kak, fresh👍",
        image = R.drawable.image_cumi,
        time = "09.50",
        sender = Sender.SELLER
    ),
    ChatMessage(
        id = 4,
        text = "Bagus! Berapa per kg?",
        time = "09.50",
        sender = Sender.BUYER
    )
)