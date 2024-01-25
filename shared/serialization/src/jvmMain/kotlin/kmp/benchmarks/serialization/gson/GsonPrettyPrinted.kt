package kmp.benchmarks.serialization.gson

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kmp.benchmarks.serialization.gson.typeadapters.RuntimeTypeAdapterFactory
import kmp.benchmarks.serialization.model.gson.Coordinates
import kmp.benchmarks.serialization.model.gson.CoordinatesAdapter
import kmp.benchmarks.serialization.model.gson.ExternalAdapter
import kmp.benchmarks.serialization.model.gson.GeoJSONObject
import kmp.benchmarks.serialization.model.gson.HtmlChunk
import kmp.benchmarks.serialization.model.gson.GithubPush
import kmp.benchmarks.serialization.model.gson.LocalDateAdapter
import kmp.benchmarks.serialization.model.gson.MacOsReleases
import kmp.benchmarks.serialization.model.gson.UserProfile
import kotlinx.datetime.LocalDate

object GsonPrettyPrinted {
    private val gson: Gson = GsonBuilder()
        .registerTypeAdapter(LocalDate::class.java, LocalDateAdapter())
        .registerTypeAdapter(MacOsReleases.External::class.java, ExternalAdapter())
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
        .registerTypeAdapter(Coordinates::class.java, CoordinatesAdapter())
        .registerTypeAdapterFactory(
            RuntimeTypeAdapterFactory.of(HtmlChunk::class.java, "type")
                .registerSubtype(HtmlChunk.Paragraph::class.java, "p")
                .registerSubtype(HtmlChunk.GeekboxChart::class.java, "geekbox_chart")
                .registerSubtype(HtmlChunk.Image::class.java, "image")
                .registerSubtype(HtmlChunk.Heading2::class.java, "h2")
                .registerSubtype(HtmlChunk.PerfChart::class.java, "perf_chart")
        )
        .serializeNulls()
        .setPrettyPrinting()
        .disableHtmlEscaping()
        .create()

    fun decodeLargeListFromString(jsonString: String): List<GithubPush.Normal> =
        gson.fromJson(
            jsonString,
            TypeToken.getParameterized(List::class.java, GithubPush.Normal::class.java).type
        )

    fun encodeLargeListToString(value: List<GithubPush.Normal>): String =
        gson.toJson(value)

    fun decodeLargeListCompactFromString(jsonString: String): List<GithubPush.Compact> =
        gson.fromJson(
            jsonString,
            TypeToken.getParameterized(List::class.java, GithubPush.Compact::class.java).type
        )

    fun encodeLargeListCompactToString(value: List<GithubPush.Compact>): String =
        gson.toJson(value)

    fun decodeMacOsReleasesFromString(jsonString: String): MacOsReleases =
        gson.fromJson(jsonString, MacOsReleases::class.java)

    fun encodeMacOsReleasesToString(value: MacOsReleases): String =
        gson.toJson(value)

    fun decodePolymorphicGeoFromString(jsonString: String): List<GeoJSONObject> =
        gson.fromJson(
            jsonString,
            TypeToken.getParameterized(List::class.java, GeoJSONObject::class.java).type
        )

    fun encodePolymorphicGeoToString(value: List<GeoJSONObject>): String =
        gson.toJson(
            value,
            TypeToken.getParameterized(List::class.java, GeoJSONObject::class.java).type
        )

    fun decodePolymorphicHtmlFromString(jsonString: String): List<HtmlChunk> =
        gson.fromJson(
            jsonString,
            TypeToken.getParameterized(List::class.java, HtmlChunk::class.java).type
        )

    fun encodePolymorphicHtmlToString(value: List<HtmlChunk>): String =
        gson.toJson(value, TypeToken.getParameterized(List::class.java, HtmlChunk::class.java).type)

    fun decodeUserProfileFromString(jsonString: String): UserProfile =
        gson.fromJson(jsonString, UserProfile::class.java)

    fun encodeUserProfileToString(value: UserProfile): String =
        gson.toJson(value)
}