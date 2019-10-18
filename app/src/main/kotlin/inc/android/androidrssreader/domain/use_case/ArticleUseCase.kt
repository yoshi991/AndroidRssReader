package inc.android.androidrssreader.domain.use_case

import inc.android.androidrssreader.domain.repository.ArticleRepository
import javax.inject.Inject

interface ArticleUseCase

class ArticleUseCaseImpl
@Inject
constructor(
    private val articleRepository: ArticleRepository
) : ArticleUseCase
