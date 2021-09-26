public class LibraryAccount extends Account{

    // field that store the reserved fine of tiems
    private double reserveFinesOfItems;

    // field that store the fine of book for each day. 
    private double bookFineEachDay;

    // field that count the books that are overdue
    private int bookOverdue;

    // constructor that inherit Class Account. Taking account number and balance limit as its input 
    public LibraryAccount(String accountNumber, int balanceLimit, double bookFineInput, double reservedFinesOfItemsInput)
    {
        super(accountNumber, balanceLimit);
        this.reserveFinesOfItems = reservedFinesOfItemsInput;
        this.bookFineEachDay = bookFineInput;
    }

    // set the fine of book for each day
    public void setBookFine(double fineEachDay)
    {
         this.bookFineEachDay = fineEachDay;
    }

    // return the fine of book for each day
    public double getBookFine()
    {
        return this.bookFineEachDay;
    } 

    // set the value of reserved fine for a item
    public void setReserveFine(double reservedFinesOfItem)
    {
        this.reserveFinesOfItems = reservedFinesOfItem;
    }

    // return the value of reserved fine for a item
    public double getReserveFine()
    {
        return this.reserveFinesOfItems;
    }

    // increase the book that overdue by 1
    public void incrementOverdueBooks()
    {
        this.bookOverdue += 1; 
    }

    // decrease the book that overdue by 1
    public void decrementOverdueBooks()
    {
        if(this.bookOverdue>=1)
        {
            this.bookOverdue -= 1;
        }
    }

    // return the number of books that areoverdue 
    public int getNumberOverdueReserve()
    {
        return this.bookOverdue;
    }

    // return whether one could borrow
    public boolean canBorrow()
    {
        return (this.getBalance() <= this.getBalanceLimit());
    }

    // increase the balance by the product of number of overdue books and the book fine, and the product of the number of overdue reserved and the reserved items fine 
    public void endOfDay()
    {
        this.charge(this.bookOverdue*this.getBookFine());
        this.charge(this.getNumberOverdueReserve()*this.getReserveFine());
    }

}
