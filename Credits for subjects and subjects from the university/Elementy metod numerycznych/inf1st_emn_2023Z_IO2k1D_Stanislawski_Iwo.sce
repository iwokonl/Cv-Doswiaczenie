//Stanisławski Iwo, Informatyka, informatyka ogólna, 3 IO, nr kol 1, wersja D
clc;
clear;
disp("Iwo Stanisławski,informatyka ,3 rok,informatyka ogólna")

function y=f(x)
    y=log((cos(x))^2+0.1);
endfunction
function y=det2(x)
    y=x(1,1)*x(2,2)-x(2,1)*x(1,2);
endfunction
function y=g(x)
    temp = [];
    for i=1:250
    if x(i) <= 0 then
        temp(i)=exp(x(i))-1;
    else
        temp(i)=log(x(i));
    end
    end
    y=temp
endfunction
A=[1/2,1/3,1/4
   1/3,1/4,1/5];
B = [];
for i = 1:2
    for y = 1:3
        B(i,y)=A(i,y)*A(i,y)
    end
end
disp(B);
z=[1];
for i=1:10
    z(i+1) = 2*z(i)+1
    if modulo(i,2)==0 then
    disp(z(i))
    end
end
disp(f(-0.1))
M = [];
for i = 1:3
    for y = 1:3
        M(i,y)=i+y;
    end
end
B = [];
for i = 1:2
    B(i,1)= A(i,2)
    B(i,2)= A(i,3)
end
disp(det2(B))
x = linspace(-5,2.5,250);
y = g(x)
clf(); plot2d(x,y)
