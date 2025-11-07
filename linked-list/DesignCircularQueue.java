

class MyCircularQueue {

    int[] q;
    int f = -1;
    int r = -1;
    int size = 0;
    int capacity = 0;

    public MyCircularQueue(int k) {
        q = new int[k];
        capacity = k;
    }
    
    public boolean enQueue(int value) {
        if(f == -1 && r == -1) {
            f = 0; r = 0;
            q[r] = value;
            size++;
            return true;
        }
        else if(size < capacity) {
            r = (r + 1) % capacity;
            q[r] = value;
            size++;
            return true;
        }

        return false;
    }
    
    public boolean deQueue() {
        if(size == 0) {
            return false;
        }
        else if(size == 1) {
            f = -1; r = -1;
            size = 0;
            return true;
        }
        else {
            f = (f + 1) % capacity;
            size--;
            return true;
        }
    }
    
    public int Front() {
        if(f == -1 && r == -1) return -1;
        else return q[f];
    }
    
    public int Rear() {
        if(f == -1 && r == -1) return -1;
        else return q[r];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}