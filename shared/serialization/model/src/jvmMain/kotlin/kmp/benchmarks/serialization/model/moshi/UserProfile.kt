package kmp.benchmarks.serialization.model.moshi

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserProfile(
    val personal: Personal,
    val billingAddress: BillingAddress,
    val delivery: Delivery,
    val preferences: Preferences,
    val active: Boolean
) {
    @JsonClass(generateAdapter = true)
    data class Personal(
        @Json(name = "first_name") val firstName: String,
        @Json(name = "last_name") val lastName: String,
        val email: String,
        @Json(name = "phone_number") val phoneNumber: String,
        @Json(name = "email_verified") val emailVerified: Boolean
    )

    @JsonClass(generateAdapter = true)
    data class BillingAddress(
        @Json(name = "post_code") val postCode: String,
        val city: String,
        @Json(name = "street_address") val streetAddress: String,
        @Json(name = "country_code") val countryCode: String
    )

    @JsonClass(generateAdapter = true)
    data class Delivery(
        val name: String,
        @Json(name = "post_code") val postCode: String,
        val city: String,
        @Json(name = "street_address") val streetAddress: String,
        @Json(name = "country_code") val countryCode: String,
        val remarks: String
    )

    @JsonClass(generateAdapter = true)
    data class Preferences(
        val notifications: Boolean
    )
}