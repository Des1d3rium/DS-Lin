public class CreditAccount
{
    // field that store amount paid this month
    private double amountPaidThisMonth;

    public CreditAccount(String accountNumber, double interestRate)
    {
        super(accountNumber, 0);
        this.interestRate = interestRate;
    }

    @override
    public void credit(double creditAmount)
    {
        super.credit(creditAmount);
        this.amountPaidThisMonth = creditAmount;
    } 

    // method that set the interest rate
    public void setInterestRate(double interestRate)
    {
        this.interestRate = interestRate;
    }

    // method that return the interest rate of account
    public double getInterestRate()
    {
        return this.interestRate;
    }

    // method that return how much the account need to pay monthly
    public double getMonthlyPayment()
    {
        if(this.getBalance()<0)
        {
            return this.getBalance();
        }
        else
        {
            return 0.0;
        }
    }

    // method that return the amount paid this month
    public double getAmountPaidThisMonth()
    {
        return amountPaidThisMonth();
    }

    // method that 
    public void endOfMonth()
    {  
        if(this.getAmountPaidThisMonth() < this.getMonthlyPayment());
        {
            this.charge(this.getBalance()*this.getInterestRate()/12);
        }
        // setting the monthly payment to be equal;
        this.amountPaidThisMonth = 0;
    }
}