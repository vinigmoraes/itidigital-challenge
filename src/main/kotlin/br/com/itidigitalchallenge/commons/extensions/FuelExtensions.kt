package br.com.itidigitalchallenge.commons.extensions

import com.github.kittinunf.fuel.core.Response

val Response.json: String
    get() = String(data, Charsets.UTF_8)
