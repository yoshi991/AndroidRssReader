package inc.android.androidrssreader.domain.repository

interface ArticleRepository {
    suspend fun <T> fetchArticles(uri: String): T
}
