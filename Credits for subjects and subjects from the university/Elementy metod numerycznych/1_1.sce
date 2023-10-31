clear;
clc;


M=[2.541 2.112
   1.872 1.556];
   
E=[0 0
   0 0];
   
b=[4.653
   3.428];


function y=wz2(C);
    y = C(1,1)*C(2,2)-C(2,1)*C(1,2);
endfunction

function Y=msum(C,D);
    Y = C+D;
endfunction



    
if wz2(M+E) ~= 0 then
    detMe = M+E
    ME1 = detMe;
    ME1(1,1) = b(1);
    ME1(2,1) = b(2);
    ME2 = detMe;
    ME2(1,2) = b(1);
    ME2(2,2) = b(2);
    x = [0;0];
    x(1) = wz2(ME1)/wz2(detMe);
    x(2) = wz2(ME2)/wz2(detMe);
    disp("x=",x);
else
    disp("Wyznacznik zerowy")
end
