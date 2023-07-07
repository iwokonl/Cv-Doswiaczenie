element(E,[E|_]).
element(E,[_|T]):-element(E,T).
