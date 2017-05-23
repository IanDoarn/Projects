// RockPaperScissors.cpp : Defines the entry point for the console application.
// Basic Rock Paper Scissors game!
// Player versus computer. 
// Rules: 
//		0 - Rock
//		1 - Paper
//		2 - Scissors
//
// Written by: Ian Doarn

#include "stdafx.h"
#include <iostream>

using namespace std;

// Choose random number for computer.
int choice()
{
	return rand() % 2;
}

void game(int cComp, int cPlayer)
{
	switch(cComp)
	{
		case 0:
		// Computer chose Rock
			if (cPlayer == 0) { cout << "Rock = Rock. Draw."; break; }
			if (cPlayer == 1) { cout << "Paper > Rock. Player Wins"; break; }
			if (cPlayer == 2) { cout << "Scissors < Rock. Computer Wins"; break; }

		case 1:
		// Computer chose Paper
			if (cPlayer == 0) { cout << "Rock < Paper. Computer Wins"; break; }
			if (cPlayer == 1) { cout << "Paper = Paper. Draw"; break; }
			if (cPlayer == 2) { cout << "Scissors > Paper. Player Wins"; break; }

		case 2:
		// Computer chose Scissors
			if (cPlayer == 0) { cout << "Scissors < Rock. Player Wins"; break; }
			if (cPlayer == 1) { cout << "Scissors > Paper. Computer Wins"; break; }
			if (cPlayer == 2) { cout << "Scissors = Scissors. Draw"; break; }

		default:
		// Default is to break and exit the game.
			break;
	}
}

int main()
{
	// Declare two unsigned ints to store the computers 
	// choice and the players choice
	unsigned int computer, player;

	// Print game info
	cout << "Rock Paper Scissors!" << endl;
	cout << "0: Rock 1: Paper 2: Scissors\n" << endl;
	cout << "Enter your choice: ";

	// Get players choice. Make sure it is not greater than 2
	cin >> player;
	computer = choice();

	game(computer, player);
	
	system("pause");

    return 0;
}

