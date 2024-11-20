import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        Person[] p = new Person[N];

        for (int i = 0; i < N; i++) {
            p[i] = new Person(sc.nextInt(), sc.next());
        }

        // 나이 오름차순
        Arrays.sort(p, Comparator.comparingInt(o -> o.age));

        for (int i = 0; i < N; i++) {
            sb.append(p[i]);
        }

        System.out.println(sb);
    }

    public static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public String toString() {
            return age + " " + name + "\n";
        }
    }
}