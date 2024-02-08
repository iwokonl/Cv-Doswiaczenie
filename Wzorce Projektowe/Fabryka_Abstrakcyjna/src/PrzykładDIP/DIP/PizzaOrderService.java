package PrzykładDIP.DIP;

class PizzaOrderService {
    void orderPizza(Pizza pizza) {
        pizza.preparePizza();
    }
}
// Teraz, jeśli chcemy dodać nowy rodzaj pizzy, wystarczy, że stworzymy nową klasę implementującą interfejs Pizza.
// Nie ma potrzeby modyfikowania PizzaOrderService.