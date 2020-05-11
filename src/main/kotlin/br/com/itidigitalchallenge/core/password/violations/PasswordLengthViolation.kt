package br.com.itidigitalchallenge.core.password.violations

class PasswordLengthViolation : Violation {

    override fun message(): String = "Password length should be minimum of 9 characters"
}
