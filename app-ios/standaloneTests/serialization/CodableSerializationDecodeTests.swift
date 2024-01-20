//
//  CodableSerializationDecodeTests.swift
//  standaloneTests
//
//  Created by Sebastian Owodzin on 13/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import standalone
import XCTest

final class CodableSerializationDecodeTests: XCTestCase {
//    func testDecodeLargeListFromString() throws {
//        let data = CodableSerialization.decodeLargeListFromString(jsonString: Resources.Minimised.largeListJsonString)
//        XCTAssertEqual("2489651045", data.first!.id)
//        XCTAssertEqual("CreateEvent", data.first!.type)
//    }
    
//    func testDecodeLargeListCompactFromString() throws {
//        let data = CodableSerialization.decodeLargeListCompactFromString(jsonString: Resources.Minimised.largeListJsonString)
//        XCTAssertEqual("2489651045", data.first!.id)
//        XCTAssertEqual("CreateEvent", data.first!.type)
//    }

    func testDecodeMacOsReleasesFromString() throws {
        let data = CodableSerialization.decodeMacOsReleasesFromString(jsonString: Resources.Minimised.macosReleasesJsonString)
        XCTAssertEqual("Kodiak", data.versions.first!.internal)
        XCTAssertEqual("US", data.versions.first!.releases.first!.version)
    }
    
//    func testDecodePolymorphicGeoFromString() throws {
//        let data = CodableSerialization.decodePolymorphicGeoFromString(jsonString: Resources.Minimised.polymorphicGeoJsonString)
//        XCTAssertTrue(data.first! is GeoJSONObject.Point)
//        XCTAssertEqual([100.0, 0.0], (data.first! as GeoJSONObject.Point).coordinates)
//    }

//    func testDecodePolymorphicHtmlFromString() throws {
//        let data = CodableSerialization.decodePolymorphicHtmlFromString(jsonString: Resources.Minimised.polymorphicHtmlJsonString)
//        XCTAssertTrue(data.first! is HtmlChunk.Paragraph)
//        XCTAssertTrue((data.first! as HtmlChunk.Paragraph).data.text.isNotEmpty())
//    }

    func testDecodeUserProfileFromString() throws {
        let data = CodableSerialization.decodeUserProfileFromString(jsonString: Resources.Minimised.userProfileJsonString)
        XCTAssertTrue(!data.personal.firstName.isEmpty)
    }
}
