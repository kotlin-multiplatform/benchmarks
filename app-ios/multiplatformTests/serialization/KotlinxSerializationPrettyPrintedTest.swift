//
//  KotlinxSerializationTests.swift
//  multiplatformTests
//
//  Created by Sebastian Owodzin on 12/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import BenchmarksShared
import XCTest

final class KotlinxSerializationPrettyPrintedTests: XCTestCase {

    func testDecodeLargeListFromString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodeLargeListFromString(jsonString: Resources.PrettyPrinted.largeListJsonString)
        XCTAssertTrue(!data.isEmpty)
    }
    
//    func testEncodeLargeListToString() throws {
//        let data = try! KotlinxSerializationPrettyPrinted().decodeLargeListFromString(jsonString: Resources.PrettyPrinted.largeListJsonString)
//        XCTAssertEqual(Resources.PrettyPrinted.largeListJsonString, try! KotlinxSerializationPrettyPrinted().encodeLargeListToString(value: data))
//    }
    
    func testDecodeMacOsReleasesFromString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodeMacOsReleasesFromString(jsonString: Resources.PrettyPrinted.macosReleasesJsonString)
        XCTAssertTrue(!data.versions.isEmpty)
    }
    
    func testEncodeMacOsReleasesToString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodeMacOsReleasesFromString(jsonString: Resources.PrettyPrinted.macosReleasesJsonString)
        XCTAssertEqual(Resources.PrettyPrinted.macosReleasesJsonString, try! KotlinxSerializationPrettyPrinted().encodeMacOsReleasesToString(value: data))
    }
    
    func testDecodePolymorphicGeoFromString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodePolymorphicGeoFromString(jsonString: Resources.PrettyPrinted.polymorphicGeoJsonString)
        XCTAssertTrue(!data.isEmpty)
    }
    
    func testEncodePolymorphicGeoToString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodePolymorphicGeoFromString(jsonString: Resources.PrettyPrinted.polymorphicGeoJsonString)
        XCTAssertEqual(Resources.PrettyPrinted.polymorphicGeoJsonString, try! KotlinxSerializationPrettyPrinted().encodePolymorphicGeoToString(value: data))
    }
    
    func testDecodePolymorphicHtmlFromString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodePolymorphicHtmlFromString(jsonString: Resources.PrettyPrinted.polymorphicHtmlJsonString)
        XCTAssertTrue(!data.isEmpty)
    }
    
    func testEncodePolymorphicHtmlToString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodePolymorphicHtmlFromString(jsonString: Resources.PrettyPrinted.polymorphicHtmlJsonString)
        XCTAssertEqual(Resources.PrettyPrinted.polymorphicHtmlJsonString, try! KotlinxSerializationPrettyPrinted().encodePolymorphicHtmlToString(value: data))
    }
    
    func testDecodeUserProfileFromString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodeUserProfileFromString(jsonString: Resources.PrettyPrinted.userProfileJsonString)
        XCTAssertTrue(!data.personal.firstName.isEmpty)
    }
    
    func testEncodeUserProfileToString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodeUserProfileFromString(jsonString: Resources.PrettyPrinted.userProfileJsonString)
        XCTAssertEqual(Resources.PrettyPrinted.userProfileJsonString, try! KotlinxSerializationPrettyPrinted().encodeUserProfileToString(value: data))
    }
}
