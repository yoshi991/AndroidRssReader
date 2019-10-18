package inc.android.androidrssreader.data.entity

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.NamespaceList
import org.simpleframework.xml.Root

@NamespaceList(
    Namespace(reference = "http://purl.org/rss/1.0/"),
    Namespace(reference = "http://www.w3.org/1999/02/22-rdf-syntax-ns#", prefix = "rdf"),
    Namespace(reference = "http://purl.org/dc/elements/1.1/", prefix = "dc"),
    Namespace(reference = "http://www.hatena.ne.jp/info/xmlns#", prefix = "hatena")
)
@Namespace(reference = "http://www.w3.org/1999/02/22-rdf-syntax-ns#")
@Root(strict = false)
data class Rdf(
    @Element(name = "channel")
    val channel: Channel,

    @ElementList(inline = true)
    val lists: List<Item>
)
