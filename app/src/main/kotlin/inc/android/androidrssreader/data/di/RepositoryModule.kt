package inc.android.androidrssreader.data.di

import dagger.Binds
import dagger.Module
import inc.android.androidrssreader.data.repository.ArticleRepositoryImpl
import inc.android.androidrssreader.domain.repository.ArticleRepository
import javax.inject.Singleton

@Module
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindArticleRepository(repository: ArticleRepositoryImpl): ArticleRepository
}
