import java.util.PriorityQueue;

public class Person implements Comparable<Person>{

    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(o.age, this.age);
    }

    @Override
    public String toString(){
        return name + "\t, " + age;
    }

    public static void main(String[] args){

        PriorityQueue<Person> heap = new PriorityQueue<>();
        heap.add(new Person("Rakesh", 34));
        heap.add(new Person("Kanika", 32));
        heap.add(new Person("Sudesh", 35));
        heap.add(new Person("Monil", 27));

        while (!heap.isEmpty()){
            System.out.println(heap.poll());
        }

    }
}
