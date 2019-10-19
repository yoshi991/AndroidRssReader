package inc.android.androidrssreader.data.repository

import inc.android.androidrssreader.data.api.API
import inc.android.androidrssreader.data.entity.HatenaRSS
import inc.android.androidrssreader.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl
@Inject
constructor(
    private val api: API
) : ArticleRepository {
    override suspend fun fetchArticles(uri: String): HatenaRSS {
        return api.fetchArticles(uri)
    }
}
