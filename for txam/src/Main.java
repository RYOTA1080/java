//import java.util.Scanner;
//import java.util.InputMismatchException;
//
//public class Main {
//    public static void main(String[] args){
//    Scanner scanner = new Scanner(System.in);
//
//      try {
//        System.out.println("Добавте первое целое число: ");
//        int a = scanner.nextInt();
//
//        System.out.println("Добавте второе целое число: ");
//        int b = scanner.nextInt();
//        System.out.println("Сумма: " + (a + b));
//        System.out.println("РАзность: " + (a - b));
//        System.out.println("Произведение: " + (a * b));
//        if (b != 0) {
//            System.out.printf("Частное: %.1f%n" , (double) a/b);
//        }else {
//            System.out.println("Ошибка: деление на ноль!");
//        }
//      }catch (InputMismatchException exception){
//          System.out.println("Ошибка: нужно вводить только целые числа!");
//      }
//      scanner.close();
//    }
//}

//import java.util.Scanner;
//import java.util.InputMismatchException;
//
//public class Main{
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//
//        try{
//            System.out.print("0=100: ");
//            int ball = scanner.nextInt();
//
//            if(ball <0 || ball > 100){
//                System.out.print("Error: invalid ball number");
//
//            } else {
//                int mark;
//
//                if (ball <= 40) {
//                    mark = 2;
//                }else if (ball <= 60) {
//                    mark = 3;
//                }else if (ball <= 80){
//                    mark = 4;
//                }else {
//                    mark = 5;
//                }
//                System.out.println("Mark: " + mark);
//
//                switch(mark){
//                    case 2:
//                        System.out.println("bad");
//                        break;
//                    case 3:
//                        System.out.println("Normal");
//                        break;
//                    case 4:
//                        System.out.println("Good");
//                        break;
//                    case 5:
//                        System.out.println("Great");
//                        break;
//
//                }
//            }
//
//        } catch (InputMismatchException exception){
//            System.out.println("Error: enter whole number");
//
//        }
//        scanner.close();
//    }
//}
//
//import java.util.Scanner;
//
//public class Main{
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//
//        try{
//            System.out.print("Enter numbers separated by spaces: ");
//            String[] input = scanner.nextLine().split(" ");
//
//            int[] nums = new int[input.length];
//
//            for (int i = 0; i < input.length; i++){
//                nums[i] = Integer.parseInt(input[i]);
//            }
//            int total = 0;
//            int minimum = nums[0];
//            int maximum = nums[0];
//            int positive = 0;
//
//            for (int x :nums){
//                total += x;
//
//                if (x < minimum){
//                    minimum = x;
//                }
//                if (x > maximum){
//                    maximum = x;
//                }
//                if ( x> 0){
//                    positive++;
//                }
//            }
//
//            double average = (double) total / nums.length;
//
//            System.out.println("Count: " + nums.length);
//            System.out.println("Sun: " + total);
//            System.out.printf("average: %.2f%n", average);
//            System.out.println("Minimum: " + minimum);
//            System.out.println("maximum:" + maximum);
//            System.out.println("positive: " + positive);
//
//
//        } catch (NumberFormatException exception){
//            System.out.println("Error: enter only intrgers");
//        }
//        scanner.close();
//    }
//}

