/* Dasheng Lin
 * class StudentAccount represent the real student account which consist with library account and credit account
 */

public class StudentAccount extends Account
{
    // field that store the library account
    LibraryAccount libraryAccountOfStudent = new LibraryAccount("library account", 0, 0.0, 0.0);
    
    // field that store the tuition account 
    CreditAccount tuitionAccountOfStudent = new CreditAccount("tuition account", 0.0);
    
    // field that store the dining account
    CreditAccount diningAccountOfStudent = new CreditAccount("dining account", 0.0);
   
    // field that store the name of account
    private String accountName = "account name";

    // field that store the address of account
    private String accountAddress = "account address";

    // field that store the refund of account
    private double refundOfAccount = 200.0;
    
    public StudentAccount(String accountNumber, String accountName)
    {
        super(accountNumber, 0);
        this.accountName = accountName;
    }

    // the override of method from Account class, return the amount of balance after adding all balance and subtracting the refund.  
    public double getBalance()
    {
        return libraryAccountOfStudent.getBalance() + tuitionAccountOfStudent.getBalance() + diningAccountOfStudent.getBalance() - refundOfAccount;
    } 

    // method that interact the value subtracting input by refund to the balance of tuition account. 
    public void charge(double inputAmount)
    {
      double difference = this.refundOfAccount - inputAmount;
        if(difference > 0.0)
        {
            super.charge(difference);
            this.refundOfAccount = 0.0;
        }
        else
        {
            this.refundOfAccount = - difference;
        }
    }

    /* the following method reduce the balance with input following the sequence: library account, dining account and tuition account; For the 
     * dining account and tuition account, the amount of balance that equal to their monthly payment should remain; For the library account, the amount of balance should at least be 0.
    */ 
    public void credit(double inputAmount)
    {
      double diningDifference = diningAccountOfStudent.getAmountPaidThisMonth() - diningAccountOfStudent.getMonthlyPayment();
      double tuitionDifference = tuitionAccountOfStudent.getAmountPaidThisMonth() - tuitionAccountOfStudent.getMonthlyPayment();
        if(inputAmount - tuitionDifference > 0)
        {
            if(inputAmount - tuitionDifference - diningDifference > 0)
            {
                if(inputAmount - tuitionDifference - diningDifference - libraryAccountOfStudent.getBalance() > 0)
                {
                 
                    this.refundOfAccount += (inputAmount - tuitionDifference - diningDifference - libraryAccountOfStudent.getBalance());  
                    libraryAccountOfStudent.credit(libraryAccountOfStudent.getBalance());
                }
                else
                {
                    libraryAccountOfStudent.credit(inputAmount - tuitionDifference - diningDifference);
                }
            diningAccountOfStudent.credit(diningDifference);
            }
            else
            {
                diningAccountOfStudent.credit(inputAmount - tuitionDifference);
            }
        tuitionAccountOfStudent.credit(tuitionDifference);
        }
        else
        {
            tuitionAccountOfStudent.credit(inputAmount);
        }
    }

    // method that set the name of the account owner
    public void setName(String accountName)
    {
        this.accountName = accountName;
    }

    // method that return the name of the account owner
    public String getName()
    {
        return this.accountName;
    }
    
    // method that set the address of the account owner
    public void setAddress(String accountAddress)
    {
        this.accountAddress = accountAddress;
    }

    // method that get the address of the account owner
    public String getAddress()
    {
        return this.accountAddress;
    }

    // method that initial the library account 
    public void setLibraryAccount(LibraryAccount inputLibraryAccount)
    {
        this.libraryAccountOfStudent = inputLibraryAccount;
    } 

    // method that return the library account that associated with main account
    public LibraryAccount getLibraryAccount()
    {
        return this.libraryAccountOfStudent;
    }

    // method that initial the tuition account
    public void setTuitionAccount(CreditAccount inputCreditAccount)
    {
        this.tuitionAccountOfStudent = inputCreditAccount;
    }

    // method that return the tuition account that associated with main account
    public CreditAccount getTuitionAccount()
    {
        return this.tuitionAccountOfStudent;
    }

    // method that initial the dining account
    public void setDiningAccount(CreditAccount inputCreditAccount)
    {
        this.diningAccountOfStudent = inputCreditAccount;
    }

    // method that return the dining account
    public CreditAccount getDiningAccount()
    {
        return this.diningAccountOfStudent;
    }
}
