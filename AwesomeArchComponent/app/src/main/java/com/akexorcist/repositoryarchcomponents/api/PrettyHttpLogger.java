package com.akexorcist.repositoryarchcomponents.api;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by trusttanapruk on 8/22/2016.
 */
public class PrettyHttpLogger implements HttpLoggingInterceptor.Logger {
    private static String TAG = PrettyHttpLogger.class.getSimpleName();

    @Override
    public void log(@NonNull String message) {
        if (!message.startsWith("{") && !message.startsWith("[")) {
            largeLog(TAG, message);
            return;
        }
        try {
            String prettyPrintJson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create()
                    .toJson(new JsonParser().parse(message));
            largeLog(TAG, prettyPrintJson);
        } catch (JsonSyntaxException exception) {
            largeLog(TAG, "html header parse failed");
            exception.printStackTrace();
            largeLog(TAG, message);
        }
    }

    private void largeLog(String tag, String content) {
        int MAX_LOG_LENGTH = 4000;
        if (content.length() > MAX_LOG_LENGTH) {
            Log.d(tag, content.substring(0, MAX_LOG_LENGTH).replace("&quot;", "\""));
            largeLog(tag, content.substring(MAX_LOG_LENGTH));
        } else {
            Log.d(tag, content.replace("&quot;", "\""));
        }
    }
}
