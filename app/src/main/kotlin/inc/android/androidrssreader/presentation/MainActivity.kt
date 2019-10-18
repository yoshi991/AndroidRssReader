package inc.android.androidrssreader.presentation

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import dagger.android.support.DaggerAppCompatActivity
import inc.android.androidrssreader.R
import inc.android.androidrssreader.databinding.ActivityMainBinding

class MainActivity : DaggerAppCompatActivity() {

    private val navController: NavController by lazy {
        findNavController(R.id.main_nav_host)
    }

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.appbar.setupWithNavController(navController)
    }
}
