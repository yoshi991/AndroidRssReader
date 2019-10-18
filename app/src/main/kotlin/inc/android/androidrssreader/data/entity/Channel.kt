package inc.android.androidrssreader.data.entity

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root

@Root(strict = false)
data class Channel(
    @Attribute(name = "about", required = false)
    @Namespace(reference = "http://www.w3.org/1999/02/22-rdf-syntax-ns#")
    val about: String,

    @Element(name = "title")
    val title: String,

    @Element(name = "link")
    val link: String,

    @Element(name = "description")
    val description: String

)
