//project1.cpp
//===========================================================
//Program Information:
//
//COP 2271 Project 1: Conversions
//Due: 9/5/2011
//Name: Yicong Yong
//
//-----------------------------------------------------------
//
//Program Description:
//
//This program does temperature conversions between Celsius and Fahrenheit,
//distance conversions between Feet and Meters, and
//weight conversions between Pounds and Kilograms.
//
//===========================================================

#include <iostream>
#include <cmath>
#include <cstdlib>

using namespace std;

int main(void){

    //variable declarations
    int mChoice; //main menu choice
    int sChoice; //submenu choice
    float input; //input variables for conversion
    float output; //output variables converted

//executable code
//do{ //while main menu choice is 1, 2, or 3, present menus
    cout << "Converter Main Menu" << endl
        << "Please choose one of the following options" << endl
        << "1. For Temperature Conversions" << endl
        << "2. For Distance Conversions" << endl
        << "3. For Weight Conversions" << endl
        << "Press any other number to quit." << endl
        << "Choose: ";
    cin >> mChoice;

    //main menu choice 1
    if(mChoice == 1){
        cout << "1. Fahrenheit -> Celsius" << endl
            << "2. Celsius -> Fahrenheit" << endl;
        cin >> sChoice;

        //submenu choice 1
        if(sChoice == 1){
            cout << "Please give the degrees in Fahrenheit: ";
            cin >> input;
            output = 5.0/9.0*(input - 32.0); //convert F to C
            cout << input << " degrees Fahrenheit correspond to " << output << " degrees Celsius." << endl;
        }

        //submenu choice 2
        else if(sChoice == 2){
            cout << "Please give the degrees in Celsius: ";
            cin >> input;
            output = 9.0/5.0*input + 32.0; //convert C to F
            cout << input << " degrees Celsius correspond to " << output << " degrees Fahrenheit." << endl;
        }
    }

    //main menu choice 2
    else if(mChoice == 2){
        cout << "1. Feet -> Meters" << endl
            << "2. Meters -> Feet" << endl;
        cin >> sChoice;

        //submenu choice 1
        if(sChoice == 1){
            cout << "Please give the distance in Feet: ";
            cin >> input;
            output = input*0.3048; //convert ft to m
            cout << input << " feet correspond to " << output << " meters." << endl;
        }

        //submenu choice 2
        else if(sChoice == 2){
            cout << "Please give the distance in Meters: ";
            cin >> input;
            output = input/0.3048; //convert m to ft
            cout << input << " meters correspond to " << output << " feet." << endl;
        }
    }

    //main menu choice 3
    else if(mChoice == 3){
        cout << "1. Pounds -> Kilograms" << endl
            << "2. Kilograms -> Pounds" << endl;
        cin >> sChoice;

        //submenu choice 1
        if(sChoice == 1){
            cout << "Please give the weight in Pounds: ";
            cin >> input;
            output = input/2.2; //convert lb to kg
            cout << input << " pounds correspond to " << output << " kilograms." << endl;
        }

        //submenu choice 2
        else if(sChoice == 2){
            cout << "Please give the weight in Kilograms: ";
            cin >> input;
            output = input*2.2; //convert kg to lb
            cout << input << " kilograms correspond to " << output << " pounds." << endl;
        }
    }
//}while(mChoice == 1 || mChoice == 2 || mChoice == 3);

    cout << "Quitting.." << endl << endl;

    system("PAUSE");
    return 0;
}
