package inc.android.androidrssreader.data.entity

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace

data class Item(
    @Attribute(name = "about", required = false)
    @Namespace(reference = "http://www.w3.org/1999/02/22-rdf-syntax-ns#")
    val about: String,

    @Element(name = "title")
    val title: String,

    @Element(name = "link")
    val link: String,

    @Element(name = "description")
    val description: String,

    @Element(name = "date")
    @Namespace(reference = "http://purl.org/dc/elements/1.1/")
    val date: String,

    @Element(name = "subject")
    @Namespace(reference = "http://purl.org/dc/elements/1.1/")
    val subject: String,

    @Element(name = "bookmarkcount")
    @Namespace(reference = "http://www.hatena.ne.jp/info/xmlns#")
    val bookMarkCount: Int
)
