package inc.android.androidrssreader.data.repository

import inc.android.androidrssreader.data.api.API
import inc.android.androidrssreader.data.entity.HatenaArticles
import inc.android.androidrssreader.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl
@Inject
constructor(
    private val api: API
) : ArticleRepository {
    override suspend fun fetchArticles(uri: String, position: Int): HatenaArticles {
        return HatenaArticles(
            position = position,
            rss = api.fetchArticles(uri)
        )
    }
}
