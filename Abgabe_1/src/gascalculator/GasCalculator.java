package gascalculator;

public class GasCalculator {
    public static void main(String[] args) {
        float km = 992.7F;
        float consumedGasInLiters = 87.1F;
        float averageConsumptionIn100Km = consumedGasInLiters / km * 100;
        System.out.print("---Benzinrechner---"
                + "\nGefahrene Kilometer: " + km
                + "\nVerbrauchtes Benzin: " + consumedGasInLiters
                + "\nIhr Auto hat einen Verbrauch von " + averageConsumptionIn100Km
                + " Litern Benzin pro 100 Kilometer.");
    }
}
