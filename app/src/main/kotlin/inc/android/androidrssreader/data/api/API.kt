package inc.android.androidrssreader.data.api

import inc.android.androidrssreader.data.entity.HatenaRSS
import retrofit2.http.GET
import retrofit2.http.Url

interface API {
    @GET
    suspend fun fetchArticles(@Url url: String): HatenaRSS
}
