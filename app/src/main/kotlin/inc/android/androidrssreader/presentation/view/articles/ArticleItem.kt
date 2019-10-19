package inc.android.androidrssreader.presentation.view.articles

import android.view.View
import com.xwray.groupie.databinding.BindableItem
import inc.android.androidrssreader.R
import inc.android.androidrssreader.data.entity.HatenaItem
import inc.android.androidrssreader.databinding.ItemArticleBinding

data class ArticleItem(
    private val article: HatenaItem,
    private val onClick: (HatenaItem) -> Unit
) : BindableItem<ItemArticleBinding>() {
    override fun getLayout(): Int = R.layout.item_article

    override fun bind(viewBinding: ItemArticleBinding, position: Int) {
        viewBinding.article = article
        if (article.imageurl == null) {
            viewBinding.itemImage.visibility = View.GONE
        } else {
            viewBinding.itemImage.visibility = View.VISIBLE
        }
    }
}
