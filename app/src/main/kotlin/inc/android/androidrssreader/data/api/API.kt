package inc.android.androidrssreader.data.api

import retrofit2.http.GET
import retrofit2.http.Url

interface API {
    @GET
    suspend fun <T> fetchArticles(@Url url: String): List<T>
}
