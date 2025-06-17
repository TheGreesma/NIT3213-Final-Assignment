package com.example.myassssmentapplication.data.model

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParseException
import java.lang.reflect.Type

class EntityDeserializer : JsonDeserializer<Entity> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Entity {
        val jsonObject = json?.asJsonObject ?: throw JsonParseException("Entity is null")
        val map = mutableMapOf<String, Any?>()
        for ((key, value) in jsonObject.entrySet()) {
            map[key] = when {
                value.isJsonPrimitive -> when {
                    value.asJsonPrimitive.isString -> value.asString
                    value.asJsonPrimitive.isNumber -> value.asNumber
                    value.asJsonPrimitive.isBoolean -> value.asBoolean
                    else -> value.toString()
                }
                value.isJsonNull -> null
                else -> value.toString()
            }
        }
        return Entity(fields = map)
    }
} 