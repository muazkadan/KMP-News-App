import SwiftUI
import shared

struct ContentView: View {
    let greet = GreetingHelper().greet()

	var body: some View {
        VStack{
            Text(greet)
            Text("Hello, world")
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
