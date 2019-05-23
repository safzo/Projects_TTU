//Project.cpp

#include <iostream>
#include <fstream>
#include <sstream>
#include <tclDecls.h>

using namespace std;

//variable declarations
struct Node {
    string name; //name of the software
    Node *left, *right;
    int rec_pos; // position of the software in the file
} *root;

//initializing those variables
struct Node * newNode (string name, int position){
    struct Node *newNode = new Node(); //create a new node nN
    newNode -> name = name;
    newNode -> rec_pos = position;
    newNode -> left = NULL;
    newNode -> right = NULL;
    return newNode;
}

int pos = 0; // declaration of a global variable pos

void inorderTraversal (Node* node){ //function for traversing a BST in order
    if (node == NULL){
        return;
    }
    inorderTraversal(node -> left);
    cout << name;
    inorderTraversal(node -> right);
}

bool NodeChecker( Node *node, string name) { //function to check whether a node exists or not
    if (node == NULL) {
        return false;
    }
    else if (name == node->name) {
        pos = node->rec_pos;
        return true;
    }
    else if (name < node->name) {
        return NodeChecker(node->left, name);
    }
    else {
        return NodeChecker(node->right, name);
    }
}

void insert (Node *&root, string name, int pos){ //complimentary function for use in the BST to insert a node
    if (root == NULL){
        root = newNode(name, pos);
        return;
    }
    else if (name < root-> name){
        insert(root -> left, name, pos);
    }
    else{
        insert(root -> right, name, pos);
    }
}

void BST() { //function for building the BST
    string name;
    ifstream software;
    string soft1, soft2, soft3, soft4, soft5, soft6;

    int i = 0;
    string line;
    software.open("software.txt");

    while (getline(software, line)) {
        istringstream iss(line);
        soft5 = "\0";
        soft6 = "\0";
        iss >> soft1 >> soft2 >> soft3 >> soft4 >> soft5 >> soft6;

        if (soft6.empty()) {
            if (soft5.empty()) {
                name = soft1 + " " + soft2;
            }
            else {
                name = soft1 + " " + soft2 + " " + soft3;
            }
        }
        else {
            name = soft1 + " " + soft2 + " " + soft3 + " " + soft4;
        }
        insert(root, name, i);
        i++;
    }
    software.close();
}


void NewSoftware() { //function for inseerting a new software in the file
    string soft, quantity, name;
    bool found;
    string soft1, soft2, soft3, soft4, soft5, soft6;

    cout << "Enter the name of the software: " << endl;
    cin.ignore();
    getline(cin, soft);
    istringstream iss(soft);

    iss >> soft1 >> soft2 >> soft3 >> soft4 >> soft5 >> soft6;

    if (soft6.empty()) {
        if (soft5.empty()) {
            name = soft1 + " " + soft2;
        }
        else {
            name = soft1 + " " + soft2 + " " + soft3;
        }
    }
    else {
        name = soft1 + " " + soft2 + " " + soft3 + " " + soft4;
    }

    //check to see if node exists
    found = NodeChecker(root, name);
    ifstream software;
    string line;

    if (found) {
        if (soft6.empty()) {
            if (soft5.empty()) {
                quantity = soft3;
            }
            else {
                quantity = soft4;
            }
        }
        else {
            quantity = soft5;
        }
        string Software[100];
        string str;
        int j = 0;

        software.open("software.txt");
        for (int lineNum = 0; lineNum < 6; lineNum++) {
            if (lineNum == pos) {
                istringstream iss(line);
                iss >> soft1 >> soft2 >> soft3 >> soft4 >> soft5 >> soft6;
                if (soft6.empty()) {
                    if (soft5.empty()) {
                        soft3 = quantity;
                    } else {
                        soft4 = quantity;
                    }
                } else {
                    soft5 = quantity;
                }
                line = soft1 + " " + soft2 + " " + soft3 + " " + soft4 + " " + soft5 + " " + soft6;
            }
            //assign line to array, where the array contains all lines in the file with the updated quantity
            Software[j] = line;
            j++;
        }
        ofstream output;
        output.open("software.txt", ios::out);

        for (int i = 0; i < 6; i++) {
            if (i == j - 1) {
                ofstream out("software.txt"); // write the line into the file
            }
            else {
                ofstream out("software.txt");// write the line into the file
            }
        }
    }
    else {
        ofstream out;
        out.open("software.txt", ios::app);
        out << line;//append the software at the end of the file
        out.close();
        root = NULL;
    }

    BST();
    cout << "The inorder traversal of the tree after insertion of a new software is: " << endl;
    inorderTraversal(root);
}

struct Node * valLeft(struct Node*) { //function for finding the left most child node in the BST
    struct Node *n = new Node;
    while (n->left != NULL) {
        n = n->left;
    }
    return n;
}

struct Node* deleteNode(struct Node* node, string name){ //function for deleting the node
    if(node == NULL){
        return root;
    }

