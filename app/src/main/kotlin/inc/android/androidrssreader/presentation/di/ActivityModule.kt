package inc.android.androidrssreader.presentation.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import inc.android.androidrssreader.presentation.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            ViewModelModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}
