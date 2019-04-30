package competitiveProgramming.notebook;

public class BinarySearch {

    public static int binarySearch(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(a[mid] == target)
                return mid;
            else if(a[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }



    public static int interpolationSearch(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        while(left <= right && target >= a[left] && target <= a[right]) {
            if(left == right) {
                if(a[left] == target)
                    return left;
                return -1;
            }
            int pos = left + (int)((((double)(right - left)) / (a[right] - a[left]))
                        * (target - a[left]));
            if(a[pos] == target)
                return pos;
            if(a[pos] < target)
                left = pos + 1;
            else
                right = pos - 1;
        }
        return -1;
    }


    public static double f(double x) {
        return x;
    }

    public static double ternaryMaximumSearch(double left, double right) {
        while(right - left > 0.1) {
            double m1 = left + (right - left) / 3;
            double m2 = right - (right - left) / 3;

            if(f(m1) < f(m2))
                left = m1;
            else
                right = m2;
        }
        return left;
    }

    public static int ternaryMaximumSearch(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while(left < right) {
            int m1 = left + (right - left) / 3;
            int m2 = right - (right - left) / 3;

            if(a[m1] < a[m2])
                left = m1;
            else
                right = m2;
        }
        return left;
    }

}
