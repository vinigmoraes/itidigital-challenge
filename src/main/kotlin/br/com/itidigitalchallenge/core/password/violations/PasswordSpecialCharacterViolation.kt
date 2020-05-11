package br.com.itidigitalchallenge.core.password.violations

class PasswordSpecialCharacterViolation : Violation {

    override fun message(): String = "Password must have at least one special character"
}
