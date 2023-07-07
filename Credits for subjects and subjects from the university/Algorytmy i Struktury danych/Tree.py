from typing import Any, List
import queue


class TreeNode:
    value: Any
    children: List['TreeNode']

    def __init__(self, n_value, childlist: List['TreeNode'] = []):
        self.value = n_value
        self.children = childlist.copy()

    def is_leaf(self):
        if self.children == []:
            return True
        return False

    def add(self, child: 'TreeNode'):
        self.children.append(child)

    def for_each_deep_first(self, visit):
        visit(self)
        if self.children != []:
            for child in self.children:
                child.for_each_deep_first(visit)

    def for_each_level_order(self, visit):
        FIFO = queue.Queue()
        FIFO.put(self)
        while FIFO.empty() == False:
            now = FIFO.get()
            visit(now)
            for child in now.children:
                FIFO.put(child)

    def search(self, value: Any):
        if self.value == value:
            return True
        for child in self.children:
            if child.search(value):
                return True
        return False

    def __repr__(self):
        return f'{self.value}'

    def show(self, level):
        print(' ' * 4 * level + '->', self.value)
        if self.children != []:
            for child in self.children:
                child.show(level + 1)
        print()




class Tree:
    root: TreeNode

    def __init__(self, nody: 'TreeNode'):
        self.root = nody

    def add(self, value: Any, parent_value: Any):
        if self.root.search(parent_value):
            nody = TreeNode(value)
            FIFO = queue.Queue()
            FIFO.put(self.root)
            while FIFO.empty() == False:
                now = FIFO.get()
                if now.value == parent_value:
                    now.add(nody)
                    break  # Dodaje dziecko pierwszemu rodzicowi
                for child in now.children:
                    FIFO.put(child)
        else:
            print("Nie ma takiego rodzica :(")

    def for_each_level_order(self, visit):
        self.root.for_each_level_order(visit)

    def for_each_deep_first(self, visit):
        self.root.for_each_deep_first(visit)

    def show(self):
        self.root.show(0)
def _visit(node: TreeNode):
    print(node)
