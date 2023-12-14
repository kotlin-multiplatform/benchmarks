package kmp.benchmarks.serialization.model.gson

sealed interface HtmlChunk {
    data class Paragraph(
        val data: Data
    ) : HtmlChunk {
        data class Data(
            val text: String
        )
    }

    data class GeekboxChart(
        val data: Data
    ) : HtmlChunk {
        data class Data(
            val chartName: String,
            val headingRows: String,
            val chart: List<List<String>>
        )
    }

    data class Image(
        val data: Data
    ) : HtmlChunk {
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

    data class Heading2(
        val data: Data
    ) : HtmlChunk {
        data class Data(
            val text: String
        )
    }

    data class PerfChart(
        val data: Data
    ) : HtmlChunk {
        data class Data(
            val chartName: String,
            val explanation: String,
            val tests: List<String>,
            val products: List<Product>
        ) {
            data class Product(
                val productName: String,
                val ratings: List<String>
            )
        }
    }
}