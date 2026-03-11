package practicequestion;

public class practice2 {

    public static void main(String[]args) {
        ATMAccount aa = new SavingsAccount(1001, "abby", 2000, "2004");

        try {
            aa.withdrawmoney(200);
            aa.withdrawmoney(134, "2005");
            aa.withdrawmoney(2000);

            aa.withdrawmoney(123, "2004");
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (InvalidTransactionException e) {
            System.out.println(e.getMessage());
        }
        finally
        {
            System.out.println("ATM Transactions Completed Succesfully.");
        }
    }
}

class InvalidTransactionException extends Exception
{
    private double amount;
    public InvalidTransactionException(double amount) {
        super("invalid transaction: "+amount);
        this.amount = amount;
    }
}

interface ATMOperations
{
    // overloading methods in interface only, because in this ATMaccount is refrence for pin
    void withdrawmoney(double amount) throws InvalidTransactionException, InsufficientBalanceException;
    void withdrawmoney(double amount, String pin)throws InvalidTransactionException;

//    void depositmoney(double amount);
//    void transferfunds(double amount);
    //void CheckBalance();

}
abstract class ATMAccount implements ATMOperations
{
    private int accountnum;
    private String name;
    private double balance;
    private String pin;
    private double dailywithdraw= 0;

    public ATMAccount(int accountnum, String name, double balance, String pin) {
        this.accountnum = accountnum;
        this.name = name;
        this.balance = balance;
        this.pin = pin;
    }
    protected void withdraw(double amount)
    {
        balance-=amount;
    }
    protected double getBalance() {
        return balance;
    }
    protected boolean verifyPin(String enteredPin)
    {
        return this.pin.equals(enteredPin);
    }
    protected void updatedailywithdraw(double amount)
    {
        this.dailywithdraw+=amount;
    }

    protected double getDailywithdraw() {
        return dailywithdraw;
    }
    public abstract double getDailyLimit();

    //    public void depositmoney(double amount)
//    {
//        if(amount <=0)
//        {
//
//        }
//        deposit(amount);
//    }
//    public void withdrawmoney(double amount)
//    {
//        if(amount > balance)
//        {
//
//        }
//        if(amount > dailylimit)
//        {
//
//        }
//        withdraw(amount);
//    }
//
//    public void transferfunds(double amount)
//    {
//        if(amount > balance)
//        {
//
//        }
//        withdraw(amount);
//    }
}

class SavingsAccount extends ATMAccount
{

    public SavingsAccount(int accountnum, String name, double balance, String pin) {
        super(accountnum, name, balance, pin);
    }

    @Override
    public double getDailyLimit()
    {
        return 10000;
    }
    public void withdrawmoney(double amount) throws InvalidTransactionException, InsufficientBalanceException
    {
        if(amount <= 0)
        {
            throw new InvalidTransactionException(amount);
        }
        if(amount > getBalance())
        {
            throw new InsufficientBalanceException(amount);
        }
        if(getDailywithdraw()+amount > getDailyLimit())
        {
            throw new InvalidTransactionException(amount);
        }
        withdraw(amount);
        updatedailywithdraw(amount);

    }
    public void withdrawmoney(double amount, String pin) throws InvalidTransactionException
    {

        if(!verifyPin(pin) )
        {
            throw new InvalidTransactionException(amount);
        }
        withdrawmoney(amount);
    }
}

