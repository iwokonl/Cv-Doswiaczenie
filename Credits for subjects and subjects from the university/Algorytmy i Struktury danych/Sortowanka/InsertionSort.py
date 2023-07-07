from typing import List, Any


class Insertion:
    lista: List[Any]

    def __init__(self, lista: List[Any]):
        self.lista = lista
        print("InsertionSort")
        self.Insertion()
        print(self.lista)


    def Insertion(self):
        for k in range(1, len(self.lista)):
            key = self.lista[k]
            while self.lista[k - 1] > key and k > 0:
                self.lista[k], self.lista[k - 1] = self.lista[k - 1], self.lista[k]
                k = k - 1




