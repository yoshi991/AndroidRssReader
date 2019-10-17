package inc.android.androidrssreader.data.di

import android.net.Uri
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import inc.android.androidrssreader.data.api.UriAdapter
import inc.android.androidrssreader.util.ZonedDateTimeTypeAdapter
import okhttp3.logging.HttpLoggingInterceptor
import org.threeten.bp.ZonedDateTime
import timber.log.Timber
import javax.inject.Singleton

@Module
class NetworkUtilModule {
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(Uri::class.java, UriAdapter())
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(ZonedDateTime::class.java, ZonedDateTimeTypeAdapter())
            .create()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val tree = Timber.tag("Network")
        return HttpLoggingInterceptor { tree.v(it) }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideStethoInterceptor(): StethoInterceptor {
        return StethoInterceptor()
    }
}
