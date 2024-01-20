//
//  CodableSerialization.swift
//  standalone
//
//  Created by Sebastian Owodzin on 13/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import Foundation

public struct CodableSerialization {
    private static let decoder = JSONDecoder()
    private static let encoder = JSONEncoder()
    
    public static func decodeLargeListFromString(jsonString: String) -> [GithubPush.Normal] {
        return try! decoder.decode([GithubPush.Normal].self, from: Data(jsonString.utf8))
    }
    
    public static func encodeLargeListToString(value: [GithubPush.Normal]) -> String {
        return String(decoding: try! encoder.encode(value), as: UTF8.self)
    }
    
    public static func decodeLargeListCompactFromString(jsonString: String) -> [GithubPush.Compact] {
        return try! decoder.decode([GithubPush.Compact].self, from: Data(jsonString.utf8))
    }
    
    public static func encodeLargeListCompactToString(value: [GithubPush.Compact]) -> String {
        return String(decoding: try! encoder.encode(value), as: UTF8.self)
    }
    
    public static func decodeMacOsReleasesFromString(jsonString: String) -> MacOsReleases {
        return try! decoder.decode(MacOsReleases.self, from: Data(jsonString.utf8))
    }
    
    public static func encodeMacOsReleasesToString(value: MacOsReleases) -> String {
        return String(decoding: try! encoder.encode(value), as: UTF8.self)
    }
    
    public static func decodePolymorphicGeoFromString(jsonString: String) -> [GeoJSONObject] {
        return try! decoder.decode([GeoJSONObject].self, from: Data(jsonString.utf8))
    }
    
    public static func encodePolymorphicGeoToString(value: [GeoJSONObject]) -> String {
        return String(decoding: try! encoder.encode(value), as: UTF8.self)
    }
    
    public static func decodePolymorphicHtmlFromString(jsonString: String) -> [HtmlChunk] {
        return try! decoder.decode([HtmlChunk].self, from: Data(jsonString.utf8))
    }
    
    public static func encodePolymorphicHtmlToString(value: [HtmlChunk]) -> String {
        return String(decoding: try! encoder.encode(value), as: UTF8.self)
    }
    
    public static func decodeUserProfileFromString(jsonString: String) -> UserProfile {
        return try! decoder.decode(UserProfile.self, from: Data(jsonString.utf8))
    }
    
    public static func encodeUserProfileToString(value: UserProfile) -> String {
        return String(decoding: try! encoder.encode(value), as: UTF8.self)
        
    }
}
