import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;



public class ShoppingBill
{
    static Scanner input =new Scanner(System.in);

    static Cashier cashier1;
    static ProductManager productManager1;
    static String fName , lName , id ;
    static int numDays = 0 , numDaysP = 0;
    static boolean cashier = false , PM = false ;

    public static void main(String args[])
    {
        int userChoice;
        do {
            Scanner reader = new Scanner(System.in);
            displayMainMenu ();
            userChoice=readNumber(reader);
            switch (userChoice) {
                case 1 :
                    displayEmployeeMenu();
                    break;
                case 2:
                    GenerateBill();
                    break;
                case 3:
                    branchinfo();
                    break;
                case 4:
                    System.out.println("Thank you for using our System!.");
                    break;
                default:
                    System.out.println("please enter a valid number.\n");

            }


        }while (userChoice!=4) ;



    }
    static void branchinfo(){
        int choicebranch;
        Scanner reader = new Scanner(System.in);
        do{
            System.out.print("\n1-National Branch\n2-International Branch\n3-Return to previous menu\n");
            choicebranch=ShoppingBill.readNumber(reader);
            switch (choicebranch){
                case 1 :
                    int nationalchoice;
                    Scanner readeri = new Scanner(System.in);
                    do{
                        System.out.print("\n1-Khobar Branch\n2-Dammam Branch\n3-Return to previous menu\n");
                        nationalchoice=ShoppingBill.readNumber(readeri);
                        switch(nationalchoice){
                            case 1:
                                National kBranch = new National("Khobar", 1101, 10000, 12);
                                System.out.print("City : "+kBranch.getCity()+"\n");
                                System.out.print("Building ID: "+kBranch.getBId()+"\n");
                                System.out.print("Population: "+kBranch.getPopul()+"\n");
                                System.out.print("Number of Employees : "+kBranch.getnoEmployee()+"\n");
                                break;
                            case 2:
                                National dBranch = new National("Dammam", 1001, 1200, 10);
                                System.out.print("City : "+dBranch.getCity()+"\n");
                                System.out.print("Building ID : "+dBranch.getBId()+"\n");
                                System.out.print("Population : "+dBranch.getPopul()+"\n");
                                System.out.print("Number of Employees : "+dBranch.getnoEmployee()+"\n");
                                break;
                            case 3:
                                break;
                            default:
                                System.out.print("Please enter a valid number\n");
                        }
                    }while(nationalchoice!=3);
                    break;
                case 2 :
                    int interchoice;
                    Scanner readerii = new Scanner(System.in);
                    do{
                        System.out.print("\n1-Bahrain Branch\n2-UAE Branch\n3-Return to previous menu\n");
                        interchoice=ShoppingBill.readNumber(readerii);
                        switch(interchoice){
                            case 1:
                                International bBranch = new International("Bahrain","Manama", 910, 220000, 32);
                                System.out.print("Country : "+bBranch.getCountry()+"\n");
                                System.out.print("City : "+bBranch.getInterCity()+"\n");
                                System.out.print("Building ID : "+bBranch.getBId()+"\n");
                                System.out.print("Population : "+bBranch.getPopul()+"\n");
                                System.out.print("Number of Employees : "+bBranch.getnoEmployee()+"\n");
                                break;
                            case 2:
                                International uBranch = new International("UAE","Abu Dhabi", 580, 320000, 25);
                                System.out.print("Country : "+uBranch.getCountry()+"\n");
                                System.out.print("City : "+uBranch.getInterCity()+"\n");
                                System.out.print("Building ID : "+uBranch.getBId()+"\n");
                                System.out.print("Population : "+uBranch.getPopul()+"\n");
                                System.out.print("Number of Employees : "+uBranch.getnoEmployee()+"\n");
                                break;
                            case 3:
                                break;
                            default:
                                System.out.print("Please enter a valid number\n");
                        }
                    }while(interchoice!=3);
                    break;
                case 3 :
                    break;
                default:
                    System.out.println("Please enter a valid number\n");
            }
        }while(choicebranch!=3);

    }

    static void displayMainMenu() {
        System.out.println("\n1-Employee\n2-Geneate a bill\n3-Branch information\n4-Exit\nEnter your choice: ");
    }

