clc;
clear;


function y=f(x)
    y = exp(sin(x))
endfunction

m=[0;1;2;3];
n=8
xt=[-1.1;-0.83;-0.57;-0.28;-0.02;0.16;0.47;0.95;1.23]
yt = f(xt)
gj = []
pj = []
expected = 2
select expected
case 0
    gj(expected*2+1)=0
    pj(expected+1) = 0
    for j = 1:2*expected+1
        for i=1:n+1
            if j == 1 then
                gj(j) = gj(j)+1
            else
                gj(j) = gj(j)+xt(i)^j
            end
        end
    end
    
        for j = 1:expected+1
        for i=1:n+1
            if j == 1 then
                pj(j) = pj(j) + f(1)+1
            else
                pj(j) = pj(i) + f(i)+xt(i)^j
            end
        end
    end
    a_0=pj(1)/gj(1)
case 1
    gj(expected*2+1)=0
    pj(expected+1) = 0
    for j = 1:2*expected+1
        for i=1:n+1
            if j == 1 then
                gj(j) = gj(j)+1
            else
                gj(j) = gj(j)+xt(i)^j
            end
        end
    end
    
        for j = 1:expected+1
        for i=1:n+1
            if j == 1 then
                pj(j) = pj(j) + f(1)+1
            else
                pj(j) = pj(j) + f(xt(i))+xt(i)^j
            end
        end
    end
    a_0=-gj(3)*pj(1)+gj(2)*pj(2)/gj(2)^2-gj(1)*gj(3)
    a_1=gj(2)*pj(1)-gj(1)*pj(2)/gj(2)^2-gj(1)*gj(3)
case 2
    gj(expected*2+1)=0
    pj(expected+1) = 0
    for j = 1:2*expected+1
        for i=1:n+1
            if j == 1 then
                gj(j) = gj(j)+1
            else
                gj(j) = gj(j)+xt(i)^j
            end
        end
    end
    
        for j = 1:expected+1
        for i=1:n+1
            if j == 1 then
                pj(j) = pj(j) + f(1)+1
            else
                pj(j) = pj(j) + f(xt(i))+xt(i)^j
            end
        end
    end
denominator = g(3)^2 + g(1)*g(4) + g(2)^2 - 2*g(2)*g(1)*g(3) - g(1)*g(4)
    a(1) = (g(2)^3*rho(1) - g(2)*g(4)*rho(1) + g(1)*g(4)*rho(2) + g(2)^2*rho(3) - g(3)*(g(2)*rho(2) + g(1)*rho(3))) / denominator
    a(2) = (g(1)*g(4)*rho(1) + g(2)^2*rho(2) - g(2)*(g(3)*rho(1) + g(1)*rho(3)) + g(1)*(-g(4)*rho(2) + g(3)*rho(3))) / denominator
    a(3) = (g(2)^2*rho(1) - g(1)*g(3)*rho(1) + g(1)*g(3)*rho(2) + g(2)^2*rho(3) - g(2)*(g(1)*rho(2) + g(1)*rho(3))) / denominator

else
    disp("brak poprawnego m")
end
