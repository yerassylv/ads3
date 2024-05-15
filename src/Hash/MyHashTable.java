package Hash;

import java.util.ArrayList;
import java.util.List;

public class MyHashTable <K,V>{
    public List<K> getKeyList(List<V> studentList) {
        List<K> keyList = new ArrayList<>();
        for (V value : studentList) {
            keyList.add(getKey(value));
        }
        return keyList;
    }

    public static class  HashNode<K,V>{
        private final K key;
        private V value;
        public HashNode<K,V> next;

        public HashNode(K key,V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }

    }
    public HashNode<K,V>[] chainArray;
    private int capacity;
    private int size;

    public MyHashTable(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException("Must be bigger than 0");
        }
        this.capacity = capacity;
        chainArray = new HashNode[capacity];
        size = 0;

    }
    private int hash(K key){
        int hashCode = key.hashCode();
        int index = hashCode % capacity;
        if(index < 0){
            index += capacity;
        }
        return index;
    }
    public void put(K key, V value){
        int index = hash(key);
        if (chainArray[index] == null){
            chainArray[index] = new HashNode<K,V>(key,value);
        }else{
            HashNode<K,V> current = chainArray[index];
            while (current != null){
                if(current.key.equals(key)){
                    current.value = value;
                    return;

                }
                current = current.next;
            }
            HashNode<K,V> newNode = new HashNode<K,V>(key,value);
            newNode.next = chainArray[index];
            chainArray[index] = newNode;
        }
        size++;

    }
    public V get(K key){
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;

    }
    public V remove(K key){
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        if (current != null && current.key.equals(key)) {
            chainArray[index] = current.next;
            size--;
            return current.value;
        }
        while (current.next != null) {
            if (current.next.key.equals(key)) {
                HashNode<K, V> temp = current.next;
                current.next = current.next.next;
                size--;
                return temp.value;
            }
            current = current.next;
        }
        return null;

    }
    public int getSize(){
        return size;
    }
    public int getCapacity(){
        return capacity;
    }
    public boolean containsKey(V value){
        for (int i = 0; i < capacity; i++) {
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;

    }
    public K getKey(V value){
        for (HashNode<K, V> node : chainArray) {
            HashNode<K, V> current = node;
            while (current != null) {
                if (current.value.equals(value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;

    }
}
