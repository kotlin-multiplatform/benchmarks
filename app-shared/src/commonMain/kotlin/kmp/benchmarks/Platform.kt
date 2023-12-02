package kmp.benchmarks

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform