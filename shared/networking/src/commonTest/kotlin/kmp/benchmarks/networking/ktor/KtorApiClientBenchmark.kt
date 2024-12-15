package kmp.benchmarks.networking.ktor

import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.Url
import io.ktor.http.headersOf
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.core.use
import kmp.benchmarks.networking.JsonStrings
import kmp.benchmarks.networking.ktor.endpoints.largeList
import kmp.benchmarks.networking.ktor.endpoints.macOsReleases
import kmp.benchmarks.networking.ktor.endpoints.polymorphicGeo
import kmp.benchmarks.networking.ktor.endpoints.polymorphicHtml
import kmp.benchmarks.networking.ktor.endpoints.userProfile
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State
import kotlinx.coroutines.runBlocking
import kotlin.test.fail

@State(Scope.Benchmark)
class KtorApiClientTestBenchmark {

    @Benchmark
    fun largeList() = runBlocking {
        val apiClient = KtorApiClient(
            baseUrl = Url("https://fake.url"),
            engine = MockEngine { request ->
                when {
                    request.url.encodedPath.matches(Regex("""/kotlin-multiplatform/benchmarks/main/json-data/large-list.json""")) -> {
                        respond(
                            content = ByteReadChannel(JsonStrings.Minimised.largeList),
                            status = HttpStatusCode.OK,
                            headers = headersOf(HttpHeaders.ContentType, "application/json")
                        )
                    }

                    else -> fail()
                }
            }
        )

        apiClient.use { it.largeList() }
    }

    @Benchmark
    fun macOsReleases() = runBlocking {
        val apiClient = KtorApiClient(
            baseUrl = Url("https://fake.url"),
            engine = MockEngine { request ->
                when {
                    request.url.encodedPath.matches(Regex("""/kotlin-multiplatform/benchmarks/main/json-data/macos-releases.json""")) -> {
                        respond(
                            content = ByteReadChannel(JsonStrings.Minimised.macosReleases),
                            status = HttpStatusCode.OK,
                            headers = headersOf(HttpHeaders.ContentType, "application/json")
                        )
                    }

                    else -> fail()
                }
            }
        )

        apiClient.use { it.macOsReleases() }
    }

    @Benchmark
    fun polymorphicGeo() = runBlocking {
        val apiClient = KtorApiClient(
            baseUrl = Url("https://fake.url"),
            engine = MockEngine { request ->
                when {
                    request.url.encodedPath.matches(Regex("""/kotlin-multiplatform/benchmarks/main/json-data/polymorphic-geo.json""")) -> {
                        respond(
                            content = ByteReadChannel(JsonStrings.Minimised.polymorphicGeo),
                            status = HttpStatusCode.OK,
                            headers = headersOf(HttpHeaders.ContentType, "application/json")
                        )
                    }

                    else -> fail()
                }
            }
        )

        apiClient.use { it.polymorphicGeo() }
    }

    @Benchmark
    fun polymorphicHtml() = runBlocking {
        val apiClient = KtorApiClient(
            baseUrl = Url("https://fake.url"),
            engine = MockEngine { request ->
                when {
                    request.url.encodedPath.matches(Regex("""/kotlin-multiplatform/benchmarks/main/json-data/polymorphic-html.json""")) -> {
                        respond(
                            content = ByteReadChannel(JsonStrings.Minimised.polymorphicHtml),
                            status = HttpStatusCode.OK,
                            headers = headersOf(HttpHeaders.ContentType, "application/json")
                        )
                    }

                    else -> fail()
                }
            }
        )

        apiClient.use { it.polymorphicHtml() }
    }

    @Benchmark
    fun userProfile() = runBlocking {
        val apiClient = KtorApiClient(
            baseUrl = Url("https://fake.url"),
            engine = MockEngine { request ->
                when {
                    request.url.encodedPath.matches(Regex("""/kotlin-multiplatform/benchmarks/main/json-data/user-profile.json""")) -> {
                        respond(
                            content = ByteReadChannel(JsonStrings.Minimised.userProfile),
                            status = HttpStatusCode.OK,
                            headers = headersOf(HttpHeaders.ContentType, "application/json")
                        )
                    }

                    else -> fail()
                }
            }
        )

        apiClient.use { it.userProfile() }
    }
}