import java.util.Comparator;
import java.util.PriorityQueue;

public class Person_Heap{

    String name;
    int age;

    public Person_Heap(String name, int age){
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString(){
        return name + "\t, " + age;
    }

    public static void main(String[] args){

        PriorityQueue<Person_Heap> heap = new PriorityQueue<>(Comparator.comparingInt(p -> -p.age));
        heap.add(new Person_Heap("Rakesh", 34));
        heap.add(new Person_Heap("Kanika", 32));
        heap.add(new Person_Heap("Sudesh", 35));
        heap.add(new Person_Heap("Monil", 27));

        while (!heap.isEmpty()){
            System.out.println(heap.poll());
        }

    }
}
