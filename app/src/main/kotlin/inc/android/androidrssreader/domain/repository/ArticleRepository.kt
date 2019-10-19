package inc.android.androidrssreader.domain.repository

import inc.android.androidrssreader.data.entity.HatenaArticles

interface ArticleRepository {
    suspend fun fetchArticles(uri: String, position: Int): HatenaArticles
}
