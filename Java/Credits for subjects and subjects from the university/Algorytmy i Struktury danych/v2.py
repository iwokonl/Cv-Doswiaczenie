class Mac_2d_k():
    dane: list[list[float]]
    wys: int
    szer: int

    # ✅
    # Inicjalizer klasy
    def __init__(self) -> None:
        self.dane = []
        Mac_2d_k.aktualizacja(self)

    # ✅
    # Aktualizuje dane do danego obiektu
    def aktualizacja(self) -> None:
        if self.dane == []:
            Mac_2d_k.wys = 0
            Mac_2d_k.szer = 0
        else:
            Mac_2d_k.szer = len(self.dane)
            Mac_2d_k.wys = len(self.dane[0])
        Mac_2d_k.dane = self.dane

    # ✅
    # Mnożonko
    def __mul__(self, other:'Mac_2dk') -> 'Mac_2d_k':

        # Zmienne pomocnicze
        Mac_2d_k.aktualizacja(self)
        szer = Mac_2d_k.szer
        wys = Mac_2d_k.wys
        other.aktualizacja()
        szer2 = other.szer
        wys2 = other.wys
        matrix = Mac_2d_k()
        pomoc = [[float(0) for x in range(wys)] for y in range(szer2)]


        if szer == wys2:
            # Mnożonko do pomocniczej macierzy
            for i in range(szer2):
                for j in range(wys):
                    for k in range(szer):
                        pomoc[i][j] += float(self.dane[k][j]) * float(other.pobierz(j,i))
            # Przepisywanie do nowego obiektu 'Mac_2d_k'
            for j in range(szer2):
                for i in range(wys):
                    matrix.ustal(i,j,pomoc[j][i])
            return matrix
        else:
            matrix.aktualizacja()
            print("Zła macierz")
            return matrix

    # ✅
    # Tak jak nazwa mówi
    def ustal(self, nr_wiersza: int, nr_kolumny: int, wartosc: float) -> None:
        dane = self.dane
        stara_szerokosc = Mac_2d_k.wys
        Mac_2d_k.aktualizacja(self)

        # Ewentualne dopełnianie macierzy
        for x in range(nr_kolumny - Mac_2d_k.szer + 1):
            dane.append([float(0) for x in range(nr_wiersza + 1)])
        for x in range(Mac_2d_k.szer):
            for y in range(nr_wiersza-Mac_2d_k.wys+1):
                dane[x].append(float(0))

        #   Bezpiecznik na wypadek a.ustal(0,1), a.ustal(11,0) itd.
        for x in range(len(dane)):
            if len(dane[0]) != len(dane[x]):
                for y in range(Mac_2d_k.wys - stara_szerokosc):
                    dane[x].append(float(0))

        #    Wpisywanie danych
        dane[nr_kolumny][nr_wiersza] = float(wartosc)
        self.dane = dane
        Mac_2d_k.aktualizacja(self)

    # ✅
    # Tak jak nazwa mówi
    def pobierz(self, nr_wiersza: int,nr_kolumny: int) -> float:
        return float(self.dane[nr_kolumny][nr_wiersza])

    # ✅
    # Tak jak nazwa mówi
    def print(self) -> str:
        Mac_2d_k.aktualizacja(self)
        if self.dane == []:
            print("Macierz jest pusta []")
            return
        for x in range(Mac_2d_k.wys):
            for y in range(Mac_2d_k.szer):
                print(str(self.dane[y][x]) + " ", end="")
            print()
        print("\n")

    # ✅
    # Tak jak nazwa mówi
    def transponuj(self) -> 'Mac_2d_k':
        Mac_2d_k.aktualizacja(self)
        szer = Mac_2d_k.szer
        wys = Mac_2d_k.wys
        matrix = Mac_2d_k()
        matrix.ustal(szer-1,wys-1,0)
        for x in range(wys):
            for y in range(szer):
                matrix.ustal(y, x, self.dane[y][x])
        return matrix

    # ✅
    # Uproszczanie macierzy
    def uprosc(self) -> None:
        flaga = 0

        Mac_2d_k.aktualizacja(self)
        for y in reversed(range(Mac_2d_k.wys)):
            for x in reversed(range(Mac_2d_k.szer)):
                if self.dane[x][y] == 0:
                    flaga = flaga + 1
                if flaga == Mac_2d_k.szer:
                    del self.dane[x][y]
            if flaga < Mac_2d_k.szer:
                break
            flaga = 0
        flaga = 0

        Mac_2d_k.aktualizacja(self)
        matrix = [[float(0) for x in range(Mac_2d_k.szer)] for y in range(Mac_2d_k.wys)]
        for x in range(Mac_2d_k.wys):
            for y in range(Mac_2d_k.szer):
                matrix[x][y] = self.dane[y][x]
        self.dane = matrix
        for x in reversed(range(Mac_2d_k.szer)):
            for y in reversed(range(Mac_2d_k.wys)):
                if self.dane[y][x] == 0:
                    flaga = flaga + 1
                if flaga == Mac_2d_k.wys:
                    del self.dane[y][x]
            if flaga < Mac_2d_k.wys:
                break
            flaga = 0
        Mac_2d_k.aktualizacja(self)
        Mac_2d_k.aktualizacja(self)
        matrix = [[float(0) for x in range(Mac_2d_k.szer)] for y in range(Mac_2d_k.wys)]
        for x in range(Mac_2d_k.wys):
            for y in range(Mac_2d_k.szer):
                matrix[x][y] = self.dane[y][x]
        self.dane = matrix
        Mac_2d_k.aktualizacja(self)
a = Mac_2d_k()
a.ustal(0,0,1)
a.ustal(0,1,2)
a.ustal(0,2,3)
a.ustal(1,0,4)
a.ustal(1,1,5)
a.ustal(1,2,6)
a.print()
b = Mac_2d_k()
b.ustal(0,0,7)
b.ustal(1,0,8)
b.ustal(2,0,9)
print()
c = a * b
c.print()




