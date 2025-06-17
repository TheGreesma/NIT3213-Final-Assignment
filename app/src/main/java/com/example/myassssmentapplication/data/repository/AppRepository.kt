package com.example.myassssmentapplication.data.repository

import android.util.Log
import com.example.myassssmentapplication.data.api.ApiService
import com.example.myassssmentapplication.data.model.DashboardResponse
import com.example.myassssmentapplication.data.model.LoginResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun login(username: String, password: String): Result<LoginResponse> {
        return try {
            Log.d("AppRepository", "Attempting login with username: $username")
            val response = apiService.login(mapOf(
                "username" to username,
                "password" to password
            ))
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.d("AppRepository", "Login successful, keypass: ${it.keypass}")
                    Result.success(it)
                } ?: Result.failure(Exception("Empty response body"))
            } else {
                Log.e("AppRepository", "Login failed with code: ${response.code()}, message: ${response.message()}")
                Result.failure(Exception("Login failed: ${response.code()} - ${response.message()}"))
            }
        } catch (e: Exception) {
            Log.e("AppRepository", "Login error", e)
            Result.failure(e)
        }
    }

    suspend fun getDashboard(keypass: String): Result<DashboardResponse> {
        return try {
            Log.d("AppRepository", "Fetching dashboard with keypass: $keypass")
            val response = apiService.getDashboard(keypass)
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.d("AppRepository", "Dashboard fetch successful, entities: ${it.entityTotal}")
                    Result.success(it)
                } ?: Result.failure(Exception("Empty response body"))
            } else {
                Log.e("AppRepository", "Dashboard fetch failed with code: ${response.code()}, message: ${response.message()}")
                Result.failure(Exception("Failed to fetch dashboard: ${response.code()} - ${response.message()}"))
            }
        } catch (e: Exception) {
            Log.e("AppRepository", "Dashboard fetch error", e)
            Result.failure(e)
        }
    }
} 