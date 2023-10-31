clear;
clc;

n=3;
a=-0.5;
b=2*%pi;
x=[0;%pi/4;%pi/2;3/2*%pi];
xb=9/10*%pi;
r=2;
xp = [0;0;0;0]
function y=f(x);
    y=sin(x);
endfunction
for i = 1:n+1
    xp(i) = f(x(i));
end
omega = 0;
function y=omega(x,n,xn);
    y = 1;
    for i=1:n+1
        y = y * (x - xn(i))
    end
endfunction
function y=phi(x,n,j,xn);
    tab1= 1
    tab2 =1
    for i=1:n+1
        if(i ~= j) then
            tab1 = tab1 * (x - xn(i))
        end
    end
        for i=1:n+1
        if(i ~= j) then
            tab2 = tab2 * (xn(j) - xn(i))
        end
    end
    y = tab1/tab2;

endfunction
omega = omega(xb,n,x)
j = 3
ls = 100;
phi = phi(xb,n,j,x)
xt = linspace(a,b,ls)
for i = 1:ls
     fpt(i) = abs(f(xt(i)));
end
M = max(fpt)
err=(M*abs(omega))/factorial(n+1)
