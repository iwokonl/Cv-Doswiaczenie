/* Predykat pojemnosc/1 ma za zadanie zadeklarowac dostepne pojemnosci plecak�w*/
pojemnosc(15).
pojemnosc(25).
pojemnosc(30).
pojemnosc(50).
pojemnosc(60).

/* Predykat marki/1 pokazuje dost�pne marki */
marki(nike).
marki(puma).
marki(adidas).
marki(vans).

/* Predykat kolor/1 pokazuje dost�pne kolory */
kolor(czarny).
kolor(czerwony).
kolor(niebieski).
kolor(szary).

/* Predykat typ/1 pokazuje dost�pne typy plecak�w */
typ(casual).
typ(vintage).
typ(sportowy).

/* Predykat plecak_typ/2 ��czy predykaty marki/1 i typ/1 opisuj�c typy poszczeg�lnych marek plecak�w */
plecak_typ(nike,casual).
plecak_typ(nike,vintage).
plecak_typ(adidas,casual).
plecak_typ(adidas,vintage).
plecak_typ(puma,casual).
plecak_typ(puma,vintage).
plecak_typ(puma,sportowy).
plecak_typ(vans,casual).
plecak_typ(vans,vintage).
plecak_typ(jordan,sportowy).

/* Predykat plecak_pojemnosc/2 ��czy predykaty marki/1 i pojemnosc/1 opisuj�c poszczeg�ln� pojemno�� plecak�w r�nych marek.
Pojemnosc wyra�ana jest w litrach czyli 50 oznacza 50 litr�w */
plecak_pojemnosc(vans,50).
plecak_pojemnosc(adidas,25).
plecak_pojemnosc(adidas,15).
plecak_pojemnosc(nike,50).
plecak_pojemnosc(puma,30).
plecak_pojemnosc(puma,60).
plecak_pojemnosc(vans,60).
plecak_pojemnosc(jordan,60).

/* Predykat plecak_kolor/2 ��czy predykaty marki/1 i kolor/1 opisuj�c dost�pne kolory r�znych marek plecak�w */
plecak_kolor(nike,czarny).
plecak_kolor(nike,czerwony).
plecak_kolor(adidas,szary).
plecak_kolor(vans,czarny).
plecak_kolor(vans,niebieski).
plecak_kolor(jordan,czerwony).
plecak_kolor(jordan,czarny).
plecak_kolor(puma,szary).
plecak_kolor(puma,niebieski).

/* Predykat plecak/4 jest zbiorem relacji poszczeg�lnych predykat�w tak aby po��czy� informacje kt�re by�y wcze�niej rozseparowane
np. plecak_pojemnosc(vans,50), plecak_kolor(vans,czarny) i plecak_typ(vans, casual) tworzy pe�en predykat plecak(vans,casual,50,czarny).*/
plecak(X,Y,Z,A):-plecak_typ(X,Y),
    plecak_pojemnosc(X,Z),
    plecak_kolor(X,A).

/* Predykaty maly_plecak/1, sredni_plecak/1 i duzy_plecak/1 maj� za zadanie wy�wietlenie plecak�w kt�re mieszcz� si� w zamieszczonych kryteriach.
 plecak jako ma�y jest zaliczany od pojemno�ci 20L w d�, �redni-od 20 do 40 a du�y od 40 w g�r�. Aby wywo�a� predykat nale�y przyk�adowo wpisa� polecenie
 maly_plecak(Plecak).*/
maly_plecak(Plecak) :-
    plecak(Marka,Typ,Pojemnosc,Kolor),
    Plecak = plecak(Marka,Typ,Pojemnosc,Kolor),
    Pojemnosc =< 20.
sredni_plecak(Plecak) :-
    plecak(Marka,Typ,Pojemnosc,Kolor),
    Plecak = plecak(Marka,Typ,Pojemnosc,Kolor),
    Pojemnosc < 20,
    Pojemnosc > 40.
duzy_plecak(Plecak) :-
    plecak(Marka,Typ,Pojemnosc,Kolor),
    Plecak = plecak(Marka,Typ,Pojemnosc,Kolor),
    Pojemnosc >= 40.

/*Predykaty znajdz_po_typie/2, znajdz_po_marce/2, znajdz_po_kolorze/2 i znajdz_po_pojemnosci/2 wyszukuje plecaki po ich: typie, marce, kolorze i pojemnosci
aby u�yc poszczeg�lnych wyszukiwa� nale�y przyk�adowo wpisa�: znajdz_po_typie("tutaj podany typ", Plecak).
Podany predykat powinien wy�wietli� wszystkie plecaki w danym wypisanym typie.*/
znajdz_po_typie(Typ, Plecak) :-
    plecak(Marka,Typ,Pojemnosc,Kolor),
    Plecak = plecak(Marka,Typ,Pojemnosc,Kolor).
znajdz_po_marce(Marka, Plecak) :-
    plecak(Marka,Typ,Pojemnosc,Kolor),
    Plecak = plecak(Marka,Typ,Pojemnosc,Kolor).
znajdz_po_kolorze(Kolor, Plecak) :-
    plecak(Marka,Typ,Pojemnosc,Kolor),
    Plecak = plecak(Marka,Typ,Pojemnosc,Kolor).
znajdz_po_pojemnosci(Pojemnosc, Plecak) :-
    plecak(Marka,Typ,Pojemnosc,Kolor),
    Plecak = plecak(Marka,Typ,Pojemnosc,Kolor).

/* Predykat ilosc_plecakow_danej_marki/2 wy�wietla liczb� plecak�w marki kt�r� podamy jako u�ytkownik w predykacie. */
ilosc_plecakow_danej_marki(Marka, Liczba):-
    findall(Marka, plecak(Marka,_,_,_), ListaMarek),
    length(ListaMarek,Liczba).

/* Predykat wszystkie_plecaki/0 wy�wietla wszystkie plecaki kt�re s� dost�pne w programie */
wszystkie_plecaki():-
    plecak(Marka,Typ,Pojemnosc,Kolor),
    findall((Marka,Typ,Pojemnosc,Kolor), plecak(Marka,Typ,Pojemnosc,Kolor), Lista),
    write(Lista).

/* Predykat ilosc_wszystkich_plecakow/1 wy�wietla liczb� wszystkich plecak�w kt�re s� dost�pne */
ilosc_wszystkich_plecakow(Liczba):-
    findall(_, plecak(_,_,_,_), Lista),
    length(Lista, Liczba).

/* Predykat por�wnaj plecaki/2 sprawdza czy dane marki maj� plecaki o takich samych parametrach i wy�wietla je u�ytkownikowi .Pola Marka1 i Marka2 nie mog� by� takie same poniewa� oczywistym jest �e plecaki tej samej marki maj� takie same parametry */
porownaj_plecaki(Marka1, Marka2) :-
    plecak(Marka1, Typ, Pojemnosc, Kolor),
    plecak(Marka2, Typ, Pojemnosc, Kolor),
    Marka1 \= Marka2,
    write('Porownane plecaki:'), nl,
    write('Marka 1: '), write(Marka1), nl,
    write('Marka 2: '), write(Marka2), nl,
    write('Pojemnosc: '), write(Pojemnosc), nl,
    write('Typ: '), write(Typ), nl,
    write('Kolor: '), write(Kolor), nl.
