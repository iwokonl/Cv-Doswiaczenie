clc;
clear;

function y=f(x)
    y= exp(sin(x) + cos(x))
endfunction

function y=fx_xj(x,j)
    for i = 1:1000
        y(i) = f(x(i)) * x(i)^j
    end
endfunction
m = [0;1;2;3]
a= -2
b= 3
xt = linspace(a,b,1000)
gj = []
pj = []
expected = 1
    gj(expected*2+1) = 0
    pj(expected+1) = 0
    for j = 1:2*expected+1
        gj(j) = inttrap(xt,(xt)^(j-1))
    end
for j = 1:expected+1
    pj(j) = inttrap(xt, fx_xj(xt, j-1))
end
select expected
case 0
    a_0=pj(1)/gj(1)
case 1
    
    a_0=(-gj(3)*pj(1)+gj(2)*pj(2))/(gj(2)^2-gj(1)*gj(3))
    a_1=(gj(2)*pj(1)-gj(1)*pj(2))/(gj(2)^2-gj(1)*gj(3))
case 2
denominator = gj(3)^2 + gj(1)*gj(4) + gj(2)^2 - 2*gj(2)*gj(1)*gj(3) - gj(1)*gj(4)
    a_0 = (gj(2)^3*pj(1) - gj(2)*gj(4)*pj(1) + gj(1)*gj(4)*pj(2) + gj(2)^2*pj(3) - gj(3)*(gj(2)*pj(2) + gj(1)*pj(3))) / denominator
    a_1 = (gj(1)*gj(4)*pj(1) + gj(2)^2*pj(2) - gj(2)*(gj(3)*pj(1) + gj(1)*pj(3)) + gj(1)*(-gj(4)*pj(2) + gj(3)*pj(3))) / denominator
    a_2 = (gj(2)^2*pj(1) - gj(1)*gj(3)*pj(1) + gj(1)*gj(3)*pj(2) + gj(2)^2*pj(3) - gj(2)*(gj(1)*pj(2) + gj(1)*pj(3))) / denominator
else
    disp("brak poprawnego m")
end
