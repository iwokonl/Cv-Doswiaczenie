clc;
clear;
function y=f(x)
    y=exp(x)-x^2
endfunction

function y=ff(x)
    y=exp(x)-2*x
endfunction

function y=fff(x)
    y=exp(x)-2
endfunction
function y=g(x)
    y=f(x+f(x)) - f(x)/f(x)
endfunction
function y=new_sol(xt_0,N,xt)
    XXX = []
    for i=1:N
        if i == 1 then
            XXX(i) = f(xt_0)/g(xt_0)
        else
            XXX(i) = f(XXX(i-1))/g(XXX(i-1))
        end 
    end
    y=XXX
endfunction
N=10;
a= -2
b=0
gj = []
xn=[]
xt_0 = 0 
xn_przyb = []
if f(a)*f(b) < 0 && ff(a)*ff(b) > 0 && fff(a)*fff(b) > 0 then
    if f(a)*fff(a) >0 then 
        xt_0 = a
    else
        xt_0 = b
end
    xn_przyb = new_sol()
    xn_a = []
for i=1:N
        if i == 1 then
            xn_a(i) = abs(xn_przyb(i) - xt_0)/ abs(f(xn_przyb(i)) - f(xt_0))
        else
            xn_a(i) = abs(xn_przyb(i) - xt_0)/ abs(f(xn_przyb(i)) - f(xn_przyb(i-1)))
        end 
    end
end
