#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>
#include<cmath>
using namespace std;

class Spot {
public:
    Spot(int x, int y, int wartosc) {
        this->wartosc = wartosc;
        this->x = x;
        this->y = y;
        this->f = 0.0;
        this->g = 0.0;
        this->h = 0.0;
        this->previoues = nullptr;
        this->neighbours = {};

    }

    int getX() {
        return this->x;
    }
    int getY() {
        return this->y;
    }
    double getH() {
        return this->h;
    }
    double getF() {
        return this->f;
    }
    double getG() {
        return this->g;
    }
    Spot* getPrevioues() {
        return this->previoues;
    }
    vector<Spot*> &getNeighbours() {
        return this->neighbours;
    }
    void setNeighbours(Spot *x) {
        return this->neighbours.push_back(x);
    }

    void setPrevioues(Spot *spot) {
        this->previoues = spot;
    }

    void setX(int x) {
        this->x = x;
    }
    void setY(int y) {
        this->y = y;
    }
    void setH(double h) {
        this->h = h;
    }
    void setF(double f) {
        this->f = f;
    }
    void setG(double g) {
        this->g = g;
    }
    void setsetWartosc(int wartosc) {
        this->wartosc = wartosc;
    }
    int getWartosc() {
        return this->wartosc;
    }

    vector<Spot*> getNeighbours(vector<vector<Spot>> grid) {
        return this->neighbours;
    }
private:
    vector<Spot*> neighbours;
    Spot* previoues;
    int wartosc;
    double f;
    double g;
    double h;
    int x;
    int y;
};

class Grid {
public:
    // Konstruktor
    Grid(string NazwaPliku) {
        // Nazwa pliku do odczytu
        string nazwaPliku = NazwaPliku;

        // Tworzenie obiektu strumienia pliku
        ifstream plik(nazwaPliku);

        if (!plik.is_open()) {
            cerr << "Błąd otwarcia pliku." << endl;
            return;
        }

        // Deklaracja wektora wektorów do przechowywania obiektów klasy Spot*
        vector<vector<Spot *>> tekstZKoordynatami;
        int liczba_kolumn = 0;
        int x = 0;
        int y = 0;
        string linia;
        while (getline(plik, linia)) {
            istringstream iss(linia);
            vector<Spot *> wiersz;
            int liczba;

            while (iss >> liczba) {
                wiersz.emplace_back(
                        new Spot(x, y, liczba));  // Tworzenie obiektu klasy Spot i dodanie wskaźnika do wektora
                y++;
            }
            y = 0;
            tekstZKoordynatami.push_back(wiersz);
            x++;
        }

        // Zamknięcie pliku po zakończeniu operacji na nim
        plik.close();
        this->grid = tekstZKoordynatami;
        this->szerokosc = this->grid[0].size();
        this->wysokosc = this->grid.size();
    }

    // Metoda publiczna
    int getSzerokosc() {
        return this->szerokosc;
    }
    int getWysokosc() {
        return this->wysokosc;
    }

    int getWartosc(int x, int y) {
        return this->grid[y][x]->getWartosc();
    }

    vector<vector<Spot*>> &getGrid() {
        return this->grid;
    }

    void toString() {
        for (int i = 0; i < this->wysokosc; i++) {
            for (int j = 0; j < this->szerokosc; j++) {
                std::cout << this->grid[i][j]->getWartosc() << " ";

            }
            cout << endl;
        }
    }
    void kordtoString() {
        for (int i = 0; i < this->wysokosc; i++) {
            for (int j = 0; j < this->szerokosc; j++) {
                cout << this->grid[i][j]->getX() << " " << this->grid[i][j]->getY() << " ";
            }
            cout << endl;
        }
    }
    void Astar() {
        vector<Spot *> path;
        vector<Spot *> openList;
        vector<Spot *> closedList;
        Spot *start = this->grid[this->grid.size() - 1][0];
        Spot *end = this->grid[0][this->grid[0].size() - 1];
        openList.push_back(start);
        while (!openList.empty()) {
            //przyjrzeć się dodawaniu na listę w tym może być problem
            Spot *current = openList[0];
            for (int i = 0; i < openList.size(); i++) {
                if (openList[i]->getF() < current->getF()) {
                    current = openList[i];
                }
            }
            openList.erase(openList.begin());
            closedList.push_back(current);
            if (current->getX() == end->getX() && current->getY() == end->getY()) {
                Spot *temp = current;
                while (temp->getPrevioues() != NULL) {
                    path.push_back(temp->getPrevioues());
                    temp = temp->getPrevioues();
                }

                for (int i = 0; i < path.size(); i++) {
                    cout << path[i]->getX() << "  " << path[i]->getY() << endl;
                    this->grid[path[i]->getX()][path[i]->getY()]->setsetWartosc(2);
                }
                this->grid[0][this->grid[0].size() - 1]->setsetWartosc(2);

                cout << "Znaleziono sciezke" << endl;
                cout << "Koszt ścieszki to: "<< path.size() << endl;
                return;
            }

            if (current->getX() > 0) {
                current->setNeighbours(this->grid[current->getX() - 1][current->getY()]);
            }
            if (current->getX() < this->grid.size() - 1) {
                current->setNeighbours(this->grid[current->getX() + 1][current->getY()]);
            }
            if (current->getY() > 0) {
                current->setNeighbours(this->grid[current->getX()][current->getY() - 1]);
            }

            if (current->getY() < this->grid[0].size() - 1) {
                current->setNeighbours(this->grid[current->getX()][current->getY() + 1]);
            }
            for(int i = 0; i < current->getNeighbours().size(); i++){
                Spot *neighbour = current;  // Use a reference here
                if (!includes(closedList, neighbour->getNeighbours()[i]) && neighbour->getNeighbours()[i]->getWartosc() != 5) {
                    double tempG = current->getG() + 1.0;
                    if (includes(openList, neighbour->getNeighbours()[i])) {
                        if (tempG < neighbour->getNeighbours()[i]->getG()) {
                            neighbour->getNeighbours()[i]->setG(tempG);
                        }
                    } else {
                        neighbour->getNeighbours()[i]->setG(tempG);
                        openList.push_back(neighbour->getNeighbours()[i]);
                    }
                    neighbour->getNeighbours()[i]->setH(heuristic(neighbour, end));
                    neighbour->getNeighbours()[i]->setF(neighbour->getG() + neighbour->getH());
                    neighbour->getNeighbours()[i]->setPrevioues(current);
                }
            }
        }
    }

    double heuristic(Spot *pSpot, Spot *pSpot1) {
        return sqrt(pow(pSpot->getX() - pSpot1->getX(),2) + pow(pSpot->getY() - pSpot1->getY(),2));
    }

    bool includes(vector<Spot*> list, Spot *spot) {
        for (int i = 0; i < list.size(); i++) {
            if (list[i]->getX() == spot->getX() && list[i]->getY() == spot->getY()) {
                return true;
            }
        }
        return false;
    }
private:
    // Pola prywatne
    vector<vector<Spot*>> grid;
    int wysokosc;
    int szerokosc;
};


int main() {
    Grid grid("C:\\Users\\iwoko\\OneDrive\\Pulpit\\A\\grid.txt");
    grid.toString();
    grid.Astar();
    //Path path(&grid);
    cout << endl;
    grid.toString();


    return 0;
}