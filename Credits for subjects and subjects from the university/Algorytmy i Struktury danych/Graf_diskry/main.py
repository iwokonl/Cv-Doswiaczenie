from enum import Enum
from typing import Any, Optional, Dict, List
import copy

import Lab_02_pd
from graphviz import Digraph as Groph
import math


class EdgeType(Enum):
    directed = 1
    undirected = 2


class Vertex:
    data: Any
    index: int

    def __init__(self, data, ind):
        self.data = data
        self.index = ind

    def __repr__(self):
        return f'{self.data}:v{self.index}'


class Edge:
    source: Vertex
    destination: Vertex
    weight: Optional[float]

    def __init__(self, s, d, w):
        self.source = s
        self.destination = d
        self.weight = w

    def __repr__(self):
        return f'{self.destination}'


class Graph:
    adjacencies: Dict[Vertex, List[Edge]]

    def __init__(self):
        self.adjacencies = dict()

    def create_vertex(self, data: Any):
        self.adjacencies[Vertex(data, len(self.adjacencies))] = list()

    def add_directed_edge(self, source: Vertex, destination: Vertex, weight: Optional[float] = None):
        grafik.adjacencies[source].append(Edge(source, destination, weight))

    def add_undirected_edge(self, source: Vertex, destination: Vertex, weight: Optional[float] = None):
        grafik.adjacencies[source].append(Edge(source, destination, weight))
        grafik.adjacencies[destination].append(Edge(destination, source, weight))

    def add(self, edge: EdgeType, source: Vertex, destination: Vertex, weight: Optional[float] = None):
        if edge.name == "directed":
            self.add_directed_edge(source, destination, weight)
        else:
            self.add_undirected_edge(source, destination, weight)

    def traverse_breadth_first(self, visit):
        lista_kluczy = [x for x in self.adjacencies.keys()]
        lista_odwiedzonych = []
        kolejka = Lab_02_pd.Queue()
        kolejka.enqueue(lista_kluczy[0])
        while (len(kolejka) != 0):
            new = kolejka.dequeue()
            lista_odwiedzonych.append(new)
            visit(new)
            for new_neighbour in self.adjacencies[new]:
                if new_neighbour.destination in lista_odwiedzonych:
                    True
                else:
                    kolejka.enqueue(new_neighbour.destination)

    def traverse_depth_first(self, visit):
        lista_kluczy = [x for x in self.adjacencies.keys()]
        lista_odwiedzonych = []
        self._dfs(lista_kluczy[0], lista_odwiedzonych, visit)

    def _dfs(self, v: Vertex, visited: List[Vertex], visit):
        visit(v)
        visited.append(v)
        for new_neighbour in self.adjacencies[v]:
            if new_neighbour.destination in visited:
                True
            else:
                self._dfs(new_neighbour.destination, visited, visit)

    def show(self, name: Optional = "graf"):
        dot = Groph(comment="graf")
        visited = []
        for x in self.adjacencies.keys():
            self._show_helper(x, dot, visited)
        with open("grafik.gv", "w") as text_file:
            print(f"{dot}", file=text_file)
        print(dot)


    def _show_helper(self, v: Vertex, dot, visited: List):
        if v in visited:
            True
        else:
            dot.node(str(v.index), str(v.data))
            visited.append(v)
            for neighbour in self.adjacencies[v]:
                desc = ""
                if neighbour.weight != None:
                    desc += f"{neighbour.weight}"
                dot.edge(str(neighbour.source.index), str(neighbour.destination.index), label=desc)
                if not (neighbour.destination in visited):
                    self._show_helper(neighbour.destination, dot, visited)

    def __repr__(self):
        stirng = ""
        for data in self.adjacencies:
            stirng += f'- {data} ---->{self.adjacencies[data]}\n'
        return stirng


