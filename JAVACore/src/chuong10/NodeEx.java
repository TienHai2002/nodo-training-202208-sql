package chuong10;

public class NodeEx<T> {
    T value;
    NodeEx<T> next;
     NodeEx(T v){
        value = v;
    }
    NodeEx(T v, NodeEx<T> n){
        value = v;
        next = n;
    }

    public T getValue() {
        return value;
    }
}
