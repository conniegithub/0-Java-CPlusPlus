//project5.cpp
//===========================================================
//Program Information:
//
//COP 2271 Project 5: Regal Cinema Manager
//Due: 12/02/2011
//Name: Yicong Yong
//
//-----------------------------------------------------------
//
//Program Description:
//
//This program does perform the following tasks:
//1. Input new information for a theatre
//2. Reserve seat
//3. Cancel a reservation
//4. Give information about a theater (earnings, name, movie, seats reserved...)
//5. Give information about the Regal Multiplex
//===========================================================

#include <iostream>
#include <cmath>
#include <cstdlib>
#include <sstream>
#include <string>

using namespace std;

class theatre{
private:
    string movie;
    float price;
    int seats[18][12];

public:
    theatre();

    string getMovie();
    float getPrice();

    void setMovie(string);
    void setPrice(float);

    bool res(int, int);//reserving seat
    bool canc(int, int);//canceling seat
    int numPpl();
    float earn();

    void print();
};

theatre::theatre(){
    movie = "N/A";//initialize movie and price
    price = 0;

    for(int i=0;i<18;i++){
        for(int j=0;j<12;j++){
            seats[i][j]=0;//set all seats to empty
        }
    }
}

int theatre::numPpl(){
    int count=0;
    for(int i=0;i<18;i++){
        for(int j=0;j<12;j++){
            count+=seats[i][j];//add up number of seats taken
        }
    }
    return count;
}

bool theatre::res(int row, int col){
    if(seats[row][col]!=1){
        seats[row][col]=1;
        return true;//returns true if seat is reserved
    }
    else{
        return false;
    }
}

bool theatre::canc(int row, int col){
    if(seats[row][col]!=0){
        seats[row][col]=0;
        return true;//returns true if seat is cancelled
    }
    else{
        return false;
    }
}

string theatre::getMovie(){
    return movie;
}

float theatre::getPrice(){
    return price;
}

void theatre::setMovie(string temp){
    movie=temp;
}

void theatre::setPrice(float temp){
    price=temp;
}

float theatre::earn(){
    return price*numPpl();//calculates revenue
}

void theatre::print(){//debugging function to print out all seats
    for(int i=0;i<18;i++){
        for(int j=0;j<12;j++){
            cout << seats[i][j];
        }
    }
}

