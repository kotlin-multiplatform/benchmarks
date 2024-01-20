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
//        let data = try! KotlinxSerializationPrettyPrinted().decodeLargeListFromString(jsonString: Resources.PrettyPrinted.largeListJsonString)
//        XCTAssertEqual(Resources.PrettyPrinted.largeListJsonString, try! KotlinxSerializationPrettyPrinted().encodeLargeListToString(value: data))
//    }
    
    func testEncodeLargeListCompactToString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodeLargeListCompactFromString(jsonString: Resources.PrettyPrinted.largeListJsonString)
        XCTAssertEqual(Resources.PrettyPrinted.largeListJsonString, try! KotlinxSerializationPrettyPrinted().encodeLargeListCompactToString(value: data))
    }

    func testEncodeMacOsReleasesToString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodeMacOsReleasesFromString(jsonString: Resources.PrettyPrinted.macosReleasesJsonString)
        XCTAssertEqual(Resources.PrettyPrinted.macosReleasesJsonString, try! KotlinxSerializationPrettyPrinted().encodeMacOsReleasesToString(value: data))
    }

    func testEncodePolymorphicGeoToString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodePolymorphicGeoFromString(jsonString: Resources.PrettyPrinted.polymorphicGeoJsonString)
        XCTAssertEqual(Resources.PrettyPrinted.polymorphicGeoJsonString, try! KotlinxSerializationPrettyPrinted().encodePolymorphicGeoToString(value: data))
    }

    func testEncodePolymorphicHtmlToString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodePolymorphicHtmlFromString(jsonString: Resources.PrettyPrinted.polymorphicHtmlJsonString)
        XCTAssertEqual(Resources.PrettyPrinted.polymorphicHtmlJsonString, try! KotlinxSerializationPrettyPrinted().encodePolymorphicHtmlToString(value: data))
    }

    func testEncodeUserProfileToString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodeUserProfileFromString(jsonString: Resources.PrettyPrinted.userProfileJsonString)
        XCTAssertEqual(Resources.PrettyPrinted.userProfileJsonString, try! KotlinxSerializationPrettyPrinted().encodeUserProfileToString(value: data))
    }
}

