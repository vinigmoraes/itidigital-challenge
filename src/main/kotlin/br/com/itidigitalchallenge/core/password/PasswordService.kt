package br.com.itidigitalchallenge.core.password

class PasswordService {

    fun validate(password: String) = Password.create(password)
}
