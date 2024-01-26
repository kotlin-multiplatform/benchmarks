//
//  JsonStrings.swift
//  multiplatformTests
//
//  Created by Sebastian Owodzin on 16/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import Foundation

extension Bundle {
    public static var testResources: Bundle { JsonStrings().bundle }
}

public class JsonStrings {
    internal var bundle: Bundle {
        return Bundle(for: type(of: self))
    }
    
    public struct Minimised {
        public static var largeList: String = try! String(contentsOfFile: Bundle.testResources.path(forResource: "large-list-min", ofType: "json")!)
        
        public static var macosReleases: String = try! String(contentsOfFile: Bundle.testResources.path(forResource: "macos-releases-min", ofType: "json")!)
        
        public static var polymorphicGeo: String = try! String(contentsOfFile: Bundle.testResources.path(forResource: "polymorphic-geo-min", ofType: "json")!)
        
        public static var polymorphicHtml: String = try! String(contentsOfFile: Bundle.testResources.path(forResource: "polymorphic-html-min", ofType: "json")!)
        
        public static var userProfile: String = try! String(contentsOfFile: Bundle.testResources.path(forResource: "user-profile-min", ofType: "json")!)
    }
    
    public struct PrettyPrinted {
        public static var largeList: String = try! String(contentsOfFile: Bundle.testResources.path(forResource: "large-list", ofType: "json")!)
        
        public static var macosReleases: String = try! String(contentsOfFile: Bundle.testResources.path(forResource: "macos-releases", ofType: "json")!)
        
        public static var polymorphicGeo: String = try! String(contentsOfFile: Bundle.testResources.path(forResource: "polymorphic-geo", ofType: "json")!)
        
        public static var polymorphicHtml: String = try! String(contentsOfFile: Bundle.testResources.path(forResource: "polymorphic-html", ofType: "json")!)
        
        public static var userProfile: String = try! String(contentsOfFile: Bundle.testResources.path(forResource: "user-profile", ofType: "json")!)
    }
}
