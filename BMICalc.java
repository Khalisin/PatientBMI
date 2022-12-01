import java.util.*;
import java.io.*;
import java.util.logging.*;

// Patient interface
interface Patient {
    // Abstract methods
    public abstract double getBMI();
    public abstract String getBMICategory(double bmi);
    public abstract String getInsuranceCategory(double bmi);
}

// Patient class implementation

// Main class
class PatientImplementation implements Patient {
    // Instance Variables
    private String name;
    private double weight;
    private double height;
    private String birthDate;

    // Constructor
    public PatientImplementation(String name, double weight, double height, String birthDate) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.birthDate = birthDate;
    }

    // Implementing methods
    @Override
    public double getBMI() {
        //Calculating and return BMI
        double BMI = (weight * 702) / (height * height);
        return BMI;
    }

    @Override
    public String getBMICategory(double bmi) {
        // Categorically finding BMI comment
        if(bmi < 18.5){
            return "Underweight";
        }
        else if(bmi >= 18.5 && bmi <= 24.9){
            return "Normal";
        }
        else if(bmi >= 25.0 && bmi <= 29.9){
            return "Overweight";
        }
        else {
            return "Obesity";
        }
    }

    @Override
    public String getInsuranceCategory(double BMI) {
        // Checking BMI
        if(BMI <= 24.9) {
            return "low";
        }
        else if(BMI <= 29.9) {
            return "high";
        }
        else {
            return "highest";
        }
    }
}

// Main class
class PatientBMI {

    // Main method
    public static void main(String[] args) throws IOException {

        String name;
        String birthDate;
        double weight;
        double height;
        PatientImplementation pImp;
        double bmiV;

        // Scanner class object
        Scanner sc = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new FileWriter("patient.txt"));

        // Reading data
        for(int i=0; ;i++) {
        //Reading name
            System.out.print("\n Person " + (i+1) + ": \n Enter name: ");
            name = sc.nextLine();

        // Checking name
            if(name.equalsIgnoreCase("q"))
                break;

        // Reading weight
            System.out.print("\n Enter weight: ");
            weight = sc.nextInt();

        // Reading height
            System.out.print("\n Enter height: ");
            height = sc.nextInt();

            sc.nextLine();

        // Reading date of birth
            System.out.print("\n Enter Birth Date: ");
            birthDate = sc.nextLine();

        // Processing patient info

        // Creating object
            pImp = new PatientImplementation(name, weight, height, birthDate);

        // Getting BMI value
            bmiV = pImp.getBMI();

        // Writing result to file
            writer.write("Name: " + name + "\r\n");
            writer.write("Weight: " + weight + "\r\n");
            writer.write("Height: " + height + "\r\n");
            writer.write("Birth Date: " + birthDate + "\r\n");
            writer.write("BMI: " + bmiV + "\r\n");
            writer.write("BMICategory: " + pImp.getBMICategory(bmiV) + "\r\n");
            writer.write("Insurance Payment Category: " + pImp.getInsuranceCategory(bmiV) + "\r\n\n");
        }

        // Closing reader and writer
        sc.close();
        writer.close();java
    }
}
class loggingBMI {
    // creating logger
    static Logger logger = Logger.getLogger(PatientBMI.class.getName());

    public static void main(String[] args) throws IOException{
        logger.setLevel(Level.FINE);
        // setting up handler and formatter
        logger.addHandler(new FileHandler("mylog.txt"));
        // accessing logmanager instance
        logger.log(Level.INFO, "info msg");
        LogManager manager = LogManager.getLogManager();
    }
}



