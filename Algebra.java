
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.
public class Algebra {

    public static void main(String args[]) {
        // Tests some of the operations
        System.out.println(plus(2, 3));   // 2 + 3
        System.out.println(minus(7, 2));  // 7 - 2
        System.out.println(minus(2, 7));  // 2 - 7
        System.out.println(times(3, 4));  // 3 * 4
        System.out.println(plus(2, times(4, 2)));  // 2 + 4 * 2
        System.out.println(pow(5, 3));      // 5^3
        System.out.println(pow(3, 5));      // 3^5
        System.out.println(div(12, 3));   // 12 / 3  120/3   
        System.out.println(div(5, 5));    // 5 / 5  
        System.out.println(div(25, 7));   // 25 / 7
        System.out.println(mod(25, 7));   // 25 % 7
        System.out.println(mod(120, 6));  // 120 % 6    
        System.out.println(sqrt(36));
        System.out.println(sqrt(263169));
        System.out.println(sqrt(76123));
    }

    // Returns x1 + x2
    public static int plus(int x1, int x2) {
        while (x2 != 0) {
            x1++;
            x2--;
        }
        return x1;
    }

    // Returns x1 - x2
    public static int minus(int x1, int x2) {
        while (x2 != 0) {
            x2--;
            x1--;
        }
        return x1;
    }

    // Returns x1 * x2
    public static int times(int x1, int x2) {
        int sum = 0;
        for (int i = 0; i < x1; i++) {
            for (int j = 0; j < x2; j++) {
                if ((x2 < 0 && x1 > 0) || (x2 > 0 && x1 < 0)) {
                    sum--;
                } else {
                    sum++;
                }
            }
        }
        return sum;

    }

    // Returns x^n (for n >= 0)
    public static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        var result = 1;

        while (n != 0) {
            result = times(result, x);
            n--;
        }
        return result;
    }

    // Returns the integer part of x1 / x2 
    public static int div(int x1, int x2) {
        int counter = 0;
        int x2Static = x2;
        while (x1 >= x2Static) {
            for (int i = 0; i < x2Static; i++) {
                x1--;
            }
            counter++;
        }
        return counter;
    }

    // Returns x1 % x2
    public static int mod(int x1, int x2) {
        int x2Static = x2;
        while (x1 >= x2Static) {
            for (int i = 0; i < x2Static; i++) {
                x1--;
            }
        }
        return x1;
    }

    // Returns the integer part of sqrt(x) 
    public static int sqrt(int x) {
        int result = 0;
        int square = 0;

        while (square < x) {
            result++;
            square = times(result, result);
        }

        return result;
    }
}
