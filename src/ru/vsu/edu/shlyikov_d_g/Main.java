package ru.vsu.edu.shlyikov_d_g;

import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	SimplePriorityQueue<String> spq = new SimplePriorityQueue<>();

        spq.put("Киев");
        spq.put("Винница");
        spq.put("Харьков");
        spq.put("Львов");
        spq.put("Винница");
        spq.put("Кременчуг");
        spq.put("Кременчуг");
        spq.put("Винница");

        SimplePriorityQueue<String> spq2 = new SimplePriorityQueue<>();
        spq2.put("Киев");
        spq2.put("Винница");
        spq2.put("Харьков");
        spq2.put("Львов");
        spq2.put("Винница");
        spq2.put("Кременчуг");
        spq2.put("Кременчуг");
        spq2.put("Винница");
        SimplePriorityQueue<String> spq3 = new SimplePriorityQueue<>();
        spq3.put("Киев");
        spq3.put("Винница");
        spq3.put("Харьков");
        spq3.put("Львов");
        spq3.put("Винница");
        spq3.put("Кременчуг");
        spq3.put("Кременчуг");
        spq3.put("Винница");
        SimplePriorityQueue<String> spq4 = new SimplePriorityQueue<>();
        spq4.put("Киев");
        spq4.put("Винница");
        spq4.put("Харьков");
        spq4.put("Львов");
        spq4.put("Винница");
        spq4.put("Кременчуг");
        spq4.put("Кременчуг");
        spq4.put("Винница");

        System.out.println("\nСодержит \"Киев\"");
        System.out.println(spq.contains("Киев"));

        System.out.println("\nСодержит \"Запорожье\"");
        System.out.println(spq.contains("Запорожье"));

        System.out.println("\nПервая очередь:");
        System.out.println(spq);

        System.out.println("\nПервая очередь peek():");
        System.out.println(spq.peek());

        spq.remove();
        System.out.println(spq);
        System.out.println("\nПервая очередь peek():");
        System.out.println(spq.peek());
        spq.remove();
        System.out.println(spq);
        spq.put("Харьков");
        spq.put("Аафыафы");
        spq.put("Ннн");
        System.out.println(spq);
        spq.remove();
        System.out.println(spq);
        System.out.println("\nПервая очередь remove():");
        System.out.println(spq.remove());

        System.out.println("\nПервая очередь:");
        System.out.println(spq);

        spq.put("");

        System.out.println("\nВторая очередь:");
        System.out.println(spq2);

        spq.clear();
        System.out.println("\nПервая очередь после clear():");
        System.out.println(spq);

        System.out.println();

        // !---------------!--------------!---------------!--------------!--------------!------------!
        // !---------------!--------------!---------------!--------------!--------------!------------!
        // !---------------!--------------!---------------!--------------!--------------!------------!
        // !---------------!--------------!---------------!--------------!--------------!------------!
        // !---------------!--------------!---------------!--------------!--------------!------------!
        // !---------------!--------------!---------------!--------------!--------------!------------!
        // !---------------!--------------!---------------!--------------!--------------!------------!
        // !---------------!--------------!---------------!--------------!--------------!------------!
        // !---------------!--------------!---------------!--------------!--------------!------------!

        Queue<String> queue1 = new java.util.PriorityQueue<>();
        queue1.offer("Киев");
        queue1.offer("Винница");
        queue1.offer("Харьков");
        queue1.offer("Львов");
        queue1.offer("Винница");
        queue1.offer("Кременчуг");
        queue1.offer("Кременчуг");
        queue1.offer("Винница");
        System.out.print("Priority queue: ");
        while (queue1.size() > 0) {
            System.out.print(queue1.remove() + " ");
        }
        System.out.println();
    }
}
