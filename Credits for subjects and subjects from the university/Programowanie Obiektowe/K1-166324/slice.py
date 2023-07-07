from pizza import Pizza


class Slice(Pizza):
    __how_many_slices: int

    def __init__(self, diameter: float,
                 toppings: dict[str, int],
                 how_many_slices: int):
        super().__init__(diameter, toppings)
        if 4 <= how_many_slices <= 12 and how_many_slices % 2 == 0:
            self.__how_many_slices = how_many_slices
        else:
            print("bledna ilosc kawalkow")
            exit(-10)

    @property
    def how_many_slices(self):
        return self.__how_many_slices

    @how_many_slices.setter
    def how_many_slices(self, other):
        if 4 <= self.__how_many_slices <= 12\
                and self.__how_many_slices % 2 == 0:
            self.__how_many_slices = other
        else:
            print("bledna ilosc kawalkow")
            exit(-10)

    def part_price(self, value) -> int:
        temp = self._price
        return int(temp / value)

    def __repr__(self):
        return f'{Pizza.__repr__(self)}\n' \
               f'cena za kawalek: {self.part_price(self.__how_many_slices)}'
