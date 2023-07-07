from typing import List, Any

class Select:
    lista: List[Any]

    def __init__(self, lista: List[Any]):
        self.lista = lista
        print("SelectSort")
        self.SelectSort()

    def SelectSort(self):
        for k in range(len(self.lista)):
            temp = k
            print(f'Krok{k+1}')
            print(self.lista)
            for x in range(k, len(self.lista)):

                if self.lista[temp] > self.lista[x]:
                    temp = x
            self.lista[k], self.lista[temp] = self.lista[temp], self.lista[k]


