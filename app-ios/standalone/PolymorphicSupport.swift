//
//  PolymorphicSupport.swift
//  standalone
//
//  Created by Sebastian Owodzin on 13/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

//import Foundation
//
//protocol Polymorphic: Codable {
//    static var id: String { get }
//}
//
//extension Polymorphic {
//    static var id: String {
//        String(describing: Self.self)
//    }
//}
//
//extension Encoder {
//    func encode<ValueType>(_ value: ValueType) throws {
//        guard let value = value as? Polymorphic else {
//            throw PolymorphicCodableError
//                .unableToRepresentAsPolymorphicForEncoding
//        }
//        var container = self.container(
//            keyedBy: PolymorphicMetaContainerKeys.self
//        )
//        try container.encode(
//            type(of: value).id,
//            forKey: ._type
//        )
//        try value.encode(to: self)
//    }
//}
//
//enum PolymorphicCodableError: Error {
//    case missingPolymorphicTypes
//    case unableToFindPolymorphicType(String)
//    case unableToCast(decoded: Polymorphic, into: String)
//    case unableToRepresentAsPolymorphicForEncoding
//}
//
//enum PolymorphicMetaContainerKeys: CodingKey {
//    case _type
//}
//
//extension CodingUserInfoKey {
//    static var polymorphicTypes: CodingUserInfoKey {
//        CodingUserInfoKey(rawValue: "com.codable.polymophicTypes")!
//    }
//}
//
//extension Decoder {
//    func decode<ExpectedType>(
//        _ expectedType: ExpectedType.Type
//    ) throws -> ExpectedType {
//        let container = try self.container(
//            keyedBy: PolymorphicMetaContainerKeys.self
//        )
//        let typeID = try container.decode(String.self, forKey: ._type)
//     
//        guard let types = self
//            .userInfo[.polymorphicTypes] as? [Polymorphic.Type] else {
//                throw PolymorphicCodableError.missingPolymorphicTypes
//        }
//     
//        let matchingType = types.first { type in
//            type.id == typeID
//        }
//     
//        guard let matchingType = matchingType else {
//            throw PolymorphicCodableError
//                .unableToFindPolymorphicType(typeID)
//        }
//     
//        let decoded = try matchingType.init(from: self)
//     
//        guard let decoded = decoded as? ExpectedType else {
//            throw PolymorphicCodableError.unableToCast(
//                decoded: decoded,
//                into: String(describing: ExpectedType.self)
//            )
//        }
//        return decoded
//    }
//}
//
//@propertyWrapper
//struct PolymorphicValue<Value> {
//    var wrappedValue: Value
//}
//
//extension PolymorphicValue: Codable {
//    init(from decoder: Decoder) throws {
//        self.wrappedValue = try decoder.decode(Value.self)
//    }
//   
//    func encode(to encoder: Encoder) throws {
//        try encoder.encode(self.wrappedValue)
//    }
//}
