from typing import Any
import queue


class BinaryNode:
    value: Any
    left_child: 'BinaryNode'
    right_child: 'BinaryNode'

    def __init__(self, value):
        self.value = value
        self.right_child = None
        self.left_child = None
        self.FIFO = queue.Queue()

    def min(self):
        if self.left_child != None:
            BinaryNode.min(self.left_child)
        return self.value

    def show(self, level):
        if self.right_child != None:
            self.right_child.show(level + 1)
        print(' ' * 4 * level + '->', self.value)
        if self.left_child != None:
            self.left_child.show(level + 1)

    def _for_each_deep_first(self, node, visit):
        print(node.value)
        if node.left_child != None:
            self._for_each_deep_first(node.left_child, visit)
        if node.right_child != None:
            self._for_each_deep_first(node.right_child, visit)

    def _levelOrderTraversal(self):
        level = 1
        while BinaryNode.printLevel(self, level):
            level = level + 1

    def printLevel(root, level):
        if root is None:
            return False
        if level == 1:
            print(root.value)
            return True

        left = BinaryNode.printLevel(root.left_child, level - 1)
        right = BinaryNode.printLevel(root.right_child, level - 1)
        return left or right

    def _traverse_in_order(self, visit):
        if self.left_child != None:
            self.left_child._traverse_in_order(visit)
        visit(self)
        if self.right_child != None:
            self.right_child._traverse_in_order(visit)

    def _traverse_pre_order(self, visit):
        visit(self)
        if self.left_child != None:
            self.left_child._traverse_pre_order(visit)
        if self.right_child != None:
            self.right_child._traverse_pre_order(visit)

    def _traverse_post_order(self, visit):
        if self.left_child != None:
            self.left_child._traverse_post_order(visit)
        if self.right_child != None:
            self.right_child._traverse_post_order(visit)
        visit(self)

    def _contains(self, node: 'BinaryNode', value):
        if value == self.value:
            return True
        elif value < self.value:
            if node.left_child != None:
                self._contains(node.left_child)
            else:
                return False
        else:
            if node.right_child != None:
                self._contains(node.right_child)
            else:
                return False
        return False

    def __repr__(self):
        return f'{self.value}'


class BinarySearchTree:
    root: BinaryNode

    def __init__(self, node):
        self.root = node

    def insert(self, value):
        self.root = self._insert(self.root, value)

    def _insert(self, node: BinaryNode, value: Any):
        if value < node.value:
            if node.left_child == None:
                node.left_child = BinaryNode(value)
            else:
                self._insert(node.left_child, value)
        else:
            if node.right_child == None:
                node.right_child = BinaryNode(value)
            else:
                self._insert(node.right_child, value)
        return node

    def insertlist(self, lista: list[Any]):
        for x in lista:
            self.insert(x)

    def for_each_deep_first(self, visit):
        return self.root._for_each_deep_first(self.root, visit)

    def for_each_level_order(self):
        return self.root.levelOrderTraversal()

    def traverse_in_order(self):
        return self.root._traverse_in_order(print)

    def traverse_pre_order(self):
        return self.root._traverse_pre_order(print)

    def traverse_post_order(self):
        return self.root._traverse_post_order(print)

    def levelOrderTraversal(self):
        return self.root._levelOrderTraversal()

    def contains(self, value):
        return self.root._contains(self.root, value)

    def show(self):
        self.root.show(0)

    def __repr__(self):
        return f'{self.root.value}'


def _visit(node: BinaryNode):
    print(node)


node = BinaryNode(8)
Drzewo = BinarySearchTree(node)
Drzewo.insertlist([3, 1, 6, 4, 7, 10, 14, 13])
Drzewo.traverse_post_order()
print()
Drzewo.traverse_pre_order()
print()
Drzewo.traverse_in_order()
Drzewo.levelOrderTraversal()

# Drzewo.show()
