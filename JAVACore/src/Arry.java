public class Arry {
    public static void main(String[] args) {
        float[] values = {4.5f,5.5f};
        float total = 0;
        for (float value : values){
            total += value;
        }
        System.out.println("the total value of array is " + total);

        float max = values[0];
        for(int i = 0;i < values.length;i++){
            if (max < values[i]) max = values[i];
        }
        System.out.println("gia tri lon nhat = " + max);
    }
}
