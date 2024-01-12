package kmp.benchmarks.serialization.model.kotlinxserialization

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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

typealias Coordinates = List<Double>

//@Serializable
//data class Coordinates(
//    val longitude: Double,
//    val latitude: Double
//)