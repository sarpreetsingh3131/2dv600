package sb223ce_assign1;

public class Arrays {

    // I assume that below methods should never get an empty array or null object

    // Extra method to print the array
    static String toString(int[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i] + ", ";
        }
        // remove extra comma and space
        return "{" + str.substring(0, str.length() - 2) + "}";
    }

    static int average(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) { // loop through array
            sum += arr[i]; // add each element into sum
        }
        return sum / arr.length; // get average
    }

    static int max(int[] arr) {
        int max = arr[0]; // set first element as max
        for (int i = 1; i < arr.length; i++) { // start from 1 as first element is already taken
            // if other element is greater than max, then put it in max
            max = arr[i] > max ? arr[i] : max;
        }
        return max;
    }

    static int[] addN(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += n; // add n in all elements
        }
        return arr;
    }

    static int[] reverse(int[] arr) {
        int[] array = new int[arr.length]; // assign given arr to new array to keep arr unchanged
        for (int i = arr.length - 1; i >= 0; i--) { // run reverse loop
            // get elements from arr, and insert them in array at position 0,1,2...
            array[array.length - 1 - i] = arr[i];
        }
        return array;
    }

    static void replaceAll(int[] arr, int old, int nw) {
        for (int i = 0; i < arr.length; i++) {
            // find old and replace it with nw, otherwise keep the same
            arr[i] = arr[i] == old ? nw : arr[i];
        }
    }

    static int[] sort(int[] arr) {
        int[] array = arr; // assign given arr to new array to keep arr unchanged
        for (int i = 0; i < array.length; i++) { // iterate through each element
            // inner loop to compare the element at position i with all the other elements
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) { // if element at position i is greater than the other
                    // swap the elements to sort the array
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }

    static boolean hasSubsequence(int[] arr, int[] sub) {
        for (int i = 0; i < sub.length; i++) { // iterate through each element in sub
            // inner loop to compare if element at position i is same as element at position j in arr
            for (int j = 0; j < arr.length; j++) {
                if (sub[i] == arr[j]) { // if same
                    while (++i < sub.length) { // iterate through the remaining elements in sub
                        // if arr length is smaller than the remaining length of sub
                        // OR elements are not same, return false
                        if (++j >= arr.length || sub[i] != arr[j]) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false; // if no element is same
    }

    static int[] absDif(int[] arr1, int[] arr2) throws Exception {
        if (arr1.length != arr2.length) {
            throw new Exception("For Abs-Dif both arrays should be of same length.");
        }
        int[] array = new int[arr1.length]; // new array of same length

        for (int i = 0; i < arr1.length; i++) { // iterate through each element
            // get absolute difference and save it in new array at the same index
            array[i] = Math.abs(arr1[i] - arr2[i]);
        }
        return array;
    }
}
