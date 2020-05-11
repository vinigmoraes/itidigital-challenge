package br.com.itidigitalchallenge.core.password.violations

class PasswordUpperCaseViolation : Violation {

    override fun message(): String = "Password must have at least one uppercase letter"
}
