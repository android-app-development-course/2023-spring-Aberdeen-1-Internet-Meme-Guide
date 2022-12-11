package com.example.forumapp.services

import org.json.JSONException
import org.json.JSONObject

object JsonUtil{
    fun json2HashMap(jsonString: String): HashMap<String, Any>? {
        try {
            val jsonObject = JSONObject(jsonString)
            val keyIter: Iterator<String> = jsonObject.keys()
            var key: String
            var value: Any
            val valueMap = HashMap<String, Any>()
            while (keyIter.hasNext()) {
                key = keyIter.next()
                value = jsonObject[key] as Any
                valueMap[key] = value
            }
            return valueMap
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return null
    }
}