package practicequestion;

public class practice1 {

    public static void main(String[] args) {

        DigitalWallet wallet = new PremiumWallet(1, "Yashashvi");
        DigitalWallet bw = new BasicWallet(2, "Sankalp");

        try
        {
            wallet.transfer(200);
            wallet.addMoney(1000);
            bw.addMoney(100);
            bw.transfer(300);
        }
        catch(InvalidAmountException e)
        {
            System.out.println("Invalid amount entered: "+e.getMessage());
        }
        catch(InsufficientBalanceException e)
        {
            System.out.println("Not enough balance: "+e.getMessage());
        }
        finally
        {
            System.out.println("Transaction attempt finished.");
        }
    }
}

class InvalidAmountException extends Exception
{
    private double amount;

    public InvalidAmountException(double amount) {

        super("invalid amount: " + amount);
        this.amount = amount;
    }
}

class InsufficientBalanceException extends RuntimeException
{
    double amount;

    public InsufficientBalanceException(double amount) {
        super("insufficient balance for amount: " + amount);
        this.amount = amount;
    }
}
interface WalletOperations
{
   void transfer(double amount) throws InvalidAmountException, InsufficientBalanceException;
   void addMoney(double amount) throws InvalidAmountException;
}

abstract class DigitalWallet implements WalletOperations
{
    private int id;
    private String name;
    private double balance;

    public DigitalWallet(int id, String name) {
        this.id = id;
        this.name = name;
        this.balance = 0;
    }


   // implemeting deposist and withdraw because, we cannot make balance public

    protected void deposit(double amount)
    {
        this.balance += amount;
    }
    protected void withdraw(double amount)
    {
        this.balance -= amount;
    }


    public void transfer(double amount) throws InvalidAmountException, InsufficientBalanceException
    {
        if(amount <= 0)
        {
            throw new InvalidAmountException(amount);
        }
        if(amount > balance)
        {
            throw new InsufficientBalanceException(amount);
        }
        withdraw(amount);
    }

    public void addMoney(double amount) throws InvalidAmountException
    {
        if(amount <= 0)
        {
            throw new InvalidAmountException(amount);
        }
        deposit(amount);
    }
}
class BasicWallet extends DigitalWallet
{
    public BasicWallet(int id, String name) {
        super(id, name);
    }
    public void transfer(double amount, String remark)
            throws InvalidAmountException, InsufficientBalanceException
    {
        System.out.println("Basic Wallet - Remark: "+ remark);
        super.transfer(amount);
    }

    public void addMoney(double amount, String method) throws InvalidAmountException
    {
        System.out.println("Basic Wallet- Adding via: "+ method);
        super.addMoney(amount);
    }
}
class PremiumWallet extends DigitalWallet
{
    public PremiumWallet(int id, String name) {
        super(id, name);
    }

    @Override
    public void addMoney(double amount) throws InvalidAmountException
    {
        super.addMoney(amount);
        double bonus = amount * 0.02; // 2% cashback
        deposit(bonus);
        System.out.println("Premium bonus added: "+ bonus);
    }
    public void addMoney(double amount, String method) throws InvalidAmountException
    {
        System.out.println("Premium Wallet added via: "+ method);
        addMoney(amount);
    }
    public void transfer(double amount, String remark)
            throws InvalidAmountException, InsufficientBalanceException
    {
        System.out.println("Premium Wallet - Remark: "+ remark);
        super.transfer(amount);
    }
}

