#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>
#include<cmath>
#include <chrono>
#include "color.hpp"

using namespace std;

class Spot {
public:
    Spot(int x, int y, int value) {
        this->wartosc = value;
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
    Grid(string NazwaPliku) {
        string nazwaPliku = NazwaPliku;
        ifstream plik(nazwaPliku);
        int liczba_kolumn = 0;
        int x = 0;
        int y = 0;
        vector<vector<Spot *>> tekstZKoordynatami;
        string linia;

        if (!plik.is_open()) {
            cerr << "Błąd otwarcia pliku." << endl;
            return;
        }

        while (getline(plik, linia)) {
            istringstream iss(linia);
            vector<Spot *> wiersz;
            int liczba;

            while (iss >> liczba) {
                wiersz.emplace_back(
                        new Spot(x, y, liczba));
                y++;
            }
            y = 0;
            tekstZKoordynatami.push_back(wiersz);
            x++;
        }
        plik.close();


        this->grid = tekstZKoordynatami;
        this->szerokosc = this->grid[0].size();
        this->wysokosc = this->grid.size();
    }

    void save(){
        const char* filename = "..\\wyniki.txt";
//        if(this->grid[0][this->szerokosc -1]->getWartosc() == 0){
//            std::cout << hue::red << "Nie zapisuje poniewaz nie znaleziona sciezki"<< hue::reset << std::endl;
//            return;
//        }
        std::ofstream outputFile(filename);

        if (!outputFile.is_open()) {
            std::cerr << "Nie można otworzyć pliku " << filename << std::endl;
            return; // Kończymy program z kodem błędu
        }


        for (int i = 0; i < this->wysokosc; i++) {
            for (int j = 0; j < this->szerokosc; j++) {
                outputFile << this->grid[i][j]->getWartosc() << " ";
            }
            outputFile << '\n';
        }

        outputFile.close();

        std::cout <<hue::green << "Plik " << filename << " zostal stworzony i dane zostaly zapisane do niego."  << std::endl<<  hue::reset;

    }

    void toString() {
        cout << "  ";
        for(int i = 0; i < this->szerokosc; i++){
            if(i < 10){

                cout << hue::purple << i << "  ";
            }
            else{
                cout << hue::purple << i << " ";
            }
        }
        cout << hue::purple << "   ";


        cout << endl;
        for (int i = 0; i < this->wysokosc; i++) {
            if(this->wysokosc - i - 1 < 10){
                cout << hue::purple << i<< "  ";
            }
            else{
                cout << hue::purple << i << " ";
            }
            for (int j = 0; j < this->szerokosc; j++) {
                if(this->grid[i][j]->getWartosc() == 5)
                    cout<< hue::red << "X  "  << hue::reset;
                if(this->grid[i][j]->getWartosc() == 3)
                    cout<< hue::green << "#  "  << hue::reset;
                if(this->grid[i][j]->getWartosc() == 0)
                    cout<< hue::blue << ".  "  << hue::reset;
            }
            cout << endl;
        }

    }

    void Astar() {
        this->toString();
        vector<Spot *> path;
        vector<Spot *> openList;
        vector<Spot *> closedList;
        Spot *start = this->grid[19][0];
        Spot *end = this->grid[0][19];
        openList.push_back(start);
        while (!openList.empty()) {
            Spot *current = openList[0];

            for (int i = 0; i < openList.size(); i++) {
                if (openList[i]->getF() < current->getF()) {
                    current = openList[i];
                }
            }
            if (current->getX() == end->getX() && current->getY() == end->getY()) {
                Spot *temp = current;
                while (temp->getPrevioues() != NULL) {
                    path.push_back(temp->getPrevioues());
                    temp = temp->getPrevioues();
                }

                for (int i = 0; i < path.size(); i++) {
                    this->grid[path[i]->getX()][path[i]->getY()]->setsetWartosc(3);
                }
                start->setsetWartosc(3);
                end->setsetWartosc(3);
                std::cout << hue::green << "Znaleziono sciezke"<< hue::reset << std::endl;
                std::cout << hue::green <<  "Koszt sciezki to: "<< path.size()<< hue::reset << std::endl;
                this->toString();
                return;
            }
            for(int i = 0;i<openList.size();i++) {
                if (openList[i]->getX() == current->getX() && openList[i]->getY() == current->getY()) {
                    openList.erase(openList.begin() + i);
                }
            }
            closedList.push_back(current);
            if (current->getY() < this->grid[0].size() - 1) {
                current->setNeighbours(this->grid[current->getX()][current->getY() + 1]);
            }
            if (current->getY() > 0) {
                current->setNeighbours(this->grid[current->getX()][current->getY() - 1]);
            }


            if (current->getX() > 0) {
                current->setNeighbours(this->grid[current->getX() - 1][current->getY()]);
            }
            if (current->getX() < this->grid.size() - 1) {
                current->setNeighbours(this->grid[current->getX() + 1][current->getY()]);
            }

            for(int i = 0; i < current->getNeighbours().size(); i++){
                Spot *neighbour = current;
                if (!includes(closedList, neighbour->getNeighbours()[i]) && neighbour->getNeighbours()[i]->getWartosc() != 5 && current->getWartosc() != 5) {
                    double tempG = current->getG() + 1.0;
                    bool newPath = false;
                    if (includes(openList, neighbour->getNeighbours()[i])) {
                        if (tempG < neighbour->getNeighbours()[i]->getG()) {
                            neighbour->getNeighbours()[i]->setG(tempG);
                            newPath = true;
                        }
                    } else {
                        neighbour->getNeighbours()[i]->setG(tempG);
                        openList.push_back(neighbour->getNeighbours()[i]);
                        newPath = true;
                    }
                    if(newPath){
                        neighbour->getNeighbours()[i]->setH(heuristic(neighbour->getNeighbours()[i], end));
                        neighbour->getNeighbours()[i]->setF(neighbour->getNeighbours()[i]->getG() + neighbour->getNeighbours()[i]->getH());
                        neighbour->getNeighbours()[i]->setPrevioues(current);
                    }
                }
            }
        }
        cout<< hue::red << "Nie znaleziono sciezki "  << hue::reset;
        cout << endl;
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
    vector<vector<Spot*>> grid;
    int wysokosc;
    int szerokosc;
};


int main() {

    auto start = std::chrono::high_resolution_clock::now();
    Grid grid("..\\generator\\grid.txt");
    grid.Astar();
    grid.save();
    auto stop = std::chrono::high_resolution_clock::now();
    auto duration = std::chrono::duration_cast<std::chrono::microseconds>(stop - start);
    std::cout << std::endl;
    std::cout<< "Czas wykonania: "<< hue::light_green << duration.count()/1000000.0 << " sekundy" << hue::reset << std::endl;
    cout<< hue::light_aqua << "Iwo Stanislawski"  << hue::reset;
    return 0;
}
