package br.com.itidigitalchallenge.core.password.violations

class PasswordLowerCaseViolation : Violation {

    override fun message(): String = "Password must have at least one lowercase letter"
}
