//
//  CodableSerializationPrettyPrinted.swift
//  standalone
//
//  Created by Sebastian Owodzin on 13/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import Foundation

public struct CodableSerializationPrettyPrinted {
    public static func decodeLargeListFromString(jsonString: String) -> [GithubPush.Normal] {
        let decoder = JSONDecoder()
        
        return try! decoder.decode([GithubPush.Normal].self, from: Data(jsonString.utf8))
    }
    
    public static func encodeLargeListToString(value: [GithubPush.Normal]) -> String {
        let encoder = JSONEncoder()
        encoder.outputFormatting = .prettyPrinted
        
        return String(decoding: try! encoder.encode(value), as: UTF8.self)
    }
    
    public static func decodeLargeListCompactFromString(jsonString: String) -> [GithubPush.Compact] {
        let decoder = JSONDecoder()
        
        return try! decoder.decode([GithubPush.Compact].self, from: Data(jsonString.utf8))
    }
    
    public static func encodeLargeListCompactToString(value: [GithubPush.Compact]) -> String {
        let encoder = JSONEncoder()
        encoder.outputFormatting = .prettyPrinted
        
        return String(decoding: try! encoder.encode(value), as: UTF8.self)
    }
    
    public static func decodeMacOsReleasesFromString(jsonString: String) -> MacOsReleases {
        let decoder = JSONDecoder()
        
        return try! decoder.decode(MacOsReleases.self, from: Data(jsonString.utf8))
    }
    
    public static func encodeMacOsReleasesToString(value: MacOsReleases) -> String {
        let encoder = JSONEncoder()
        encoder.outputFormatting = .prettyPrinted
        
        return String(decoding: try! encoder.encode(value), as: UTF8.self)
    }
    
    public static func decodePolymorphicGeoFromString(jsonString: String) -> [GeoJSONObject] {
        let decoder = JSONDecoder()
    
        return try! decoder.decode([GeoJSONObject].self, from: Data(jsonString.utf8))
    }
    
    public static func encodePolymorphicGeoToString(value: [GeoJSONObject]) -> String {
        let encoder = JSONEncoder()
        encoder.outputFormatting = .prettyPrinted
    
        return String(decoding: try! encoder.encode(value), as: UTF8.self)
    }
    
    public static func decodePolymorphicHtmlFromString(jsonString: String) -> [HtmlChunk] {
        let decoder = JSONDecoder()
    
        return try! decoder.decode([HtmlChunk].self, from: Data(jsonString.utf8))
    }
    
    public static func encodePolymorphicHtmlToString(value: [HtmlChunk]) -> String {
        let encoder = JSONEncoder()
        encoder.outputFormatting = .prettyPrinted
    
        return String(decoding: try! encoder.encode(value), as: UTF8.self)
    }
    
    public static func decodeUserProfileFromString(jsonString: String) -> UserProfile {
        let decoder = JSONDecoder()
        
        return try! decoder.decode(UserProfile.self, from: Data(jsonString.utf8))
    }
    
    public static func encodeUserProfileToString(value: UserProfile) -> String {
        let encoder = JSONEncoder()
        encoder.outputFormatting = .prettyPrinted
        
        return String(decoding: try! encoder.encode(value), as: UTF8.self)
    }
}
