import math


class Pizza:
    __price: float
    __toppings: dict[str, int]
    __diameter: float

    @staticmethod
    def area(other: float):
        return math.pi * (other / 2) ** 2

    def __init__(self, diameter: float, toppings: dict[str, int]) -> None:
        if diameter < 20:
            print("Bledna srednica")
            exit(-10)
        else:
            self._diameter = diameter
        temp2 = 0
        self._toppings = toppings
        for x in toppings:
            temp = toppings[x]
            temp2 += toppings[x]
            if not 1 <= temp <= 3:
                print("Bledna dodatki")
                exit(10)
        self._price = 0.05 * Pizza.area(diameter) + temp2 * 2

    @property
    def diameter(self) -> float:
        return self._diameter

    @diameter.setter
    def diameter(self, other: float) -> None:
        if other < 20:
            print("Bledna srednica")
            exit(-10)
        else:
            temp2 = 0
            self._diameter = other
            for x in self._toppings:
                temp = self._toppings[x]
                temp2 += self._toppings[x]
                if not 1 <= temp <= 3:
                    print("Bledna dodatki")
                    exit(10)
            self._price = 0.05 * Pizza.area(other) + temp2 * 2

    def add_topping(self,topping: str):
        for x in self._toppings:
            if x == topping and self._toppings[x] <= 3:
                self._toppings[x] = self._toppings[x] + 1
        temp2 = 0
        for x in self._toppings:
            temp2 += self._toppings[x]
        self._price = 0.05 * Pizza.area(self._diameter) + temp2 * 2

    def __repr__(self) -> str:
        if self._toppings == {}:
            return f'Pizza:\nsrednica: {self._diameter}\n' \
                   f'cena: {int(round(self._price, 0))}'
        else:
            temp2 = ""
            for x in self._toppings:
                temp2 += str(x) + " x " + str(self._toppings[x])
            return f'Pizza:\nsrednica: {self._diameter}\n' \
                   f'dodatki: {temp2}\n' \
                   f'cena: {int(round(self._price,0))}'

    def __add__(self, other: 'Pizza') -> 'Pizza':
        srednica = max(self._diameter, other.diameter)
        slownik = self._toppings
        for x in self._toppings:
            slownik[x] = self._toppings[x]
        for x in other._toppings:
            slownik[x] = other._toppings[x]
            if x in other._toppings:
                if self._toppings[x] + other._toppings[x] > 3:
                    slownik[x] = 3

            print(slownik)
        new_pizza = Pizza(srednica, slownik)
        return new_pizza
