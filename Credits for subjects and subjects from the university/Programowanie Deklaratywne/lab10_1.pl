liczba_elem2(L,N):-liczba_elem_ak(L,0,N).
liczba_elem_ak([],A,A).
liczba_elem_ak([_|T],A,N):-
    A1 is A+1,
    liczba_elem_ak(T,A1,N).

