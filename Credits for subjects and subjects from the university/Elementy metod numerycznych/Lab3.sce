clc;
clear;
function y=SIN(x)
    y= sin(x);
endfunction
function y=W(x,xt,n)
    temp = [];
    for i = 1:n+1
        temp(i) = x-xt(i)
    end
    y = prod(temp)
endfunction
function y=wd(tab,i,xt)
    y = (tab(i+1,1)-tab(i))/(xt(i+1)-xt(i))
endfunction
n=7;
xb = %pi/2;
xt = [1;2;3;4;5;6;7;8]
yt = SIN(xt)


w = W(xb,xt,n)
tab = []
tab(n+1,n+1) = 0
for i =1:n+1
    tab(i,1)=yt(i)
end
for i = 1:n+1
    tab()
end
for i = 1:n
if abs(xt(1) - xt(2)) == abs(xt(i) - xt(i+1))then
        h = abs(xt(1) - xt(2));
    else
        disp("Nie są równo odległe")
        break;
    end
    
end
if h ==  abs(xt(1) - xt(2))then
    s = yt(1);
    for k = 1:n
        for i = 0:(n-k)
            tab(i + 1, k + 1) = (tab(i + 2, k) - tab(i + 1, k))
        end
    end
    for i = 1:n+1
        s = s + (tab(1,i)/factorial(i)*h^i)*W(xb, xt, n)
    end

else
        for k = 1:n
        for i = 0:(n-k)
            tab(i + 1, k + 1) = (tab(i + 2, k) - tab(i + 1, k)) / (xt(i + k+1) - xt(i+1))
        end
    end
    s = yt(1);
    for k = 1:n+1
        for i = 0:(n-k)+1
            s = s + tab(k,i+1)* W(xb, xt, i - 1)
        end
    end
end

