package inc.android.androidrssreader.presentation.view.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import inc.android.androidrssreader.databinding.FragmentArticlesBinding
import inc.android.androidrssreader.presentation.view.base.BaseFragment

class ArticlesFragment : BaseFragment() {

    lateinit var binding: FragmentArticlesBinding

    private val viewModel: ArticlesViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ArticlesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticlesBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }
}
