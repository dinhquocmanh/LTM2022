public class Snippets {
    public static int USCLN(int a, int b) {
        if (b == 0) return a;
        return USCLN(b, a % b);
    }
     
    public static int BSCNN(int a, int b) {
        return (a * b) / USCLN(a, b);
    }

    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void print2largest(int arr[], int arr_size) {
        int i;
        if (arr_size < 2) {
            System.out.printf("Khong ton tai phan tu lon thu 2");
            return;
        }
        Arrays.sort(arr);
        for (i = arr_size - 2; i >= 0; i--) {
            if (arr[i] != arr[arr_size - 1]) {
                System.out.printf("Phan tu lon thu 2: " + arr[i]);
                return;
            }
        }
        System.out.printf("Khong ton tai phan tu lon thu 2");
    }

    static void splitString(String str ){
        str = "geekss@for@geekss";
        String[] arrOfStr = str.split("@", 2);
        int intArray[] = new int[arrOfStr.length]; 
        for (int i=0;i<arrOfStr.length;i++){
            intArray[i] =Integer.parseInt(arrOfStr[i]);
        }
    }

}
