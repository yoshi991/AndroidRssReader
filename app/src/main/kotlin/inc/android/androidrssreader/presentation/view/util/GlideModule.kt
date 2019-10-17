package inc.android.androidrssreader.presentation.view.util

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import inc.android.androidrssreader.util.OkHttpClientProvider
import okhttp3.OkHttpClient
import java.io.InputStream

@GlideModule
class GlideModule : AppGlideModule() {
    private var okHttpClient: OkHttpClient? = null

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        if (okHttpClient == null)
            okHttpClient = (context as? OkHttpClientProvider)?.okHttpClient

        okHttpClient?.let {
            registry.replace(
                GlideUrl::class.java,
                InputStream::class.java,
                OkHttpUrlLoader.Factory(it)
            )
        }
        super.registerComponents(context, glide, registry)
    }
}
