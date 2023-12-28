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
                pj(j) = pj(j) + f(1)*1
            else
                pj(j) = pj(i) + f(i)*xt(i)^j
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
                pj(j) = pj(j) + f(1)*1
            else
                pj(j) = pj(j) + f(xt(i))*xt(i)^j
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
                gj(j) = gj(j)+xt(i)^(j-1)
            end
        end
    end
    
        for j = 1:expected+1
        for i=1:n+1
            if j == 1 then
                pj(j) = pj(j) + f(xt(i))*1
            else
                pj(j) = pj(j) + f(xt(i))*xt(i)^(j-1)
            end
        end
    end
denominator = gj(3)^2 + gj(1)*gj(4) + gj(2)^2 - 2*gj(2)*gj(1)*gj(3) - gj(1)*gj(4)
    a_0 = (gj(2)^3*pj(1) - gj(2)*gj(4)*pj(1) + gj(1)*gj(4)*pj(2) + gj(2)^2*pj(3) - gj(3)*(gj(2)*pj(2) + gj(1)*pj(3))) / denominator
    a_1 = (gj(1)*gj(4)*pj(1) + gj(2)^2*pj(2) - gj(2)*(gj(3)*pj(1) + gj(1)*pj(3)) + gj(1)*(-gj(4)*pj(2) + gj(3)*pj(3))) / denominator
    a_2 = (gj(2)^2*pj(1) - gj(1)*gj(3)*pj(1) + gj(1)*gj(3)*pj(2) + gj(2)^2*pj(3) - gj(2)*(gj(1)*pj(2) + gj(1)*pj(3))) / denominator
else
    disp("brak poprawnego m")
end

function y = F(x,m)
    select m
    case 0 then
        y = a_0
    case 1 then
        y = a_0 + a_1*x
    case 2 then
        y = a_0 + a_1*x + a_2*x^2
    else
        disp("Invalid m")
    end
endfunction

x_grid = linspace(xt(1) - 0.1, xt(n+1) + 0.1, 100)

y_grid = F(x_grid,expected)
plot(x_grid, y_grid)

// 8. Place the points on the generated plot of the function F.
for i=1:n+1
    plot(xt(i), f(xt(i)), 'ro')
end
