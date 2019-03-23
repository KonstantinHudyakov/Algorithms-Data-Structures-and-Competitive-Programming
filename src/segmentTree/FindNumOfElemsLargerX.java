package segmentTree;

import competitiveProgramming.notebook.FastReader;

import java.io.IOException;
import java.util.*;

//Дан массив из N чисел, к которому поступает M запросов. Запросы имеют вид (l,r,x).
//На каждый запрос нужно ответить, сколько элементов, больше либо равных x, содержится на отрезке [l;r].
public class FindNumOfElemsLargerX {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        int m = reader.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
            list.add(reader.nextInt());

        SegmentMemoizationTree tree = new SegmentMemoizationTree(list);

        int left, right, x, ans;
        for(int i = 0; i < m; i++) {
            left = reader.nextInt();
            right = reader.nextInt();
            x = reader.nextInt();
            ans = tree.executeQuery(1, 0, n - 1, left, right, x);
            System.out.println(ans);
        }
//        Stress-test
//        int n = 300000;
//        int m = 100000;
//        Random random = new Random(System.currentTimeMillis());
//        List<Integer> list = new ArrayList<>();
//        for(int i = 0; i < n; i++)
//            list.add(random.nextInt());
//
//        SegmentMemoizationTree tree = new SegmentMemoizationTree(list);
//
//        List<int[]> queries = new ArrayList<>();
//        int left, right;
//        for(int i = 0; i < m; i++) {
//            do {
//                left = random.nextInt(n);
//                right = random.nextInt(n);
//            } while(left > right);
//            queries.add(new int[] {left, right, random.nextInt()});
//        }
//
//        long start = System.currentTimeMillis();
//        int ans;
//        int[] q;
//        for(int i = 0; i < m; i++) {
//            q = queries.get(i);
//            ans = tree.executeQuery(1, 0, n - 1, q[0], q[1], q[2]);
//            System.out.println(ans);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("Runtime: " + (end - start) + " milis");
    }

    private static class SegmentMemoizationTree {
        private int n;
        private List<List<Integer>> nodeValue;
        private List<Integer> arr;

        public SegmentMemoizationTree(List<Integer> arr) {
            this.n = arr.size();
            this.arr = arr;
            nodeValue = new ArrayList<>(4 * n + 1);
            for(int i = 0; i < 4 * n + 1; i++)
                nodeValue.add(new ArrayList<>());
            buildTree(1, 0, arr.size() - 1);
        }

        public int executeQuery(int curNode, int curLeft, int curRight, int targetLeft, int targetRight, int x) {
            if(curLeft >= targetLeft && curRight <= targetRight) {
                return findNumOfElemsLargerX(nodeValue.get(curNode), x);
            }
            else if(curLeft > targetRight || curRight < targetLeft){
                return 0;
            }
            else {
                int mid = curLeft + (curRight - curLeft) / 2;
                return executeQuery(curNode * 2, curLeft, mid, targetLeft, targetRight, x)
                        + executeQuery(curNode * 2 + 1, mid + 1, curRight, targetLeft, targetRight, x);
            }
        }

        public void update(int curNode, int left, int right, int index, int val) {
            if(left == index && right == index) {
                arr.set(index, val);
                nodeValue.get(curNode).set(0, val);
            }
            else if(left > index || right < index) {
                return;
            }
            else {
                int mid = left + (right - left) / 2;
                update(curNode * 2, left, mid, index, val);
                update(curNode * 2 + 1, mid + 1, right, index, val);
                nodeValue.set(curNode, mergeWithSort(nodeValue.get(curNode * 2),
                        nodeValue.get(curNode * 2 + 1)));
            }
        }

        private void buildTree(int curNode, int left, int right) {
            if(left == right) {
                nodeValue.get(curNode).add(arr.get(left));
            }
            else {
                int mid = left + (right - left) / 2;
                buildTree(curNode * 2, left, mid);
                buildTree(curNode * 2 + 1, mid + 1, right);
                nodeValue.set(curNode, mergeWithSort(nodeValue.get(curNode * 2),
                                                     nodeValue.get(curNode * 2 + 1)));
            }
        }

        private int findNumOfElemsLargerX(List<Integer> list, int x) {
            if(list.size() == 1)
                return list.get(0) >= x ? 1 : 0;
            int left = 0;
            int right = list.size() - 1;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(list.get(mid) < x && list.get(mid + 1) >= x)
                    return list.size() - mid - 1;
                else if(list.get(mid) < x)
                    left = mid + 1;
                else
                    right = mid;
            }
            int a = list.get(left);
            int b = list.get(right);
            if(a < x && b >= x)
                return list.size() - left - 1;
            if(a < x)
                return 0;
            if(b >= x)
                return list.size();
            return 0;
        }

        private <T extends Comparable<T>> List<T> mergeWithSort(List<T> list1, List<T> list2) {
            List<T> res = new ArrayList<>(list1.size() + list2.size());
            int i = 0, j = 0;
            T a, b;
            while(i < list1.size() || j < list2.size()) {
                if(i < list1.size() && j < list2.size()) {
                    a = list1.get(i);
                    b = list2.get(j);
                    if(a.compareTo(b) < 0) {
                        res.add(a);
                        i++;
                    }
                    else {
                        res.add(b);
                        j++;
                    }
                }
                else if(i < list1.size()) {
                    res.add(list1.get(i));
                    i++;
                }
                else {
                    res.add(list2.get(j));
                    j++;
                }
            }
            return res;
        }
    }
}