package com.akexorcist.repositoryarchcomponents.api

import android.util.Log

import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException

import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by trusttanapruk on 8/22/2016.
 */
class PrettyHttpLogger : HttpLoggingInterceptor.Logger {

    override fun log(message: String) {
        if (!message.startsWith("{") && !message.startsWith("[")) {
            largeLog(TAG, message)
            return
        }
        try {
            val prettyPrintJson = GsonBuilder()
                    .setPrettyPrinting()
                    .create()
                    .toJson(JsonParser().parse(message))
            largeLog(TAG, prettyPrintJson)
        } catch (exception: JsonSyntaxException) {
            largeLog(TAG, "html header parse failed")
            exception.printStackTrace()
            largeLog(TAG, message)
        }

    }

    private fun largeLog(tag: String, content: String) {
        val MAX_LOG_LENGTH = 4000
        if (content.length > MAX_LOG_LENGTH) {
            Log.d(tag, content.substring(0, MAX_LOG_LENGTH).replace("&quot;", "\""))
            largeLog(tag, content.substring(MAX_LOG_LENGTH))
        } else {
            Log.d(tag, content.replace("&quot;", "\""))
        }
    }

    companion object {
        private val TAG = PrettyHttpLogger::class.java.simpleName
    }
}
