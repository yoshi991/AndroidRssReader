package inc.android.androidrssreader.presentation.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import inc.android.androidrssreader.presentation.view.articles.ArticlesViewModel
import inc.android.androidrssreader.presentation.view.base.view_model.ViewModelKey

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ArticlesViewModel::class)
    fun bindRootViewModel(viewModel: ArticlesViewModel): ViewModel
}
