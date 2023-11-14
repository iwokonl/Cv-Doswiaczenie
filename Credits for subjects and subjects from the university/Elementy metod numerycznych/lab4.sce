clc;
clear;


function y=f(x)
    y=(x^2-3)*sin(x)
endfunction
function y=f1(x,h)
    y=(f(x+h)-f(x))/h
endfunction
function y=f2(x,h)
    y=(f1(x+h,h)-f1(x,h))/h
endfunction
r=4;
a=-4;
b=0.5;
nmax = 50
h=0.001;
wi=0;
if(f(a)*f(b)<0) then
    while 4<5
        if(f1(a+h)*f1(b+h)>0) && (f2(a+h)*f2(b+h)>0)then
            disp("Warunek został spełniony")
            break;
        else
            wi= wi + 1;
            xb = (a+b)/2
                if f(a)*f(xb) < 0 then
                   b = xb
                else
                   a = xb 
                end
        end
    end
    if f1(a)*f2(a)<0 then
        c = a
        xt = [b]
    else
        c=b
        xt = [a]
    end
    iii = 2
    if(f1(a+h)*f1(b+h)>0) && (f2(a+h)*f2(b+h)>0)then
    while 4 < 5
        xt(iii) = xt(iii-1)-(((f(xt(iii-1)))/(f(c)-f(xt(iii-1))))*(c-xt(iii-1)))
        
        if wi > nmax then
            disp("nie udało się osiągnąć żadnej dkoładności")
            break;
        end
        if abs(xt(iii)- xt(iii-1) ) < 10^(-r)then
            disp("Rozwiązanie to")
            disp(xt(iii))
            break;
        
    end
    
iii = iii + 1;
end
end

        
    
else
    
end


