liczba_elem1([],0).
liczba_elem1([_|T],N):-
    liczba_elem1(T,N1),
    N is N1+1.
