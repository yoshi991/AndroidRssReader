package inc.android.androidrssreader

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import inc.android.androidrssreader.data.di.ApiModule
import inc.android.androidrssreader.presentation.di.ActivityModule
import inc.android.androidrssreader.presentation.di.ViewModelFactoryModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        ApiModule::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
