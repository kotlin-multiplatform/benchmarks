package kmp.benchmarks.serialization.model.kotlinxserialization

import kotlinx.datetime.LocalDate
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
data class MacOsReleases(
    val updated: LocalDate,
    val key: List<String>,
    val versions: List<Version>
) {
    @Serializable
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
//        @Serializable(with = ExternalSerializer::class)
        enum class External(private val stringValue: String) {
            @SerialName("Big Sur") BIG_SUR("Big Sur"),
            @SerialName("Catalina") CATALINA("Catalina"),
            @SerialName("Cheetah") CHEETAH("Cheetah"),
            @SerialName("El Capitan") EL_CAPITAN("El Capitan"),
            @SerialName("High Sierra") HIGH_SIERRA("High Sierra"),
            @SerialName("Jaguar") JAGUAR("Jaguar"),
            @SerialName("Kodiak") KODIAK("Kodiak"),
            @SerialName("Leopard") LEOPARD("Leopard"),
            @SerialName("Lion") LION("Lion"),
            @SerialName("Mavericks") MAVERICKS("Mavericks"),
            @SerialName("Mojave") MOJAVE("Mojave"),
            @SerialName("Monterey") MONTEREY("Monterey"),
            @SerialName("Mountain Lion") MOUNTAIN_LION("Mountain Lion"),
            @SerialName("Panther") PANTHER("Panther"),
            @SerialName("Puma") PUMA("Puma"),
            @SerialName("Sierra") SIERRA("Sierra"),
            @SerialName("Snow Leopard") SNOW_LEOPARD("Snow Leopard"),
            @SerialName("Sonoma") SONOMA("Sonoma"),
            @SerialName("Tiger") TIGER("Tiger"),
            @SerialName("Ventura") VENTURA("Ventura"),
            @SerialName("Yosemite") YOSEMITE("Yosemite");

            companion object {
                @Throws(NoSuchElementException::class)
                fun fromString(value: String): External = entries.first { it.stringValue == value }
            }

            override fun toString(): String = stringValue
        }

//        object ExternalSerializer : KSerializer<External> {
//            override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("External", PrimitiveKind.STRING)
//
//            override fun deserialize(decoder: Decoder): External = External.fromString(decoder.decodeString())
//
//            override fun serialize(encoder: Encoder, value: External) {
//                encoder.encodeString(value.toString())
//            }
//        }

        @Serializable
        data class Release(
            val version: String,
            val platforms: List<String>,
            val build: String,
            val darwin: String,
            val kernel: String,
            val released: String
        )
    }
}