package practicequestion;
import java.util.*;

public class BankTransactionProcessor {

    public static void main(String[] args)
    {
       Scanner sc = new Scanner(System.in);
       System.out.println("enter no of transaction to execute: ");
       int n = sc.nextInt();

       for(int i = 0; i < n; i++)
       {

       }

    }


}
class Account extends BankAccount
{
    public Account(int accnumber, String name, double balance) {
        super(accnumber, name, balance);
    }
}
interface TransactionOperations
{
    void depositmoney(double amount) throws InvalidTransactionException;
    void withdrawmoney(double amount) throws InvalidTransactionException, InsufficientBalanceException;
}

abstract class BankAccount implements TransactionOperations
{
    private int accnumber;
    private String name;
    private double balance;

    public BankAccount(int accnumber, String name, double balance) {
        this.accnumber = accnumber;
        this.name = name;
        this.balance = balance;
    }
    // Helper-method -->
    protected void withdraw(double amount)
    {
        balance-=amount;
    }
    protected void deposit(double amount)
    {
        balance+=amount;
    }
    @Override
    public void depositmoney(double amount) throws InvalidTransactionException {

        if(amount <=0)
        {
            throw new InvalidTransactionException(amount);
        }
        deposit(amount);
    }
    @Override
    public void withdrawmoney(double amount)throws InsufficientBalanceException, InvalidTransactionException
    {
        if(amount >=0)
        {
            throw new InvalidTransactionException(amount);
        }
        if(amount > balance)
        {
            throw new InsufficientBalanceException(amount);
        }
        withdraw(amount);
    }

}
