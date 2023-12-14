package kmp.benchmarks.serialization.model.gson

/**
 * https://datatracker.ietf.org/doc/html/rfc7946
 */
sealed interface GeoJSONObject {
    data class Point(
        val coordinates: Coordinates
    ) : GeoJSONObject

    data class LineString(
        val coordinates: List<Coordinates>
    ) : GeoJSONObject

    data class Polygon(
        val coordinates: List<List<Coordinates>>
    ) : GeoJSONObject

    data class MultiPoint(
        val coordinates: List<Coordinates>
    ) : GeoJSONObject

    data class MultiLineString(
        val coordinates: List<List<Coordinates>>
    ) : GeoJSONObject

    data class MultiPolygon(
        val coordinates: List<List<List<Coordinates>>>
    ) : GeoJSONObject

    data class GeometryCollection(
        val geometries: List<GeoJSONObject>
    ) : GeoJSONObject
}

typealias Coordinates = List<Double>

//@JsonClass(generateAdapter = true)
//data class Coordinates(
//    val longitude: Double,
//    val latitude: Double
//)