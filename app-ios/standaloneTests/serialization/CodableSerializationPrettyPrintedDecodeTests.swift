//
//  CodableSerializationPrettyPrintedDecodeTests.swift
//  standaloneTests
//
//  Created by Sebastian Owodzin on 16/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import standalone
import XCTest

final class CodableSerializationPrettyPrintedDecodeTests: XCTestCase {
//    func testDecodeLargeListFromString() throws {
//        let data = CodableSerializationPrettyPrinted.decodeLargeListFromString(jsonString: Resources.PrettyPrinted.largeListJsonString)
//        XCTAssertEqual("2489651045", data.first!.id)
//        XCTAssertEqual("CreateEvent", data.first!.type)
//    }
    
//    func testDecodeLargeListCompactFromString() throws {
//        let data = CodableSerializationPrettyPrinted.decodeLargeListCompactFromString(jsonString: Resources.PrettyPrinted.largeListJsonString)
//        XCTAssertEqual("2489651045", data.first!.id)
//        XCTAssertEqual("CreateEvent", data.first!.type)
//    }
    
    func testDecodeMacOsReleasesFromString() throws {
        let data = CodableSerializationPrettyPrinted.decodeMacOsReleasesFromString(jsonString: Resources.PrettyPrintedJsonString.macosReleases)
        XCTAssertEqual("Kodiak", data.versions.first!.internal)
        XCTAssertEqual("US", data.versions.first!.releases.first!.version)
    }
    
//    func testDecodePolymorphicGeoFromString() throws {
//        let data = CodableSerializationPrettyPrinted.decodePolymorphicGeoFromString(jsonString: Resources.PrettyPrinted.polymorphicGeoJsonString)
//        XCTAssertTrue(data.first! is GeoJSONObject.Point)
//        XCTAssertEqual([100.0, 0.0], (data.first! as GeoJSONObject.Point).coordinates)
//    }

//    func testDecodePolymorphicHtmlFromString() throws {
//        let data = CodableSerializationPrettyPrinted.decodePolymorphicHtmlFromString(jsonString: Resources.PrettyPrinted.polymorphicHtmlJsonString)
//        XCTAssertTrue(data.first! is HtmlChunk.Paragraph)
//        XCTAssertTrue((data.first! as HtmlChunk.Paragraph).data.text.isNotEmpty())
//    }

    func testDecodeUserProfileFromString() throws {
        let data = CodableSerializationPrettyPrinted.decodeUserProfileFromString(jsonString: Resources.PrettyPrintedJsonString.userProfile)
        XCTAssertTrue(!data.personal.firstName.isEmpty)
    }
}
