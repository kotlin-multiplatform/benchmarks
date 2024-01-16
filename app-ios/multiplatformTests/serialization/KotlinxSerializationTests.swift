//
//  KotlinxSerializationTests.swift
//  multiplatformTests
//
//  Created by Sebastian Owodzin on 12/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import BenchmarksShared
import XCTest

final class KotlinxSerializationTests: XCTestCase {

    func testDecodeLargeListFromString() throws {
        let data = try! KotlinxSerialization().decodeLargeListFromString(jsonString: Resources.Minimised.largeListJsonString)
        XCTAssertTrue(!data.isEmpty)
    }
    
//    func testEncodeLargeListToString() throws {
//        let data = try! KotlinxSerialization().decodeLargeListFromString(jsonString: Resources.Minimised.largeListJsonString)
//        XCTAssertEqual(Resources.Minimised.largeListJsonString, try! KotlinxSerialization().encodeLargeListToString(value: data))
//    }
    
    func testDecodeMacOsReleasesFromString() throws {
        let data = try! KotlinxSerialization().decodeMacOsReleasesFromString(jsonString: Resources.Minimised.macosReleasesJsonString)
        XCTAssertTrue(!data.versions.isEmpty)
    }
    
    func testEncodeMacOsReleasesToString() throws {
        let data = try! KotlinxSerialization().decodeMacOsReleasesFromString(jsonString: Resources.Minimised.macosReleasesJsonString)
        XCTAssertEqual(Resources.Minimised.macosReleasesJsonString, try! KotlinxSerialization().encodeMacOsReleasesToString(value: data))
    }
    
    func testDecodePolymorphicGeoFromString() throws {
        let data = try! KotlinxSerialization().decodePolymorphicGeoFromString(jsonString: Resources.Minimised.polymorphicGeoJsonString)
        XCTAssertTrue(!data.isEmpty)
    }
    
    func testEncodePolymorphicGeoToString() throws {
        let data = try! KotlinxSerialization().decodePolymorphicGeoFromString(jsonString: Resources.Minimised.polymorphicGeoJsonString)
        XCTAssertEqual(Resources.Minimised.polymorphicGeoJsonString, try! KotlinxSerialization().encodePolymorphicGeoToString(value: data))
    }
    
    func testDecodePolymorphicHtmlFromString() throws {
        let data = try! KotlinxSerialization().decodePolymorphicHtmlFromString(jsonString: Resources.Minimised.polymorphicHtmlJsonString)
        XCTAssertTrue(!data.isEmpty)
    }
    
    func testEncodePolymorphicHtmlToString() throws {
        let data = try! KotlinxSerialization().decodePolymorphicHtmlFromString(jsonString: Resources.Minimised.polymorphicHtmlJsonString)
        XCTAssertEqual(Resources.Minimised.polymorphicHtmlJsonString, try! KotlinxSerialization().encodePolymorphicHtmlToString(value: data))
    }
    
    func testDecodeUserProfileFromString() throws {
        let data = try! KotlinxSerialization().decodeUserProfileFromString(jsonString: Resources.Minimised.userProfileJsonString)
        XCTAssertTrue(!data.personal.firstName.isEmpty)
    }
    
    func testEncodeUserProfileToString() throws {
        let data = try! KotlinxSerialization().decodeUserProfileFromString(jsonString: Resources.Minimised.userProfileJsonString)
        XCTAssertEqual(Resources.Minimised.userProfileJsonString, try! KotlinxSerialization().encodeUserProfileToString(value: data))
    }
}
