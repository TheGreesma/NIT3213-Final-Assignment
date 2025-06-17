package com.example.myassssmentapplication.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.RawValue

data class LoginResponse(
    val keypass: String
)

data class DashboardResponse(
    val entities: List<Entity>,
    val entityTotal: Int
)

@Parcelize
data class Entity(
    val fields: @RawValue Map<String, Any?>
) : Parcelable 