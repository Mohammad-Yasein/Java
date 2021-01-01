import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;

public class BankAccount implements Serializable {
    private String accountNum = "";
    private double checkingBalance = 0;
    private double savingsBalance = 0;
    private static int numOfAccounts = 0;
    private static final HashMap<String, Double> accountsTotalBalance = new HashMap<>();

    public BankAccount() {
        accountNum = getRandomAccountNum();
        accountsTotalBalance.put(accountNum, 0.0);
        numOfAccounts++;
    }

    public BankAccount(double checkingBalance, double savingsBalance) {
        accountNum = getRandomAccountNum();
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        accountsTotalBalance.put(accountNum, checkingBalance + savingsBalance);
        numOfAccounts++;
    }

    private String getRandomAccountNum() {
        Random random = new Random();
        return ((long) (random.nextDouble() * 9000000000L) + 1000000000L) + "";
    }

    public void deposit(String accountType, double amount) {
        if (accountType.equals("checking")) {
            checkingBalance += amount;
        } else if (accountType.equals("savings")) {
            savingsBalance += amount;
        } else {
            return;
        }
        accountsTotalBalance.put(accountNum, checkingBalance + savingsBalance);
    }

    public void withdraw(String accountType, double amount) {
        if (accountType.equals("checking") && checkingBalance >= amount) {
            checkingBalance -= amount;
        } else if (accountType.equals("savings") && savingsBalance >= amount) {
            savingsBalance -= amount;
        } else {
            return;
        }
        accountsTotalBalance.put(accountNum, checkingBalance + savingsBalance);
    }

    public double getTotalBalance() {
        return checkingBalance + savingsBalance;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public static int getNumOfAccounts() {
        return numOfAccounts;
    }

    public static HashMap<String, Double> getAccountsTotalBalance() {
        return accountsTotalBalance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNum='" + accountNum + '\'' +
                ", checkingBalance=" + checkingBalance +
                ", savingsBalance=" + savingsBalance +
                '}';
    }
}
