package kmp.benchmarks.networking.retrofit.moshi

import kmp.benchmarks.networking.JsonStrings
import kmp.benchmarks.serialization.moshi.Moshi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import java.net.HttpURLConnection
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class RetrofitMoshiApiClientTest {
    private val mockWebServer = MockWebServer()
    private lateinit var apiClient: RetrofitMoshiApiClient

    @BeforeTest
    fun setup() {
        mockWebServer.start()

        apiClient = RetrofitMoshiApiClient(mockWebServer.url("/"))
    }

    @AfterTest
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Test
    fun largeList() = runBlocking {
        mockWebServer.enqueue(
            MockResponse().apply {
                setResponseCode(HttpURLConnection.HTTP_OK)
                addHeader("Content-Type", "application/json")
                setBody(JsonStrings.Minimised.largeList)
            }
        )

        assertEquals(
            Moshi.decodeLargeListFromString(JsonStrings.Minimised.largeList),
            apiClient.apiService.largeList()
        )
    }

    @Test
    fun macOsReleases() = runBlocking {
        mockWebServer.enqueue(
            MockResponse().apply {
                setResponseCode(HttpURLConnection.HTTP_OK)
                addHeader("Content-Type", "application/json")
                setBody(JsonStrings.Minimised.macosReleases)
            }
        )

        assertEquals(
            Moshi.decodeMacOsReleasesFromString(JsonStrings.Minimised.macosReleases),
            apiClient.apiService.macOsReleases()
        )
    }

    @Test
    fun polymorphicGeo() = runBlocking {
        mockWebServer.enqueue(
            MockResponse().apply {
                setResponseCode(HttpURLConnection.HTTP_OK)
                addHeader("Content-Type", "application/json")
                setBody(JsonStrings.Minimised.polymorphicGeo)
            }
        )

        assertEquals(
            Moshi.decodePolymorphicGeoFromString(JsonStrings.Minimised.polymorphicGeo),
            apiClient.apiService.polymorphicGeo()
        )
    }

    @Test
    fun polymorphicHtml() = runBlocking {
        mockWebServer.enqueue(
            MockResponse().apply {
                setResponseCode(HttpURLConnection.HTTP_OK)
                addHeader("Content-Type", "application/json")
                setBody(JsonStrings.Minimised.polymorphicHtml)
            }
        )

        assertEquals(
            Moshi.decodePolymorphicHtmlFromString(JsonStrings.Minimised.polymorphicHtml),
            apiClient.apiService.polymorphicHtml()
        )
    }

    @Test
    fun userProfile() = runBlocking {
        mockWebServer.enqueue(
            MockResponse().apply {
                setResponseCode(HttpURLConnection.HTTP_OK)
                addHeader("Content-Type", "application/json")
                setBody(JsonStrings.Minimised.userProfile)
            }
        )

        assertEquals(
            Moshi.decodeUserProfileFromString(JsonStrings.Minimised.userProfile),
            apiClient.apiService.userProfile()
        )
    }
}