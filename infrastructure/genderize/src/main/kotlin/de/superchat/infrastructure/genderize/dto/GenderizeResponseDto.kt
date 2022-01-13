package de.superchat.infrastructure.genderize.dto

data class GenderizeResponseDto(
    val name: String,
    val gender: String?,
    val probability: Float
)
