from typing import List, Any

class Buble:
    lista: List[Any]

    def __init__(self, lista: List[Any]):
        self.lista = lista
        print("BubleSort")
        self.BubleSort()

    def BubleSort(self):
        for k in range(len(self.lista) - 1, 0, -1):
            print(f'Krok{5 - k}')
            print()
            for x in range(k):
                if self.lista[x] > self.lista[x + 1]:
                    temp = self.lista[x]
                    self.lista[x] = self.lista[x + 1]
                    self.lista[x + 1] = temp
                    print(self.lista)
