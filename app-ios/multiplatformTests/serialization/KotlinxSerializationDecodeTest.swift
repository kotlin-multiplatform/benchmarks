//
//  KotlinxSerializationDecodeTest.swift
//  multiplatformTests
//
//  Created by Sebastian Owodzin on 12/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import BenchmarksShared
import XCTest

final class KotlinxSerializationDecodeTest: XCTestCase {
    func testDecodeLargeListFromString() throws {
        try! KotlinxSerialization().decodeLargeListFromString(jsonString: "[]")
        
        let data = try! KotlinxSerialization().decodeLargeListFromString(jsonString: JsonStrings.Minimised.largeList)
        
        XCTAssertEqual("2489651045", data.first!.id)
        XCTAssertEqual("https://avatars.githubusercontent.com/u/665991?", data.first!.actor.avatarUrl)
    }
    
    func testDecodeLargeListFromString_failed() throws {
        XCTAssertThrowsError(try KotlinxSerialization().decodeLargeListFromString(jsonString: "{}")) { error in
//            XCTAssertTrue(error is Kotlinx_serialization_coreSerializationException)
        }
        
        XCTAssertThrowsError(try KotlinxSerialization().decodeLargeListFromString(jsonString: "")) { error in
//            XCTAssertTrue(error is Kotlinx_serialization_coreSerializationException)
        }
    }
    
    func testDecodeLargeListCompactFromString() throws {
        try! KotlinxSerialization().decodeLargeListCompactFromString(jsonString: "[]")
        
        let data = try! KotlinxSerialization().decodeLargeListCompactFromString(jsonString: JsonStrings.Minimised.largeList)
        
        XCTAssertEqual("2489651045", data.first!.id)
        XCTAssertEqual("https://avatars.githubusercontent.com/u/665991?", data.first!.actor.avatarUrl)
    }
    
    func testDecodeLargeListCompactFromString_failed() throws {
        XCTAssertThrowsError(try KotlinxSerialization().decodeLargeListCompactFromString(jsonString: "{}")) { error in
//            XCTAssertTrue(error is Kotlinx_serialization_coreSerializationException)
        }
        
        XCTAssertThrowsError(try KotlinxSerialization().decodeLargeListCompactFromString(jsonString: "")) { error in
//            XCTAssertTrue(error is Kotlinx_serialization_coreSerializationException)
        }
    }

    func testDecodeMacOsReleasesFromString() throws {
        let data = try! KotlinxSerialization().decodeMacOsReleasesFromString(jsonString: JsonStrings.Minimised.macosReleases)

        XCTAssertEqual(MacOsReleases.VersionExternal.kodiak, data.versions.first!.external)
        XCTAssertEqual("US", data.versions.first!.releases.first!.version)
    }
    
    func testDecodeMacOsReleasesFromString_failed() throws {
        XCTAssertThrowsError(try KotlinxSerialization().decodeMacOsReleasesFromString(jsonString: "{}")) { error in
//            XCTAssertTrue(error is Kotlinx_serialization_coreSerializationException)
        }
        
        XCTAssertThrowsError(try KotlinxSerialization().decodeMacOsReleasesFromString(jsonString: "")) { error in
//            XCTAssertTrue(error is Kotlinx_serialization_coreSerializationException)
        }
    }

    func testDecodePolymorphicGeoFromString() throws {
        try! KotlinxSerialization().decodePolymorphicGeoFromString(jsonString: "[]")
        
        let data = try! KotlinxSerialization().decodePolymorphicGeoFromString(jsonString: JsonStrings.Minimised.polymorphicGeo)
        
        XCTAssertTrue(data.first is GeoJSONObjectPoint)
        XCTAssertEqual(Coordinates(longitude: 100.0, latitude: 0.0), (data.first! as! GeoJSONObjectPoint).coordinates)
    }
    
    func testDecodePolymorphicGeoFromString_failed() throws {
        XCTAssertThrowsError(try KotlinxSerialization().decodePolymorphicGeoFromString(jsonString: "{}")) { error in
//            XCTAssertTrue(error is Kotlinx_serialization_coreSerializationException)
        }
        
        XCTAssertThrowsError(try KotlinxSerialization().decodePolymorphicGeoFromString(jsonString: "")) { error in
//            XCTAssertTrue(error is Kotlinx_serialization_coreSerializationException)
        }
    }

    func testDecodePolymorphicHtmlFromString() throws {
        try! KotlinxSerialization().decodePolymorphicHtmlFromString(jsonString: "[]")
        
        let data = try! KotlinxSerialization().decodePolymorphicHtmlFromString(jsonString: JsonStrings.Minimised.polymorphicHtml)
        
        XCTAssertTrue(data.first is HtmlChunkParagraph)
        XCTAssertTrue((data.first as! HtmlChunkParagraph).data.text.isNotBlank())
    }
    
    func testDecodePolymorphicHtmlFromString_failed() throws {
        XCTAssertThrowsError(try KotlinxSerialization().decodePolymorphicHtmlFromString(jsonString: "{}")) { error in
//            XCTAssertTrue(error is Kotlinx_serialization_coreSerializationException)
        }
        
        XCTAssertThrowsError(try KotlinxSerialization().decodePolymorphicHtmlFromString(jsonString: "")) { error in
//            XCTAssertTrue(error is Kotlinx_serialization_coreSerializationException)
        }
    }
    
    func testDecodeUserProfileFromString() throws {
        let data = try! KotlinxSerialization().decodeUserProfileFromString(jsonString: JsonStrings.Minimised.userProfile)
        
        XCTAssertTrue(data.personal.firstName.isNotBlank())
    }
    
    func testDecodeUserProfileFromString_failed() throws {
        XCTAssertThrowsError(try KotlinxSerialization().decodeUserProfileFromString(jsonString: "{}")) { error in
//            XCTAssertTrue(error is Kotlinx_serialization_coreSerializationException)
        }
        
        XCTAssertThrowsError(try KotlinxSerialization().decodeUserProfileFromString(jsonString: "")) { error in
//            XCTAssertTrue(error is Kotlinx_serialization_coreSerializationException)
        }
    }
}
