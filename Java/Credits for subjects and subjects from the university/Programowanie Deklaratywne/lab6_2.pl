st_wielomian(X,X,1).
st_wielomian(C,_,0):-number(C).
st_wielomian(-W,X,N):-st_wielomian(W,X,N).
st_wielomian(W1+W2,X,N):-st_wielomian(W1,X,N1),
    st_wielomian(W2,X,N2),
    N is max(N1, N2).
st_wielomian(W1-W2,X,N):-st_wielomian(W1,X,N1),
    st_wielomian(W2,X,N2),
    N is max(N1, N2).
st_wielomian(W1,W2,X,N):-st_wielomian(W1,X,N1),
    st_wielomian(W2,X,N2),
    N is N1+N2.
st_wielomian(W^M,X,N):-integer(M),
    M>1,
    st_wielomian(W,X,M1),
    N is M1*M.

