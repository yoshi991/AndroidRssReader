package inc.android.androidrssreader.presentation.view.base

import dagger.android.support.DaggerFragment
import inc.android.androidrssreader.presentation.view.base.view_model.ViewModelFactory
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
}
