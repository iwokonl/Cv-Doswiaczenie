/* Predykat pojemnosc/1 ma za zadanie zadeklarowac dostepne pojemnosci plecaków*/
pojemnosc(15).
pojemnosc(25).
pojemnosc(30).
pojemnosc(50).
pojemnosc(60).

/* Predykat marki/1 pokazuje dostêpne marki */
marki(nike).
marki(puma).
marki(adidas).
marki(vans).

/* Predykat kolor/1 pokazuje dostêpne kolory */
kolor(czarny).
kolor(czerwony).
kolor(niebieski).
kolor(szary).

/* Predykat typ/1 pokazuje dostêpne typy plecaków */
typ(casual).
typ(vintage).
typ(sportowy).

/* Predykat plecak_typ/2 ³¹czy predykaty marki/1 i typ/1 opisuj¹c typy poszczególnych marek plecaków */
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

/* Predykat plecak_pojemnosc/2 ³¹czy predykaty marki/1 i pojemnosc/1 opisuj¹c poszczególn¹ pojemnoœæ plecaków ró¿nych marek.
Pojemnosc wyra¿ana jest w litrach czyli 50 oznacza 50 litrów */
plecak_pojemnosc(vans,50).
plecak_pojemnosc(adidas,25).
plecak_pojemnosc(adidas,15).
plecak_pojemnosc(nike,50).
plecak_pojemnosc(puma,30).
plecak_pojemnosc(puma,60).
plecak_pojemnosc(vans,60).
plecak_pojemnosc(jordan,60).

/* Predykat plecak_kolor/2 ³¹czy predykaty marki/1 i kolor/1 opisuj¹c dostêpne kolory róznych marek plecaków */
plecak_kolor(nike,czarny).
plecak_kolor(nike,czerwony).
plecak_kolor(adidas,szary).
plecak_kolor(vans,czarny).
plecak_kolor(vans,niebieski).
plecak_kolor(jordan,czerwony).
plecak_kolor(jordan,czarny).
plecak_kolor(puma,szary).
plecak_kolor(puma,niebieski).

/* Predykat plecak/4 jest zbiorem relacji poszczególnych predykatów tak aby po³¹czyæ informacje które by³y wczeœniej rozseparowane
np. plecak_pojemnosc(vans,50), plecak_kolor(vans,czarny) i plecak_typ(vans, casual) tworzy pe³en predykat plecak(vans,casual,50,czarny).*/
plecak(X,Y,Z,A):-plecak_typ(X,Y),
    plecak_pojemnosc(X,Z),
    plecak_kolor(X,A).

/* Predykaty maly_plecak/1, sredni_plecak/1 i duzy_plecak/1 maj¹ za zadanie wyœwietlenie plecaków które mieszcz¹ siê w zamieszczonych kryteriach.
 plecak jako ma³y jest zaliczany od pojemnoœci 20L w dó³, œredni-od 20 do 40 a du¿y od 40 w górê. Aby wywo³aæ predykat nale¿y przyk³adowo wpisaæ polecenie
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
aby u¿yc poszczególnych wyszukiwañ nale¿y przyk³adowo wpisaæ: znajdz_po_typie("tutaj podany typ", Plecak).
Podany predykat powinien wyœwietliæ wszystkie plecaki w danym wypisanym typie.*/
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

/* Predykat ilosc_plecakow_danej_marki/2 wyœwietla liczbê plecaków marki któr¹ podamy jako u¿ytkownik w predykacie. */
ilosc_plecakow_danej_marki(Marka, Liczba):-
    findall(Marka, plecak(Marka,_,_,_), ListaMarek),
    length(ListaMarek,Liczba).

/* Predykat wszystkie_plecaki/0 wyœwietla wszystkie plecaki które s¹ dostêpne w programie */
wszystkie_plecaki():-
    plecak(Marka,Typ,Pojemnosc,Kolor),
    findall((Marka,Typ,Pojemnosc,Kolor), plecak(Marka,Typ,Pojemnosc,Kolor), Lista),
    write(Lista).

/* Predykat ilosc_wszystkich_plecakow/1 wyœwietla liczbê wszystkich plecaków które s¹ dostêpne */
ilosc_wszystkich_plecakow(Liczba):-
    findall(_, plecak(_,_,_,_), Lista),
    length(Lista, Liczba).

/* Predykat porównaj plecaki/2 sprawdza czy dane marki maj¹ plecaki o takich samych parametrach i wyœwietla je u¿ytkownikowi .Pola Marka1 i Marka2 nie mog¹ byæ takie same poniewa¿ oczywistym jest ¿e plecaki tej samej marki maj¹ takie same parametry */
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
