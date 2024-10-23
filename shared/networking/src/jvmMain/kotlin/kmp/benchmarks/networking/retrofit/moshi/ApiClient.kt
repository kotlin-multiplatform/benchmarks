package kmp.benchmarks.networking.retrofit.moshi

import kmp.benchmarks.serialization.model.moshi.GeoJSONObject
import kmp.benchmarks.serialization.model.moshi.GithubPush
import kmp.benchmarks.serialization.model.moshi.HtmlChunk
import kmp.benchmarks.serialization.model.moshi.MacOsReleases
import kmp.benchmarks.serialization.model.moshi.UserProfile
import kmp.benchmarks.serialization.moshi.Moshi
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("/kotlin-multiplatform/benchmarks/main/json-data/large-list.json")
    suspend fun largeList(): List<GithubPush.Normal>

    @GET("/kotlin-multiplatform/benchmarks/main/json-data/macos-releases.json")
    suspend fun macOsReleases(): MacOsReleases

    @GET("/kotlin-multiplatform/benchmarks/main/json-data/polymorphic-geo.json")
    suspend fun polymorphicGeo(): List<GeoJSONObject>

    @GET("/kotlin-multiplatform/benchmarks/main/json-data/polymorphic-html.json")
    suspend fun polymorphicHtml(): List<HtmlChunk>

    @GET("/kotlin-multiplatform/benchmarks/main/json-data/user-profile.json")
    suspend fun userProfile(): UserProfile
}

class ApiClient(
    baseUrl: HttpUrl = "https://raw.githubusercontent.com".toHttpUrl()
) {
    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BASIC
                }
            )
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.moshi))
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}