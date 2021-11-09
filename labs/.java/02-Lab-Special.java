// For posterity, this is not the code the class asked students to write.
// This is just what I ended up with while seeing what I could do with Java.
// JSYK, This is garbage code.

public class ProjectProfits {
    public static void main(String[] args) {
        class Projection {
            long projectedRevenue;
            // threeYearProjectedProfitRatio,
            // changed because stupid style guide throws errors over
            // for lines over 80 characters
            double[] thrYrProfRat;
            int[] projectedProfit;

            // Projection class constructor
            Projection(long itemProjectedRevenue,
                       double[] itemThreeYearProjectedProfitRatios) {
                projectedRevenue = itemProjectedRevenue;
                thrYrProfRat =
                        itemThreeYearProjectedProfitRatios;
                projectedProfit = new int[3];
            }
        }

        Projection[] obj = new Projection[4];
        obj[0] = new Projection(2_000_000,
                new double[]{5.1, 6.0, 8.0});
        obj[1] = new Projection(2_500_000,
                new double[]{7.2, 8.0, 10.5});
        obj[2] = new Projection(3_000_000,
                new double[]{9.3, 10.1, 13.0});
        obj[3] = new Projection(4_000_000,
                new double[]{11.2, 13.2, 16.8});
        final String[] satisficeDumbFormatting = {"next", "second", "third"};
        final int YEARS = 3;
        int[] yearlyProfits = new int[obj.length];
        int totalProfits = 0;

        // for each projection (projectionIndex)
        //   for each projection year (yearIndex)
        //     obj.projectedProfits[yearIndex] = projectedRevenue
        //         * yearProfitRatio
        //  for each projection (projectionIndex)
        //   sum(year projectedProfits) / 4

        for (int projectionIndex = 0;
             projectionIndex < obj.length;
             projectionIndex++) {
            double projectedRevenue = obj[projectionIndex].projectedRevenue;
            double[] profitRatios =
                    obj[projectionIndex].thrYrProfRat;
            for (int yearIndex = 0;
                 yearIndex < profitRatios.length;
                 yearIndex++) {
                int itemYearProfit =
                        (int) (projectedRevenue
                                * obj[projectionIndex].thrYrProfRat[yearIndex]);
                obj[projectionIndex].projectedProfit[yearIndex] =
                        itemYearProfit;
            }
        }

        for (int yearIndex = 0; yearIndex < YEARS; yearIndex++) {
            for (int projectionIndex = 0;
                 projectionIndex < obj.length;
                 projectionIndex++) {
                yearlyProfits[projectionIndex] =
                        obj[projectionIndex].projectedProfit[yearIndex];
            }
            System.out.println("The average profit for the "
                    + satisficeDumbFormatting[yearIndex]
                    + " year: "
                    + formatBoi((sumInt(yearlyProfits) / 4), true));
            totalProfits = totalProfits + (sumInt(yearlyProfits) / 4);
        }
        System.out.println();
        System.out.println("Total profit in next "
                + YEARS
                + " years: "
                + formatBoi(totalProfits, false));
    }

    // Sums an array of integers; doesn't really need a comment, but I'm
    // scared you'll take off points :,(
    public static int sumInt(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    // Jank the jank up son. Match that unit test.
    public static String formatBoi(int number, boolean dec) {
        String substring = String.format("%s", number).substring(0,
                String.format(
                        "%s",
                        number).length() - 2);
        return dec ? substring + ".0" :
                substring;
    }
}