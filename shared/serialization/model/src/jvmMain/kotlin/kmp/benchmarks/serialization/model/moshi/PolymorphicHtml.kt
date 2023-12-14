package kmp.benchmarks.serialization.model.moshi

import com.squareup.moshi.JsonClass

sealed interface HtmlChunk {
    @JsonClass(generateAdapter = true)
    data class Paragraph(
        val data: Data
    ) : HtmlChunk {
        @JsonClass(generateAdapter = true)
        data class Data(
            val text: String
        )
    }

    @JsonClass(generateAdapter = true)
    data class GeekboxChart(
        val data: Data
    ) : HtmlChunk {
        @JsonClass(generateAdapter = true)
        data class Data(
            val chartName: String,
            val headingRows: String,
            val chart: List<List<String>>
        )
    }

    @JsonClass(generateAdapter = true)
    data class Image(
        val data: Data
    ) : HtmlChunk {
        @JsonClass(generateAdapter = true)
        data class Data(
            val id: String,
            val title: String?,
            val credit: String,
            val caption: String,
            val imageUrl: String,
            val imageWidth: Int,
            val imageHeight: Int
        )
    }

    @JsonClass(generateAdapter = true)
    data class Heading2(
        val data: Data
    ) : HtmlChunk {
        @JsonClass(generateAdapter = true)
        data class Data(
            val text: String
        )
    }

    @JsonClass(generateAdapter = true)
    data class PerfChart(
        val data: Data
    ) : HtmlChunk {
        @JsonClass(generateAdapter = true)
        data class Data(
            val chartName: String,
            val explanation: String,
            val tests: List<String>,
            val products: List<Product>
        ) {
            @JsonClass(generateAdapter = true)
            data class Product(
                val productName: String,
                val ratings: List<String>
            )
        }
    }
}