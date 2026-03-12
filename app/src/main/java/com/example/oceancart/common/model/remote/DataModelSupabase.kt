package com.example.oceancart.common.model.remote

import kotlinx.serialization.Serializable

@Serializable
data class Clients(
    val email: String,
    val peran: String,
    val name: String,
    val noTelepon: String,
    val password: String
)