import java.util.Arrays;

public class Cashier extends Employee {
    private int numDays = 0;
    private String[] days;
    private static final int MAX_DAYS = 5;

    public Cashier(String fName, String lName, String id) {
        super(fName, lName, id);
        this.numDays = 0;
        this.days = new String[MAX_DAYS];
    }

    public Cashier(int numDays, String[] days, String fName, String lName, String id) {
        super(fName, lName, id);
        this.numDays = numDays;
        this.days = days;
    }

    public int getNumDays() {
        return numDays;
    }

    public void setNumDays(int numDays) {
        this.numDays = numDays;
    }

    public String[] getDays() {
        return days;
    }

    public void setDays(String[] days) {
        this.days = days;
    }

    @Override
    public String displayEmployee() {
        return super.displayEmployee() + " number of working days in the week= " + numDays + " which is " + Arrays.toString(days);
    }


    public boolean removeDays(String dayss) {
        for (int i = 0; i < numDays; ++i)
            if (days[i].equals(dayss)) {

                while (i < numDays - 1 ) {
                    days[i] = days[i + 1];
                    ++i;
                }
                numDays--;
                days[numDays]=null;

                return true;
            }
        return false;
    }

    public void printDays() {
        for (int i = 0; i < numDays; ++i)
            System.out.println("days of work: " + (i + 1) + " " + days[i]);
    }

    public boolean addDays(String dayss) {
        for (int i = 0; i < numDays; ++i) {
            if (days[i].equals(dayss)) {
                return false;
            }
        }

        days[numDays]=dayss;
        numDays++;
        return true;

    }

}


