package exceptionalhandling;

public class customexceptionpractice {

    public static void main(String[] args) {
        BankAccount b = new BankAccount(10);

        try {
            b.withdraw(11);
        } catch (InsufficientFundsException e) {
            System.out.println(e);
        }
    }
}
//custom exception
class InsufficientFundsException extends Exception
{
    private String message;
    private double amount;
    public InsufficientFundsException(String message, double amount) {
        super(message);
        this.amount = amount;

    }
}


class BankAccount
{
    private double balance;


    public BankAccount(double amount) {
        this.balance = amount;
    }
    public void withdraw(int amount) throws InsufficientFundsException
    {
        if(amount > balance)
        {
            throw new InsufficientFundsException("insuffiencint balance", amount);
        }
        balance-=amount;
    }

}

