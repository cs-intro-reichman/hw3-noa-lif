
public class LoanCalc {

    static double epsilon = 0.001;  // Approximation accuracy
    static int iterationCounter;    // Number of iterations 

    // Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
    public static void main(String[] args) {
        // Gets the loan data
        // double loan = Double.parseDouble(args[0]);
        // double rate = Double.parseDouble(args[1]);
        // int n = Integer.parseInt(args[2]);

        double loan = 100000;
        double rate = 3;
        int n = 12;

        System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);
        // Computes the periodical payment using brute force search
        System.out.print("\nPeriodical payment, using brute force: ");
        System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);
        // Computes the periodical payment using bisection search
        System.out.print("\nPeriodical payment, using bi-section search: ");
        System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);
    }

    // Computes the ending balance of a loan, given the loan amount, the periodical
    // interest rate (as a percentage), the number of periods (n), and the periodical payment.
    private static double endBalance(double loan, double rate, int n, double payment) {
        double balance = loan;
        while (n > 0) {
            balance -= payment;
            balance *= (1 + (rate / 100));
            n--;
        }
        return balance;
    }

    // Uses sequential search to compute an approximation of the periodical payment
    // that will bring the ending balance of a loan close to 0.
    // Given: the sum of the loan, the periodical interest rate (as a percentage),
    // the number of periods (n), and epsilon, the approximation's accuracy
    // Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        iterationCounter=0;
        double balance = loan;
        double payment = loan/(double)n;
        while (balance > epsilon) {
            balance = endBalance(loan, rate, n, payment);
            payment+=epsilon;
            iterationCounter++;
        }
        iterationCounter--;
        return payment-epsilon;
    }

    // Uses bisection search to compute an approximation of the periodical payment 
    // that will bring the ending balance of a loan close to 0.
    // Given: the sum of the loan, the periodical interest rate (as a percentage),
    // the number of periods (n), and epsilon, the approximation's accuracy
    // Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
        double lowPayment = loan / (double)n;
        double highPayment = loan;
        double midAmount = (lowPayment + highPayment) / 2;
        iterationCounter = 0;
        while (highPayment - lowPayment > epsilon) {
            midAmount = (lowPayment + highPayment) / 2;
            if (endBalance(loan, rate, n, midAmount) < 0) {
                highPayment = midAmount;
            } else {
                lowPayment = midAmount;
            }
            iterationCounter++;
        }
        return midAmount;
    }
}
