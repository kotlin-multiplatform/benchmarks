package kmp.benchmarks.serialization.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface HtmlChunk {
    @SerialName("p")
    @Serializable
    data class Paragraph(
        val data: Data
    ) : HtmlChunk {
        @Serializable
        data class Data(
            val text: String
        )
    }

    @SerialName("geekbox_chart")
    @Serializable
    data class GeekboxChart(
        val data: Data
    ) : HtmlChunk {
        @Serializable
        data class Data(
            val chartName: String,
            val headingRows: String,
            val chart: List<List<String>>
        )
    }

    @SerialName("image")
    @Serializable
    data class Image(
        val data: Data
    ) : HtmlChunk {
        @Serializable
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

    @SerialName("h2")
    @Serializable
    data class Heading2(
        val data: Data
    ) : HtmlChunk {
        @Serializable
        data class Data(
            val text: String
        )
    }

    @SerialName("perf_chart")
    @Serializable
    data class PerfChart(
        val data: Data
    ) : HtmlChunk {
        @Serializable
        data class Data(
            val chartName: String,
            val explanation: String,
            val tests: List<String>,
            val products: List<Product>
        ) {
            @Serializable
            data class Product(
                val productName: String,
                val ratings: List<String>
            )
        }
    }
}