package inc.android.androidrssreader.presentation.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import inc.android.androidrssreader.presentation.view.base.view_model.ViewModelFactory

@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
