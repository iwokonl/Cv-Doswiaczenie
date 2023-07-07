odwrotna(L1,L2):-odwrotna_ak(L1,[],L2).
odwrotna_ak([],A,A).
odwrotna_ak([H|T],A,L2):-
    odwrotna_ak(T,[H|A],L2).
