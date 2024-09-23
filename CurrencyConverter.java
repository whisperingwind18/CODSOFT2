import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    // Hardcoded exchange rates (1 unit of base currency to target currency)
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 1.0); // Base currency
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("JPY", 110.0);
        exchangeRates.put("INR", 74.0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input base and target currencies
        System.out.print("Enter base currency (e.g., USD): ");
        String baseCurrency = scanner.next().toUpperCase();
        System.out.print("Enter target currency (e.g., EUR): ");
        String targetCurrency = scanner.next().toUpperCase();

        // Input amount
        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Error: One or both currencies are not supported.");
            scanner.close();
            return;
        }

        // Convert amount
        double convertedAmount = (amount / exchangeRates.get(baseCurrency)) * exchangeRates.get(targetCurrency);

        // Display result
        System.out.printf("%.2f %s = %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);
        scanner.close();
    }
}
