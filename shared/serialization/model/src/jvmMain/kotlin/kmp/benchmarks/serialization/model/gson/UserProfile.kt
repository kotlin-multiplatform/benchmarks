package kmp.benchmarks.serialization.model.gson

import com.google.gson.annotations.SerializedName

data class UserProfile(
    val personal: Personal,
    val billingAddress: BillingAddress,
    val delivery: Delivery,
    val preferences: Preferences,
    val active: Boolean
) {
    data class Personal(
        @SerializedName("first_name") val firstName: String,
        @SerializedName("last_name") val lastName: String,
        val email: String,
        @SerializedName("phone_number") val phoneNumber: String,
        @SerializedName("email_verified") val emailVerified: Boolean
    )

    data class BillingAddress(
        @SerializedName("post_code") val postCode: String,
        val city: String,
        @SerializedName("street_address") val streetAddress: String,
        @SerializedName("country_code") val countryCode: String
    )

    data class Delivery(
        val name: String,
        @SerializedName("post_code") val postCode: String,
        val city: String,
        @SerializedName("street_address") val streetAddress: String,
        @SerializedName("country_code") val countryCode: String,
        val remarks: String
    )

    data class Preferences(
        val notifications: Boolean
    )
}