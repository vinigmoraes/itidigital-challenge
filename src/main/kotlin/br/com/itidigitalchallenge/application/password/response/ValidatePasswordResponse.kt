package br.com.itidigitalchallenge.application.password.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ValidatePasswordResponse(
    @get:JsonProperty("valid")
    val valid: Boolean
) {
    companion object {
        fun create(isValid: Boolean) = ValidatePasswordResponse(valid = isValid)
    }
}
