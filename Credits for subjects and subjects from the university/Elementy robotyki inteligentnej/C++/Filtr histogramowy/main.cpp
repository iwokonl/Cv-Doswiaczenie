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

void move(std::vector<std::vector<double>>& p, const std::string& direction) {
    std::vector<std::vector<double>> q(p.size(), std::vector<double>(p[0].size(), 0));
    size_t length = p[0].size() - 1;
    size_t height = p.size() - 1;
    double precision = 0.9;

    for (size_t i = 0; i < p.size(); ++i) {
        for (size_t j = 0; j < p[i].size(); ++j) {
            double tmp;
            if (direction == "right") {
                if (j == 0) {
                    tmp = p[i][length] * precision + p[i][length - 1] * (1 - precision);
                } else if (j == 1) {
                    tmp = p[i][0] * precision + p[i][length] * (1 - precision);
                } else {
                    tmp = p[i][j - 1] * precision + p[i][j - 2] * (1 - precision);
                }
            } else if (direction == "left") {
                if (j == length) {
                    tmp = p[i][0] * precision + p[i][1] * (1 - precision);
                } else if (j == length - 1) {
                    tmp = p[i][length] * precision + p[i][0] * (1 - precision);
                } else {
                    tmp = p[i][j + 1] * precision + p[i][j + 2] * (1 - precision);
                }
            }
         else if (direction == "down") {
            if (i == 0) {
                tmp = p[height][j] * precision + p[height - 1][j] * (1 - precision);
            } else if (i == 1) {
                tmp = p[0][j] * precision + p[height][j] * (1 - precision);
            } else {
                tmp = p[i - 1][j] * precision + p[i - 2][j] * (1 - precision);
            }
        } else if (direction == "up") {
            if (i == height) {
                tmp = p[0][j] * precision + p[1][j] * (1 - precision);
            } else if (i == height - 1) {
                tmp = p[height][j] * precision + p[0][j] * (1 - precision);
            } else {
                tmp = p[i + 1][j] * precision + p[i + 2][j] * (1 - precision);
            }
        }

            q[i][j] = tmp;
        }
    }

    p = q; // Assign back to the original vector
}
int main() {
    // zielony 3 , czerwony 5 bialy 6 czarny 1

    std::vector<std::vector<int>> w = {{1,5,6,5,3},
                                       {5,6,3,1,6},
                                       {6,5,6,5,3}};//tutaj mapa swiata czerwony 0, zielony 1, bialy 2, czarny 3
    std::vector<std::vector<double>> p = {{1.0/15, 1.0/15, 1.0/15, 1.0/15, 1.0/15},
                                          {1.0/15, 1.0/15, 1.0/15, 1.0/15, 1.0/15},
                                          {1.0/15, 1.0/15, 1.0/15, 1.0/15, 1.0/15}};//tutaj prawdopodobienstwo poczatkowe
    //std::vector<int> z = {3,4,1,3,2};//tutaj odczyty z czujnikow
    std::vector<int> z = {6,5,6,5,3};//tutaj odczyty z czujnikow

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

        if(i == z.size() - 1) {
            break;
        }
        move(p,"down");
        std::cout << "Po ruchu: " << std::endl;
        for (int j = 0; j < p.size(); ++j) {
            for (int k = 0; k < p[j].size(); ++k) {
                std::cout << p[j][k] << " ";
            }
            std::cout << std::endl;

            std::cout << std::endl;
        }
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
    double max = 0;
    int max_x = 0, max_y = 0;
    for (int i=0; i<p.size(); i++)
    {
        for (int j=0; j<p[i].size(); j++)
        {
            if (p[i][j]>max)
            {
                max = p[i][j];
                max_x = i;
                max_y = j;

            }
        }
    }
    std::cout<<"Prawdopodobienstwo: "<<p[max_x][max_y]<<" dla wysokosci: "<<max_x<<" dla szerokoscis: "<<max_y<<std::endl;
    return 0;
}