package educ.service.teacher;

/**
 * @author: renjw
 * @date : 2021/7/6:17:56
 **/
public class test {

    public static void main(String[] args) {
        int a = 1, b = 1;
        int count = 2;
        int sum = 0;
        System.out.println(getSum(a, b, count, sum));
        for (int i = 2; i < 30; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        System.out.println(sum);
    }

    private static int getSum(int a, int b, int count, int sum) {
        if (count == 30) {
            return sum;
        } else {
            count += 1;
            sum = a + b;
            a = b;
            b = sum;
            return getSum(a, b, count, sum);
        }
    }
}
