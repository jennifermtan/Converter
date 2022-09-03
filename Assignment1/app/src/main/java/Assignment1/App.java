package Assignment1;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.*;
import java.lang.*;


public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        // Creating a list of hashmaps to store currency data in
        List<LinkedHashMap<String, Double>> maps = new ArrayList<>();
        try {
            Scanner currencyFiles = new Scanner(new File("./src/main/java/Assignment1/currencies/currencyFiles.txt"));
            while(currencyFiles.hasNextLine()) {
                String line = currencyFiles.nextLine();
                maps.add(new LinkedHashMap<String, Double>());
            }
            currencyFiles.close();

            // Loading data into the hashmaps
            currencyFiles = new Scanner(new File("./src/main/java/Assignment1/currencies/currencyFiles.txt"));
            for (HashMap<String, Double> map : maps) {
                String line = currencyFiles.nextLine();
                Scanner temp = new Scanner(new File(line));
                while (temp.hasNextLine()) {
                    String values = temp.nextLine();
                    String[] arr = values.split(", ");
                    map.put(arr[0], Double.parseDouble(arr[1]));
                }
                temp.close();
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found exception.");
        }


        // Starting of the application
        System.out.println("Welcome to Currency Converter! Select displayed options to continue!\nWhat is your user type?\n1: User\n2: Admin");
        String user = scan.nextLine();

        selectUserOption(user);


    }

    public static void selectUserOption(String userType) {
        if(userType.equals("1")) {
            // run code for user
            System.out.println("User, what would you like to do?\n1: Convert currencies\n2: Display currency table\n3: Summary of 2 currencies");
            String input = scan.nextLine();
            switch (input) {
                case "1":
                    // Convert currencies
                    break;
                case "2":
                    // Display currency table
                    break;
                case "3":
                    // Summary of two currencies
                    break;
            }
        }
        else if(userType.equals("2")) {
            // run code for admin
            System.out.println("Administrator, what would you like to do?\n1: Convert currencies\n2: Display currency table\n" +
                    "3: Summary of 2 currencies\n4: ");
        }
    }

    public static void printOptions() {
        ;
    }

    //Returns the average rate from a history list of a specific currency
    public static double getAverage(ArrayList<Double> ls) {
        double total = 0;

        for (double value : ls) {
            total += value;
        }
        return total / ls.size();
    }

    public static double getMedian(ArrayList<Double> ls) {
        Collections.sort(ls);

        if (ls.size() % 2 == 1) {
            int index = (int) Math.ceil(ls.size() / 2);
            return ls.get(index);
        } else {
            int index1 = (int) (ls.size() / 2) - 1;
            int index2 = index1 + 1;

            return (ls.get(index1) + ls.get(index2)) / 2;
        }
    }

    public static double getMaximum(ArrayList<Double> ls) {
        double largest = ls.get(0);

        for (Double l : ls) {
            if (l > largest) {
                largest = l;
            }
        }
        return largest;
    }

    public static double getMinimum(ArrayList<Double> ls) {
        double smallest = ls.get(0);

        for (Double l : ls) {
            if (l < smallest) {
                smallest = l;
            }
        }
        return smallest;
    }

    public static double getSD(ArrayList<Double> ls) {
        double total = 0;
        double standardDeviation = 0;

        for (double value : ls) {
            total += value;
        }

        double mean = getAverage(ls);

        for (double value : ls) {
            standardDeviation += Math.pow(value - mean, 2);
        }

        return Math.sqrt(standardDeviation / ls.size());
    }

}
