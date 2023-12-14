package kmp.benchmarks.networking.endpoints

import com.goncalossilva.resources.Resource
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.Url
import io.ktor.http.headersOf
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.core.use
import kmp.benchmarks.networking.ApiClient
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class PolymorphicGeoTest {

    @Test
    fun `GIVEN mocked api client WHEN polymorphicGeo is invoked THEN expected data is returned`() = runBlocking {
        val jsonString = Resource("src/commonTest/resources/polymorphic-geo.json").readText()

        val apiClient = ApiClient(
            baseUrl = Url("https://fake.url"),
            engine = MockEngine { request ->
                when {
                    request.url.encodedPath.matches(Regex("""/kotlin-multiplatform/benchmarks/main/json-data/polymorphic-geo.json""")) -> {
                        respond(
                            content = ByteReadChannel(jsonString),
                            status = HttpStatusCode.OK,
                            headers = headersOf(HttpHeaders.ContentType, "application/json")
                        )
                    }

                    else -> fail()
                }
            }
        )

        assertEquals(
            Json.decodeFromString(jsonString),
            apiClient.use { it.polymorphicGeo() }
        )
    }
}