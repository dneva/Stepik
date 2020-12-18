import java.util.*;

public class SetTest {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        List<T> list = new LinkedList<>(set1);
        list.removeAll(set2);
        Set<T> set3 = new HashSet<>(list);
        list.clear();
        list.addAll(set2);
        list.removeAll(set1);
        set3.addAll(list);
        return set3;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(0,1,2));
        System.out.println(symmetricDifference(set1,set2));
    }
}