    if(name < node -> name){
        node -> left = deleteNode(node -> left, name);
    }
    else if(name > node -> name){
        node -> right = deleteNode (node -> right, name);
    }
    else{
        if(node-> left == NULL){
            struct Node *newNode = node-> right;
            free(node);
            return newNode;
        }
        else if (node-> right == NULL){
            struct Node* newNode = node-> left;
            free(node);
            return newNode;
        }
        struct Node *newNode = valLeft(node->right);
        node -> name = newNode -> name;
        node -> right = deleteNode(node-> right, newNode -> name);
    }
    return node;
}


void sellSoftware() { //function for selling the software
    string product;
    int copies;
    bool found;
    ifstream software;

    string line;
    string quantity;
    string soft[100];
    string soft1, soft2, soft3, soft4, soft5, soft6;
    int j = 0;

    cout << "Enter the product to be 'sold'";
    cin.ignore();
    getline(cin, product);

    cout << "Enter the quantities to be 'sold'";
    cin >> copies;

    software.open("software.txt");
    found = NodeChecker(root, product);

    if (found){
        for(int lineNum = 0; lineNum < 6; lineNum++){
            if (lineNum == pos){
                stringstream iss(line);
                iss >> soft1 >> soft2 >> soft3 >> soft4 >> soft5 >> soft6;
                if(soft6.empty()){
                    if(soft5.empty()){
                        quantity = soft3;
                    }
                    else{
                        quantity = soft4;
                    }
                }
                else{
                    quantity = soft5;
                }

                copies = stoi(quantity)-copies;
                stringstream outs;
                string remaining;
                outs << copies;
                remaining = outs.str();

                if(copies >= 0){
                    if (copies == 0){
                        root = deleteNode(root, product);
                        cout << "After the product is sold out, the inorder traversal of the BST is: " << endl;
                        inorderTraversal(root);
                        if(soft6.empty()){
                            if(soft5.empty()){
                                soft3 = "0";
                            }
                            else{
                                soft4 = "0";
                            }
                        }
                        else{
                            soft5 = "0";
                        }
                    }
                    else{
                        if(soft6.empty()){
                            if(soft5.empty()){
                                soft3 = remaining;
                            }
                            else{
                                soft4 = remaining;
                            }
                        }
                        else{
                            soft5 = remaining;
                        }
                    }
                }
                else{
                    cout << "Out of copies" << endl;
                }

                line = soft1 + " " + soft2 + " " + soft3 + " " + soft4 + " " + soft5 + " " + soft6;
            }
            soft[j] = line;
            j++;
        }
        software.close();
        ofstream out;
        out.open("software.txt", ios::out);

        //copying all lines in the array to the file
        for(int i = 0; i < 6; i++){
            if(i == j-1){
                //writing the line to the file without new line character
                out << line << endl;
            }
            else{
                //writing the line to the file with new line character
                out << line << "\n" << endl;
            }
        }
        out.close();
    }
    else{
        cout << "The product that you are trying to sell is not here" << endl;
    }
}

void removeZeroQuantity(){ //function for removing the software with has 0 quantities in the file
    ifstream software, software1;
    string line;
    int i;

    software.open("input software.txt");

    string Soft[10];
    string Soft2[10];
    string soft1, soft2, soft3, soft4, soft5, soft6;
    string quantity;

    for(i = 0; i < 6; i++){
        Soft[i] = line;
    }

    int z = i;
    i = i-1;

    software1.open("input software.txt");

    for(int k = 0; k < 6; k++) {

        //assigning each line to string stream
        istringstream iss(Soft[k]);

        //assigning each word of the line to the variable soft1 to soft6
        iss >> soft1 >> soft2 >> soft3 >> soft4 >> soft5 >> soft6;

        if (soft6.empty()) {
            if (soft5.empty()) {
                quantity = soft3;
            }
            else {
                quantity = soft4;
            }
        }
        else {
            quantity = soft5;
        }
        if(quantity == "0") {
            Soft[k]=Soft[i];
            Soft[i] = "\0";
            i--;
            z--;
        }
    }
    software.close();
    ofstream out;
    out.open("input software", ios::out);

    //write each line from the array to output file
    for(int w = 0; w < 6; w++){
        if (w == z-1){
            //write the line into the file without new line character
            out << line << endl;
        }
        else{
            //write the line into the file with new line character
            out << line << "\n" << endl;
        }
    }
    out.close();
}

int main(){ //menu-driven main function
    int character;
    char input = 'Y';

    BST();
    cout << "The inorder traversal of the initial tree is: " << endl;
    inorderTraversal(root);
    cout << endl;

    while(input == 'Y'){
        cout << endl << endl;
        cout << "(1) Insert a new software" << endl;
        cout << "(2) Sell the software" << endl;
        cout << "(3) Exit the program" << endl;

        cout << "Enter your choice: " << endl;
        cin >> character;

        switch(character){
            case 1:
                NewSoftware();
                break;
            case 2:
                sellSoftware();
                break;
            case 3:
                removeZeroQuantity();
                break;
            default:
                cout << "Invalid input, try again..." << endl;
        }
        cout << "Type Y to continue, anything else to exit the program" << endl;
        cin >> input;
    }
    return 0;
}

