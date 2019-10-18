package inc.android.androidrssreader.presentation.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import inc.android.androidrssreader.presentation.view.articles.ArticlesFragment

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeArticlesFragment(): ArticlesFragment
}
