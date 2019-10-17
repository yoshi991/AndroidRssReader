package inc.android.androidrssreader

import com.facebook.stetho.Stetho
import com.jakewharton.threetenabp.AndroidThreeTen
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        // LeakCanary
        LeakCanary.install(this)

        // Dagger2
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

        // Stetho
        Stetho.initializeWithDefaults(this)
        AndroidThreeTen.init(this)
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder()
            .application(this)
            .build()
}
