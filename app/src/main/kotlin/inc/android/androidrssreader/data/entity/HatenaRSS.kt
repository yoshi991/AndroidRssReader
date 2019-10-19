package inc.android.androidrssreader.data.entity

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "rdf:RDF", strict = false)
class HatenaRSS {
    @set:ElementList(inline = true)
    @get:ElementList(inline = true)
    var lists: List<HatenaItem>? = null
}
