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
        let data = try! KotlinxSerialization().decodeLargeListFromString(jsonString: Resources.Minimised.largeListJsonString)
        XCTAssertEqual("2489651045", data.first!.id)
        XCTAssertEqual("https://avatars.githubusercontent.com/u/665991?", data.first!.actor.avatarUrl)
    }
    
    func testDecodeLargeListCompactFromString() throws {
        let data = try! KotlinxSerialization().decodeLargeListCompactFromString(jsonString: Resources.Minimised.largeListJsonString)
        XCTAssertEqual("2489651045", data.first!.id)
        XCTAssertEqual("https://avatars.githubusercontent.com/u/665991?", data.first!.actor.avatarUrl)
    }

    func testDecodeMacOsReleasesFromString() throws {
        let data = try! KotlinxSerialization().decodeMacOsReleasesFromString(jsonString: Resources.Minimised.macosReleasesJsonString)
        XCTAssertEqual("Kodiak", data.versions.first!.internal)
        XCTAssertEqual("US", data.versions.first!.releases.first!.version)
    }

    func testDecodePolymorphicGeoFromString() throws {
        let data = try! KotlinxSerialization().decodePolymorphicGeoFromString(jsonString: Resources.Minimised.polymorphicGeoJsonString)
        XCTAssertTrue(data.first is GeoJSONObjectPoint)
        XCTAssertEqual([100.0, 0.0], (data.first! as! GeoJSONObjectPoint).coordinates)
    }

    func testDecodePolymorphicHtmlFromString() throws {
        let data = try! KotlinxSerialization().decodePolymorphicHtmlFromString(jsonString: Resources.Minimised.polymorphicHtmlJsonString)
        XCTAssertTrue(data.first is HtmlChunkParagraph)
        XCTAssertTrue((data.first as! HtmlChunkParagraph).data.text.isNotBlank())
    }
    
    func testDecodeUserProfileFromString() throws {
        let data = try! KotlinxSerialization().decodeUserProfileFromString(jsonString: Resources.Minimised.userProfileJsonString)
        XCTAssertTrue(data.personal.firstName.isNotBlank())
    }
}
