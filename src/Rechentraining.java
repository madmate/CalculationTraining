import java.util.Scanner;

/**
 * Created by markus on 15.06.17.
 */
public class Rechentraining {

    private static class Node {
        int num1;
        int num2;
        char cS;
        int result;

        public Node(int num1, int num2, char cS, int result) {
            this.num1 = num1;
            this.num2 = num2;
            this.cS = cS;
            this.result = result;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Are you in class 1 or 2?");
        int classNum = in.nextInt();
        while (classNum > 2 || classNum < 1) {
            System.out.println("Wrong class, try again!");
            classNum = in.nextInt();
        }

        boolean classOne = true;
        if (classNum == 2) classOne = false;

        System.out.println("How much tasks you want to do?");
        int tasks = in.nextInt();
        while (tasks < 1) {
            System.out.println("Task number to small");
            tasks = in.nextInt();
        }

        for (int i = 0; i < tasks; i++) {

        }

    }

    public static Node computeSign(boolean classOne) {
        if (classOne) {
            int random = (int) (Math.random()*2);
            if (random == 0) return addition(true);
            else return subtraction(true);
        } else {
            int random = (int) (Math.random()*4);
            switch(random) {
                case 0: return addition(false);
                case 1: return subtraction(false);
                case 2: return multiplication();
                default: return division();

            }
        }
    }

    public static Node addition(boolean classOne) {
        int size = 100;
        if (classOne) size = 200;

        int num1 = (int) (Math.random() * size + 1);
        int num2 = size - num1;
        return new Node(num1, num2, '+', num1+num2);

    }

    public static Node subtraction(boolean classOne) {
        int size = 100;
        if (classOne) size = 20;

        int num1 = (int) (Math.random() * size + 1);
        int num2 = (int) (Math.random() * num1 + 1);
        return new Node(num1, num2, '-', num1-num2);
    }

    public static Node multiplication() {
        int size = 10;

        int num1 = (int) (Math.random() * size + 1);
        int num2 = (int) (Math.random() * size + 1);
        return new Node(num1, num2, '*', num1*num2);
    }

    public static Node division() {
        int num1 = (int) (Math.random() * 100 + 1);
        int num2 = (int) (Math.random() * Math.sqrt(num1) + 1);
        return new Node(num1, num2, '-', num1/num2);
    }
}
