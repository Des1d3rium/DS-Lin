public class StudentAccount extends Account
{
    LibraryAccount libraryAccountOfStudent = new LibraryAccount("", 0, 0.0, 0.0);
    CreditAccount tuitionAccountOfStudent = new CreditAccount("", 0.0);
    CreditAccount diningAccountOfStudent = new CreditAccount("", 0.0);
    private String accountName;
    private String accountAddress;
    private double refundOfAccount;
    
    public StudentAccount(String accountNumber, String accountName)
    {
        super(accountNumber, 0);
        this.accountName = accountName;
    }

    public double getBalance()
    {
        return libraryAccountOfStudent.getBalance()+tuitionAccountOfStudent.getBalance()+diningAccountOfStudent.getBalance() - refundOfAccount;
    } 


    public void charge(double inputAmount)
    {
        if(inputAmount > refundOfAccount)
        {
            tuitionAccountOfStudent.charge(inputAmount);
            this.refundOfAccount = 0;
        }
        else
        {
            tuitionAccountOfStudent.credit(inputAmount);
        }
    }


    public void credit(double inputAmount)
    {
        if(inputAmount - tuitionAccountOfStudent.getMonthlyPayment() > 0)
        {
            if(inputAmount - tuitionAccountOfStudent.getMonthlyPayment() - diningAccountOfStudent.getMonthlyPayment() > 0)
            {
                if(inputAmount - tuitionAccountOfStudent.getMonthlyPayment() - diningAccountOfStudent.getMonthlyPayment() - libraryAccountOfStudent.getBalance() > 0)
                {
                 
                this.refundOfAccount = inputAmount - tuitionAccountOfStudent.getMonthlyPayment() - diningAccountOfStudent.getMonthlyPayment() - libraryAccountOfStudent.getBalance();  
                libraryAccountOfStudent.credit(libraryAccountOfStudent.getBalance());
                }
            diningAccountOfStudent.credit(diningAccountOfStudent.getMonthlyPayment());
            }
        tuitionAccountOfStudent.credit(tuitionAccountOfStudent.getMonthlyPayment());
        }
    }

    // method that set the name of the account owner
    public void setName(String accountName)
    {
        this.accountName = accountName;
    }

    // method that return the name of the account owner
    public String getname()
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
        return this.tuitionAccountOfStudent;
    }
}
