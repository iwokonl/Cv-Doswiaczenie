konkat([],L,L).
konkat([H1|T1],L2,[H1|T3]):-
    konkat(T1,L2,T3).

