package week11_08;

public class Harshad {

    /*

    A number is said to be Harshad if it's exactly divisible
    by the sum of its digits. Create a function that determines
    whether a number is a Harshad or not.

     */

    // 1) without recursion
    public static boolean isHarshad(int number){

        int sum = 0;
        int quotient = number;
        while(quotient > 0){
            sum += quotient % 10;
            quotient = (quotient/10);
        }

        return number % sum == 0;
    }

    /* *************************************************************************** */

    // 2 with recursion

    public static boolean isItHarshad(int number){

        return number % getSum(number) == 0;

    }

    public static int getSum(int number){

        if(number/10 > 0){
            return (number % 10) + getSum(number / 10);
        }
        else return number % 10;
    }

/* ************************************************************************************ */

    public static void main(String[] args) {

        System.out.println(isHarshad(481));
        System.out.println(isItHarshad(89));

    }
}
