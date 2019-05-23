#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

//Class definition
class BluRay
{
private:
    int ID;
    string title;
    string recordingArtist;
    double wholesalePrice;
    string genre;

public:
    //Default Constructor
    BluRay();

    //Argument Constructor
    BluRay(int tid, string tit, string rec, double price, string g);

    //Copy Constructor
    BluRay(BluRay &obj);

    //Getter methods
    int getID();
    string getTitle();
    string getRecordingArtist();
    double getWholesalePrice();
    string getGenre();

    //Setter methods
    void setID(int tid);
    void setTitle(string tit);
    void setRecordingArtist(string art);
    void setWholeSalePrice(double p);
    void setGenre(string g);

    //Overloading == operator
    bool operator==(BluRay &obj);

    //Overloading increment operator
    BluRay operator++();

    friend ostream& operator <<(ostream &out, const BluRay &c);
};

BluRay::BluRay()
{
    ID = 0;
    title = "Value is needed";
    recordingArtist = "Value is needed";
    wholesalePrice = 0.0;
    genre = "Value is needed";
}

BluRay::BluRay(int tid, string tit, string rec, double price, string g)
{
    ID = tid;
    title = tit;
    recordingArtist = rec;
    wholesalePrice = price;
    genre = g;
}

BluRay::BluRay(BluRay &obj)
{
ID = obj.ID;
title = obj.title;
recordingArtist = obj.recordingArtist;
wholesalePrice = obj.wholesalePrice;
genre = obj.genre;
}

void BluRay::setID(int tid) { ID = (tid<0)?0:tid; }
void BluRay::setTitle(string tit) { title = tit; }
void BluRay::setRecordingArtist(string art) { recordingArtist = art; }
void BluRay::setWholeSalePrice(double p) { wholesalePrice = (p<0)?0:p; }
void BluRay::setGenre(string g) { genre = g; }

int BluRay:: getID() { return ID; }
string BluRay:: getTitle() { return title; }
string BluRay::getRecordingArtist() { return recordingArtist; }
double BluRay::getWholesalePrice() { return wholesalePrice; }
string BluRay::getGenre() { return genre; }

bool BluRay::operator==(BluRay &obj)
{
    if(ID == obj.ID) { return true; }

    return false;
}

BluRay BluRay:: operator++()
{
    BluRay temp;

    wholesalePrice += 1;

    temp.ID = ID;
    temp.title = title;
    temp.recordingArtist = recordingArtist;
    temp.wholesalePrice = wholesalePrice;
    temp.genre = genre;

    return temp;
}
ostream& operator <<(ostream &out, const BluRay &c)
{
    out << fixed << setprecision(2);

    out << endl << right << setw(15) << " ID Number: " << c.ID;
    out << endl << right << setw(15) << " Title: " << c.title;
    out << endl << right << setw(15) << " Artist: " << c.recordingArtist;
    out << endl << right << setw(15) << " Wholesale: " << "$" << c.wholesalePrice;
    out << endl << right << setw(15) << " Genre: " << c.genre << endl;

    return out;
}
int main() {
    BluRay a;
    BluRay c(58964, "Achy Breaky Heart", "Billy Ray Cyrus", 4.99, "Country");
    a.setID(12893);
    a.setTitle("Happy");
    a.setRecordingArtist("Pharell Williams");
    a.setWholeSalePrice(1.48);
    a.setGenre("Pop");
    BluRay b=a;
    cout << "\n\n Here is the detailed report...";
    cout << "\n\n ID Number: " << b.getID();
    cout << "\n Title: " << b.getTitle();
    cout << "\n Artist: " << b.getRecordingArtist();
    cout << "\n Wholesale: $" << b.getWholesalePrice();
    cout << "\n Genre: " << b.getGenre();
    cout << "\n Compare: " << (b==a ? "true" : "false");
    cout << "\n\n" << c << endl;
    cout << " Compare: " << (c==b ? "true" : "false");
    cout << "\n\n" << ++a << endl;
    cout << "\n\nEnd of Program...";
    return 0;
}
