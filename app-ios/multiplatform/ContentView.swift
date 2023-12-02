//
//  ContentView.swift
//  benchmarks-multiplatform
//
//  Created by Sebastian Owodzin on 02/12/2023.
//  Copyright © 2023 kmp. All rights reserved.
//

import SwiftUI
import BenchmarksShared

struct ContentView: View {
    let greet = Greeting().greet()

    var body: some View {
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundStyle(.tint)
            Text(greet)
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
