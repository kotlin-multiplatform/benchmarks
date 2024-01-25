package kmp.benchmarks.serialization.model.kotlinxserialization

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ArraySerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * https://datatracker.ietf.org/doc/html/rfc7946
 */
@Serializable
sealed interface GeoJSONObject {
    @SerialName("Point")
    @Serializable
    data class Point(
        val coordinates: Coordinates
    ) : GeoJSONObject

    @SerialName("LineString")
    @Serializable
    data class LineString(
        val coordinates: List<Coordinates>
    ) : GeoJSONObject

    @SerialName("Polygon")
    @Serializable
    data class Polygon(
        val coordinates: List<List<Coordinates>>
    ) : GeoJSONObject

    @SerialName("MultiPoint")
    @Serializable
    data class MultiPoint(
        val coordinates: List<Coordinates>
    ) : GeoJSONObject

    @SerialName("MultiLineString")
    @Serializable
    data class MultiLineString(
        val coordinates: List<List<Coordinates>>
    ) : GeoJSONObject

    @SerialName("MultiPolygon")
    @Serializable
    data class MultiPolygon(
        val coordinates: List<List<List<Coordinates>>>
    ) : GeoJSONObject

    @SerialName("GeometryCollection")
    @Serializable
    data class GeometryCollection(
        val geometries: List<GeoJSONObject>
    ) : GeoJSONObject
}

//typealias Coordinates = List<Double>

@Serializable(with = CoordinatesSerializer::class)
data class Coordinates(
    val longitude: Double,
    val latitude: Double
)

@OptIn(ExperimentalSerializationApi::class)
object CoordinatesSerializer : KSerializer<Coordinates> {
    private val delegateSerializer = ListSerializer(Double.serializer())
    override val descriptor: SerialDescriptor = SerialDescriptor("Coordinates", delegateSerializer.descriptor)

    override fun deserialize(decoder: Decoder): Coordinates =
        decoder.decodeSerializableValue(delegateSerializer).let { (longitude, latitude) ->
            Coordinates(longitude, latitude)
        }

    override fun serialize(encoder: Encoder, value: Coordinates) {
        encoder.encodeSerializableValue(
            delegateSerializer,
            listOf(
                value.longitude,
                value.latitude
            )
        )
    }
}