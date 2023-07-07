import Lab_02

class Queue:
    def __init__(self):
        self.queue= Lab_02.LinkedList()

    def __len__(self):
        return len(self.queue)

    def __repr__(self):
        temp=self.queue.head
        ret = str(temp.value)
        temp=temp.next
        while(temp!=None):
            ret+=', '+str(temp.value)
            temp=temp.next
        return ret

    def peek(self):
        return self.queue.head.value

    def enqueue(self, n_value):
        self.queue.append(n_value)

    def dequeue(self):
        return self.queue.pop()

