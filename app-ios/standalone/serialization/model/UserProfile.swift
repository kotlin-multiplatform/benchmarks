//
//  UserProfile.swift
//  standalone
//
//  Created by Sebastian Owodzin on 13/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import Foundation

public struct UserProfile: Codable {
    public var personal: Personal
    public var billingAddress: BillingAddress
    public var delivery: Delivery
    public var preferences: Preferences
    public var active: Bool
    
    public struct Personal: Codable {
        public var firstName: String
        public var lastName: String
        public var email: String
        public var phoneNumber: String
        public var emailVerified: Bool
        
        enum CodingKeys: String, CodingKey {
            case firstName = "first_name"
            case lastName = "last_name"
            case email
            case phoneNumber = "phone_number"
            case emailVerified = "email_verified"
        }
    }

    public struct BillingAddress: Codable {
        public var postCode: String
        public var city: String
        public var streetAddress: String
        public var countryCode: String
        
        enum CodingKeys: String, CodingKey {
            case postCode = "post_code"
            case city
            case streetAddress = "street_address"
            case countryCode = "country_code"
        }
    }

    public struct Delivery: Codable {
        public var name: String
        public var postCode: String
        public var city: String
        public var streetAddress: String
        public var countryCode: String
        public var remarks: String
        
        enum CodingKeys: String, CodingKey {
            case name
            case postCode = "post_code"
            case city
            case streetAddress = "street_address"
            case countryCode = "country_code"
            case remarks
        }
    }

    public struct Preferences: Codable {
        public var notifications: Bool
    }
}
