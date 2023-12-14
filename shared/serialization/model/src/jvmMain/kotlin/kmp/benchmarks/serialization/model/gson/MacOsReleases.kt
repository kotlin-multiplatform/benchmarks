package kmp.benchmarks.serialization.model.gson

data class MacOsReleases(
    val updated: String,
    val key: List<String>,
    val versions: List<Version>
) {
    data class Version(
        val family: String,
        val version: String,
        val platforms: List<String>,
        val internal: String,
        val external: String,
        val announced: String,
        val released: String,
        val requirements: List<String>,
        val releases: List<Release>
    ) {
        data class Release(
            val version: String,
            val platforms: List<String>,
            val build: String,
            val darwin: String,
            val kernel: String,
            val released: String,
        )
    }
}