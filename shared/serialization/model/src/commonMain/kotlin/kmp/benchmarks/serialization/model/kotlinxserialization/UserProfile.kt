package kmp.benchmarks.serialization.model.kotlinxserialization

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserProfile(
    val personal: Personal,
    val billingAddress: BillingAddress,
    val delivery: Delivery,
    val preferences: Preferences,
    val active: Boolean
) {
    @Serializable
    data class Personal(
        @SerialName("first_name") val firstName: String,
        @SerialName("last_name") val lastName: String,
        val email: String,
        @SerialName("phone_number") val phoneNumber: String,
        @SerialName("email_verified") val emailVerified: Boolean
    )

    @Serializable
    data class BillingAddress(
        @SerialName("post_code") val postCode: String,
        val city: String,
        @SerialName("street_address") val streetAddress: String,
        @SerialName("country_code") val countryCode: String
    )

    @Serializable
    data class Delivery(
        val name: String,
        @SerialName("post_code") val postCode: String,
        val city: String,
        @SerialName("street_address") val streetAddress: String,
        @SerialName("country_code") val countryCode: String,
        val remarks: String
    )

    @Serializable
    data class Preferences(
        val notifications: Boolean
    )
}