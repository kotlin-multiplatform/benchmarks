package kmp.benchmarks.serialization.moshi

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import kmp.benchmarks.serialization.model.moshi.GeoJSONObject
import kmp.benchmarks.serialization.model.moshi.HtmlChunk

val moshi: Moshi = Moshi.Builder()
    .add(
        PolymorphicJsonAdapterFactory.of(GeoJSONObject::class.java, "type")
            .withSubtype(GeoJSONObject.Point::class.java, "Point")
            .withSubtype(GeoJSONObject.LineString::class.java, "LineString")
            .withSubtype(GeoJSONObject.Polygon::class.java, "Polygon")
            .withSubtype(GeoJSONObject.MultiPoint::class.java, "MultiPoint")
            .withSubtype(GeoJSONObject.MultiLineString::class.java, "MultiLineString")
            .withSubtype(GeoJSONObject.MultiPolygon::class.java, "MultiPolygon")
            .withSubtype(GeoJSONObject.GeometryCollection::class.java, "GeometryCollection")
    )
    .add(
        PolymorphicJsonAdapterFactory.of(HtmlChunk::class.java, "type")
            .withSubtype(HtmlChunk.Paragraph::class.java, "p")
            .withSubtype(HtmlChunk.GeekboxChart::class.java, "geekbox_chart")
            .withSubtype(HtmlChunk.Image::class.java, "image")
            .withSubtype(HtmlChunk.Heading2::class.java, "h2")
            .withSubtype(HtmlChunk.PerfChart::class.java, "perf_chart")
    )
    .build()