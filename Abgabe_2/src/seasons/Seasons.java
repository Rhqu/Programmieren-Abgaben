package seasons;

public class Seasons {
    public static void main(String[] main){
        int month = 1;
        String season = "";
        switch (month){
            case 12:
            case 1:
            case 2:
                season = "Winter";
            case 3:
            case 4:
            case 5:
                season = "Frühling";
            case 6:
            case 7:
            case 8:
                season = "Sommer";
            case 9:
            case 10:
            case 11:
                season = "Herbst";
            default:
                System.out.print("Falscher Monat!");
                System.exit(1);

            System.out.print("Der " + month + ". Monat ist " + season);

        }
    }
}
