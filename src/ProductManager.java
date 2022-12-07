import java.util.Arrays;

public class ProductManager extends Employee  {
    private int numDaysP;
    private String [] days;
    private static final int MAX_DAYS = 5;

    public ProductManager(String fName, String lName, String id){
        super(fName, lName, id) ;
        this.numDaysP = 0;
        this.days = new String[MAX_DAYS];
    }
    public ProductManager(int numDaysP, String[] days, String fName, String lName, String id) {
        super(fName, lName, id);
        this.numDaysP = numDaysP;
        this.days = days;
    }

    public int getNumDays() {
        return numDaysP;
    }
    public void setNumDays(int numDaysP) {
        this.numDaysP = numDaysP;
    }

    public String[] getDays() {
        return days;
    }

    @Override
    public String displayEmployee() {
        return super.displayEmployee() + " number of working days in the week= " + numDaysP + " which is " + Arrays.toString(days);
    }

    public boolean removeDays(String dayss)
    {

        for ( int i = 0 ; i< numDaysP; ++i)
            if (days[i].equals(dayss)) {

                while (i < numDaysP - 1 ) {
                    days[i] = days[i + 1];
                    ++i;
                }
                numDaysP--;
                days[numDaysP]=null;

                return true;
            }
        return false;
    }

    public void printDays ()
    {
        for (int i=0; i< numDaysP; ++i)
            System.out.println("days of work: " + (i+1) + " " + days[i]);
    }
    public boolean addDays(String dayss) {
        for (int i = 0; i < numDaysP; ++i) {
            if (days[i].equals(dayss)) {
                return false;
            }
        }

        days[numDaysP]=dayss;
        numDaysP++;
        return true;

    }

}
