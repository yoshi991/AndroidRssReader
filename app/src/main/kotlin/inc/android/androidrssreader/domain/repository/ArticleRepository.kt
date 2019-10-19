package inc.android.androidrssreader.domain.repository

import inc.android.androidrssreader.data.entity.HatenaRSS

interface ArticleRepository {
    suspend fun fetchArticles(uri: String): HatenaRSS
}
