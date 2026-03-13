package com.example.oceancart.data.model

import com.example.oceancart.R
import com.example.oceancart.presentation.chat.ChatListItem

data class ChatItem(
    val name: String,
    val message: String,
    val time: String,
    val unreadCount: Int = 0,
    val avatar: Int
)

val chatItems = listOf(
    ChatItem(
        "Raion Perikanan",
        "Halo Kak, ada yang bisa dibantu?",
        "09.50",
        1,
        R.drawable.avatar_raion
    ),
    ChatItem(
        "MBG Mart",
        "Stocknya masih ada 30kg ga pak?",
        "08.25",
        0,
        R.drawable.avatar_mbg
    ),
    ChatItem(
        "Joko Fresh Malang",
        "Oke",
        "07.00",
        0,
        R.drawable.avatar_jm
    ),
    ChatItem(
        "Seafood Pak Bahlil",
        "Mengirim foto",
        "Kemarin",
        5,
        R.drawable.avatar_sb
    ),
    ChatItem(
        "FPIK Store",
        "Oke, saya pesan 5 kg ya",
        "Sen",
        0,
        R.drawable.avatar_fs
    ),
)