    public static int readNumber(Scanner reader) {
        while (true) {
            try {
                int readNumber = Integer.parseInt(reader.nextLine());
                return readNumber;
            } catch (Exception e) {
                System.out.println("input was not a number!\nplease enter a number:");
            }
        }
    }
    public static double readDouble(Scanner reader) {
        while (true) {
            try {
                double readNumber = Double.parseDouble(reader.nextLine());
                return readNumber;
            } catch (Exception e) {
                System.out.println("input was not a number!\nplease enter a number:");
            }
        }
    }
    static void GenerateBill() {
        String id = null;
        String productName = null;
        int quantity = 0;
        double price = 0.0;
        double totalPrice = 0.0;
        double overAllPrice = 0.0;
        double tax, subtotal = 0.0;
        char choice = '\0';
        System.out.println("\t\t\t\t--------------------Invoice-----------------");
        System.out.println("\t\t\t\t\t     AL-Khairi’s goodies");
        System.out.println("\t\t\t\t\t     Dammam branch");
        //format of date and time
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        //prints current date and time
        System.out.println("Date: " + formatter.format(date) + "  " + days[calendar.get(Calendar.DAY_OF_WEEK) - 1] );
        Scanner scan = new Scanner(System.in);
        //creating an ArrayList to store the product
        List<Product> product = new ArrayList<Product>();
        do
        {
            // read input values
            System.out.println("Enter the product details: ");
            System.out.print("Product ID: ");
            id = scan.nextLine();
            System.out.print("Product Name: ");
            productName = scan.nextLine();
            System.out.print("Quantity: ");
            quantity=readNumber(scan);
            System.out.print("Price (per unit): ");
            price = readDouble(scan);
            //calculate total price for a particular product
            totalPrice = price * quantity;
            //calculates overall price
            overAllPrice = overAllPrice + totalPrice;
            //creates Product class object and add it to the List
            product.add( new Product(id, productName, quantity, price, totalPrice) );
            // ask for continue shopping?
            System.out.print("Want to add more items? (y or n): ");
            //reads a character Y or N
            choice = scan.next().charAt(0);
            //read remaining characters, don't store (no use)
            scan.nextLine();
        }
        while (choice == 'y' || choice == 'Y');
        //display all product with its properties
        Product.displayFormat();
        for (Product p : product)
        {
            p.display();
        }
        //price calculation
        System.out.println("\n\t\t\t\t\t\t\t    Total Amount without tax (SR) " + overAllPrice);
        //calculating tax
        tax = overAllPrice * 15 / 100;
        //calculating amount to be paid by buyer
        System.out.println("\n\t\t\t\t\t\t\t    Total with tax(SR) " + (tax + overAllPrice));
        System.out.println("\t\t\t\t----------------Thank You for Shopping!!-----------------");
        System.out.println("\t\t\t\t                     Visit Again\n\n\n\n");

    }
    public static void displayEmployeeMenu(){
        int userChoice;
        Scanner reader = new Scanner(System.in);
        do {
            System.out.print("\n1-Cashier menu\n2-Product Manager menu\n3-Return to previous menu\nPlease enter your choice: ");
            userChoice= ShoppingBill.readNumber(reader);
            switch (userChoice){
                case 1 :
                    displayCashierMenu() ;
                    break;
                case 2 :
                    displayProductManagerMenu();
                    break;
                case 3 :
                    break;
                default:
                    System.out.println("please enter a valid number\n");
            }
        }while (userChoice!=3);

    }
    public static void displayCashierMenu(){
        int userChoice;
        Scanner reader = new Scanner(System.in);
        do {
            System.out.print("\n1- Add Cashier\n2- Remove working days\n3- Print the working days\n4- Add days\n5- Return to previous menu\nPlease enter your choice: ");
            userChoice= ShoppingBill.readNumber(reader);
            switch (userChoice) {
                case 1:
                    if(cashier){
                        System.out.println("sorry you cant add more than cashier");
                        break;
                    }
                    Scanner scan = new Scanner(System.in);
                    System.out.print("Enter your first Name: ");
                    fName = scan.nextLine();
                    System.out.print("Enter your last Name: ");
                    lName = scan.nextLine();
                    System.out.print("please enter your ID: ");
                    id = scan.nextLine();
                    cashier1 = new Cashier(fName, lName, id);
                    System.out.println(cashier1.displayEmployee());
                    cashier=true;
                    break;
                case 2:
                    if (numDays == 0) {
                        System.out.println("sorry there is nothing to delete.");
                        break;
                    }
                    System.out.print("\tPlease enter the day you want to delete :");
                    String delDay = input.nextLine();

                    if (cashier1.removeDays(delDay)) {
                        System.out.println(delDay + " removed");
                        numDays--;
                    } else
                        System.out.println(delDay + " can not be removed");

                    break;
                case 3:
                    if (numDays == 0) {
                        System.out.println("sorry there is nothing to print.");
                        break;
                    }
                    cashier1.printDays();
                    break;
                case 4:
                    Scanner scan2 = new Scanner(System.in);
                    if(!cashier){
                        System.out.println("please add a cashier first.");
                        break;
                    }
                    if (numDays == 0) {

                        System.out.print("how many days you like to work in the week?: ");
                        numDays = readNumber(scan2);
                        if (numDays > 5) {
                            System.out.print("sorry you cant work more than 5 days a week.\n");
                            numDays = 0;
                            break;
                        }
                        System.out.println("1-sunday 2-monday 3-tuesday 4-wednesday 5-thursday 6-friday 7-saturday \n please enter your chooice");
                        int userChoice2;
                        String dayss;
                        Scanner reader2 = new Scanner(System.in);
                        String[] workingDays = new String[numDays];
                        for (int i = 0; i < numDays; i++) {
                            userChoice2 = ShoppingBill.readNumber(reader2);
                            do {
                                if(userChoice2>7||userChoice2<1){
                                    System.out.println("please enter a number from the list");
                                    userChoice2 = ShoppingBill.readNumber(reader2);
                                }

                            }while(userChoice2>7||1>userChoice2);

                            switch (userChoice2) {
                                case 1:
                                    dayss = "sunday";
                                    if(cashier1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!cashier1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDays--;
                                    }
                                    break;
                                case 2:
                                    dayss = "monday";
                                    if(cashier1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!cashier1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDays--;
                                    }
                                    break;
                                case 3:
                                    dayss = "tuesday";
                                    if(cashier1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!cashier1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDays--;
                                    }
                                    break;
                                case 4:
                                    dayss = "wednesday";
                                    if(cashier1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!cashier1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDays--;
                                    }
                                    break;
                                case 5:
                                    dayss = "thursday";
                                    if(cashier1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!cashier1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDays--;
                                    }
                                    break;
                                case 6:
                                    dayss = "friday";
                                    if(cashier1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!cashier1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDays--;
                                    }
                                    break;
                                case 7:
                                    dayss = "saturday";
                                    if(cashier1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!cashier1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDays--;
                                    }
                                    break;
                                default:
                                    System.out.println("please enter a valid number\n");

                            }

                        }
                        System.out.println(cashier1.displayEmployee());
                        break;
                    }
                    else if (numDays > 0) {
                        if (numDays==5) {
                            System.out.println("you already working 5 days a week you cant take more.");
                            break;
                        }

                        System.out.println(cashier1.displayEmployee());
                        int newDays;
                        do {
                            System.out.print("how many days you like to add?: ");
                            newDays = readNumber(scan2);
                            if (newDays + numDays > 5) {
                                System.out.print("sorry you cant work more than 5 days a week.\n");

                            }
                        } while (newDays + numDays > 5);
                        int beforeNumDays=numDays;
                        numDays=numDays+newDays;
                        int userChoice2;
                        String dayss;
                        Scanner reader2 = new Scanner(System.in);
                        String[] workingDays = new String[numDays];
                        System.out.println("1-sunday 2-monday 3-tuesday 4-wednesday 5-thursday 6-friday 7-saturday \n please enter your chooice");
                        for (int i = beforeNumDays; i < numDays; i++) {
                            userChoice2 = ShoppingBill.readNumber(reader2);
                            do {
                                if(userChoice2>7||userChoice2<1){
                                    System.out.println("please enter a number from the list");
                                    userChoice2 = ShoppingBill.readNumber(reader2);
                                }

                            }while(userChoice2>7||1>userChoice2);
                            switch (userChoice2) {
                                case 1:
                                    dayss = "sunday";
                                    if(cashier1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!cashier1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDays--;
                                    }
                                    break;
                                case 2:
                                    dayss = "monday";
                                    if(cashier1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!cashier1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDays--;
                                    }
                                    break;
                                case 3:
                                    dayss = "tuesday";
                                    if(cashier1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!cashier1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDays--;
                                    }
                                    break;
                                case 4:
                                    dayss = "wednesday";
                                    if(cashier1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!cashier1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDays--;
                                    }
                                    break;
                                case 5:
                                    dayss = "thursday";
                                    if(cashier1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!cashier1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDays--;
                                    }
                                    break;
                                case 6:
                                    dayss = "friday";
                                    if(cashier1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!cashier1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDays--;
                                    }
                                    break;
                                case 7:
                                    dayss = "saturday";
                                    if(cashier1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!cashier1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDays--;
                                    }
                                    break;
                                default:
                                    System.out.println("please enter a valid number\n");
                            }
                        }
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("please enter a valid number\n");
            }
        } while (userChoice!=5);

    }
    public static void displayProductManagerMenu(){
        int userChoice;
        Scanner reader = new Scanner(System.in);
        do {

            System.out.print("\n1- Add Product Manager\n2- Remove working days\n3- Print the working days\n4- Add days\n5- Return to previous menu\nPlease enter your choice: ");
            userChoice= ShoppingBill.readNumber(reader);
            switch (userChoice) {
                case 1:
                    if(PM){
                        System.out.println("sorry you cant add more than one product manager");
                        break;
                    }
                    Scanner scan2 = new Scanner(System.in);
                    System.out.print("Enter your first Name: ");
                    fName = scan2.nextLine();
                    System.out.print("Enter your last Name: ");
                    lName = scan2.nextLine();
                    System.out.print("please enter your ID: ");
                    id = scan2.nextLine();
                    productManager1 = new ProductManager(fName,lName,id);
                    PM = true;
                    break;
                case 2:
                    if (numDaysP == 0) {
                        System.out.println("sorry there is nothing to delete.");
                        break;
                    }
                    System.out.print("\tPlease enter the day you want to delete :");
                    String delDay = input.nextLine();

                    if (productManager1.removeDays(delDay)) {
                        System.out.println(delDay + " removed");
                        numDaysP--;
                    } else
                        System.out.println(delDay + " can not be removed");

                    break;
                case 3:

                    if (numDaysP == 0) {
                        System.out.println("sorry there is nothing to print.");
                        break;
                    }
                    productManager1.printDays();
                    break;

                case 4:
                    Scanner scan3 = new Scanner(System.in);
                    if(!PM){
                        System.out.println("please add a Product Manager first.");
                        break;
                    }
                    if (numDaysP == 0) {

                        System.out.print("how many days you like to work in the week?: ");
                        numDaysP = readNumber(scan3);
                        if (numDaysP > 5) {
                            System.out.print("sorry you cant work more than 5 days a week.\n");
                            numDaysP = 0;
                            break;
                        }
                        System.out.println("1-sunday 2-monday 3-tuesday 4-wednesday 5-thursday 6-friday 7-saturday \n please enter your chooice");
                        int userChoice2;
                        String dayss;
                        Scanner reader2 = new Scanner(System.in);
                        String[] workingDays = new String[numDaysP];
                        for (int i = 0; i < numDaysP; i++) {
                            userChoice2 = ShoppingBill.readNumber(reader2);
                            do {
                                if(userChoice2>7||userChoice2<1){
                                    System.out.println("please enter a number from the list");
                                    userChoice2 = ShoppingBill.readNumber(reader2);
                                }

                            }while(userChoice2>7||1>userChoice2);

                            switch (userChoice2) {
                                case 1:
                                    dayss = "sunday";
                                    if(productManager1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!productManager1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDaysP--;
                                    }
                                    break;
                                case 2:
                                    dayss = "monday";
                                    if(productManager1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!productManager1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDaysP--;
                                    }
                                    break;
                                case 3:
                                    dayss = "tuesday";
                                    if(productManager1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!productManager1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDaysP--;
                                    }
                                    break;
                                case 4:
                                    dayss = "wednesday";
                                    if(productManager1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!productManager1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDaysP--;
                                    }
                                    break;
                                case 5:
                                    dayss = "thursday";
                                    if(productManager1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!productManager1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDaysP--;
                                    }
                                    break;
                                case 6:
                                    dayss = "friday";
                                    if(productManager1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!productManager1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDaysP--;
                                    }
                                    break;
                                case 7:
                                    dayss = "saturday";
                                    if(productManager1.addDays(dayss)){
                                        System.out.println(dayss+" added");
                                    }
                                    else if(!productManager1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDaysP--;
                                    }
                                    break;
                                default:
                                    System.out.println("please enter a valid number\n");

                            }

                        }
                        System.out.println(productManager1.displayEmployee());
                        break;
                    } else if (numDaysP > 0) {
                        if (numDaysP==5) {
                            System.out.println("you already working 5 days a week you cant take more.");
                            break;
                        }
                        System.out.println(productManager1.displayEmployee());
                        int newDays;
                        do {
                            System.out.print("how many days you like to add?: ");
                            newDays = readNumber(scan3);
                            if (newDays + numDaysP > 5) {
                                System.out.print("sorry you cant work more than 5 days a week.\n");

                            }
                        } while (newDays + numDaysP > 5);
                        int beforeNumDays = numDaysP;
                        numDaysP = numDaysP + newDays;
                        int userChoice2;
                        String dayss;
                        Scanner reader2 = new Scanner(System.in);
                        String[] workingDays = new String[numDaysP];
                        System.out.println("1-sunday 2-monday 3-tuesday 4-wednesday 5-thursday 6-friday 7-saturday \n please enter your chooice");
                        for (int i = beforeNumDays; i < numDaysP; i++) {
                            userChoice2 = ShoppingBill.readNumber(reader2);
                            do {
                                if(userChoice2>7||userChoice2<1){
                                    System.out.println("please enter a number from the list");
                                    userChoice2 = ShoppingBill.readNumber(reader2);
                                }

                            }while(userChoice2>7||1>userChoice2);
                            switch (userChoice2) {
                                case 1:
                                    dayss = "sunday";
                                    if (productManager1.addDays(dayss)) {
                                        System.out.println(dayss + " added");
                                    }
                                    else if(!productManager1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDaysP--;
                                    }
                                    break;
                                case 2:
                                    dayss = "monday";
                                    if (productManager1.addDays(dayss)) {
                                        System.out.println(dayss + " added");
                                    }
                                    else if(!productManager1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDaysP--;
                                    }
                                    break;
                                case 3:
                                    dayss = "tuesday";
                                    if (productManager1.addDays(dayss)) {
                                        System.out.println(dayss + " added");
                                    }
                                    else if(!productManager1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDaysP--;
                                    }
                                    break;
                                case 4:
                                    dayss = "wednesday";
                                    if (productManager1.addDays(dayss)) {
                                        System.out.println(dayss + " added");
                                    }
                                    else if(!productManager1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDaysP--;
                                    }
                                    break;
                                case 5:
                                    dayss = "thursday";
                                    if (productManager1.addDays(dayss)) {
                                        System.out.println(dayss + " added");
                                    }
                                    else if(!productManager1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDaysP--;
                                    }
                                    break;
                                case 6:
                                    dayss = "friday";
                                    if (productManager1.addDays(dayss)) {
                                        System.out.println(dayss + " added");
                                    }
                                    else if(!productManager1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDaysP--;
                                    }
                                    break;
                                case 7:
                                    dayss = "saturday";
                                    if (productManager1.addDays(dayss)) {
                                        System.out.println(dayss + " added");
                                    }
                                    else if(!productManager1.addDays(dayss)){
                                        System.out.println("you already working on " + dayss);
                                        numDaysP--;
                                    }
                                    break;
                                default:
                                    System.out.println("please enter a valid number\n");
                            }
                        }
                    }

                    break;
                case 5 :
                    break;
                default:
                    System.out.println("please enter a valid number\n");
            }
        }while (userChoice!=5);

    }
}




