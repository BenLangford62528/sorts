import java.util.ArrayList;
import java.util.List;

public class sorts {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        while (list.size() != 100) {
            int a = (int) Math.ceil(Math.random() * 100);
            if (!(list.contains(a))) list.add(a);
        }
        System.out.println(list);
        System.out.println(mergeSort(list));
        //quickSort(list);
    }

    private static List<Integer> mergeSort(List<Integer> list) {
        if (list.size() == 1) {
            return list;
        } else {
            int middle = list.size() / 2;
            List<Integer> left = mergeSort(list.subList(0, middle));
            List<Integer> right = mergeSort(list.subList(middle, list.size()));
            return merge(left, right);
        }
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int a = 0, b = 0;
        while (a < left.size() && b < right.size()) {
            if (left.get(a) < right.get(b)) {
                result.add(left.get(a));
                a++;
            } else {
                result.add(right.get(b));
                b++;
            }
        }

        for (int i = a; i < left.size(); i++) result.add(left.get(i));
        for (int j = b; j < right.size(); j++) result.add(right.get(j));
        return result;
    }
}