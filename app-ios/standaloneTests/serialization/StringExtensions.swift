//
//  StringExtensions.swift
//  standaloneTests
//
//  Created by Sebastian Owodzin on 18/01/2024.
//  Copyright © 2024 kmp. All rights reserved.
//

import Foundation

extension String {
    public func isNotBlank() -> Bool {
        return filter { !$0.isWhitespace }.isEmpty == false
    }
}
