package Hash;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int capacity = getCapacity();
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(capacity);

        Random random = new Random();
        int iterations = getIterations();
        for (int i = 0; i < iterations; i++) {
            MyTestingClass key = new MyTestingClass(random.nextInt(100000), "Name" + random.nextInt(100000));
            Student value = new Student(random.nextInt(100000), "Student" + random.nextInt(100000));
            table.put(key, value);
        }

        for (int i = 0; i < table.getCapacity(); i++) {
            int bucketSize = getBucketSize(table, i);
            System.out.println("Size of bucket" + " " + i + " is " + bucketSize);
        }
    }

    private static int getCapacity() {
        return 11;
    }

    private static int getIterations() {
        return 10000;
    }

    private static int getBucketSize(MyHashTable<MyTestingClass, Student> table, int index) {
        int bucketSize = 0;
        MyHashTable.HashNode<MyTestingClass, Student> current = table.chainArray[index];
        while (current != null) {
            bucketSize++;
            current = current.next;
        }
        return bucketSize;
    }

}
