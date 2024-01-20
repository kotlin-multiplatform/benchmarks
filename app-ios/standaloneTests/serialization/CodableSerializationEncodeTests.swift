//
//  CodableSerializationEncodeTests.swift
//  standaloneTests
//
//  Created by Sebastian Owodzin on 13/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import standalone
import XCTest

final class CodableSerializationEncodeTests: XCTestCase {
//    func testEncodeLargeListToString() throws {
//        let data = CodableSerialization.decodeLargeListFromString(jsonString: Resources.Minimised.largeListJsonString)
//        XCTAssertEqual(Resources.Minimised.largeListJsonString, CodableSerialization.encodeLargeListToString(value: data))
//    }

    func testEncodeMacOsReleasesToString() throws {
        let data = CodableSerialization.decodeMacOsReleasesFromString(jsonString: Resources.Minimised.macosReleasesJsonString)
        XCTAssertEqual(Resources.Minimised.macosReleasesJsonString, CodableSerialization.encodeMacOsReleasesToString(value: data))

//        let decodedData = CodableSerialization.decodeMacOsReleasesFromString(jsonString: Resources.Minimised.macosReleasesJsonString)
//        let encodedJsonString = CodableSerialization.encodeMacOsReleasesToString(value: decodedData)
//
//        XCTAssertEqual(
//            decodedData.versions.first?.internal,
//            CodableSerialization.decodeMacOsReleasesFromString(jsonString: encodedJsonString).versions.first?.internal
//        )
    }

//    func testEncodePolymorphicGeoToString() throws {
//        let data = CodableSerialization.decodePolymorphicGeoFromString(jsonString: Resources.Minimised.polymorphicGeoJsonString)
//        XCTAssertEqual(Resources.Minimised.polymorphicGeoJsonString, CodableSerialization.encodePolymorphicGeoToString(value: data))
//    }

//    func testEncodePolymorphicHtmlToString() throws {
//        let data = CodableSerialization.decodePolymorphicHtmlFromString(jsonString: Resources.Minimised.polymorphicHtmlJsonString)
//        XCTAssertEqual(Resources.Minimised.polymorphicHtmlJsonString, CodableSerialization.encodePolymorphicHtmlToString(value: data))
//    }

    func testEncodeUserProfileToString() throws {
        let data = CodableSerialization.decodeUserProfileFromString(jsonString: Resources.Minimised.userProfileJsonString)
        XCTAssertEqual(Resources.Minimised.userProfileJsonString, CodableSerialization.encodeUserProfileToString(value: data))

//        let decodedData = CodableSerialization.decodeUserProfileFromString(jsonString: Resources.Minimised.userProfileJsonString)
//        let encodedJsonString = CodableSerialization.encodeUserProfileToString(value: decodedData)
//
//        XCTAssertEqual(
//            decodedData.personal.email,
//            CodableSerialization.decodeUserProfileFromString(jsonString: encodedJsonString).personal.email
//        )
    }
}
