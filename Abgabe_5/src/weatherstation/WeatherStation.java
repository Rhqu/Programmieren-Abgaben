package weatherstation;

public class WeatherStation {
    public static void main(String[] args) {
        // @formatter:off
        int[][] dailyMeanTemperatures = {
                { -3, 2, 6, 3, -1, 0, 4, 9, 9, 13, 5, 7, 11, 8, 10, 7, 4, 1, 1, 1, 1, 1, 1, 1, 2, 1, 3, 4, 4, 3, 3 },
                { 2, 1, 0, -1, -1, 0, -2, -2, 0, 2, 0, -1, 1, 6, 1, 1, 1, 2, 2, 7, 5, 3, 4, 5, 5, 5, 5, 4 },
                { 8, 9, 8, 5, 4, 4, 5, 7, 8, 9, 8, 6, 5, 4, 4, 6, 9, 10, 10, 8, 8, 7, 9, 9, 8, 6, 8, 8, 11, 11, 12 },
                { 7, 6, 6, 6, 5, 5, 6, 8, 12, 15, 14, 15, 14, 15, 17, 19, 13, 10, 12, 13, 14, 14, 12, 14, 14, 16, 15, 9, 10, 13 },
                { 10, 12, 16, 19, 18, 16, 15, 16, 17, 17, 19, 22, 20, 18, 10, 14, 16, 17, 15, 11, 12, 13, 15, 16, 16, 13, 12, 15, 18, 16, 17 },
                { 18, 21, 23, 21, 25, 24, 23, 16, 16, 17, 21, 21, 21, 21, 18, 17, 17, 16, 16, 14, 16, 18, 15, 16, 18, 20, 21, 21, 22, 24 },
                { 26, 28, 29, 29, 30, 26, 27, 22, 20, 19, 24, 23, 22, 24, 24, 26, 29, 25, 24, 26, 27, 25, 22, 24, 21, 17, 19, 19, 16, 17, 17 },
                { 18, 21, 24, 21, 22, 27, 29, 27, 23, 22, 24, 25, 25, 21, 19, 16, 17, 16, 17, 18, 19, 20, 18, 17, 18, 19, 24, 25, 23, 26, 26 },
                { 22, 17, 17, 16, 14, 13, 13, 15, 16, 15, 15, 19, 18, 16, 15, 17, 16, 16, 14, 14, 14, 15, 12, 14, 13, 15, 14, 12, 14, 12 },
                { 10, 11, 16, 14, 15, 18, 16, 12, 12, 12, 12, 9, 8, 7, 5, 7, 6, 8, 8, 6, 7, 10, 12, 12, 15, 8, 8, 10, 12, 8, 9 },
                { 7, 7, 6, 10, 12, 16, 18, 16, 17, 13, 9, 8, 11, 11, 14, 15, 14, 15, 15, 12, 4, 3, 2, 0, 4, 4, -1, 3, 8, 10 },
                { 11, 8, 2, 9, 7, 11, 10, 7, 8, 1, 9, 9, 6, 3, 8, 12, 13, 12, 8, 10, 11, 12, 12, 11, 12, 11, 9, 4, 7, 4, 7 } };
        // @formatter:on

        int daysInYear = 0;
        for (int[] month : dailyMeanTemperatures) {
            daysInYear += month.length;
        }
        System.out.println("Die Anzahl der Tage im gegebenen Jahr ist: " + daysInYear);

        double summedTemperature = 0;
        for (int[] month : dailyMeanTemperatures) {
            for (int day : month) {
                summedTemperature += day;
            }
        }
        double averageTemperature = (double) Math.round((summedTemperature / daysInYear) * 10) / 10;
        System.out.println("Jahresdurchschnittstemperatur: " + averageTemperature + " Grad");

        double[] avaregeTemperatures = new double[12];
        for (int month = 0; month < dailyMeanTemperatures.length; month++) {
            double temp = 0;
            for (int day : dailyMeanTemperatures[month]) {
                temp += day;
            }
            avaregeTemperatures[month] = temp / dailyMeanTemperatures[month].length;
        }
        System.out.println("Monatsdurchschnittstemperaturen:");
        for (int tempIndex = 0; tempIndex < avaregeTemperatures.length; tempIndex++) {
            System.out.printf("* Monat %d: %.1f Grad\n", tempIndex + 1, avaregeTemperatures[tempIndex]);
        }

        int warmestDay = dailyMeanTemperatures[0][0];
        int warmestDayIndex = 0;
        int warmestMonthofDay = 0;
        for (int month = 0; month < dailyMeanTemperatures.length; month++) {
            for (int day = 0; day < dailyMeanTemperatures[month].length; day++) {
                if (dailyMeanTemperatures[month][day] > warmestDay) {
                    warmestDay = dailyMeanTemperatures[month][day];
                    warmestDayIndex = day;
                    warmestMonthofDay = month;

                }
            }
        }
        System.out.printf("Wärmster Tag am %d.%d.2015 mit %d Grad.\n", warmestDayIndex + 1, warmestMonthofDay + 1, warmestDay);
        int[] temperatures = new int[daysInYear];
        int counter = 0;
        for (int[] month : dailyMeanTemperatures) {
            for (int day : month) {
                temperatures[counter] = day;
                counter++;
            }
        }
        System.out.print("Temperaturen an allen Tagen, die durch hundert teilbar sind:\n* ");
        for (int day = 99; day < temperatures.length; day += 100) {
            if (day < 299) {
                System.out.printf("Tag %d: %d Grad, ", day + 1, temperatures[day]);
            } else {
                System.out.printf("Tag %d: %d Grad\n", day + 1, temperatures[day]);
            }
        }
        int[] sorted = new int[daysInYear];

        for (int dayInSorted = 0; dayInSorted < temperatures.length; dayInSorted++) {
            int maxTemperature = 0;
            int indexOfHighestTemperature = 0;
            for (int dayInTemperatures = 0; dayInTemperatures < temperatures.length; dayInTemperatures++) {
                if (temperatures[dayInTemperatures] > maxTemperature) {
                    maxTemperature = temperatures[dayInTemperatures];
                    indexOfHighestTemperature = dayInTemperatures;
                }
            }
            sorted[dayInSorted] = maxTemperature;
            temperatures[indexOfHighestTemperature] = -100;
        }
        System.out.print("Die fünf wärmsten Tage:\n* ");
        for (int day = 0; day < 5; day++) {
            if (day < 4) {
                System.out.print(sorted[day] + " Grad" + ", ");
            } else {
                System.out.print(sorted[day] + " Grad");
            }
        }

    }
}
