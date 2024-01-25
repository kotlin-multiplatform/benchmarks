package kmp.benchmarks.serialization.moshi

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import kmp.benchmarks.serialization.model.moshi.CoordinatesAdapter
import kmp.benchmarks.serialization.model.moshi.ExternalAdapter
import kmp.benchmarks.serialization.model.moshi.GeoJSONObject
import kmp.benchmarks.serialization.model.moshi.GithubPush
import kmp.benchmarks.serialization.model.moshi.HtmlChunk
import kmp.benchmarks.serialization.model.moshi.LocalDateAdapter
import kmp.benchmarks.serialization.model.moshi.MacOsReleases
import kmp.benchmarks.serialization.model.moshi.UserProfile

@OptIn(ExperimentalStdlibApi::class)
object Moshi {
    private val moshi: Moshi = Moshi.Builder()
        .add(LocalDateAdapter())
        .add(ExternalAdapter())
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
        .add(CoordinatesAdapter())
        .add(
            PolymorphicJsonAdapterFactory.of(HtmlChunk::class.java, "type")
                .withSubtype(HtmlChunk.Paragraph::class.java, "p")
                .withSubtype(HtmlChunk.GeekboxChart::class.java, "geekbox_chart")
                .withSubtype(HtmlChunk.Image::class.java, "image")
                .withSubtype(HtmlChunk.Heading2::class.java, "h2")
                .withSubtype(HtmlChunk.PerfChart::class.java, "perf_chart")
        )
        .build()

    fun decodeLargeListFromString(jsonString: String): List<GithubPush.Normal> =
        moshi.adapter<List<GithubPush.Normal>>().fromJson(jsonString)!!

    fun encodeLargeListToString(value: List<GithubPush.Normal>): String =
        moshi.adapter<List<GithubPush.Normal>>().toJson(value)

    fun decodeLargeListCompactFromString(jsonString: String): List<GithubPush.Compact> =
        moshi.adapter<List<GithubPush.Compact>>().fromJson(jsonString)!!

    fun encodeLargeListCompactToString(value: List<GithubPush.Compact>): String =
        moshi.adapter<List<GithubPush.Compact>>().toJson(value)

    fun decodeMacOsReleasesFromString(jsonString: String): MacOsReleases =
        moshi.adapter<MacOsReleases>().fromJson(jsonString)!!

    fun encodeMacOsReleasesToString(value: MacOsReleases): String =
        moshi.adapter<MacOsReleases>().toJson(value)

    fun decodePolymorphicGeoFromString(jsonString: String): List<GeoJSONObject> =
        moshi.adapter<List<GeoJSONObject>>().fromJson(jsonString)!!

    fun encodePolymorphicGeoToString(value: List<GeoJSONObject>): String =
        moshi.adapter<List<GeoJSONObject>>().toJson(value)

    fun decodePolymorphicHtmlFromString(jsonString: String): List<HtmlChunk> =
        moshi.adapter<List<HtmlChunk>>().fromJson(jsonString)!!

    fun encodePolymorphicHtmlToString(value: List<HtmlChunk>): String =
        moshi.adapter<List<HtmlChunk>>().serializeNulls().toJson(value)

    fun decodeUserProfileFromString(jsonString: String): UserProfile =
        moshi.adapter<UserProfile>().fromJson(jsonString)!!

    fun encodeUserProfileToString(value: UserProfile): String =
        moshi.adapter<UserProfile>().toJson(value)
}