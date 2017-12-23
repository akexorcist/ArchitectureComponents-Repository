package com.akexorcist.repositoryarchcomponents.api

import android.util.Log
import retrofit2.Response
import java.io.IOException


/**
 * Created by Anirut Teerabut on 12/23/2017.
 */
class ApiResponse<T> {
    val code: Int
    val body: T?
    val errorMessage: String?

    companion object {
        private val TAG = ApiResponse::class.java.simpleName
    }

    val isSuccessful: Boolean
        get() = code >= 200 && code < 300

    constructor(code: Int, body: T?, errorMessage: String?) {
        this.code = code
        this.body = body
        this.errorMessage = errorMessage
    }

    constructor(error: Throwable) {
        code = 500
        body = null
        errorMessage = error.message
    }

    constructor(response: Response<T>) {
        code = response.code()
        if (response.isSuccessful) {
            body = response.body()
            errorMessage = null
        } else {
            var message: String? = null
            if (response.errorBody() != null) {
                try {
                    message = response.errorBody()?.string()
                } catch (ignored: IOException) {
                    Log.e(TAG, "error while parsing response")
                }

            }
            if (message == null || message.trim().isEmpty()) {
                message = response.message()
            }
            errorMessage = message
            body = null
        }
    }
}