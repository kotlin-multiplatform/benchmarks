//
//  MacOsReleases.swift
//  standalone
//
//  Created by Sebastian Owodzin on 13/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import Foundation

public struct MacOsReleases: Codable {
    public var updated: String
    public var key: [String]
    public var versions: [Version]
    
    public struct Version: Codable {
        public var family: String
        public var version: String
        public var platforms: [String]
        public var `internal`: String
        public var external: String
        public var announced: String
        public var released: String
        public var requirements: [String]
        public var releases: [Release]
        
        public struct Release: Codable {
            public var version: String
            public var platforms: [String]
            public var build: String
            public var darwin: String
            public var kernel: String
            public var released: String
        }
    }
}
