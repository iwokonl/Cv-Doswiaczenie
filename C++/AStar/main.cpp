#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>
#include<cmath>
#include <Windows.h>
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

    void toString() {
        for (int i = 0; i < this->wysokosc; i++) {
            if(i < 10){
                cout << hue::purple << this->wysokosc - i -1 << " ";
            }
            else{
                cout << hue::purple << this->wysokosc - i -1 << "  ";
            }
            for (int j = 0; j < this->szerokosc; j++) {
                if(this->grid[i][j]->getWartosc() == 5)
                    cout<< hue::red << "X  "  << hue::reset;
                if(this->grid[i][j]->getWartosc() == 2)
                    cout<< hue::green << "#  "  << hue::reset;
                if(this->grid[i][j]->getWartosc() == 0)
                    cout<< hue::blue << ".  "  << hue::reset;
            }
            cout << endl;
        }
        cout << hue::purple << "   ";

        for(int i = 0; i < this->szerokosc; i++){
            if(i < 10){

                cout << hue::purple << i << "  ";
            }
            else{
                cout << hue::purple << i << " ";
            }
        }
        cout << endl;
    }

    void Astar() {
        this->toString();
        vector<Spot *> path;
        vector<Spot *> openList;
        vector<Spot *> closedList;
        Spot *start = this->grid[this->grid.size() - 1][0];
        Spot *end = this->grid[0][this->grid[0].size() - 1];
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
                    this->grid[path[i]->getX()][path[i]->getY()]->setsetWartosc(2);
                }
                this->grid[0][this->grid[0].size() - 1]->setsetWartosc(2);

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
                Spot *neighbour = current;
                if (!includes(closedList, neighbour->getNeighbours()[i]) && neighbour->getNeighbours()[i]->getWartosc() != 5) {
                    double tempG = current->getG() + 1.0;
                    if (includes(openList, neighbour->getNeighbours()[i])) {
                        if (tempG < neighbour->getNeighbours()[i]->getF()) {
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
    Grid grid("..\\generator\\grid.txt");
    grid.Astar();

    return 0;
}