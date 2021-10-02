/* Dasheng Lin
 * Class LibraryAccount represent the account of library, including interaction
 * of book fine, reserve fine and overdue books. 
 */

public class LibraryAccount extends Account{

    // field that store the reserved fine of items. I initial its value to be 5 dollar per each
    private double reserveFinesOfItems = 5.0;
    
    // field that store the number of reserved items which is overdue
    private int reserveItems = 0;

    // field that store the fine of book for each day. 
    private double bookFineEachDay = 3.0;

    // field that count the books that are overdue
    private int bookOverdue = 0;

    /* constructor that inherit Class Account. Initializing a object by using its account number, balance limitation, book fine and
     * reserved fine for each item
     */
    public LibraryAccount(String accountNumber, int balanceLimit, double bookFineInput, double reservedFinesOfItemsInput)
    {
        super(accountNumber, balanceLimit);
        this.reserveFinesOfItems = reservedFinesOfItemsInput;
        this.bookFineEachDay = bookFineInput;
    }

    // set the fine to borrow a book for one day
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

    // increase the book which overdue by 1
    public void incrementOverdueBooks()
    {
        this.bookOverdue ++; 
    }

    // decrease the book which overdue by 1
    public void decrementOverdueBooks()
    {
        if(this.bookOverdue >= 1)
        {
            this.bookOverdue --;
        }
    }

    // return the number of books which are overdue 
    public int getNumberOverdueBooks()
    {
        return this.bookOverdue;
    }

    // increase the items which overdue by 1
    public void incrementOverdueReserve()
    {
        this.reserveItems ++; 
    }

    // decrease the items which overdue by 1
    public void decrementOverdueReserve()
    {
        if(this.reserveItems >= 1)
        {
            this.reserveItems --;
        }
    }

    // return the number of items which are overdue 
    public int getNumberOverdueReserve()
    {
        return this.reserveItems;
    }

    // return whether one could borrow
    public boolean canBorrow()
    {
        return (this.getBalance() <= this.getBalanceLimit());
    }

    // increase the balance by the product of number of overdue books and the book fine, and the product of the number of overdue reserved and the reserved items fine 
    public void endOfDay()
    {
        this.charge(this.getNumberOverdueBooks()*this.getBookFine());
        this.charge(this.getNumberOverdueReserve()*this.getReserveFine());
    }

}