/* Dasheng Lin
 *  Account class is the basic account of the project that initial the 
 *  account number, balance limit and interaction of balance
 */

public class Account
{
    // field that store the account number of user
    private String accountNumber = "account number";

    // field that store the balance limit of user
    private int balanceLimit = 0;

    // field that store the current balance of user
    private int balanceCurrent = 0;

    // a constructor that create an instance with Account type
    public Account (String accountNumberInput, int balanceLimitInput)
    {
        this.accountNumber = accountNumberInput;
        this.balanceLimit = balanceLimitInput;
    }       

    // a method that return one's account number 
    public String getAccountNumber()
    {
        return this.accountNumber;
    }

    // a method that return one's current balance
    public double getBalance()
    {
        return this.balanceCurrent;
    }


    // increase the current balance by input value
    public void charge(double balanceIncrease)
    {
        this.balanceCurrent += balanceIncrease; 
    }

    // decrease the current balance by input value 
    public void credit(double balanceDecrease)
    {
        this.balanceCurrent -= balanceDecrease;
    }

    // set the limitation of balance to be input value 
    public void setBalanceLimit(int balanceLimit)
    {
        this.balanceLimit = balanceLimit;
    }

    // return the limit of balance of the account
    public int getBalanceLimit()
    {
        return this.balanceLimit;
    }
}
