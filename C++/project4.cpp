//project4.cpp
//===========================================================
//Program Information:
//
//COP 2271 Project 4: Graphs and File Processing
//Due: 10/8/2011
//Name: Yicong Yong
//
//-----------------------------------------------------------
//
//Program Description:
//
//This program does perform the following tasks:
//1. Accepts user file
//2. Reading the graph from file
//3. Calculating number of arcs from node i
//4. Calculating number of arcs to node i
//5. Find subnetwork of nodes and edges from original network
//
//===========================================================

#include <iostream>
#include <cmath>
#include <cstdlib>
#include <fstream>

using namespace std;

int main(void){

    char choice;
    bool flag1=false, flag2=false;//flags to make sure option 1 and 2 are completed
    char filename[100];//input file name
    ifstream inp;//input file declaration
    ofstream out("subgraph.txt");
    bool done=false;
    int counter;//count number of times a wrong input file has been inputed

    int edge;
    int *tail=NULL, *head=NULL;
    int node;
    char *nodes=NULL;
    int i,j,k;
    int *pos=NULL;



    do{
        cout << endl << "COP2271 Data Manager" << endl << endl << "MAIN MENU" << endl;//main menu
        cout << "1. To input graph data-file." << endl
        << "2. To read graph from data file." << endl
        << "3. To compute the number of outgoing arcs from a certain node." << endl
        << "4. To compute the number of incoming arcs to a certain node." << endl
        << "5. To create a file with a subgraph." << endl;
        cout << "Please choose: ";
        cin >> choice;

        //quitting option
        if(choice=='0'){
            cout << "Now quitting.." << endl;
        }

        //input user file option
        else if(choice=='1'){
            counter=0;
            if(cin.get()=='\n'){//exclude the previous enter key as a file name input
                do{
                    cout << "Please give the file name: ";
                    cin.getline(filename, sizeof(filename));//get file name
                    inp.open(filename);
                    if(inp.fail()){
                        cout << "Error opening file. Please try again.\n";
                        counter++;//count up to three times
                    }
                    else{
                        done=true;
                        flag1=true;//option 1 has been done
                    }
                }while(!done&&counter<3);
            }
        }

        //read user file option
        else if(choice=='2'){
            if(flag1){
                done=false;
                inp >> edge;
                tail = new int[edge];//dynamic arrays to store data input
                head = new int[edge];
                i=0;
                while(!done){//while not at the end of the file//begin reading file
                    if(inp.eof()){
                        done=true;
                        flag2=true;//option 2 has been done
                    }
                    else{
                        inp >> tail[i] >> head[i];
                        i++;
                    }
                }
                cout << "Graph successfully inputted! The graph has " << edge << " arcs." << endl;
            }
            else{
                cout << "No file has been given yet!" << endl;
            }
        }

        //Calculating number of arcs from node i option
        else if(choice=='3'){
            if(flag1){
                if(flag2){
                    cout << "Please give the node you are looking for: ";
                    cin >> node;

                    counter=0;//count number of matching tail node
                    for(i=0;i<edge;i++){
                        if(*(tail+i)==node){
                            counter++;
                        }
                    }
                    cout << "There are " << counter << " arcs leaving node " << node << "." << endl;
                }
                else{
                    cout << "The file has not been read yet." << endl;
                }
            }
            else{
                cout << "No file has been given yet!" << endl;
            }
        }

        //Calculating number of arcs to node i option
        else if(choice=='4'){
            if(flag1){
                if(flag2){
                    cout << "Please give the node you are looking for: ";
                    cin >> node;

                    counter=0;//count number of matching head node
                    for(i=0;i<edge;i++){
                        if(*(head+i)==node){
                            counter++;
                        }
                    }
                    cout << "There are " << counter << " arcs going to node " << node << "." << endl;
                }
                else{
                    cout << "The file has not been read yet." << endl;
                }
            }
            else{
                cout << "No file has been given yet!" << endl;
            }
        }

        //Find subnetwork of nodes and edges option
        else if(choice=='5'){
            if(flag1){
                if(flag2){
                    cout << "Please give nodes you want to include in the subgraph (press -1 to stop input): ";
                    nodes = new char();//declare dynamic array to receive input values
                    counter=0;
                    do{
                        cin >> node;
                        if(node!=-1){//making sure -1 is not stored
                            nodes[counter] = node;
                            counter++;
                        }
                    }while(node!=-1);//exit loop when receives -1

                    pos = new int();//records the line number from the input file which contains the corresponding demanded nodes
                    k=0;
                    for(j=0;j<edge;j++){
                        i=0;
                        bool flag=false;
                        while(i<counter&&!flag){//while we have not recorded anything in the current postion and that we have not exceeded the number of inputs
                            if(*(nodes+i)==*(tail+j)||*(nodes+i)==*(head+j)){//check to see if ith matches
                                pos[k]=j;
                                k++;//move onto next position in array
                                flag=true;//mark that this position has been recorded
                            }
                            else{//if not, increase i
                                i++;
                            }
                        }
                    }

                    out << k << endl;//print out number of arcs
                    for(i=0;i<k;i++){//print out arcs
                        out << *(tail+*(pos+i)) << " " << *(head+*(pos+i)) << endl;
                    }
                    cout << "Subgraph written successfully in subgraph.txt" << endl;
                }
                else{
                    cout << "The file has not been read yet." << endl;
                }
            }
            else{
                cout << "No file has been given yet!" << endl;
            }
        }

        //wrong options
        else{
            cout << "Wrong choice. Please choose again!" << endl;
        }

    }while(choice!='0');


    system("PAUSE");
    return 0;
}

