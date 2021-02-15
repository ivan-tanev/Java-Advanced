public class BankAccount {
    private final static double default_interest_rate = 0.02;
    private static double interestRate = default_interest_rate;
    private static int bankAccountCount = 1;
    private int Id;
    private double balance;

    private BankAccount (){
        this.Id = bankAccountCount++;
    }

    public static void setInterestRate(double interest){
        BankAccount.interestRate = interest;
    }

    public double getInterest (int years){
        return BankAccount.interestRate * years * this.balance;
    }

    public void deposit (double amount){
        this.balance += amount;
    }
}
