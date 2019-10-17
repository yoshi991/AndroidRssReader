package inc.android.androidrssreader.data.api

import android.net.Uri
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.io.IOException

class UriAdapter : TypeAdapter<Uri>() {

    @Throws(IOException::class)
    override fun write(out: JsonWriter, uri: Uri) {
        out.value(uri.toString())
    }

    @Throws(IOException::class)
    override fun read(`in`: JsonReader): Uri {
        return Uri.parse(`in`.nextString())
    }
}
