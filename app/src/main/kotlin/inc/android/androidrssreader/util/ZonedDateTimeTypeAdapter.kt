package inc.android.androidrssreader.util

import com.google.gson.*
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeParseException
import java.lang.reflect.Type

class ZonedDateTimeTypeAdapter : JsonSerializer<ZonedDateTime>, JsonDeserializer<ZonedDateTime> {
    override fun serialize(
        src: ZonedDateTime,
        typeOfSrc: Type,
        context: JsonSerializationContext
    ): JsonElement = JsonPrimitive(src.toString())

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): ZonedDateTime? {
        return try {
            ZonedDateTime.parse(json.asJsonPrimitive.asString)
        } catch (e: DateTimeParseException) {
            null
        }
    }
}
