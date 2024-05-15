public class MyHashTable <K,V>{
    public class HashNode<K,V>{
        private K key;
        private V value;
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

    }
    public V get(K key){

    }
    public V remove(K key){

    }
    public boolean containsKey(V value){

    }
    public K getKey(V value){

    }
}
