package inc.android.androidrssreader.domain.use_case

import inc.android.androidrssreader.data.entity.Rdf
import inc.android.androidrssreader.domain.repository.ArticleRepository
import inc.android.androidrssreader.presentation.Articles
import inc.android.androidrssreader.util.extension.result
import javax.inject.Inject

interface ArticleUseCase {
    suspend fun getGeneral(): Result<Rdf>
}

class ArticleUseCaseImpl
@Inject
constructor(
    private val articleRepository: ArticleRepository
) : ArticleUseCase {
    override suspend fun getGeneral(): Result<Rdf> {
        return result { articleRepository.fetchArticles<Rdf>(Articles.GENERAL.uri) }
    }
}
