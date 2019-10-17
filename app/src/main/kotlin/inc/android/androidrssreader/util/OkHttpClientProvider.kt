package inc.android.androidrssreader.util

import okhttp3.OkHttpClient

interface OkHttpClientProvider {
    val okHttpClient: OkHttpClient
}
