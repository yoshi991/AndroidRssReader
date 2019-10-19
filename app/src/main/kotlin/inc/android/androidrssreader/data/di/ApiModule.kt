package inc.android.androidrssreader.data.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import inc.android.androidrssreader.BuildConfig
import inc.android.androidrssreader.data.api.API
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Singleton

@Module(includes = [NetworkUtilModule::class])
object ApiModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideOkHttp(
        logInterceptor: HttpLoggingInterceptor,
        stethoInterceptor: StethoInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .apply { if (BuildConfig.DEBUG) addNetworkInterceptor(stethoInterceptor) }
            .build()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideApi(httpClient: OkHttpClient): API {
        return Retrofit.Builder()
            .baseUrl("http://b.hatena.ne.jp/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .client(httpClient)
            .build()
            .create(API::class.java)
    }
}
