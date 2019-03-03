package binarySearch;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {

    }

    public char nextGreatestLetter(char[] letters, char target) {
        if(target < letters[0] || target >= letters[letters.length - 1])
            return letters[0];
        int left = 0;
        int right = letters.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(letters[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        return letters[left];
    }
}
