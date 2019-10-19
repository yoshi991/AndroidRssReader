package inc.android.androidrssreader.data.entity

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

data class HatenaArticles(
    val position: Int,
    val rss: HatenaRSS
)

@Root(name = "rdf:RDF", strict = false)
class HatenaRSS {
    @set:ElementList(inline = true)
    @get:ElementList(inline = true)
    var lists: List<HatenaItem>? = null
}
