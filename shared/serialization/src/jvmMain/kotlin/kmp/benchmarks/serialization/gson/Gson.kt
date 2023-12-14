package kmp.benchmarks.serialization.gson

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kmp.benchmarks.serialization.gson.typeadapters.RuntimeTypeAdapterFactory
import kmp.benchmarks.serialization.model.gson.GeoJSONObject
import kmp.benchmarks.serialization.model.gson.HtmlChunk

val gson: Gson = GsonBuilder()
    .registerTypeAdapterFactory(
        RuntimeTypeAdapterFactory.of(GeoJSONObject::class.java, "type")
            .registerSubtype(GeoJSONObject.Point::class.java, "Point")
            .registerSubtype(GeoJSONObject.LineString::class.java, "LineString")
            .registerSubtype(GeoJSONObject.Polygon::class.java, "Polygon")
            .registerSubtype(GeoJSONObject.MultiPoint::class.java, "MultiPoint")
            .registerSubtype(GeoJSONObject.MultiLineString::class.java, "MultiLineString")
            .registerSubtype(GeoJSONObject.MultiPolygon::class.java, "MultiPolygon")
            .registerSubtype(GeoJSONObject.GeometryCollection::class.java, "GeometryCollection")
    )
    .registerTypeAdapterFactory(
        RuntimeTypeAdapterFactory.of(HtmlChunk::class.java, "type")
            .registerSubtype(HtmlChunk.Paragraph::class.java, "p")
            .registerSubtype(HtmlChunk.GeekboxChart::class.java, "geekbox_chart")
            .registerSubtype(HtmlChunk.Image::class.java, "image")
            .registerSubtype(HtmlChunk.Heading2::class.java, "h2")
            .registerSubtype(HtmlChunk.PerfChart::class.java, "perf_chart")
    )
    .setPrettyPrinting()
    .serializeNulls()
    .disableHtmlEscaping()
    .create()