package inc.android.androidrssreader.presentation.view.articles

import androidx.lifecycle.LiveData
import inc.android.androidrssreader.data.entity.HatenaArticles
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

    private val _article = mutableLiveDataOf<HatenaArticles>()
    val article: LiveData<HatenaArticles> = _article

    fun getArticles(position: Int) {
        coroutineScope.launch {
            articleUseCase.getArticles(position)
                .onSuccess { _article.postValue(it) }
                .onFailure { onError(it) }
        }
    }
}
