/**
 * Created by Markus on 15/06/2017.
 */
public class UnitTest {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            CalculationTraining.divisionReverseMulti();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("divisionReverseMulti time = " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            CalculationTraining.division();
        }
        endTime = System.currentTimeMillis();
        System.out.println("divisionSqrt time = " + (endTime - startTime));
    }
}
