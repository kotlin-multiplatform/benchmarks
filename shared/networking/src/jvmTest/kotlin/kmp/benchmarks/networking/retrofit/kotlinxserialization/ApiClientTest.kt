package kmp.benchmarks.networking.retrofit.kotlinxserialization

import kmp.benchmarks.networking.JsonStrings
import kmp.benchmarks.serialization.kotlinxserialization.KotlinxSerialization
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import java.net.HttpURLConnection
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ApiClientTest {
    private val mockWebServer = MockWebServer()
    private lateinit var apiClient: ApiClient

    @BeforeTest
    fun setup() {
        mockWebServer.start()

        apiClient = ApiClient(mockWebServer.url("/"))
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
            KotlinxSerialization.decodeLargeListFromString(JsonStrings.Minimised.largeList),
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
            KotlinxSerialization.decodeMacOsReleasesFromString(JsonStrings.Minimised.macosReleases),
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
            KotlinxSerialization.decodePolymorphicGeoFromString(JsonStrings.Minimised.polymorphicGeo),
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
            KotlinxSerialization.decodePolymorphicHtmlFromString(JsonStrings.Minimised.polymorphicHtml),
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
            KotlinxSerialization.decodeUserProfileFromString(JsonStrings.Minimised.userProfile),
            apiClient.apiService.userProfile()
        )
    }
}