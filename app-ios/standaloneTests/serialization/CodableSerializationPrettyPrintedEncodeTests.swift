//
//  CodableSerializationPrettyPrintedEncodeTests.swift
//  standaloneTests
//
//  Created by Sebastian Owodzin on 16/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import standalone
import XCTest

final class CodableSerializationPrettyPrintedEncodeTests: XCTestCase {
//    func testEncodeLargeListToString() throws {
//        let data = CodableSerializationPrettyPrinted.decodeLargeListFromString(jsonString: Resources.PrettyPrinted.largeListJsonString)
//        XCTAssertEqual(Resources.PrettyPrinted.largeListJsonString, CodableSerializationPrettyPrinted.encodeLargeListToString(value: data))
//    }

    func testEncodeMacOsReleasesToString() throws {
        let data = CodableSerializationPrettyPrinted.decodeMacOsReleasesFromString(jsonString: Resources.PrettyPrinted.macosReleasesJsonString)
        XCTAssertEqual(Resources.PrettyPrinted.macosReleasesJsonString, CodableSerializationPrettyPrinted.encodeMacOsReleasesToString(value: data))

//        let decodedData = CodableSerializationPrettyPrinted.decodeMacOsReleasesFromString(jsonString: Resources.PrettyPrinted.macosReleasesJsonString)
//        let encodedJsonString = CodableSerializationPrettyPrinted.encodeMacOsReleasesToString(value: decodedData)
//
//        XCTAssertEqual(
//            decodedData.versions.first?.internal,
//            CodableSerializationPrettyPrinted.decodeMacOsReleasesFromString(jsonString: encodedJsonString).versions.first?.internal
//        )
    }

//    func testEncodePolymorphicGeoToString() throws {
//        let data = CodableSerializationPrettyPrinted.decodePolymorphicGeoFromString(jsonString: Resources.PrettyPrinted.polymorphicGeoJsonString)
//        XCTAssertEqual(Resources.PrettyPrinted.polymorphicGeoJsonString, CodableSerializationPrettyPrinted.encodePolymorphicGeoToString(value: data))
//    }

//    func testEncodePolymorphicHtmlToString() throws {
//        let data = CodableSerializationPrettyPrinted.decodePolymorphicHtmlFromString(jsonString: Resources.PrettyPrinted.polymorphicHtmlJsonString)
//        XCTAssertEqual(Resources.PrettyPrinted.polymorphicHtmlJsonString, CodableSerializationPrettyPrinted.encodePolymorphicHtmlToString(value: data))
//    }

    func testEncodeUserProfileToString() throws {
        let data = CodableSerializationPrettyPrinted.decodeUserProfileFromString(jsonString: Resources.PrettyPrinted.userProfileJsonString)
        XCTAssertEqual(Resources.PrettyPrinted.userProfileJsonString, CodableSerializationPrettyPrinted.encodeUserProfileToString(value: data))

//        let decodedData = CodableSerializationPrettyPrinted.decodeUserProfileFromString(jsonString: Resources.PrettyPrinted.userProfileJsonString)
//        let encodedJsonString = CodableSerializationPrettyPrinted.encodeUserProfileToString(value: decodedData)
//
//        XCTAssertEqual(
//            decodedData.personal.email,
//            CodableSerializationPrettyPrinted.decodeUserProfileFromString(jsonString: encodedJsonString).personal.email
//        )
    }
}
