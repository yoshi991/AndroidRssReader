package inc.android.androidrssreader.presentation.view.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import inc.android.androidrssreader.presentation.view.util.GlideApp

@BindingAdapter("image_path")
fun ImageView.loadImage(path: String?) {
    GlideApp.with(context)
        .load(path)
        .apply {
            diskCacheStrategy(DiskCacheStrategy.DATA)
            transition(DrawableTransitionOptions.withCrossFade())
        }
        .into(this)
}
