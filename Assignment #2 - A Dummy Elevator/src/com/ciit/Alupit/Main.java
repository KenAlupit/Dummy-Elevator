package com.ciit.Alupit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Random;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader (input);
	
	String[] Passengers = new String[10] ;
	String[] NullPassenger = {"Jade", "Patrick", "Christian", "Victoria", "Bille", "JM", "Marion", "Chelsey", "Lauren","Dave","Matt"};
	Random RandomNumber = new Random();
	int [] RandomPassengers;
	LinkedList<String> PassengerLog= new LinkedList<String>();
	LinkedList<String> LogBook = new LinkedList<String>();
do {
	Passengers = new String[10] ;
	System.out.println("+------------------------------+");
	System.out.println("|Welcome to the dummy elevator!|");
	System.out.println("+------------------------------+");
	System.out.println("|      [R] ride elevator       |");
	System.out.println("+------------------------------+");
	System.out.println("|   [S] Show Passenger Log     |");
	System.out.println("+------------------------------+");
	char Selection = reader.readLine().charAt(0);
	switch(Selection) {
	case 'R':
	case 'r':
		System.out.println("+--------------------+");
		System.out.println("| What is your name? |");
		System.out.println("+--------------------+");
		String PassengerName = reader.readLine();
		Passengers[0] = PassengerName;
		System.out.println("+--------------------------------+");
		System.out.println("| Which floor do you want to go? |");
		System.out.println("+--------------------------------+");
		System.out.println("|            [1 - 25]            |");
		System.out.println("+--------------------------------+");
		int FloorNumber = Integer.parseInt(reader.readLine());
		if(FloorNumber > 25) {
			System.out.println("Invalid floor");
		}
		PassengerLog.add((PassengerName + " went out in floor " + FloorNumber));
		LogBook.add((PassengerName + " went out in floor " + FloorNumber));
		System.out.println("+---------------------------+");
		System.out.println("| Is there people with you? |");
		System.out.println("+---------------------------+");
		System.out.println("|        [Y] - Yes         |");
		System.out.println("+--------------------------+");
		System.out.println("|        [N] - No          |");
		System.out.println("+--------------------------+");
		Selection = reader.readLine().charAt(0);
		switch (Selection){
			case 'N':
			case 'n':
				for (int i = 0; 9 > i; i++) {
					Passengers[i] = NullPassenger[i];
				}
				if (Passengers != null) {
					System.out.println("+----------------+");
					System.out.println("| Elevator full! |");
					System.out.println("+----------------+");
					System.out.println("|    Going Up!   |");
					System.out.println("+----------------+");
					}
				RandomPassengers = new int[9];
				for (int i = 0; i < RandomPassengers.length; i++) {
					RandomPassengers[i] = RandomNumber.nextInt(9);
					for(int j = 0; j < i; j++) {
						if(RandomPassengers[i] == RandomPassengers[j]) {
							i--;
							break;
						}
					}
				}
			for (int b = 0; b < 9; b++) {
				int RandomFloor = RandomNumber.nextInt(25)+1;
				PassengerLog.add((Passengers[RandomPassengers[b]] + " went out in floor " + RandomFloor));
				LogBook.add((Passengers[RandomPassengers[b]] + " went out in floor " + RandomFloor));
			}
			Passengers = PassengerLog.toArray(new String[PassengerLog.size()]);
			for (int i= 0; i< Passengers.length; i++) {
				System.out.println(Passengers[i]);
				}
			PassengerLog.clear();
			Passengers = null;
			if(Passengers == null) {
				System.out.println("+--------------------+");
				System.out.println("| Elevator is empty! |");
				System.out.println("+--------------------+");
			}
			break;
			case 'Y':
			case 'y':
			System.out.println("+-------------------+");
			System.out.println("| How many are you? |");
			System.out.println("+-------------------+");
			int PassengerFriends = Integer.parseInt(reader.readLine());
			Passengers = new String [10 - PassengerFriends];
			if(PassengerFriends > 10) {
				System.out.println("+------------------------------+");
				System.out.println("| Oops that's too many people! |");
				System.out.println("+------------------------------+");
				break;
			}
			for (int i = 1; i < (PassengerFriends + 1); i++) {
				System.out.println("+------+");
				System.out.println("| Name |");
				System.out.println("+------+");
				String FriendName = reader.readLine();
				System.out.println("+--------------------+");
				System.out.println("| Destination floor  |");
				System.out.println("+--------------------+");
				FloorNumber = Integer.parseInt(reader.readLine());
				if(FloorNumber >= 25) {
					System.out.println("+----------------+");
					System.out.println("| Invalid floor! |");
					System.out.println("+----------------+");
					break;
				}
				PassengerLog.add((FriendName + " went out in floor " + FloorNumber));
				LogBook.add((FriendName + " went out in floor " + FloorNumber));
				
			}
			if (PassengerFriends < 10) {
				for (int i = 0; 10 - PassengerFriends > i; i++) {
					Passengers[i] = NullPassenger[i];
				}
			}
				if (Passengers != null) {
					System.out.println("+----------------+");
					System.out.println("| Elevator full! |");
					System.out.println("+----------------+");
					System.out.println("|    Going Up!   |");
					System.out.println("+----------------+");
					}
				RandomPassengers = new int[10 - PassengerFriends];
				for (int i = 0; i < RandomPassengers.length; i++) {
					RandomPassengers[i] = RandomNumber.nextInt(10-PassengerFriends);
					for(int j = 0; j < i; j++) {
						if(RandomPassengers[i] == RandomPassengers[j]) {
							i--;
							break;
						}
					}
				}
			for (int b = 0; b < 9 - PassengerFriends; b++) {
				int RandomFloor = RandomNumber.nextInt(25)+1;
				PassengerLog.add((Passengers[RandomPassengers[b]] + " went out in floor " + RandomFloor));
				LogBook.add((Passengers[RandomPassengers[b]] + " went out in floor " + RandomFloor));
			}
			Passengers = PassengerLog.toArray(new String[PassengerLog.size()]);
			for (int i= 0; i< Passengers.length; i++) {
				System.out.println(Passengers[i]);
				}
			PassengerLog.clear();
			Passengers = null;
			if(Passengers == null) {
				System.out.println("+--------------------+");
				System.out.println("| Elevator is empty! |");
				System.out.println("+--------------------+");
			}
		}
		break;
	case 'S':
	case 's':
		boolean ListChecker = LogBook.isEmpty();
		if(ListChecker == true) {
			System.out.println("+------------------------+");
			System.out.println("| Passenger Log is empty |");
			System.out.println("+------------------------+");
		}else
		for (String i: LogBook) {
			System.out.println(i);
			}
		break;
	}
	
	}while (Passengers == null);
	}
}