package inc.android.androidrssreader.presentation

import androidx.annotation.StringRes
import inc.android.androidrssreader.R

enum class Articles(
    @StringRes val title: Int,
    val uri: String
) {
    GENERAL(
        R.string.article_general,
        "https://b.hatena.ne.jp/hotentry.rss"
    ),
    WORLD(
        R.string.article_world,
        "https://b.hatena.ne.jp/hotentry/social.rss"
    ),
    POLITICS_AND_ECONOMY(
        R.string.article_politics_and_economy,
        "https://b.hatena.ne.jp/hotentry/economics.rss"
    ),
    LIVING(
        R.string.article_living,
        "https://b.hatena.ne.jp/hotentry/life.rss"
    )
}