class GraphPath:
    tablica_kosztow: Dict[Vertex, int]
    tablica_parents: Dict[Vertex, List[Vertex]]
    visited: List[Vertex]
    path: List[Vertex]

    def __init__(self, g: Graph, p: Vertex, k: Vertex, name: Optional = "graf"):
        self.tablica_kosztow = dict()
        self.tablica_parents = dict()
        self.visited = list()
        self.path = list()
        for child in g.adjacencies.keys():
            self.tablica_kosztow[child] = math.inf
            self.tablica_parents[child] = None
        for neighbour in g.adjacencies[p]:
            self.tablica_kosztow[neighbour.destination] = neighbour.weight
            self.tablica_parents[neighbour.destination] = neighbour.source
        self._search_shortest_way(g, p, k)
        dot = Groph(comment='graf')
        visited = []
        for x in g.adjacencies.keys():
            self._show(x, dot, visited, g)
        print(f"Koszt trasy: {self.tablica_kosztow[k]}")
        with open("grafik_najkr_droga.gv", "w") as text_file:
            print(f"{dot}", file=text_file)
        print(dot)


    def _dijkstra(self, g: Graph, p: Vertex, k: Vertex):
        self.visited.append(p)
        v = min(self.tablica_kosztow, key=self.tablica_kosztow.get)
        while v is not None:
            self.visited.append(v)
            c = self.tablica_kosztow[v]
            for edge in g.adjacencies[v]:
                nc = c + edge.weight
                if self.tablica_kosztow[edge.destination] > nc:
                    self.tablica_kosztow[edge.destination] = nc
                    self.tablica_parents[edge.destination] = edge.source
            koszty_copy = self.tablica_kosztow.copy()
            v = min(koszty_copy, key=koszty_copy.get)
            while min(koszty_copy, key=koszty_copy.get) in self.visited:
                koszty_copy.pop(min(koszty_copy, key=koszty_copy.get))
                if len(koszty_copy.keys()) == 0:
                    v = None
                    break
                v = min(koszty_copy, key=koszty_copy.get)
        while k is not None:
            self.path.append(k)
            k = self.tablica_parents[k]
        self.path.reverse()

    def _wszerz(self, g: Graph, p: Vertex, k: Vertex):
        kolejka = Lab_02_pd.Queue()
        kolejka.enqueue([p])
        while len(kolejka) != 0:
            b = kolejka.dequeue()
            b_v = b[-1]
            for neighbour in g.adjacencies[b_v]:
                if neighbour.destination not in self.visited:
                    b_new = b.copy()
                    b_new.append(neighbour.destination)
                    self.visited.append(neighbour.destination)
                    kolejka.enqueue(b_new)
                    if neighbour.destination == k:
                        self.path = b_new

    def _search_shortest_way(self, g: Graph, p: Vertex, k: Vertex):
        li = [y for x in g.adjacencies.values() for y in x]
        if li[0].weight == None:
            self._wszerz(g, p, k)
        else:
            self._dijkstra(g, p, k)
        print(self.path)

    def _show(self, v: Vertex, dot, visited: List, g: Graph):
        if v in visited:
            True
        else:
            dot.node(str(v.index), str(v.data))
            visited.append(v)
            for neighbour in g.adjacencies[v]:
                desc = ""
                if neighbour.weight != None:
                    desc += f"{neighbour.weight}"
                trasa = False
                for x in range(1, len(self.path)):
                    if ((self.path[x - 1] == neighbour.source) & (self.path[x] == neighbour.destination)):
                        trasa = True
                if trasa:
                    dot.edge(str(neighbour.source.index), str(neighbour.destination.index), label=desc, color="green")
                else:
                    dot.edge(str(neighbour.source.index), str(neighbour.destination.index), label=desc)
                if not (neighbour.destination in visited):
                    self._show(neighbour.destination, dot, visited, g)


def name_of_global_obj(xx):
    for objname, oid in globals().items():
        if oid is xx:
            return objname


grafik = Graph()
grafik.create_vertex(0)
grafik.create_vertex(1)
grafik.create_vertex(2)
grafik.create_vertex(3)
grafik.create_vertex(4)
grafik.create_vertex(5)
grafik.create_vertex(6)
lista_kluczy = [x for x in grafik.adjacencies.keys()]
grafik.add(EdgeType(1), lista_kluczy[1], lista_kluczy[2], 9)
grafik.add(EdgeType(1), lista_kluczy[1], lista_kluczy[5], 11)
grafik.add(EdgeType(1), lista_kluczy[2], lista_kluczy[4], 12)
grafik.add(EdgeType(1), lista_kluczy[4], lista_kluczy[5], 11)
grafik.add(EdgeType(1), lista_kluczy[4], lista_kluczy[6], 6)
grafik.add(EdgeType(1), lista_kluczy[5], lista_kluczy[6], 8)
grafik.add(EdgeType(1), lista_kluczy[0], lista_kluczy[4], 12)
grafik.add(EdgeType(1), lista_kluczy[0], lista_kluczy[2], 5)
grafik.add(EdgeType(1), lista_kluczy[3], lista_kluczy[4], 5)
grafik.add(EdgeType(1), lista_kluczy[3], lista_kluczy[5], 13)
grafik.traverse_depth_first(print)
grafik.show(name=name_of_global_obj(grafik))
gp = GraphPath(grafik, lista_kluczy[3], lista_kluczy[6], name=name_of_global_obj(grafik))
