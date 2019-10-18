package inc.android.androidrssreader.presentation.view.articles

import inc.android.androidrssreader.domain.use_case.ArticleUseCase
import inc.android.androidrssreader.presentation.view.base.BaseViewModel
import javax.inject.Inject

class ArticlesViewModel
@Inject
constructor(
    private val articleUseCase: ArticleUseCase
) : BaseViewModel()
