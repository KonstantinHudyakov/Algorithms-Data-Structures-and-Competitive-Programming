package competitiveProgramming.notebook;

public class SegmentTree {
    private int n;
    private int[] nodeValue;
    private int[] arr;

    public SegmentTree(int[] arr) {
        this.n = arr.length;
        this.arr = arr;
        nodeValue = new int[4 * n + 1];
        buildTree(1, 0, arr.length - 1);
    }

    public int getSum(int curNode, int curLeft, int curRight, int targetLeft, int targetRight) {
        if (curLeft >= targetLeft && curRight <= targetRight) {
            return nodeValue[curNode];
        } else if (curLeft > targetRight || curRight < targetLeft) {
            return 0;
        } else {
            int mid = curLeft + (curRight - curLeft) / 2;
            return getSum(curNode * 2, curLeft, mid, targetLeft, targetRight)
                    + getSum(curNode * 2 + 1, mid + 1, curRight, targetLeft, targetRight);
        }
    }

    public void update(int curNode, int left, int right, int index, int val) {
        if (left == index && right == index) {
            nodeValue[curNode] = val;
            arr[index] = val;
        } else if (left > index || right < index) {
            return;
        } else {
            int mid = left + (right - left) / 2;
            update(curNode * 2, left, mid, index, val);
            update(curNode * 2 + 1, mid + 1, right, index, val);
            nodeValue[curNode] = nodeValue[curNode * 2] + nodeValue[curNode * 2 + 1];
        }
    }

    private void buildTree(int curNode, int left, int right) {
        if (left == right) {
            nodeValue[curNode] = arr[left];
        } else {
            int mid = left + (right - left) / 2;
            buildTree(curNode * 2, left, mid);
            buildTree(curNode * 2 + 1, mid + 1, right);
            nodeValue[curNode] = nodeValue[curNode * 2] + nodeValue[curNode * 2 + 1];
        }
    }
}