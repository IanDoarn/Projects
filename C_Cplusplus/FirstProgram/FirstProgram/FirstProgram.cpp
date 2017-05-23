// Extremely simple example of C++

#include "stdafx.h"
#include <iostream>

using namespace std;

int main()
{
	// Define integer variable x
	int x;

	// Ask user for a value for x
	cout << "Enter a number to square: ";

	// Set x to the number they gave
	cin >> x;

	// Print the result to the console
	cout << x << " to the power of 2 is " << pow(x, 2) << endl;

	// Stop program from immediatly exiting
	system("pause");
	
	// Return exit code of 0
    return 0;
}

