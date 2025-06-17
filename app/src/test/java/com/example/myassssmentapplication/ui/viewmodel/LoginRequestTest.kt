package com.example.myassssmentapplication

import org.junit.Test
import org.junit.Assert.*

class LoginRequestTest {

    @Test
    fun `login request fields should be set correctly`() {
        val request = LoginRequest("john", "secret123")
        assertEquals("john", request.username)
        assertEquals("secret123", request.password)
    }
}
