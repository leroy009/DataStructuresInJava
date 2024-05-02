import java.util.*;

public class SetUnion {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        // Union of two sets
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        System.out.println("Union of set1 and set2: " + union);
    }
}
