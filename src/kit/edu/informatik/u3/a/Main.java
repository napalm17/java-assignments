package kit.edu.informatik.u3.a;

public class Main {
    public static void main(String[] args) {
        UnrolledLinkedList list1 = new UnrolledLinkedList(4);
        for (int i = 6; i < 84; i++) {
            list1.push(i);
        }
        // list1.pop();
        System.out.println(list1.toString("-"));
        System.out.println(list1.get(2));
        System.out.println(list1.size());


    }
}
