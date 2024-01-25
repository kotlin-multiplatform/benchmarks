package kmp.benchmarks.serialization.model.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonClass
import com.squareup.moshi.ToJson

/**
 * https://datatracker.ietf.org/doc/html/rfc7946
 */
sealed interface GeoJSONObject {
    @JsonClass(generateAdapter = true)
    data class Point(
        val coordinates: Coordinates
    ) : GeoJSONObject

    @JsonClass(generateAdapter = true)
    data class LineString(
        val coordinates: List<Coordinates>
    ) : GeoJSONObject

    @JsonClass(generateAdapter = true)
    data class Polygon(
        val coordinates: List<List<Coordinates>>
    ) : GeoJSONObject

    @JsonClass(generateAdapter = true)
    data class MultiPoint(
        val coordinates: List<Coordinates>
    ) : GeoJSONObject

    @JsonClass(generateAdapter = true)
    data class MultiLineString(
        val coordinates: List<List<Coordinates>>
    ) : GeoJSONObject

    @JsonClass(generateAdapter = true)
    data class MultiPolygon(
        val coordinates: List<List<List<Coordinates>>>
    ) : GeoJSONObject

    @JsonClass(generateAdapter = true)
    data class GeometryCollection(
        val geometries: List<GeoJSONObject>
    ) : GeoJSONObject
}

//typealias Coordinates = List<Double>

@JsonClass(generateAdapter = true)
data class Coordinates(
    val longitude: Double,
    val latitude: Double
)

class CoordinatesAdapter {
    @ToJson
    fun toJson(value: Coordinates): List<Double> = listOf(
        value.longitude,
        value.latitude
    )

    @FromJson
    fun fromJson(values: List<Double>): Coordinates = values.let { (longitude, latitude) ->
        Coordinates(longitude, latitude)
    }
}