package com.ned.core.data.helper

import android.content.Context

class SharedPreferencesHelper(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    fun saveUsername(username: String) {
        val editor = sharedPreferences.edit()
        editor.putString("username", username)
        editor.apply()
    }

    fun getUsername(): String? {
        return sharedPreferences.getString("username", "User")
    }

    fun saveUserFullName(fullName: String) {
        with(sharedPreferences.edit()) {
            putString("user_full_name", fullName)
            apply()
        }
    }

    fun getUserFullName(): String? {
        return sharedPreferences.getString("user_full_name", null)
    }
}