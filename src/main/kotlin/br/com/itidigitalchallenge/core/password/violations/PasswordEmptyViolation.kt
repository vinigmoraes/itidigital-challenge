package br.com.itidigitalchallenge.core.password.violations

class PasswordEmptyViolation : Violation {

    override fun message(): String = "Password content is empty"
}
