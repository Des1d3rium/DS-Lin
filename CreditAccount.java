/* Dasheng Lin
 * Class CreditAccount represent how the money flow, including the 
 * interaction of interest rate and amount paid this month.
 */ 

public class CreditAccount extends Account 
{
    // field that store amount paid this month
    private double amountPaidThisMonth = 0.0;
    
    // field that store the amount should be paid this month in order to avoid the interest fee. I initial it with 50 per month
    private double monthlyPayment = 50.0;

    // field that store the interest rate. I set its initial value to be 0.03  
    private double interestRate = 0.03;

    public CreditAccount(String accountNumber, double interestRate)
    {
        super(accountNumber, 0);
        this.interestRate = interestRate;
    }

    // method that not only decrease the balance but also increase the amount paid this month.
    public void credit(double balanceDecrease)
    {
        super.credit(balanceDecrease);
        this.amountPaidThisMonth += balanceDecrease;
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

    // method that return how much the account need to pay monthly in order to avoid the interest fee.
    public double getMonthlyPayment()
    {
        return this.monthlyPayment;
    }

    // method that return the amount paid this month
    public double getAmountPaidThisMonth()
    {
        return this.amountPaidThisMonth;
    }

    // method that check for an interest charge. After that, the method change the monthly payment and amount paid this month.
    public void endOfMonth()
    {  
        if(this.getAmountPaidThisMonth() < this.getMonthlyPayment());
        {
            this.charge(this.getBalance()*this.getInterestRate()/12);
        }
        this.monthlyPayment = this.getBalance();
        this.amountPaidThisMonth = 0.0;
    }
}