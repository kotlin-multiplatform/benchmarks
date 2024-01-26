package kmp.benchmarks.serialization.model.gson

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import kotlinx.datetime.LocalDate

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
            @Throws(NoSuchElementException::class)
            fun fromString(value: String): External = entries.first { it.stringValue == value }
        }

        override fun toString(): String = stringValue
    }

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

class LocalDateAdapter : TypeAdapter<LocalDate>() {
    override fun write(out: JsonWriter?, value: LocalDate?) {
        out?.run {
            value?.let { date ->
                value(date.toString())
            }
        }
    }

    override fun read(`in`: JsonReader?): LocalDate {
        var date: String = ""

        `in`?.run {
            date = nextString()
        }

        return LocalDate.parse(date)
    }
}

class ExternalAdapter : TypeAdapter<MacOsReleases.External>() {
    override fun write(out: JsonWriter?, value: MacOsReleases.External?) {
        out?.run {
            value?.let { date ->
                value(date.toString())
            }
        }
    }

    override fun read(`in`: JsonReader?): MacOsReleases.External {
        var stringValue: String = ""

        `in`?.run {
            stringValue = nextString()
        }

        return MacOsReleases.External.fromString(stringValue)
    }
}