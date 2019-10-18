package inc.android.androidrssreader.util.extension

import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData

fun <T> mutableLiveDataOf(): MutableLiveData<T> = MutableLiveData<T>()

@MainThread
fun <T> mutableLiveDataOf(defaultValue: T): MutableLiveData<T> {
    return MutableLiveData<T>().apply {
        value = defaultValue
    }
}
