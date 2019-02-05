//project2.cpp
//===========================================================
//Program Information:
//
//COP 2271 Project 2: Lucas sequence
//Due: 9/17/2011
//Name: Yicong Yong
//
//-----------------------------------------------------------
//
//Program Description:
//
//This program does perform the following tasks:
//1. Detect if a given number is in the Lucas sequence or not
//2. Find the n-th in line Lucas number
//3. Compute the summation of all Lucas numbers up to a certain point
//4. Find out if a given two digit number is a Carol number or not
//
//===========================================================

#include <iostream>
#include <cmath>
#include <cstdlib>

using namespace std;

int main(void){

    //variable declarations
    char choice; //main menu selection
    int n, i; //declare user input variable and a counter for loops
    int a, b, acopy, sum; //declare variables for computing terms in sequence and sum
    int c_1, c_2; //declare variables for checking Carol number

//executable code
//do{ //while main menu choice is 1, 2, 3, or 4, present menus
do{

    cout << "Lucas Numbers Calculator" << endl
        << "Please enter one of the following choices." << endl
        << "1. To find if a number belongs to the series or not." << endl
        << "2. To find the n-th number in rank." << endl
        << "3. To compute the sum of all Lucas numbers up to a given bound." << endl
        << "4. To check if a given two digit number is a Carol number." << endl
        << "Please choose: ";
    cin >> choice;



    if(choice == '1' || choice == '2' || choice == '3' || choice == '4'){ //check to make sure the input is 1,2,3 or 4; letters and other choices would be invalid, 0 quits

        switch(choice){

            case '1': //menu choice 1
                cout << "Please give the number you want to check: ";
                cin >> n;
                if(n > 0){ //checking if input is positive
                    a = 2, b = 1; //initializing first two terms
                    while(n > b){
                        acopy = a; //save a copy of a
                        a = b; //replace a with b
                        b = acopy + b; //replace b with the sum of b and the previous value of a
                    }
                    if(n == 2 || n == b){ //check whether n matches value of the computed b
                        cout << n << " IS a Lucas number." << endl << endl;
                    }
                    else{
                        cout << n << " is NOT a Lucas number." << endl << endl;
                    }
                }

                else{
                    cout << "Only positive numbers are accepted." << endl << endl;
                }

                break;

            case '2': //menu choice 2
                cout << "Please give the rank of the number you are looking for: ";
                cin >> n;
                if(n > 0){ //checking if number is positive
                    if(n == 1){ //first term in the sequence
                        cout << "2 is the 1-th Lucas number." << endl << endl;
                    }
                    else if(n == 2){ //second term in the sequence
                        cout << "1 is the 2-th Lucas number." << endl << endl;
                    }
                    else{ //all other terms in the sequence after the first and second terms
                        a = 2, b = 1; //initializing first two terms in the sequence
                        for(i = 0; i <= n-3; i++){ //computing, with the help of a counter, the nth term
                            acopy = a;
                            a = b;
                            b = acopy + b;
                    }
                    cout << b << " is the " << n << "-th Lucas number." << endl << endl;
                    }
                }
                else{
                    cout << "Only positive numbers are accepted." << endl << endl;
                }

                break;

            case '3': //menu choice 3
                cout << "Please enter the upper bound of the summation you are looking for: ";
                cin >> n;
                if(n > 0){ //checking if number is positive
                    a = 2, b = 1, sum = 3; //initializing first two terms and sum
                    for(i=0; i<=n-3; i++){
                        acopy = a;
                        a = b;
                        b = acopy + b;
                        if(b <= n){ //for each iteration, if the computed b is less or equal to the bound, add that to the sum
                            sum = sum + b;
                        }
                    }
                    cout << sum << " is the summation of all Lucas numbers until " << n << "." << endl << endl;
                }
                else{
                    cout << "Only positive numbers are accepted." << endl << endl;
                }

                break;

            case '4': //menu choice 4
                cout << "Please give a two digit, positive number: ";
                cin >> n;

                if(n >= 10 && n <= 99){ //checking if input is positive and two-digit
                    a = 2, b = 1; //initializing first two terms
                    while(n > b){
                        acopy = a; //save a copy of a
                        a = b; //replace a with b
                        b = acopy + b; //replace b with the sum of b and the previous value of a
                    }
                    if(n == b){ //check whether input is in Lucas sequence
                        c_1 = b%10; //units digit of input
                        c_2 = b/10; //tenth digit of input

                        a = 2, b = 1; //initializing first two terms
                        while(c_1 > b){ //check whether
                            acopy = a; //save a copy of a
                            a = b; //replace a with b
                            b = acopy + b; //replace b with the sum of b and the previous value of a
                        }
                        if(c_1 == b){ //check whether units digit of input is in Lucas sequence
                            a = 2, b = 1; //initializing first two terms
                            while(c_2 > b){
                                acopy = a; //save a copy of a
                                a = b; //replace a with b
                                b = acopy + b; //replace b with the sum of b and the previous value of a
                            }
                            if(c_2 == b){ //check whether tenth digit of input is in Lucas sequence
                                cout << n << " IS a Carol number." << endl << endl;
                            }
                        }
                        else{
                        cout << n << " is NOT a Carol number." << endl << endl;
                        }

                    }
                    else{
                        cout << n << " is NOT a Carol number." << endl << endl;
                    }
                }

                else{
                    cout << "Only two digit positive numbers are accepted." << endl << endl;
                }

                break;

        }

    }

    else if(choice != '0'){ //while user input is not 0, any other invalid inputs will receive this message
        cout << "Wrong choice. Please choose again." << endl << endl;
    }


}while(choice != '0'); //quits when user inputs 0


    cout << endl << "Now quitting.." << endl << endl;

    system("PAUSE");
    return 0;
}