int main(){
    char choice;
    theatre regal[16];//16 instances of theatre

    string temp="";
    int num;//theatre number
    char ans;
    float p;
    int row,col;
    int total;

    do{
        cout << endl << "Regal Cinemas Manager" << endl
            << "1. To input new movie info in a theatre." << endl
            << "2. To reserve a seat in a theatre." << endl
            << "3. To cancel a reservation in a theatre." << endl
            << "4. To calculate earnings for a theatre." << endl
            << "5. To calculate overall earnings for all theatres." << endl
            << "Please choose: ";
        cin >> choice;

        if(choice=='1'){
            cout << "Please select theatre: ";
            cin >> num;//accepts number
            if(num>0&&num<=16){//check to see if it is a valid number within the range
                cout << "Warning: This theatre is showing "<<regal[num-1].getMovie()
                        <<" with a price of "<<regal[num-1].getPrice()<<"."<<endl;
                //check for reserved number of seats
                if(regal[num-1].numPpl()==0){
                    cout << "Currently, no people have a reservation for that movie." << endl;
                }
                else{
                    cout << "Currently, " << regal[num-1].numPpl() << " people have a reservation for that movie." << endl;
                }

                cout << "Do you want to continue? Press Y/y to continue or anything else to go back. ";
                cin >> ans;
                if(ans=='y'||ans=='Y'){
                    cout << "Please give the movie name: ";
                    cin.ignore();
                    getline(cin,temp);//accepts name
                    regal[num-1].setMovie(temp);

                    cout << "Please give the ticket price: ";
                    cin >> p;
                    regal[num-1].setPrice(p);

                    cout << "Movie successfully inputted in cinema " << num << "!" << endl;
                }
            }
            else{
                cout << "We only have 16 theatres.  Please enter a number from 1 - 16." << endl;
            }
        }
        else if(choice=='2'){//reserve seat option
            cout << "Please choose from the following options:" << endl
                << "1. If you know the theatre number." << endl
                << "2. If you want to search through movie name." << endl
                << "Choose: ";
            cin >> ans;
            if(ans=='1'){
                cout << "Please give the theatre number: ";
                cin >> num;
                if(num>0&&num<=16){//check to see if it is a valid number within the range
                    cout << "Please select row and column: ";
                    cin >> row >> col;
                    if(row>0&&row<=18&&col>0&&col<=12){//check to see if it is a valid seat
                        if(regal[num-1].res(row, col)){//check to see if seat is available
                            cout << "Seat successfully reserved!" << endl;
                        }
                        else{
                            cout << "Seat is already reserved!" << endl;
                        }
                    }
                    else{
                        cout << "This is not a valid seat!" << endl;
                    }
                    //regal[num-1].print();
                }
                else{
                    cout << "We only have 16 theatres.  Please enter a number from 1 - 16." << endl;
                }
            }
            else if(ans=='2'){
                cout << "Please give the movie name: ";
                cin.ignore();
                getline(cin,temp);
                int count=0;
                for(int i=0;i<16;i++){//check to see if given movie name matches with any available
                    if(regal[i].getMovie()!=temp){
                        count++;
                    }
                }
                if(count==16){
                    cout << "I am sorry but this movie does not exist." << endl;
                }
                else{
                    cout << "Please select row and column: ";
                    cin >> row >> col;
                    if(row>0&&row<=18&&col>0&&col<=12){//check to see if it is a valid seat
                        if(regal[num-1].res(row, col)){
                            cout << "Seat successfully reserved!" << endl;
                        }
                        else{
                            cout << "Seat is already reserved!" << endl;
                        }
                    }
                    else{
                        cout << "This is not a valid seat!" << endl;
                    }
                }
            }
        }
        else if(choice=='3'){//cancel seat option
            cout << "Please choose from the following options:" << endl
                << "1. If you know the theatre number." << endl
                << "2. If you want to search through movie name." << endl
                << "Choose: ";
            cin >> ans;
            if(ans=='1'){
                cout << "Please give the theatre number: ";
                cin >> num;
                if(num>0&&num<=16){//check to see if it is a valid number within the range
                    cout << "Please select row and column: ";
                    cin >> row >> col;
                    if(row>0&&row<=18&&col>0&&col<=12){//check to see if it is a valid seat
                        if(regal[num-1].canc(row, col)){//check to see if seat is available
                            cout << "Reservation successfully cancelled!" << endl;
                        }
                        else{
                            cout << "This seat was not reserved and cannot be cancelled." << endl;
                        }
                    }
                    else{
                        cout << "This is not a valid seat!" << endl;
                    }
                }
                else{
                    cout << "We only have 16 theatres.  Please enter a number from 1 - 16." << endl;
                }
            }
            else if(ans=='2'){
                cout << "Please give the movie name: ";
                cin.ignore();
                getline(cin,temp);

                int count=0;
                for(int i=0;i<16;i++){//check to see if given movie name matches with any available
                    if(regal[i].getMovie()!=temp){
                        count++;
                    }
                }
                if(count==16){
                    cout << "I am sorry but this movie does not exist." << endl;
                }
                else{
                    cout << "Please select row and column: ";
                    cin >> row >> col;
                    if(row>0&&row<=18&&col>0&&col<=12){//check to see if it is a valid seat
                        if(regal[num-1].canc(row, col)){
                            cout << "Reservation successfully cancelled!" << endl;
                        }
                        else{
                            cout << "This seat was not reserved and cannot be cancelled." << endl;
                        }
                    }
                    else{
                        cout << "This is not a valid seat!" << endl;
                    }
                }
            }
        }
        else if(choice=='4'){//give info about one theatre
            cout << "Please give theatre number: ";
            cin >> num;
            if(num>0&&num<=16){//check to see if it is a valid number within the range
                cout << "Theater " << num << endl
                    << "Movie Name: " << regal[num-1].getMovie() << endl
                    << "Total tickets: " << regal[num-1].numPpl() << endl
                    << "Earning: " << regal[num-1].earn() << endl;
            }
            else{
                cout << "We only have 16 theatres.  Please enter a number from 1 - 16." << endl;
            }
        }
        else if(choice=='5'){//calculate total earnings
            total=0;
            for(int i=0;i<16;i++){
                total+=regal[i].earn();
            }
            cout << "Total Earnings: " << total << endl;
        }
        else if(choice!='0'){
            cout << "Wrong choice. Please choose again." << endl;
        }
    }while(choice!='0');

    cout << "Now quitting.." << endl;

    system("PAUSE");
    return 0;
}
