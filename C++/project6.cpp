//project6.cpp
//===========================================================
//Program Information:
//
//COP 2271 Project 6: Sorted Array
//Due: 12/10/2011
//Name: Yicong Yong
//===========================================================

#include <iostream>
#include <cmath>
#include <cstdlib>
#include <sstream>
#include <string>

using namespace std;

class SortedArray{
private:
    int size;
    int *elements;

public:
    SortedArray();

    void insert(int inp);
    void remove(int inp);
    bool find(int inp);
    void print();
    void operator +(int inp);
    void operator -(int inp);
};

SortedArray::SortedArray(){
    size=0;
    elements=NULL;
}

void SortedArray::insert(int inp){
    if(elements==NULL&&inp>=0){//check if our array is empty, if yes, place the first input in the array
        size=1;                 //also check to see if input is valid
        elements=new int[size];
        elements[size-1]=inp;
    }
    else if(inp>=0){
        bool flag=true;
        int i=0,pos;
        int *temp;
        temp=new int[size];
        for(int i=0;i<size;i++){
            temp[i]=elements[i];//make copy of current array
        }
        delete [] elements;
        size++;
        elements=new int[size];
        while(flag&&i<size){
            if(inp>=temp[i]){//if input is greater than the value at current position then keep current
                elements[i]=temp[i];
            }
            else{//if input is less than the value at current position for the first time, set equal to new input
                elements[i]=inp;
                pos=i+1;//record the cut
                flag=false;//exit the loop
            }
            i++;
        }
        for(i=pos;i<size;i++){
            elements[i]=temp[i-1];//fill in the remaining
        }
    }
}

void SortedArray::remove(int inp){
    if(elements==NULL&&inp>=0){
        cout << "The array is empty and there is nothing to remove." << endl;
    }
    else if(inp>=0&&find(inp)==true){
        int *temp;
        temp=new int[size];
        for(int i=0;i<size;i++){
            temp[i]=elements[i];//make copy
        }
        delete [] elements;//delete original array
        size--;
        elements=new int[size];
        for(int i=0;i<size;i++){
            if(inp>temp[i]){//if the input greater than the one at current position, then keep current
                elements[i]=temp[i];
            }
            else if(inp<=temp[i]){//if the input is less than the one at current position, then keep current
                elements[i]=temp[i+1];
            }
        }
    }
}

bool SortedArray::find(int inp){//check to see if there is such an element in the array already
    for(int i=0;i<size;i++){
        if(elements[i]==inp){
            return true;
        }
    }
    return false;
}

void SortedArray::print(){//print out elements of current array
    for(int i=0;i<size;i++){
        cout << elements[i];
    }
    cout << endl;
}

void SortedArray::operator +(int inp){
    insert(inp);
}

void SortedArray::operator -(int inp){
    remove(inp);
}




//main program
int main(){
    SortedArray x;
    int inp;
    do{
            cin >> inp;
            x.insert(inp);
            x.print();
        }while(inp>=0);
    x+6;
        x.print();
    do{
            cin >> inp;
            x.remove(inp);
            x.print();
        }while(inp>=0);
    x-1;
    x.print();

    return 0;
}


/*debug
int main(){
    SortedArray x;
    int inp;
    //do{
        //cout << "Insert: ";
        //cin >> inp;
        //x.insert(inp);
        x+6;
        x+1;
        x.print();
    //}while(inp>=0);

    //do{
        //cout << "Remove: ";
        //cin >> inp;
        //x.remove(inp);
        x-6;
        x.print();
    //}while(inp>=0);
}
*/
