package kmp.benchmarks.serialization.kotlinxserialization

import kmp.benchmarks.serialization.model.kotlinxserialization.MacOsReleases
import kmp.benchmarks.serialization.model.kotlinxserialization.MacOsReleases.Version
import kmp.benchmarks.serialization.model.kotlinxserialization.UserProfile
import kotlinx.datetime.LocalDate

object FakeData {
    object MacOsReleases {
        val data = MacOsReleases(
            updated = LocalDate.parse("2023-10-01"),
            key = listOf(
                "? = No data available / unable to confirm"
            ),
            versions = listOf(
                Version(
                    family = "Mac OS X",
                    version = "Public Beta",
                    platforms = listOf(
                        "PowerPC (32-bit)"
                    ),
                    internal = "Kodiak",
                    external = Version.External.KODIAK,
                    announced = LocalDate.parse("2000-05-15"),
                    released = LocalDate.parse("2000-09-13"),
                    requirements = listOf(
                        "PowerPC G3 (original PowerBook G3 not supported)",
                        "128 MB of RAM",
                        "1.5 GB of avaialable disk space"
                    ),
                    releases = listOf(
                        Version.Release(
                            version = "US",
                            platforms = listOf(
                                "PowerPC"
                            ),
                            build = "1H39",
                            darwin = "1.2.1",
                            kernel = "xnu-?",
                            released = "2000-09-13"
                        ),
                        Version.Release(
                            version = "Int.",
                            platforms = listOf(
                                "PowerPC"
                            ),
                            build = "2E14",
                            darwin = "1.2.1",
                            kernel = "xnu-?",
                            released = "2000-09-13"
                        )
                    )
                ),
                Version(
                    family = "macOS",
                    version = "14",
                    platforms = listOf(
                        "Intel (x86-64)",
                        "ARM64"
                    ),
                    internal = "Sunburst",
                    external = Version.External.SONOMA,
                    announced = LocalDate.parse("2023-06-05"),
                    released = LocalDate.parse("2023-09-26"),
                    requirements = listOf(
                        "iMac (2019) and later",
                        "iMac Pro (2017)",
                        "MacBook Air (2018) and later",
                        "MacBook Pro (2018) and later",
                        "Mac Mini (2018) and later",
                        "Mac Studio (2022) and later",
                        "Mac Pro (2019) and later"
                    ),
                    releases = listOf(
                        Version.Release(
                            version = "14.0",
                            platforms = listOf(
                                "Intel",
                                "ARM64"
                            ),
                            build = "23A344",
                            darwin = "23.0.0",
                            kernel = "xnu-10002.1.13~1",
                            released = "2023-09-26"
                        )
                    )
                )
            )
        )

        val jsonString = """
            {
              "updated": "${data.updated}",
              "key": [
                ${data.key.joinToString { "\"$it\"" }}
              ],
              "versions": [
                ${data.versions.map { version ->  
                    """
                        {
                          "family": "${version.family}",
                          "version": "${version.version}",
                          "platforms": [
                            ${version.platforms.joinToString { "\"$it\"" }}
                          ],
                          "internal": "${version.internal}",
                          "external": "${version.external}",
                          "announced": "${version.announced}",
                          "released": "${version.released}",
                          "requirements": [
                            ${version.requirements.joinToString { "\"$it\"" }}
                          ],
                          "releases": [
                            ${version.releases.map { release -> 
                                """
                                    {
                                      "version": "${release.version}",
                                      "platforms": [
                                        ${release.platforms.joinToString { "\"$it\"" }}
                                      ],
                                      "build": "${release.build}",
                                      "darwin": "${release.darwin}",
                                      "kernel": "${release.kernel}",
                                      "released": "${release.released}"
                                    }
                                """.trimIndent()        
                            }}
                          ]
                        }
                    """.trimIndent()
                }}
                ,
                {
                  "family": "macOS",
                  "version": "14",
                  "platforms": [
                    "Intel (x86-64)",
                    "ARM64"
                  ],
                  "internal": "Sunburst",
                  "external": "Sonoma",
                  "announced": "2023-06-05",
                  "released": "2023-09-26",
                  "requirements": [
                    "iMac (2019) and later",
                    "iMac Pro (2017)",
                    "MacBook Air (2018) and later",
                    "MacBook Pro (2018) and later",
                    "Mac Mini (2018) and later",
                    "Mac Studio (2022) and later",
                    "Mac Pro (2019) and later"
                  ],
                  "releases": [
                    {
                      "version": "14.0",
                      "platforms": [
                        "Intel",
                        "ARM64"
                      ],
                      "build": "23A344",
                      "darwin": "23.0.0",
                      "kernel": "xnu-10002.1.13~1",
                      "released": "2023-09-26"
                    }
                  ]
                }
              ]
            }
        """.trimIndent()
    }

//    object PolymorphicGeo {
//        val data = listOf()
//
//        val jsonString = """
//
//        """.trimIndent()
//    }
//
//    object PolymorphicHtml {
//        val data = listOf()
//
//        val jsonString = """
//
//        """.trimIndent()
//    }

    object UserProfile {
        val data = UserProfile(
            personal = kmp.benchmarks.serialization.model.kotlinxserialization.UserProfile.Personal(
                firstName = "Name",
                lastName = "Last name",
                email = "email@test.com",
                phoneNumber = "888777666",
                emailVerified = false
            ),
            billingAddress = kmp.benchmarks.serialization.model.kotlinxserialization.UserProfile.BillingAddress(
                postCode = "AB1 2CD",
                city = "Some Town",
                streetAddress = "Some street",
                countryCode = "GB"
            ),
            delivery = kmp.benchmarks.serialization.model.kotlinxserialization.UserProfile.Delivery(
                name = "Some name",
                postCode = "EF3 4GH",
                city = "Somewhere",
                streetAddress = "Nice Street",
                countryCode = "GB",
                remarks = "On the second floor"
            ),
            preferences = kmp.benchmarks.serialization.model.kotlinxserialization.UserProfile.Preferences(
                notifications = false
            ),
            active = false
        )

        val jsonString = """
            {
              "personal": {
                "first_name": "${data.personal.firstName}",
                "last_name": "${data.personal.lastName}",
                "email": "${data.personal.email}",
                "phone_number": "${data.personal.phoneNumber}",
                "email_verified": ${data.personal.emailVerified}
              },
              "billingAddress": {
                "post_code": "${data.billingAddress.postCode}",
                "city": "${data.billingAddress.city}",
                "street_address": "${data.billingAddress.streetAddress}",
                "country_code": "${data.billingAddress.countryCode}"
              },
              "delivery": {
                "name": "${data.delivery.name}",
                "post_code": "${data.delivery.postCode}",
                "city": "${data.delivery.city}",
                "street_address": "${data.delivery.streetAddress}",
                "country_code": "${data.delivery.countryCode}",
                "remarks": "${data.delivery.remarks}"
              },
              "preferences": {
                "notifications": ${data.preferences.notifications}
              },
              "active": ${data.active}
            }
        """.trimIndent()
    }
}