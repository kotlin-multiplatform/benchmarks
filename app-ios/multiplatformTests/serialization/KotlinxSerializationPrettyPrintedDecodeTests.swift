//
//  KotlinxSerializationPrettyPrintedDecodeTests.swift
//  multiplatformTests
//
//  Created by Sebastian Owodzin on 12/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import BenchmarksShared
import XCTest

final class KotlinxSerializationPrettyPrintedDecodeTests: XCTestCase {

    func testDecodeLargeListFromString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodeLargeListFromString(jsonString: Resources.PrettyPrinted.largeListJsonString)
        XCTAssertEqual("2489651045", data.first!.id)
        XCTAssertEqual("https://avatars.githubusercontent.com/u/665991?", data.first!.actor.avatarUrl)
    }
    
    func testDecodeLargeCompactListFromString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodeLargeListCompactFromString(jsonString: Resources.PrettyPrinted.largeListJsonString)
        XCTAssertEqual("2489651045", data.first!.id)
        XCTAssertEqual("https://avatars.githubusercontent.com/u/665991?", data.first!.actor.avatarUrl)
    }
    
    func testDecodeMacOsReleasesFromString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodeMacOsReleasesFromString(jsonString: Resources.PrettyPrinted.macosReleasesJsonString)
        XCTAssertEqual("Kodiak", data.versions.first!.internal)
        XCTAssertEqual("US", data.versions.first!.releases.first!.version)
    }

    func testDecodePolymorphicGeoFromString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodePolymorphicGeoFromString(jsonString: Resources.PrettyPrinted.polymorphicGeoJsonString)
        XCTAssertTrue(data.first is GeoJSONObjectPoint)
        XCTAssertEqual([100.0, 0.0], (data.first! as! GeoJSONObjectPoint).coordinates)
    }

    func testDecodePolymorphicHtmlFromString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodePolymorphicHtmlFromString(jsonString: Resources.PrettyPrinted.polymorphicHtmlJsonString)
        XCTAssertTrue(data.first is HtmlChunkParagraph)
        XCTAssertTrue((data.first as! HtmlChunkParagraph).data.text.isNotBlank())
    }

    func testDecodeUserProfileFromString() throws {
        let data = try! KotlinxSerializationPrettyPrinted().decodeUserProfileFromString(jsonString: Resources.PrettyPrinted.userProfileJsonString)
        XCTAssertTrue(data.personal.firstName.isNotBlank())
    }
}
