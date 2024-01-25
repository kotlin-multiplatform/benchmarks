package kmp.benchmarks.serialization.model.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonClass
import com.squareup.moshi.ToJson
import kotlinx.datetime.LocalDate

@JsonClass(generateAdapter = true)
data class MacOsReleases(
    val updated: LocalDate,
    val key: List<String>,
    val versions: List<Version>
) {
    enum class External(private val stringValue: String) {
        BIG_SUR("Big Sur"),
        CATALINA("Catalina"),
        CHEETAH("Cheetah"),
        EL_CAPITAN("El Capitan"),
        HIGH_SIERRA("High Sierra"),
        JAGUAR("Jaguar"),
        KODIAK("Kodiak"),
        LEOPARD("Leopard"),
        LION("Lion"),
        MAVERICKS("Mavericks"),
        MOJAVE("Mojave"),
        MONTEREY("Monterey"),
        MOUNTAIN_LION("Mountain Lion"),
        PANTHER("Panther"),
        PUMA("Puma"),
        SIERRA("Sierra"),
        SNOW_LEOPARD("Snow Leopard"),
        SONOMA("Sonoma"),
        TIGER("Tiger"),
        VENTURA("Ventura"),
        YOSEMITE("Yosemite");

        companion object {
            fun fromString(value: String): External = entries.first { it.stringValue == value }
        }

        override fun toString(): String = stringValue
    }

    @JsonClass(generateAdapter = true)
    data class Version(
        val family: String,
        val version: String,
        val platforms: List<String>,
        val internal: String,
        val external: External,
        val announced: LocalDate,
        val released: LocalDate,
        val requirements: List<String>,
        val releases: List<Release>
    ) {
        @JsonClass(generateAdapter = true)
        data class Release(
            val version: String,
            val platforms: List<String>,
            val build: String,
            val darwin: String,
            val kernel: String,
            val released: String,
        )
    }
}

class LocalDateAdapter {
    @ToJson
    fun toJson(value: LocalDate): String = value.toString()

    @FromJson
    fun fromJson(value: String): LocalDate = LocalDate.parse(value)
}

class ExternalAdapter {
    @ToJson
    fun toJson(value: MacOsReleases.External): String = value.toString()

    @FromJson
    fun fromJson(value: String): MacOsReleases.External = MacOsReleases.External.fromString(value)
}