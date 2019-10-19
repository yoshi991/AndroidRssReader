package inc.android.androidrssreader.presentation.view.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.databinding.BindableItem
import inc.android.androidrssreader.R
import inc.android.androidrssreader.data.entity.HatenaItem
import inc.android.androidrssreader.databinding.FragmentArticlesBinding
import inc.android.androidrssreader.databinding.ItemArticlesBinding
import inc.android.androidrssreader.presentation.Articles
import inc.android.androidrssreader.presentation.view.base.BaseFragment

class ArticlesFragment : BaseFragment() {

    lateinit var binding: FragmentArticlesBinding

    private val viewModel: ArticlesViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ArticlesViewModel::class.java)
    }

    private val adapter = GroupAdapter<ViewHolder>()
    private val items = mutableListOf<ArticlesItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticlesBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = getString(Articles.values()[position].title)
        }.attach()

        for (i in Articles.values().indices) {
            items.add(ArticlesItem(emptyList()) {
                // TODO: navigate detail fragment
            })
        }
        adapter.updateAsync(items)

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab ?: return
                if (items[tab.position].items.isEmpty()) {
                    viewModel.getArticles(tab.position)
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
        })

        with(viewModel) {
            article.observe(this@ArticlesFragment) {
                val lists = it.rss.lists ?: return@observe
                items[it.position].items = lists
                adapter.notifyDataSetChanged()
            }
        }
        viewModel.getArticles(Articles.values().first().ordinal)
    }

    inner class ArticlesItem(
        var items: List<HatenaItem>,
        protected val onClick: (HatenaItem) -> Unit
    ) : BindableItem<ItemArticlesBinding>() {
        private val adapter = GroupAdapter<ViewHolder>()
        private lateinit var layoutManager: GridLayoutManager

        override fun getLayout(): Int = R.layout.item_articles

        override fun bind(viewBinding: ItemArticlesBinding, position: Int) {
            (0 until viewBinding.recyclerView.itemDecorationCount)
                .forEach(viewBinding.recyclerView::removeItemDecorationAt)

            layoutManager = GridLayoutManager(context, 2)
            viewBinding.recyclerView.layoutManager = layoutManager
            viewBinding.recyclerView.adapter = adapter
            viewBinding.recyclerView.setHasFixedSize(true)
            adapter.update(items.map { ArticleItem(it) { onClick } })
        }
    }
}
