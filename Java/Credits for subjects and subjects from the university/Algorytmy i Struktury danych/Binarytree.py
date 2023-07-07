from typing import Any, Callable
import queue


class BinaryNode:
    value: Any
    left_child: 'BinaryNode'
    right_child: 'BinaryNode'

    def __init__(self, val):
        self.value = val
        self.left_child = None
        self.right_child = None

    def __repr__(self):
        return f'{self.value}'

    def is_leaf(self):
        if (self.right_child == None) & (self.left_child == None):
            return True
        return False

    def add_left_child(self, value: Any):
        self.left_child = BinaryNode(value)

    def add_right_child(self, value: Any):
        self.right_child = BinaryNode(value)

    def traverse_in_order(self, visit: Callable[[Any], None]):
        if self.left_child != None:
            self.left_child.traverse_in_order(visit)
        visit(self)
        if self.right_child != None:
            self.right_child.traverse_in_order(visit)

    def traverse_post_order(self, visit: Callable[[Any], None]):
        if self.left_child != None:
            self.left_child.traverse_post_order(visit)
        if self.right_child != None:
            self.right_child.traverse_post_order(visit)
        visit(self)

    def traverse_pre_order(self, visit: Callable[[Any], None]):
        visit(self)
        if self.left_child != None:
            self.left_child.traverse_pre_order(visit)
        if self.right_child != None:
            self.right_child.traverse_pre_order(visit)

    def show(self, level):
        if self.right_child != None:
            self.right_child.show(level + 1)
        print(' ' * 4 * level + '->', self.value)
        if self.left_child != None:
            self.left_child.show(level + 1)


class BinaryTree:
    root: BinaryNode

    def __init__(self, val):
        self.root = BinaryNode(val)

    def traverse_in_order(self, visit: Callable[[Any], None]):
        self.root.traverse_in_order(visit)

    def traverse_post_order(self, visit: Callable[[Any], None]):
        self.root.traverse_post_order(visit)

    def traverse_pre_order(self, visit: Callable[[Any], None]):
        self.root.traverse_pre_order(visit)

    def show(self):
        self.root.show(0)
