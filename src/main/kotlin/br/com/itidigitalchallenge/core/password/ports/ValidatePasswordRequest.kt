package br.com.itidigitalchallenge.core.password.ports

import com.fasterxml.jackson.annotation.JsonProperty

data class ValidatePasswordRequest(
    @get:JsonProperty("password")
    val password: String
)
