package segmentTree;

import competitiveProgramming.notebook.FastReader;

import java.io.IOException;

public class FindFirstZero {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();

        int n = reader.nextInt();
        boolean[] arr = new boolean[100001];
        SegmentTree tree = new SegmentTree(arr);

        int cur;
        for(int i = 0; i < n; i++) {
            cur = reader.nextInt();
            if(cur > 0)
                System.out.println(tree.add(cur));
            else
                tree.remove(-cur);
        }
    }

    private static class SegmentTree {
        private int n;
        private int[] nodeValues;
        private boolean[] arr;

        public SegmentTree(boolean[] arr) {
            n = arr.length;
            this.arr = arr;
            nodeValues = new int[n * 4 + 1];
            buildTree(1, 0, n - 1);
        }

        public int add(int index) {
            int firstZeroIndex = findFirstZero(1, 0, n - 1, index, n - 1);
            update(1, 0, n - 1, firstZeroIndex, true);
            return firstZeroIndex;
        }

        public void remove(int index) {
            update(1, 0, n - 1, index, false);
        }

        public int findFirstZero(int curNode, int curLeft, int curRight, int tgLeft, int tgRight) {
            if(curLeft >= tgLeft && curRight <= tgRight) {
                return nodeValues[curNode];
            }
            else if(curLeft > tgRight || curRight < tgLeft) {
                return Integer.MAX_VALUE;
            }
            else {
                int mid = curLeft + (curRight - curLeft) / 2;
                return Math.min(findFirstZero(curNode * 2, curLeft, mid, tgLeft, tgRight),
                        findFirstZero(curNode * 2 + 1, mid + 1, curRight, tgLeft, tgRight));
            }
        }

        public void update(int curNode, int curLeft, int curRight, int index, boolean val) {
            if(curLeft == index && curRight == index) {
                arr[index] = val;
                nodeValues[curNode] = val ? Integer.MAX_VALUE : index;
            }
            else if(curLeft > index || curRight < index)
                return;
            else {
                int mid = curLeft + (curRight - curLeft) / 2;
                update(curNode * 2, curLeft, mid, index, val);
                update(curNode * 2 + 1, mid + 1, curRight, index, val);
                nodeValues[curNode] = Math.min(nodeValues[curNode * 2], nodeValues[curNode * 2 + 1]);
            }
        }

        private void buildTree(int curNode, int left, int right) {
            if(left == right) {
                nodeValues[curNode] = left;
            }
            else {
                int mid = left + (right - left) / 2;
                buildTree(curNode * 2, left, mid);
                buildTree(curNode * 2 + 1, mid + 1, right);
                nodeValues[curNode] = Math.min(nodeValues[curNode * 2], nodeValues[curNode * 2  +1]);
            }
        }
    }
}
