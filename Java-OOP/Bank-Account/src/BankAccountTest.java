public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount(1000, 2000);
        System.out.println(account1);
        System.out.println(account2);
        account1.deposit("checking", 1500);
        System.out.println(account1);
        account2.withdraw("savings", 1750);
        System.out.println(account2);
        System.out.println(account1.getTotalBalance());
        System.out.println(account2.getTotalBalance());
        System.out.println(BankAccount.getAccountsTotalBalance());
    }
}
