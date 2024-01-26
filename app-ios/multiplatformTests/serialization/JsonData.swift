//
//  JsonData.swift
//  multiplatformTests
//
//  Created by Sebastian Owodzin on 25/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import BenchmarksShared

public class JsonData {
    public static var largeList: [GithubPushNormal] {
        return try! KotlinxSerialization().decodeLargeListFromString(jsonString: JsonStrings.Minimised.largeList)
    }

    public static var largeListCompact: [GithubPushCompact] {
        return try! KotlinxSerialization().decodeLargeListCompactFromString(jsonString: JsonStrings.Minimised.largeList)
    }
    
    public static var macosReleases: MacOsReleases {
        return try! KotlinxSerialization().decodeMacOsReleasesFromString(jsonString: JsonStrings.Minimised.macosReleases)
    }
    
    public static var polymorphicGeo: [GeoJSONObject] {
        return try! KotlinxSerialization().decodePolymorphicGeoFromString(jsonString: JsonStrings.Minimised.polymorphicGeo)
    }
    
    public static var polymorphicHtml: [HtmlChunk] {
        return try! KotlinxSerialization().decodePolymorphicHtmlFromString(jsonString: JsonStrings.Minimised.polymorphicHtml)
    }
    
    public static var userProfile: UserProfile {
        return try! KotlinxSerialization().decodeUserProfileFromString(jsonString: JsonStrings.Minimised.userProfile)
    }
}
