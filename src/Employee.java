import java.util.List;
import java.util.Scanner;

class Employee {
    private String fName = "null", lName= "null" , id = "null";

    //constructor
    Employee(String fName, String lName, String id) {
        this.fName = fName;
        this.lName = lName;
        this.id = id;
    }

    // getter methods
    public String getId() {
        return id;
    }

    public String getfName() {
        return fName;

    }

    public String getlName() {
        return lName;
    }

    // setter methods
    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String fName) {
        this.fName = fName;
    }

    public void setLastName(String lName) {
        this.lName = lName;
    }

    // display
    public String displayEmployee() {
        return "ID " + id + " Name " + fName + " " + lName;
    }
}