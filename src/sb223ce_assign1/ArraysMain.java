package sb223ce_assign1;

public class ArraysMain {

    public static void main(String[] args) {
        int[] array = {1000, 700, 500, 4, 600, 800, 4};

        System.out.println(
                "Average: " + Arrays.average(array) +
                        "\nMax : " + Arrays.max(array) +
                        "\nAdd N : " + Arrays.toString(Arrays.addN(array, 1)) +
                        "\nReverse All: " + Arrays.toString(Arrays.reverse(array)) +
                        "\nSort : " + Arrays.toString(Arrays.sort(array)) +
                        "\nSort : " + Arrays.toString(Arrays.sort(array)) +
                        "\nHas Sub-Sequence : " + Arrays.hasSubsequence(array, new int[]{501, 601, 701})
        );

        Arrays.replaceAll(array, 5, 500);

        System.out.println("Replace All: " + Arrays.toString(array));

        try {
            System.out.println("Abs-Dif : " +
                    Arrays.toString(Arrays.absDif(new int[]{-11, -22, -33, 4}, new int[]{1, 2, 3, 4}))
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
