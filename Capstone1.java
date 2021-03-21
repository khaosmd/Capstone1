//imports classes needed for the program
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Create the Capstone1 class and the main method
public class Capstone1 {
    public static void main(String arguments[]) {

        //Try statement to test for exceptions. A new project is created by calling the captureProject method.
        // The updateDetails method is then called to update details. An invoice object is created by calling the invoice
        //constructor. If the fee variable doesn't equal the paid variable (accessed via the getters) then an
        //invoice is created for the project.
        try {
            Project project1 = captureProject();

            updateDetails(project1);

            Invoice invoice = new Invoice();
            if (project1.getFee() != project1.getPaid()) {
                createInvoice(project1, invoice);

            }

            //The project's status is set as "finalised", and the current date is set as the completion date. The invoice file is then
            //created using the invoice
            project1.setStatus("finalised");
            project1.setCompletionDate(new Date());
            createInvoiceFile(invoice);

        //if an exception is caught, it is printed
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    //The updateDetails method is created, which takes a project parameter
    public static void updateDetails(Project project) throws ParseException{

        //new scanner created to get user input
        Scanner input = new Scanner(System.in);

        //update String variable declared and initialised with a value of "no"
        String update = "no";

        //Ask the user for input, if the user inputs "y", ask the user to enter the date which is stored as a string then converted to a date object
        System.out.print("Would you like to update the project deadline? Type \"y\" for yes or \"n\" for no: ");
        update = input.nextLine();

        if (update.equals("y")) {

            System.out.println("Enter the deadline for the project (dd/MM/yyyy): ");
            String deadlineString = input.nextLine();
            Date deadline = new SimpleDateFormat("dd/MM/yyyy").parse(deadlineString);
            project.setDeadline(deadline);

        }

        //asks for user input and stores the input as the variable "update"
        System.out.print("Would you like to update the total amount of the fee paid to date? Type \"y\" for yes or \"n\" for no: ");
        update = input.nextLine();

        //If statement used to get input from the user if the user inputs "y" to the above, or prints a statement
        //to the screen if "n" is inputted.

        if (update.equals("y")) {

            System.out.print("Enter the new fee paid to date: ");

            //Convert the value captured as a string object to a float variable
            String feeString = input.nextLine();
            float fee = Float.parseFloat(feeString);

            project.setFee(fee);

        }

        //ask the user for input and stores the entry as the variable "update"
        System.out.print("Would you like to update the contractor's contact details? Type \"y\" for yes or \"n\" for no: ");
        update = input.nextLine();

        //If statement used to get input from the user if the user inputs "y" to the above and store the input as a string variable, or prints a statement
        //to the screen if "n" is inputted.

        if (update.equals("y")) {
            Scanner input3 = new Scanner(System.in);

            System.out.print("Enter the name of the contractor: ");
            String name = input3.nextLine();

            System.out.print("Enter the telephone number of the contractor: ");
            String tel = input3.nextLine();

            System.out.print("Enter the email address of the contractor: ");
            String email = input3.nextLine();

            System.out.print("Enter the physical address of the contractor: ");
            String address = input3.nextLine();

            //constructor to create a new person object
            Person p = new Person("contractor", name, tel, email, address);
            project.person[0] = p;
        }
    }
//Create the createInvoiceFile method which writes the invoice to a string in a text file
    public static void createInvoiceFile(Invoice invoice){
        try {
            FileWriter myWriter = new FileWriter("completedProject.txt");
            myWriter.write(invoice.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

//Create the invoice creation method which creates a new invoice and customer object. The invoice object gets its
//variables from the customer and project objects
    public static void createInvoice(Project project, Invoice invoice) {

        Person customer = project.person[2];
        invoice.setCustomer(customer.getName());
        invoice.setTelephone(customer.getTel());
        invoice.setEmailAdd(customer.getEmail());
        invoice.setPhysAdd(customer.getAddress());
        invoice.setPaidAmount(project.getPaid());
        invoice.setTotal(project.getFee());

    }

//Create the captureProject method
    public static Project captureProject() throws ParseException {
        //create a new scanner to capture user input
        Scanner input = new Scanner(System.in);
        //capture user input
        System.out.println("Enter the project number: ");
        int number = input.nextInt();

        input.nextLine();

        System.out.println("Enter the project name. If there is no name, enter \"none\": ");
        String projectName = input.nextLine();

        System.out.println("Enter the type of building being designed: ");
        String building = input.nextLine();

        System.out.println("Enter the physical address of the project: ");
        String projectAddress = input.nextLine();

        System.out.println("Enter the ERF number of the project: ");
        String erf = input.nextLine();

        System.out.println("Enter the total fee being charged for the project: ");

        //Convert the value captured as a string object to a float variable
        String feeString = input.nextLine();
        float fee = Float.parseFloat(feeString);

        System.out.println("Enter the total amount paid to date for the project: ");

        //Convert the value captured as a string object to a float variable
        String paidString = input.nextLine();
        float paid = Float.parseFloat(paidString);

        //Ask the user for a date input, and stores it as a string, which is then converted to a date object.
        System.out.println("Enter the deadline for the project (dd/MM/yyyy): ");
        String deadlineString = input.nextLine();
        Date deadline = new SimpleDateFormat("dd/MM/yyyy").parse(deadlineString);

        //create an array of type Person (object) of size 3
        Person[] person = new Person[3];

        //declare variables
        String role;
        String name;
        String tel;
        String email;
        String address;

        //A for loop to loop through person[0] to person[2] asking the user for input for each person
        for (int x = 0; x < person.length; x++) {

            //A new scanner is created to get the user's input. The user is then asked for input, which is stored as the previously declared variables.
            Scanner input1 = new Scanner(System.in);

            System.out.print("Enter the role of the person in the following order: 1. architect, 2. contractor, 3. customer): ");
            role = input1.nextLine();

            System.out.print("Enter the name of the person (e.g. John Smith): ");
            name = input1.nextLine();

            System.out.print("Enter the telephone number of the person: ");
            tel = input1.nextLine();

            System.out.print("Enter the email address of the person: ");
            email = input1.nextLine();

            System.out.print("Enter the physical address of the person: ");
            address = input1.nextLine();

            //New person object p
            Person p = new Person(role, name, tel, email, address);
            person[x] = p;


        }

        //If statement used to determine if the project has a name, and if it doesn't (project name is "none"),
        //it uses the type of building and the customer's surname to name the project. The split string method is used
        //to split the first name from the last name, and the building type and surname are used to name the project
        if (projectName.equals("none")) {

            String customerName = person[2].getName();
            String[] splitName = customerName.split(" ");
            projectName = building + " " + splitName[1];

        }
        //Constructor to create a new project
        Project project = new Project(number, projectName, building, projectAddress, erf, fee, paid, deadline);

        project.person = person;

        return project;

    }
}


