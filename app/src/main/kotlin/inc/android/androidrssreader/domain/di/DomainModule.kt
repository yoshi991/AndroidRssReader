package inc.android.androidrssreader.domain.di

import dagger.Binds
import dagger.Module
import inc.android.androidrssreader.domain.use_case.ArticleUseCase
import inc.android.androidrssreader.domain.use_case.ArticleUseCaseImpl
import javax.inject.Singleton

@Module
interface DomainModule {
    @Binds
    @Singleton
    fun bindArticleUseCase(useCase: ArticleUseCaseImpl): ArticleUseCase
}
