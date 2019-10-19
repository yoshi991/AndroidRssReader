package inc.android.androidrssreader.presentation.view.articles

import inc.android.androidrssreader.data.entity.HatenaRSS
import inc.android.androidrssreader.domain.use_case.ArticleUseCase
import inc.android.androidrssreader.presentation.view.base.BaseViewModel
import inc.android.androidrssreader.util.extension.mutableLiveDataOf
import kotlinx.coroutines.launch
import javax.inject.Inject

class ArticlesViewModel
@Inject
constructor(
    private val articleUseCase: ArticleUseCase
) : BaseViewModel() {

    private val _general = mutableLiveDataOf<HatenaRSS>()

    fun getGeneralArticle() {
        coroutineScope.launch {
            articleUseCase.getGeneral()
                .onSuccess { _general.postValue(it) }
                .onFailure { onError(it) }
        }
    }
}
