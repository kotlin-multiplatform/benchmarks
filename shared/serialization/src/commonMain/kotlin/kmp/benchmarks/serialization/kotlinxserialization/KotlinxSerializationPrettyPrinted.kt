package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.model.kotlinxserialization.GeoJSONObject
import kmp.benchmarks.serialization.model.kotlinxserialization.GithubPush
import kmp.benchmarks.serialization.model.kotlinxserialization.HtmlChunk
import kmp.benchmarks.serialization.model.kotlinxserialization.MacOsReleases
import kmp.benchmarks.serialization.model.kotlinxserialization.UserProfile
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object KotlinxSerializationPrettyPrinted {

    @OptIn(ExperimentalSerializationApi::class)
    private val kotlinxSerializationJson: Json = Json {
        prettyPrint = true
        prettyPrintIndent = "  "
    }

    @OptIn(ExperimentalSerializationApi::class)
    private val kotlinxSerializationJsonIgnoreKeys: Json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
        prettyPrintIndent = "  "
    }

    @Throws(SerializationException::class, IllegalArgumentException::class)
    fun decodeLargeListFromString(jsonString: String): List<GithubPush.Normal> =
        kotlinxSerializationJson.decodeFromString(jsonString)

    @Throws(SerializationException::class, IllegalArgumentException::class)
    fun encodeLargeListToString(value: List<GithubPush.Normal>): String =
        kotlinxSerializationJson.encodeToString(value)

    @Throws(SerializationException::class, IllegalArgumentException::class)
    fun decodeLargeListCompactFromString(jsonString: String): List<GithubPush.Compact> =
        kotlinxSerializationJsonIgnoreKeys.decodeFromString(jsonString)

    @Throws(SerializationException::class, IllegalArgumentException::class)
    fun encodeLargeListCompactToString(value: List<GithubPush.Compact>): String =
        kotlinxSerializationJsonIgnoreKeys.encodeToString(value)

    @Throws(SerializationException::class, IllegalArgumentException::class)
    fun decodeMacOsReleasesFromString(jsonString: String): MacOsReleases =
        kotlinxSerializationJson.decodeFromString(jsonString)

    @Throws(SerializationException::class, IllegalArgumentException::class)
    fun encodeMacOsReleasesToString(value: MacOsReleases): String =
        kotlinxSerializationJson.encodeToString(value)

    @Throws(SerializationException::class, IllegalArgumentException::class)
    fun decodePolymorphicGeoFromString(jsonString: String): List<GeoJSONObject> =
        kotlinxSerializationJson.decodeFromString(jsonString)

    @Throws(SerializationException::class, IllegalArgumentException::class)
    fun encodePolymorphicGeoToString(value: List<GeoJSONObject>): String =
        kotlinxSerializationJson.encodeToString(value)

    @Throws(SerializationException::class, IllegalArgumentException::class)
    fun decodePolymorphicHtmlFromString(jsonString: String): List<HtmlChunk> =
        kotlinxSerializationJson.decodeFromString(jsonString)

    @Throws(SerializationException::class, IllegalArgumentException::class)
    fun encodePolymorphicHtmlToString(value: List<HtmlChunk>): String =
        kotlinxSerializationJson.encodeToString(value)

    @Throws(SerializationException::class, IllegalArgumentException::class)
    fun decodeUserProfileFromString(jsonString: String): UserProfile =
        kotlinxSerializationJson.decodeFromString(jsonString)

    @Throws(SerializationException::class, IllegalArgumentException::class)
    fun encodeUserProfileToString(value: UserProfile): String =
        kotlinxSerializationJson.encodeToString(value)
}