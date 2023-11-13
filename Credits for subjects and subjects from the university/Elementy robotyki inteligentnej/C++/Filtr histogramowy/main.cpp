#include <iostream>
#include <vector>
int horizontal = 0;
int vertical = 0;
void sens(int z, std::vector<std::vector<double>> &p, std::vector<std::vector<int>> &w) {
    double precyzja = 0.8;
    double suma = 0;
    for (int i = 0; i < p.size(); ++i) {
        for (int y = 0; y < p[i].size(); ++y) {
            if (w[i][y] == z) {
                p[i][y] *= precyzja;
            } else {
                p[i][y] *= (1 - precyzja);
            }
            suma += p[i][y];
        }

    }
    for (int i = 0; i < p.size(); ++i) {
        for (int y = 0; y < p[i].size(); ++y) {
            p[i][y] /= suma;
        }
    }
}

void move(std::vector<std::vector<double>>& probabilities) {
    std::vector<std::vector<double>> new_probabilities;
    double precision = 0.9;

    for (size_t i = 0; i < probabilities.size(); ++i) {
        std::vector<double> row;
        for (size_t j = 0; j < probabilities[i].size(); ++j) {
            double temp_horizontal = 0.0;
            double temp_vertical = 0.0;

            // Przesunięcie w poziomie
            if (j == 0) {
                temp_horizontal = probabilities[i][probabilities[i].size() - 1] * precision + probabilities[i][probabilities[i].size() - 2] * (1 - precision);
            } else if (j == 1) {
                temp_horizontal = probabilities[i][0] * precision + probabilities[i][probabilities[i].size() - 1] * (1 - precision);
            } else {
                temp_horizontal = probabilities[i][j - 1] * precision + probabilities[i][j - 2] * (1 - precision);
            }

            // Przesunięcie w pionie
            if (i == 0) {
                temp_vertical = probabilities[probabilities.size() - 1][j] * precision + probabilities[probabilities.size() - 2][j] * (1 - precision);
            } else if (i == 1) {
                temp_vertical = probabilities[0][j] * precision + probabilities[probabilities.size() - 1][j] * (1 - precision);
            } else {
                temp_vertical = probabilities[i - 1][j] * precision + probabilities[i - 2][j] * (1 - precision);
            }

            // Wybór lepszej opcji
            row.push_back(std::max(temp_horizontal, temp_vertical));

        }
        new_probabilities.push_back(row);
    }

    for (size_t i = 0; i < probabilities.size(); ++i) {
        for (size_t j = 0; j < probabilities[i].size(); ++j) {
            probabilities[i][j] = new_probabilities[i][j];
        }
    }
}

int main() {
    // zielony 1 , czerwony 2 bialy 3 czarny 4

    std::vector<std::vector<int>> w = {{1,2,3,4,5},
                                       {6,7,8,9,10},
                                       {4,4,4,4,4}};//tutaj mapa swiata czerwony 0, zielony 1, bialy 2, czarny 3
    std::vector<std::vector<double>> p = {{1.0/15, 1.0/15, 1.0/15, 1.0/15, 1.0/15},
                                          {1.0/15, 1.0/15, 1.0/15, 1.0/15, 1.0/15},
                                          {1.0/15, 1.0/15, 1.0/15, 1.0/15, 1.0/15}};//tutaj prawdopodobienstwo poczatkowe
    std::vector<int> z = {1,2,3,4,5 };//tutaj odczyty z czujnikow

    std::cout << "Poczatkowe prawdopodobienstwo: " << std::endl;
    for (int i = 0; i < p.size(); ++i) {
        for (int j = 0; j < p[i].size(); ++j) {
            std::cout << p[i][j] << " ";
        }
        std::cout << std::endl;
    }
    std::cout << std::endl;
    int prev_max_i = 0, prev_max_j = 0;
    for (int i = 0; i < z.size(); ++i) {
        sens(z[i], p, w);
        std::cout << "Aktualizacja prawdopodobienstwa po pomiarze: " << std::endl;
        for (int j = 0; j < p.size(); ++j) {
            for (int k = 0; k < p[j].size(); ++k) {
                std::cout << p[j][k] << " ";
            }
            std::cout << std::endl;
        }
        std::cout << std::endl;


        move(p);
        std::cout << "Po ruchu: " << std::endl;
        for (int j = 0; j < p.size(); ++j) {
            for (int k = 0; k < p[j].size(); ++k) {
                std::cout << p[j][k] << " ";
            }
            std::cout << std::endl;
        }
        std::cout << std::endl;
        int max_i = 0, max_j = 0;
        double max_val = p[0][0];
        for (int j = 0; j < p.size(); ++j) {
            for (int k = 0; k < p[j].size(); ++k) {
                if (p[j][k] > max_val) {
                    max_val = p[j][k];
                    max_i = j;
                    max_j = k;
                }
            }
        }

        // Sprawdzamy, czy największe prawdopodobieństwo przesunęło się pionowo czy poziomo
        if (max_i != prev_max_i ) {
            vertical++;
        } else if (max_j != prev_max_j) {
            horizontal++;
        } else {
            std::cout << "Największe prawdopodobieństwo nie przesunęło się.\n";
        }

        // Aktualizujemy poprzednie indeksy
        prev_max_i = max_i;
        prev_max_j = max_j;
    }
    std::cout << horizontal << " " << vertical << std::endl;
    if (horizontal > vertical) {
        std::cout << "Robot przesunął się w poziomie.\n";
    } else if (vertical > horizontal) {
        std::cout << "Robot przesunął się w pionie.\n";
    } else {
        std::cout << "Robot nie przesunął się.\n";
    }
    return 0;
}
