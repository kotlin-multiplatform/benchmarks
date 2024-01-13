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
        let filePath = Bundle(for: type(of: self)).path(forResource: "large-list", ofType: "json")
        let jsonString = try! String(contentsOfFile: filePath!)
        
        let data = try! KotlinxSerializationKt.decodeLargeListFromString(jsonString: jsonString)
        XCTAssertTrue(!data.isEmpty)
    }
    
//    func testEncodeLargeListToString() throws {
//        let filePath = Bundle(for: type(of: self)).path(forResource: "large-list", ofType: "json")
//        let expectedJsonString = try! String(contentsOfFile: filePath!)
//        
//        let data = try! KotlinxSerializationKt.decodeLargeListFromString(jsonString: expectedJsonString)
//        XCTAssertEqual(expectedJsonString, try! KotlinxSerializationKt.encodeLargeListToString(value: data))
//    }
    
    func testDecodeMacOsReleasesFromString() throws {
        let filePath = Bundle(for: type(of: self)).path(forResource: "macos-releases", ofType: "json")
        let jsonString = try! String(contentsOfFile: filePath!)
        
        let data = try! KotlinxSerializationKt.decodeMacOsReleasesFromString(jsonString: jsonString)
        XCTAssertTrue(!data.versions.isEmpty)
    }
    
    func testEncodeMacOsReleasesToString() throws {
        let filePath = Bundle(for: type(of: self)).path(forResource: "macos-releases", ofType: "json")
        let expectedJsonString = try! String(contentsOfFile: filePath!)
        
        let data = try! KotlinxSerializationKt.decodeMacOsReleasesFromString(jsonString: expectedJsonString)
        XCTAssertEqual(expectedJsonString, try! KotlinxSerializationKt.encodeMacOsReleasesToString(value: data))
    }
    
    func testDecodePolymorphicGeoFromString() throws {
        let filePath = Bundle(for: type(of: self)).path(forResource: "polymorphic-geo", ofType: "json")
        let jsonString = try! String(contentsOfFile: filePath!)
        
        let data = try! KotlinxSerializationKt.decodePolymorphicGeoFromString(jsonString: jsonString)
        XCTAssertTrue(!data.isEmpty)
    }
    
    func testEncodePolymorphicGeoToString() throws {
        let filePath = Bundle(for: type(of: self)).path(forResource: "polymorphic-geo", ofType: "json")
        let expectedJsonString = try! String(contentsOfFile: filePath!)
        
        let data = try! KotlinxSerializationKt.decodePolymorphicGeoFromString(jsonString: expectedJsonString)
        XCTAssertEqual(expectedJsonString, try! KotlinxSerializationKt.encodePolymorphicGeoToString(value: data))
    }
    
    func testDecodePolymorphicHtmlFromString() throws {
        let filePath = Bundle(for: type(of: self)).path(forResource: "polymorphic-html", ofType: "json")
        let jsonString = try! String(contentsOfFile: filePath!)
        
        let data = try! KotlinxSerializationKt.decodePolymorphicHtmlFromString(jsonString: jsonString)
        XCTAssertTrue(!data.isEmpty)
    }
    
    func testEncodePolymorphicHtmlToString() throws {
        let filePath = Bundle(for: type(of: self)).path(forResource: "polymorphic-html", ofType: "json")
        let expectedJsonString = try! String(contentsOfFile: filePath!)
        
        let data = try! KotlinxSerializationKt.decodePolymorphicHtmlFromString(jsonString: expectedJsonString)
        XCTAssertEqual(expectedJsonString, try! KotlinxSerializationKt.encodePolymorphicHtmlToString(value: data))
    }
    
    func testDecodeUserProfileFromString() throws {
        let filePath = Bundle(for: type(of: self)).path(forResource: "user-profile", ofType: "json")
        let jsonString = try! String(contentsOfFile: filePath!)
        
        let data = try! KotlinxSerializationKt.decodeUserProfileFromString(jsonString: jsonString)
        XCTAssertTrue(!data.personal.firstName.isEmpty)
    }
    
    func testEncodeUserProfileToString() throws {
        let filePath = Bundle(for: type(of: self)).path(forResource: "user-profile", ofType: "json")
        let expectedJsonString = try! String(contentsOfFile: filePath!)
        
        let data = try! KotlinxSerializationKt.decodeUserProfileFromString(jsonString: expectedJsonString)
        XCTAssertEqual(expectedJsonString, try! KotlinxSerializationKt.encodeUserProfileToString(value: data))
    }
}
