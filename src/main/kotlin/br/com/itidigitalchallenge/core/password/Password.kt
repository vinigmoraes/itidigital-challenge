package br.com.itidigitalchallenge.core.password

import br.com.itidigitalchallenge.commons.extensions.isSpecialCharacter
import br.com.itidigitalchallenge.core.password.violations.PasswordEmptyViolation
import br.com.itidigitalchallenge.core.password.violations.PasswordLengthViolation
import br.com.itidigitalchallenge.core.password.violations.PasswordLowerCaseViolation
import br.com.itidigitalchallenge.core.password.violations.PasswordSpecialCharacterViolation
import br.com.itidigitalchallenge.core.password.violations.PasswordUpperCaseViolation
import br.com.itidigitalchallenge.core.password.violations.Violation

class Password(
    val content: String
) {

    private val violations = mutableListOf<Violation>()
    private val minimumLength = 9

    companion object {
        fun create(password: String) = Password(content = password)
            .apply {
                validLength()
                atLestOneDigit()
                atLestOneLowerCaseLetter()
                atLestOneUpperCaseLetter()
                atLestOneSpecialCharacter()
            }
    }

    fun isValid() = violations.isEmpty()

    private fun validLength() {
        if (content.length < minimumLength) violations.add(PasswordLengthViolation())
    }

    private fun atLestOneDigit() {
        if (content.isBlank()) violations.add(PasswordEmptyViolation())
    }

    private fun atLestOneLowerCaseLetter() {
        if (content.none { it.isLowerCase() }) violations.add(PasswordLowerCaseViolation())
    }

    private fun atLestOneUpperCaseLetter() {
        if (content.none { it.isUpperCase() }) violations.add(PasswordUpperCaseViolation())
    }

    private fun atLestOneSpecialCharacter() {
        if (content.none { it.isSpecialCharacter() }) violations.add(PasswordSpecialCharacterViolation())
    }
}
