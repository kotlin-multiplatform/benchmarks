//
//  CodableSerializationTests.swift
//  standaloneTests
//
//  Created by Sebastian Owodzin on 13/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import standalone
import XCTest

final class CodableSerializationTests: XCTestCase {

//    func testDecodeLargeListFromString() throws {
//        let data = CodableSerialization.decodeLargeListFromString(jsonString: Resources.Minimised.largeListJsonString)
//        XCTAssertEqual("2489651045", data.first!.id)
//        XCTAssertEqual("CreateEvent", data.first!.type)
//    }
    
//    func testEncodeLargeListToString() throws {
//        let data = CodableSerialization.decodeLargeListFromString(jsonString: Resources.Minimised.largeListJsonString)
//        XCTAssertEqual(Resources.Minimised.largeListJsonString, CodableSerialization.encodeLargeListToString(value: data))
//    }
    
    func testDecodeMacOsReleasesFromString() throws {
        let data = CodableSerialization.decodeMacOsReleasesFromString(jsonString: Resources.Minimised.macosReleasesJsonString)
        XCTAssertEqual("Kodiak", data.versions.first!.internal)
        XCTAssertEqual("US", data.versions.first!.releases.first!.version)
    }
    
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
    
//    func testDecodePolymorphicGeoFromString() throws {
//        let data = CodableSerialization.decodePolymorphicGeoFromString(jsonString: Resources.Minimised.polymorphicGeoJsonString)
//        XCTAssertTrue(data.first! is GeoJSONObject.Point)
//        XCTAssertEqual([100.0, 0.0], (data.first! as GeoJSONObject.Point).coordinates)
//    }
    
//    func testEncodePolymorphicGeoToString() throws {
//        let data = CodableSerialization.decodePolymorphicGeoFromString(jsonString: Resources.Minimised.polymorphicGeoJsonString)
//        XCTAssertEqual(Resources.Minimised.polymorphicGeoJsonString, CodableSerialization.encodePolymorphicGeoToString(value: data))
//    }
    
//    func testDecodePolymorphicHtmlFromString() throws {
//        let data = CodableSerialization.decodePolymorphicHtmlFromString(jsonString: Resources.Minimised.polymorphicHtmlJsonString)
//        XCTAssertTrue(data.first! is HtmlChunk.Paragraph)
//        XCTAssertTrue((data.first! as HtmlChunk.Paragraph).data.text.isNotEmpty())
//    }
    
//    func testEncodePolymorphicHtmlToString() throws {
//        let data = CodableSerialization.decodePolymorphicHtmlFromString(jsonString: Resources.Minimised.polymorphicHtmlJsonString)
//        XCTAssertEqual(Resources.Minimised.polymorphicHtmlJsonString, CodableSerialization.encodePolymorphicHtmlToString(value: data))
//    }
    
    func testDecodeUserProfileFromString() throws {
        let data = CodableSerialization.decodeUserProfileFromString(jsonString: Resources.Minimised.userProfileJsonString)
        XCTAssertTrue(!data.personal.firstName.isEmpty)
    }
    
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
