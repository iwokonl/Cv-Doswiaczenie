from typing import List


def booble(l:List):
    for i in range(0,len(l)):
        print(l)
        for j in range(0,len(l)):
            if l[i]<l[j]:
                temp= l[i]
                l[i]=l[j]
                l[j]=temp


def select(l):
    for i in range(0,len(l)):
        min_index=i
        for j in range(i+1,len(l)):
            if l[j]<l[min_index]:
                min_index=j
        temp= l[i]
        l[i]=l[min_index]
        l[min_index]=temp

def insert(l):
    n=len(l)
    for i in range(1,n):
        key=l[i]
        j=i-1
        while ((j>=0)&(l[j]>key)):
            l[j+1]=l[j]
            j=j-1
            l[j+1]=key

def booble_reverse(l):
    for i in range(0,len(l)):
        for j in range(0,len(l)):
            if l[i]>l[j]:
                temp= l[i]
                l[i]=l[j]
                l[j]=temp

def select_reverse(l):
    for i in range(0,len(l)):
        min_index=i
        for j in range(i+1,len(l)):
            if l[j]>l[min_index]:
                min_index=j
        temp= l[i]
        l[i]=l[min_index]
        l[min_index]=temp

def insert_reverse(l):
    n=len(l)
    for i in range(1,n):
        key=l[i]
        j=i-1
        while ((j>=0)&(l[j]<key)):
            l[j+1]=l[j]
            j=j-1
            l[j+1]=key

l = [6, 3, 9, 0, 4]
booble(l)
