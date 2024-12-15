package kmp.benchmarks.networking.retrofit.kotlinxserialization

import kmp.benchmarks.networking.JsonStrings
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.Setup
import kotlinx.benchmark.State
import kotlinx.benchmark.TearDown
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import java.net.HttpURLConnection

@State(Scope.Benchmark)
class RetrofitKotlinxSerializationApiClientTestBenchmark {
    private val mockWebServer = MockWebServer()
    private lateinit var apiClient: RetrofitKotlinxSerializationApiClient

    @Setup
    fun setup() {
        mockWebServer.start()

        apiClient = RetrofitKotlinxSerializationApiClient(mockWebServer.url("/"))
    }

    @TearDown
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Benchmark
    fun largeList() = runBlocking {
        mockWebServer.enqueue(
            MockResponse().apply {
                setResponseCode(HttpURLConnection.HTTP_OK)
                addHeader("Content-Type", "application/json")
                setBody(JsonStrings.Minimised.largeList)
            }
        )

        apiClient.apiService.largeList()
    }

    @Benchmark
    fun macOsReleases() = runBlocking {
        mockWebServer.enqueue(
            MockResponse().apply {
                setResponseCode(HttpURLConnection.HTTP_OK)
                addHeader("Content-Type", "application/json")
                setBody(JsonStrings.Minimised.macosReleases)
            }
        )

        apiClient.apiService.macOsReleases()
    }

    @Benchmark
    fun polymorphicGeo() = runBlocking {
        mockWebServer.enqueue(
            MockResponse().apply {
                setResponseCode(HttpURLConnection.HTTP_OK)
                addHeader("Content-Type", "application/json")
                setBody(JsonStrings.Minimised.polymorphicGeo)
            }
        )

        apiClient.apiService.polymorphicGeo()
    }

    @Benchmark
    fun polymorphicHtml() = runBlocking {
        mockWebServer.enqueue(
            MockResponse().apply {
                setResponseCode(HttpURLConnection.HTTP_OK)
                addHeader("Content-Type", "application/json")
                setBody(JsonStrings.Minimised.polymorphicHtml)
            }
        )

        apiClient.apiService.polymorphicHtml()
    }

    @Benchmark
    fun userProfile() = runBlocking {
        mockWebServer.enqueue(
            MockResponse().apply {
                setResponseCode(HttpURLConnection.HTTP_OK)
                addHeader("Content-Type", "application/json")
                setBody(JsonStrings.Minimised.userProfile)
            }
        )

        apiClient.apiService.userProfile()
    }
}