package Array;

public class Utility {

    public static int[] convertToIntegerArray(String[] input) {
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i].trim());
        }
        return array;
    }

    public static double[] convertToDoubleArray(String[] input) {
        double[] array = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Double.parseDouble(input[i].trim());
        }
        return array;
    }
}
