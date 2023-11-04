clear;
clc;

function y = w(xb, x)
    temp =1;
    si=size(x);
    for i =1:si(1); 
        temp = temp*(xb-x(i))
    end
    y = prod(temp);
endfunction
function y=SIN(x)
    temp = []
    si = size(x);
    for i=1:si(1);
        temp = [temp,sin(x(i))];
    end
    y = temp;
endfunction
n=7;
a=-0.5;
b=2*%pi;
x=[1;2;3;4;5;6;7;8];
xb=%pi/2;
y = SIN(x);
h = abs(x(1) - x(2));
disp(h)
boole = 1;
pusta_tablica(n+1,n+1)=0

for i=1:n;
    if(h == abs(x(i)-x(i+1)));
    else
        boole = 0;
        break;
    end
end

if(boole == 1)
    //Wzory z f
    
    beka = w(xb,x)
    for i = 1:n+1
    pusta_tablica
    end
    for i = 1:n;
       pust_tablica 
    end
else
    // wzyory z y
    disp("Nie równe")
end
