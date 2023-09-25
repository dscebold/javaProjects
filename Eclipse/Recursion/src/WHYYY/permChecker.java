package WHYYY;

public class permChecker {
    public static void main(String[] args) {
        System.out.println(checkCircularPerm("abcde", "bcdea"));

        int twoCount = 0, threeCount = 0, fiveCount = 0, twoThreeCount = 0, twoFiveCount = 0, threeFiveCount = 0, allCount = 0;

        for(int i = 1; i <= 100; i++) {
            if(i % 2 == 0) {
                twoCount++;
            }
            if(i % 3 == 0) {
                threeCount++;
            }
            if(i % 5 == 0) {
                fiveCount++;
            }
            if (i % 2 == 0 && i % 3 == 0){
                twoThreeCount++;
            }
            if(i % 2 == 0 && i % 5 == 0){
                twoFiveCount++;
            }
            if(i % 3 == 0 && i % 5 == 0){
                threeFiveCount++;
            }
            if(i % 2 == 0 && i % 3 == 0 && i % 5 == 0) {
                allCount++;
            }
        }
        System.out.println("Two Count: " + twoCount
                +"\nThree Count: " + threeCount
                + "\nFive Count: " + fiveCount
                + "\nTwo And Three Count: " + twoThreeCount
                + "\nTwo And Five Count: " + twoFiveCount
                + "\nThree and Five Count: " + threeFiveCount
                + "\nAll Count: " + allCount);
    }

    public static boolean checkCircularPerm(String firstPerm, String secondPerm) {
        return (firstPerm.substring(1).equals(secondPerm.substring(0, secondPerm.length()-1))
                && (firstPerm.charAt(0) == secondPerm.charAt(secondPerm.length() -1)));
    }
}
