//
//  KotlinxSerializationEncodeTest.swift
//  multiplatformTests
//
//  Created by Sebastian Owodzin on 12/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import BenchmarksShared
import XCTest

final class KotlinxSerializationEncodeTest: XCTestCase {
//    func testEncodeLargeListToString() throws {
//        XCTAssertEqual(
//            JsonStrings.Minimised.largeList,
//            try! KotlinxSerialization().encodeLargeListToString(value: JsonData.largeList)
//        )
//    }
//    
//    func testEncodeLargeListCompactToString() throws {
//        XCTAssertEqual(
//            JsonStrings.Minimised.largeList,
//            try! KotlinxSerialization().encodeLargeListCompactToString(value: JsonData.largeListCompact)
//        )
//    }

    func testEncodeMacOsReleasesToString() throws {
        XCTAssertEqual(
            JsonStrings.Minimised.macosReleases, 
            try! KotlinxSerialization().encodeMacOsReleasesToString(value: JsonData.macosReleases)
        )
    }

    func testEncodePolymorphicGeoToString() throws {
        XCTAssertEqual(
            JsonStrings.Minimised.polymorphicGeo, 
            try! KotlinxSerialization().encodePolymorphicGeoToString(value: JsonData.polymorphicGeo)
        )
    }

    func testEncodePolymorphicHtmlToString() throws {
        XCTAssertEqual(
            JsonStrings.Minimised.polymorphicHtml, 
            try! KotlinxSerialization().encodePolymorphicHtmlToString(value: JsonData.polymorphicHtml)
        )
    }

    func testEncodeUserProfileToString() throws {
        XCTAssertEqual(
            JsonStrings.Minimised.userProfile, 
            try! KotlinxSerialization().encodeUserProfileToString(value: JsonData.userProfile)
        )
    }
}
