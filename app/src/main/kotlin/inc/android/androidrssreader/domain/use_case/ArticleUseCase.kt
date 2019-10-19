package inc.android.androidrssreader.domain.use_case

import inc.android.androidrssreader.data.entity.HatenaArticles
import inc.android.androidrssreader.domain.repository.ArticleRepository
import inc.android.androidrssreader.presentation.Articles
import inc.android.androidrssreader.util.extension.result
import javax.inject.Inject

interface ArticleUseCase {
    suspend fun getArticles(position: Int): Result<HatenaArticles>
}

class ArticleUseCaseImpl
@Inject
constructor(
    private val articleRepository: ArticleRepository
) : ArticleUseCase {
    override suspend fun getArticles(position: Int): Result<HatenaArticles> {
        return result {
            articleRepository.fetchArticles(
                uri = Articles.values()[position].uri,
                position = position
            )
        }
    }
}
