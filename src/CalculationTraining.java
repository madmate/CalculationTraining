import java.util.Scanner;

/**
 * Task out of computer science class
 * Generating random math training tasks for the first and second grade
 * first grade has only addition and subtraction and numbers up to 20
 * second grade has addition, subtraction, division and multiplication and numbers up to 100
 */
public class CalculationTraining {

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
        System.out.println("Are you in grade 1 or 2?");
        int gradeNum = in.nextInt();
        while (gradeNum > 2 || gradeNum < 1) {
            System.out.println("Wrong grade, try again!");
            gradeNum = in.nextInt();
        }

        boolean gradeOne = true;
        if (gradeNum == 2) gradeOne = false;

        System.out.println("How much tasks you want to do?");
        int tasks = in.nextInt();
        while (tasks < 1) {
            System.out.println("Task number to small");
            tasks = in.nextInt();
        }

        int correctTasks = 0;
        System.out.println("Tasks:");
        for (int i = 0; i < tasks; i++) {
            Node node = compute(gradeOne);

            System.out.print(node.num1 + " " + node.cS + " " + node.num2 + " = ");
            int input = in.nextInt();
            if (input == node.result) {
                System.out.println("Correct!");
                correctTasks++;
            } else {
                System.out.println("Wrong the correct result is " + node.result);
            }
        }
        evaluation(correctTasks, tasks);
    }

    public static void evaluation(int correctTasks, int tasks) {
        System.out.println("You have " + correctTasks + " from " + tasks + " correct!");
        long percent = Math.round(((double) correctTasks) / tasks * 100);
        System.out.println("That are " + percent + " %");
    }

    public static Node compute(boolean gradeOne) {
        if (gradeOne) {
            int random = (int) (Math.random() * 2);
            if (random == 0) return addition(true);
            else return subtraction(true);
        } else {
            int random = (int) (Math.random() * 4);
            switch (random) {
                case 0:
                    return addition(false);
                case 1:
                    return subtraction(false);
                case 2:
                    return multiplication();
                default:
                    return division();
            }
        }
    }

    public static Node addition(boolean gradeOne) {
        int size = 100;
        if (gradeOne) size = 20;
        int num1 = (int) (Math.random() * size + 1);
        int num2 = (int) (Math.random() * (size - num1));
        return new Node(num1, num2, '+', num1 + num2);

    }

    public static Node subtraction(boolean gradeOne) {
        int size = 100;
        if (gradeOne) size = 20;
        int num1 = (int) (Math.random() * size + 1);
        int num2 = (int) (Math.random() * num1 + 1);
        return new Node(num1, num2, '-', num1 - num2);
    }

    public static Node multiplication() {
        int size = 10;
        int num1 = (int) (Math.random() * size + 1);
        int num2 = (int) (Math.random() * size + 1);
        return new Node(num1, num2, '*', num1 * num2);
    }

    public static Node division() {
        int size = 10;
        int num2 = (int) (Math.random() * size + 1);
        int result = (int) (Math.random() * size + 1);
        return new Node(num2 * result, num2, '/', result);
    }
}
