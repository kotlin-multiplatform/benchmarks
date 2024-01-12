package kmp.benchmarks.serialization.kotlinxserialization

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

@OptIn(ExperimentalSerializationApi::class)
val kotlinxSerializationJson: Json = Json {
    prettyPrint = true
    prettyPrintIndent = "  "
}