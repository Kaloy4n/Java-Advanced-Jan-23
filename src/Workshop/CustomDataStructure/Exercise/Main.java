package Workshop.CustomDataStructure.Exercise;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.addLast(1);
        doublyLinkedList.addLast(2);
        doublyLinkedList.addLast(3);
        doublyLinkedList.addLast(4);
        doublyLinkedList.addLast(5);

//        System.out.println(doublyLinkedList);

        int[] numbers = doublyLinkedList.toArray();
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
