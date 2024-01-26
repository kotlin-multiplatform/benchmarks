//
//  KotlinxSerializationPrettyPrintedEncodeTests.swift
//  multiplatformTests
//
//  Created by Sebastian Owodzin on 17/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import BenchmarksShared
import XCTest

final class KotlinxSerializationPrettyPrintedEncodeTests: XCTestCase {
//    func testEncodeLargeListToString() throws {
//        XCTAssertEqual(
//            JsonStrings.PrettyPrinted.largeList,
//            try! KotlinxSerializationPrettyPrinted().encodeLargeListToString(value: JsonData.largeList)
//        )
//    }
//    
//    func testEncodeLargeListCompactToString() throws {
//        XCTAssertEqual(
//            JsonStrings.PrettyPrinted.largeList,
//            try! KotlinxSerializationPrettyPrinted().encodeLargeListCompactToString(value: JsonData.largeListCompact)
//        )
//    }

    func testEncodeMacOsReleasesToString() throws {
        XCTAssertEqual(
            JsonStrings.PrettyPrinted.macosReleases, 
            try! KotlinxSerializationPrettyPrinted().encodeMacOsReleasesToString(value: JsonData.macosReleases)
        )
    }

    func testEncodePolymorphicGeoToString() throws {
        XCTAssertEqual(
            JsonStrings.PrettyPrinted.polymorphicGeo,
            try! KotlinxSerializationPrettyPrinted().encodePolymorphicGeoToString(value: JsonData.polymorphicGeo)
        )
    }

    func testEncodePolymorphicHtmlToString() throws {
        XCTAssertEqual(
            JsonStrings.PrettyPrinted.polymorphicHtml,
            try! KotlinxSerializationPrettyPrinted().encodePolymorphicHtmlToString(value: JsonData.polymorphicHtml)
        )
    }

    func testEncodeUserProfileToString() throws {
        XCTAssertEqual(
            JsonStrings.PrettyPrinted.userProfile,
            try! KotlinxSerializationPrettyPrinted().encodeUserProfileToString(value: JsonData.userProfile)
        )
    }
}

