package data_type;

public class UniformNumber {
    public static void main(String[] args) {
        double num1 = Math.random();
        double num2 = Math.random();
        double num3 = Math.random();
        double num4 = Math.random();
        double num5 = Math.random();
        System.out.println("5 giá trị ngẫu nhiên :"+ num1 + "," + num2 + "," + num3 + "," + num4 + "," + num5);
        //average
        System.out.println("Giá trị trung bình: " + ((num1 + num2 + num3 + num4 + num5)/5));
        //max
        double max12 = Math.max(num1,num2);
        double max34 = Math.max(num3,num4);
        double max1234 = Math.max(max12,max34);
        double max12345 = Math.max(max1234,num5);
        System.out.println("Giá trị lớn nhất: " + (max12345));
        //min
        double min12 = Math.min(num1,num2);
        double min34 = Math.min(num3,num4);
        double min1234 = Math.min(min12,min34);
        double min12345 = Math.min(min1234,num5);
        System.out.println("Giá trị nhỏ nhất: " + (min12345));
        //Phần này em không nghĩ ra cách nào không dùng kiến thức của bài sau
        double[] nums = {num1,num2,num3,num4,num5};
        double[] notMinNotMax = new double[3];
        int index = 0;
        for(int i = 0; i < nums.length;i++){
            if(nums[i] != max12345 && nums[i] != min12345) {
                notMinNotMax[index] = nums[i];
                index++;
            }
        }
        String notMinNotMaxString = "";
        for (int i = 0; i < notMinNotMax.length ; i++) {
            notMinNotMaxString += notMinNotMax[i];
            if (i != notMinNotMax.length - 1){
                notMinNotMaxString += ",";
            }
        }
        System.out.println("Not min not max: " + notMinNotMaxString);



    }
}
