package cop2805;

public class CCulpHomework1 {
    public static double computeIncome(double salesAmount) {

        // Base and commission rates stored as constants
        final double BASE_RATE = 5000.00;
        final double COMMISSION_RATE_1 = 0.08;
        final double COMMISSION_RATE_2 = 0.10;
        final double COMMISSION_RATE_3 = 0.12;
        final double COMMISSION_CAP_1 = 5000.00;
        final double COMMISSION_CAP_2 = 10000.00;

        double totalCommission = BASE_RATE;


        if (salesAmount > COMMISSION_CAP_2) {
            // Get commission for the amount above the second tier, bring overage down to second tier.
            totalCommission += ((salesAmount - COMMISSION_CAP_2) * COMMISSION_RATE_3);
            salesAmount = COMMISSION_CAP_2;
        }
        if (salesAmount > COMMISSION_CAP_1) {
            totalCommission += ((salesAmount - COMMISSION_CAP_1) * COMMISSION_RATE_2);
            salesAmount = COMMISSION_CAP_1;
        }

        totalCommission += salesAmount * COMMISSION_RATE_1;

        return totalCommission;
    }

    public static void main(String[] args) {
        double sales = 1000.00;
        double income;

        System.out.println("Sales            Income");
        System.out.println("------------------------");
        do {
            income = computeIncome(sales);
            System.out.printf("$%-10.2f    $%.2f\n", sales, income);
            sales += 1000.00;
        } while (sales <= 20000.00);
    }
}
