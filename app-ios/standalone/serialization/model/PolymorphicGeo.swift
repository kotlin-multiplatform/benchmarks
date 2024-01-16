//
//  PolymorphicGeo.swift
//  standalone
//
//  Created by Sebastian Owodzin on 13/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import Foundation

public struct GeoJSONObject: Codable {
    
}

//public protocol _GeoJSONObject : Codable {
//    static var type: String { get }
//}
//
//public enum GeoJSONObject {
//    public struct Point : _GeoJSONObject {
//        public static var type: String { return "Point" }
//        public var coordinates: Coordinates
//    }
//    
//    public struct LineString : _GeoJSONObject {
//        public static var type: String { return "LineString" }
//        public var coordinates: [Coordinates]
//    }
//    
//    public struct Polygon : _GeoJSONObject {
//        public static var type: String { return "Polygon" }
//        public var coordinates: [[Coordinates]]
//    }
//    
//    public struct MultiPoint : _GeoJSONObject {
//        public static var type: String { return "MultiPoint" }
//        public var coordinates: [Coordinates]
//    }
//    
//    public struct MultiLineString : _GeoJSONObject {
//        public static var type: String { return "MultiLineString" }
//        public var coordinates: [[Coordinates]]
//    }
//    
//    public struct MultiPolygon : _GeoJSONObject {
//        public static var type: String { return "MultiPolygon" }
//        public var coordinates: [[[Coordinates]]]
//    }
//    
//    public struct GeometryCollection : _GeoJSONObject {
//        public static var type: String { return "GeometryCollection" }
//        public var geometries: [_GeoJSONObject]
//        
//        enum CodingKeys: String, CodingKey {
//            case type
//            case geometries
//        }
//        
//        public func encode(to encoder: Encoder) throws {
//            var container = encoder.container(keyedBy: CodingKeys.self)
//            var _geometries = container.nestedUnkeyedContainer(forKey: .geometries)
//            for geometry in geometries {
//                if let value = geometry as? Point {
//                    try _geometries.encode(value)
//                } else if let value = geometry as? LineString {
//                    try _geometries.encode(value)
//                } else if let value = geometry as? Polygon {
//                    try _geometries.encode(value)
//                } else if let value = geometry as? MultiPoint {
//                    try _geometries.encode(value)
//                } else if let value = geometry as? MultiLineString {
//                    try _geometries.encode(value)
//                } else if let value = geometry as? MultiPolygon {
//                    try _geometries.encode(value)
//                }
//            }
//        }
//        
//        public init(from decoder: Decoder) throws {
//            let container = try decoder.container(keyedBy: CodingKeys.self)
//            var _geometries = try container.nestedUnkeyedContainer(forKey: .geometries)
//            geometries = []
//            while !_geometries.isAtEnd {
//                if let value = try? _geometries.decode(Point.self) {
//                    geometries.append(value)
//                } else if let value = try? _geometries.decode(LineString.self) {
//                    geometries.append(value)
//                } else if let value = try? _geometries.decode(Polygon.self) {
//                    geometries.append(value)
//                } else if let value = try? _geometries.decode(MultiPoint.self) {
//                    geometries.append(value)
//                } else if let value = try? _geometries.decode(MultiLineString.self) {
//                    geometries.append(value)
//                } else if let value = try? _geometries.decode(MultiPolygon.self) {
//                    geometries.append(value)
//                }
//            }
//        }
//        
//        public init(geometries: [_GeoJSONObject]) {
//            self.geometries = geometries
//        }
//    }
//}
//
//public typealias Coordinates = [Double]
//
////public struct Coordinates : Codable {
////    public var longitude: Double
////    public var latitude: Double
////}
//
//func dd() {
////    let _ = GeoJSONObject.Point(coordinates: [])
//    let _ = GeoJSONObject.GeometryCollection(geometries: [GeoJSONObject.Point(coordinates: [])])
//}
