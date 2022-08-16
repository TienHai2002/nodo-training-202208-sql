package chuong10;

public class Stack <T>{
    private NodeEx<T> current = null;

    public T pop(){
        T result = current.value;
        current = current.next;
        return result;
    }
    public boolean hasNext(){
        return current != null;
    }
    public void push(T v){
        NodeEx newNode = new NodeEx<>(v, current);
        this.current = newNode;
    }
}
