/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.akexorcist.repositoryarchcomponents.api

/**
 * A generic class that holds a value with its loading status.
 *
 * @param <T>
</T> */
class Request<T>(val data: T?, val isForceFetch: Boolean) {

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null || javaClass != obj.javaClass) return false

        val request = obj as Request<*>?

        if (isForceFetch != request!!.isForceFetch) return false
        return if (data != null) data == request.data else request.data == null
    }

    override fun hashCode(): Int {
        var result = if (isForceFetch) 1 else 0
        result = 31 * result + (data?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Request{" +
                "isForceFetch=" + isForceFetch +
                ", data=" + data +
                '}'
    }
}
