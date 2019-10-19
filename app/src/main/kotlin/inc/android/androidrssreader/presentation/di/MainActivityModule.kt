package inc.android.androidrssreader.presentation.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import inc.android.androidrssreader.presentation.view.articles.ArticlesFragment
import inc.android.androidrssreader.presentation.view.webview.WebViewFragment

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeArticlesFragment(): ArticlesFragment

    @ContributesAndroidInjector
    abstract fun contributeWebViewFragment(): WebViewFragment
}
