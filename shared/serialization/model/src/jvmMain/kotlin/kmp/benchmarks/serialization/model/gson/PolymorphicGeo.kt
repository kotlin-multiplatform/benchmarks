package kmp.benchmarks.serialization.model.gson

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter

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

//typealias Coordinates = List<Double>

data class Coordinates(
    val longitude: Double,
    val latitude: Double
)

class CoordinatesAdapter : TypeAdapter<Coordinates>() {
    override fun write(out: JsonWriter?, value: Coordinates?) {
        out?.run {
            value?.let { coordinates ->
                beginArray()
                value(coordinates.longitude)
                value(coordinates.latitude)
                endArray()
            }
        }
    }

    override fun read(`in`: JsonReader?): Coordinates {
        var longitude: Double = -1.0
        var latitude: Double = -1.0

        `in`?.run {
            beginArray()

            longitude = nextDouble()
            latitude = nextDouble()

            endArray()
        }

        return Coordinates(longitude, latitude)
    }
}