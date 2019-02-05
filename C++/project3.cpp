//project3.cpp
//===========================================================
//Program Information:
//
//Name: Connie
//
//-----------------------------------------------------------
//
//Program Description:
//
//This program does perform the following tasks:
//1. Accepts user input
//2. Encrypts user input
//3. Decrypts user input
//4. Performs statistical analysis of user input
//
//===========================================================

#include <iostream>
#include <cmath>
#include <cstdlib>
#include <fstream>

using namespace std;

int main(void){

    int choice, count, shift, i;
    char answer;
    char text[140], encrypt[140], decrypt[140];//input array, encrypted array, decrypted array
    int convert[140];//array used to convert ascii characters to corresponding dec value

    for(i=0;i<140;i++){//initializing arrays to all null characters
        text[i]=0;
        encrypt[i]=0;
        decrypt[i]=0;
        convert[i]=0;
    }

    bool flag=false;
    int extra;//shift count for letters near the two ends of the alphabet

    do{
        cout << endl << "Caesar Cipher v2.0" << endl;//main menu
        cout << "1. To input/modify input data" << endl
        << "2. To cipher a message" << endl
        << "3. To decipher a message" << endl
        << "4. To perform a statistical analysis of the text." << endl
        << "Press 0 to quit." << endl;
        cout << "Please choose: ";
        cin >> choice;

        if(choice==0){
            cout << "Now quitting.." << endl;
        }

        else if(choice==1){//option to accept or modify user input

            if(flag==false){//switch is off

                cout << "Give input count: ";
                cin >> count;

                cout << "Please give text: ";
                for(i=0;i<count;i++){//loop to enter input values
                    cin >> text[i];
                }

                flag = true;//turn on switch
            }
            else if(flag){//switch is on

                do{
                    cout << "Are you sure you want to modify the input? ";
                    cin >> answer;

                    if(answer=='Y' || answer=='y'){
                        cout << "Give new input count: ";
                        cin >> count;

                        cout << "Please give new text: ";
                        for(i=0;i<count;i++){//reentering input values
                            cin >> text[i];
                        }
                    }
                    else if(answer=='N' || answer=='n'){
                        cout << "Returning to the main menu.." << endl << endl;
                    }
                    else{
                        cout << "Please choose Y(es) or N(o)." << endl;//making sure user gives correct input
                    }
                }while(answer!='N' && answer!='n' && answer!='Y' && answer!='y');//make sure to repeatedly remind user to input yes or no characters
            }
        }

        else if(choice==2){//option to encrypt

            if(flag){//switch is on

                cout << "Please choose the number of shifts you want: ";
                cin >> shift;
                if(shift<0){//check to see if shift is negative
                    cout << "Cannot have negative number of shifts!" << endl;
                }
                else{
                    shift=shift%26;//avoid having to repeat cycles of 26 shifts which returns to the original state

                    for(i=0;i<count;i++){//looping through the user input array
                        convert[i]=text[i];
                        if(convert[i]<123 && convert[i]>96){//make sure only characters from the alphabet are shifted

                            if(convert[i]-shift<97){//when the ascii minus shift is less than the value of a
                                extra=shift-convert[i]+97-1;//calcuate number of shifts for letters at the beginning of the alphabet
                                encrypt[i]=122-extra;//122 is the value of z
                            }
                            else{
                                encrypt[i]=convert[i]-shift;//shifts the ascii value
                            }

                        }
                        else{//if not an alphabet character, it stays the same

                            encrypt[i]=convert[i];

                        }
                    }
                    cout << "The encrypted message is: " << encrypt << endl << endl;
                }
            }
            else{
                cout << "Please use option 1 before using this one.\n";
            }
        }

        else if(choice==3){//option to decrypt

            if(flag){//switch is on

                cout << "Please choose the number of shifts in the encrypted message: ";
                cin >> shift;
                if(shift<0){//check to see if shift is negative
                    cout << "Cannot have negative number of shifts!" << endl;
                }
                else{
                    shift=shift%26;//avoid having to repeat cycles of 26 shifts which returns to the original state

                    for(i=0;i<count;i++){
                        convert[i]=text[i];
                        if(convert[i]<123 && convert[i]>96){//make sure only characters from the alphabet are shifted

                            if(convert[i]+shift>122){//when the ascii plus shift is great than the value of z
                                extra=shift+convert[i]-122-1;
                                decrypt[i]=97+extra;//97 is the value of a
                            }
                            else{
                                decrypt[i]=convert[i]+shift;//shifts the ascii value
                            }

                        }
                        else{//if not an alphabet character, it stays the same

                            decrypt[i]=convert[i];

                        }
                    }

                    cout << "The decrypted message is: " << decrypt << endl << endl;
                }
            }
            else{
                cout << "Please use option 1 before using this one.\n";
            }
        }

        else if(choice==4){//option to perform stat analysis

            if(flag){//switch is on
                cout << "Statistical Analysis" << endl;
                int counter[26];
                int j;
                float vowel=0.0, consonant=0.0;
                int convert[count];


                for(j=97;j<=122;j++){
                    counter[j-97]=0;//set counter to zero for all elements
                    for(i=0;i<count;i++){//looping through the input array
                        convert[i]=text[i];//convert to dec representation
                        if(convert[i]==j){//check to see if corresponding ascii value is the same
                            counter[j-97]++;//count number of each character
                            if(text[i]=='a'||text[i]=='e'||text[i]=='i'||text[i]=='o'||text[i]=='u'){
                                vowel++;//count number of vowels
                            }
                            else{
                                consonant++;//count number of consonants
                            }
                        }
                    }
                }

                for(i=0;i<26;i++){//print out counts
                    cout << (char)(i+97) << ": " << counter[i] << endl;//prints letter and corresponding counter
                }

                cout << "The ratio of vowels to consonants is " << vowel/consonant << endl;
            }

            else{
                cout << "Please use option 1 before using this one.\n";
            }
        }

        else{
            cout << "Wrong choice! Please choose again!" << endl << endl;//any input other than the menu choices
        }

    }while(choice!=0);


    system("PAUSE");
    return 0;
}

