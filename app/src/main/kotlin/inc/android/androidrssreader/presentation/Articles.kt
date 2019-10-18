package inc.android.androidrssreader.presentation

import androidx.annotation.StringRes
import inc.android.androidrssreader.R

enum class Articles(
    @StringRes val title: Int,
    val uri: String
) {
    GENERAL(
        R.string.article_general,
        "http://b.hatena.ne.jp/hotentry.rss"
    )
}
