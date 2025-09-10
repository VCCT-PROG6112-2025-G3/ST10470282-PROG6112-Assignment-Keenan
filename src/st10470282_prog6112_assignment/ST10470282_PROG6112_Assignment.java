
package st10470282_prog6112_assignment;
import java.util.Scanner;
import java.util.ArrayList;

public class ST10470282_PROG6112_Assignment {

   
    public static void main(String[] args) {
    //Called the class Series into the main method by creating an object called MySeries
     Series mySeries = new Series(); 
        
     //Created an arraylist to store the values with SeriesModel objects and the variable name is serieslist
     ArrayList<SeriesModel> seriesList = new ArrayList<>();
        
     //Initialized a Scanner with object called Scan  
     Scanner Scan = new Scanner(System.in);

     //Calling the method FirstMessage into the main method from the class series
     mySeries.firstMessage();

     //Saves what the user wants to do in the variable UserChoice
     int userChoice = Scan.nextInt();
     Scan.nextLine();

     //If statement created to check if the user wants to enter the program or exit
     if (userChoice != 1) { 
         System.out.println("Exiting Application");       
         return;
        }

     //Boolean with variable Application created. Set to true
     //Runs the menu while true
     boolean Application = true;
     while (Application) {
     //Calling the method menu from class Series
      mySeries.menu();
            
     //Saves what the user wants to do in the menu under the variable MenuChoice
     int MenuChoice = Scan.nextInt();
     Scan.nextLine();

     //Created a switch statement
     //Passed MenuChoice as a argument into the switch statement
     //so that the program can run based on the users choice
     //ChatGPT
     //Question: how to create a switch statement with cases
     //Answer: Lines 50-54
     //URL: https://chatgpt.com/c/68b9fa87-4abc-8330-97fb-9cca11e20c2d
    switch (MenuChoice) {
        //At each case I got the method from the class Series and passed Scan and seriesList as an argument
        case 1:
             mySeries.captureSeries(Scan, seriesList);
             break;
             
        case 2:
             mySeries.searchSeries(Scan, seriesList);
             break;
             
        case 3:
             mySeries.updateSeries(Scan, seriesList);
             break;
             
        case 4:
             mySeries.deleteSeries(Scan, seriesList);
             break;
             
        case 5:
             mySeries.seriesReport(Scan, seriesList);
             break;
             
        case 6:
             mySeries.exitSeriesApplication();
             Application = false;
             continue; 
             default: 
                 //If the user does not type 1-6 it will display this error
                 System.out.println("Option is invalid!");
                 System.out.println(" ");
    }
                   
    //After every case except the exit one it will ask if user wants to relaunch menu or exit
    System.out.println("*************************************************");
    System.out.println("Press (1) to launch menu or any other key to exit");
    //checks that the user only selects 1 for the first message otherwise it will exit the application
    int Choice;
    if (Scan.hasNextInt()) {
        Choice = Scan.nextInt();
        Scan.nextLine();
        if (Choice != 1) {
            System.out.println("Exiting Application");
            Application = false;
                }
            } 
    else {
        //If user typed something other than a number
        System.out.println("Exiting Application");
        Application = false;
    }
     }
}
}

//Class called Series created
class Series {
//Created a method called FirstMessage
//This displays the first message that pops up once the program starts    
public void firstMessage() {
    System.out.println("Welcome to the TV series management application!");
    System.out.println(" ");
    System.out.println("LATEST SERIES - 2025");
    System.out.println("*************************************************");
    System.out.println("Press (1) to launch menu or any other key to exit");
 }

//Created a method called Menu
//This is the menu of the program 
public void menu() {
    System.out.println("Please select one of the following menu items: ");
    System.out.println("(1) Capture a new series.");
    System.out.println("(2) Search for a series.");
    System.out.println("(3) Update series details");
    System.out.println("(4) Delete a series.");
    System.out.println("(5) Print series report - 2025");
    System.out.println("(6) Exit application.");
 }

//Created a method called captureSeries
//This allows the user to capture a new series at case 1
public void captureSeries(Scanner Scan, ArrayList<SeriesModel> seriesList) {
    /*
    Stack Overflow
    Question: How to call a method in another class in java?
    Answer: Line 137 as an example
    URL: https://stackoverflow.com/questions/4593232/how-to-call-a-method-in-another-class-in-java
    */
    int seriesId = SeriesRestrictions.SeriesIdRestriction(Scan);
    String seriesName = SeriesRestrictions.SeriesNameRestrictions(Scan);
    int seriesAge = SeriesRestrictions.SeriesAgeRestrictions(Scan);
    int seriesNumberOfEpisodes = SeriesRestrictions.SeriesEpisodesRestrictions(Scan);
    
    SeriesModel newSeries = new SeriesModel(seriesId, seriesName, seriesAge, seriesNumberOfEpisodes);
    seriesList.add(newSeries);

    System.out.println(" ");
    System.out.println("Series processed successfully!!!");
    System.out.println("***************************************************");
  }

//Created a method called searchSeries
//This class handles case 2 that searches for the series from the series id
//It then searches for it and displays it if the series is found
//If not found it displays an error
public void searchSeries(Scanner Scan, ArrayList<SeriesModel> seriesList) {
    System.out.print("Enter the series id to search: ");
    int searchId = Scan.nextInt();
    Scan.nextLine();
    
    boolean found = false;
    /*
    GeeksforGeeks
    //Java for loops
    //Answer: line 166
    URL: https://www.geeksforgeeks.org/java/loops-in-java/
    */
    for (SeriesModel series : seriesList) {
        if (series.getSeriesId() == searchId) {
            System.out.println("Found the Series!");
            System.out.println("------------------");
            System.out.println(series.Printing());
            found = true;
            break;
            }
        }
        if (!found) {
            System.out.println("Series with series id: " + searchId + " was not found!");
        }
        
    }

// Created a method called updateSeries
//This allows the user to update the series details at case 3
//The user must first enter the series id and the system will verify if its already created
public void updateSeries(Scanner Scan, ArrayList<SeriesModel> seriesList) {
    System.out.print("Enter the series id to update: ");
    int updateId = Scan.nextInt();
    Scan.nextLine();
    boolean updated = false;

    for (SeriesModel series : seriesList) {
        if (series.getSeriesId() == updateId) {
            updated = true;
            System.out.println("Found the series! Current details:");
            System.out.println(series.Printing());
            //fetch the series restrictions from the seriesrestrictions class
            /*
            Stack Overflow
            Question: How to call a method in another class in java?
            Answer: Line 202 as an example
            URL: https://stackoverflow.com/questions/4593232/how-to-call-a-method-in-another-class-in-java
            */
            String newName = SeriesRestrictions.SeriesNameRestrictions(Scan);
            int newAge = SeriesRestrictions.SeriesAgeRestrictions(Scan);
            int newEpisodes = SeriesRestrictions.SeriesEpisodesRestrictions(Scan);

            series.setSeriesName(newName);
            series.setSeriesAge(newAge);
            series.setSeriesNumberOfEpisodes(newEpisodes);

            System.out.println("Series successfully updated!");
            break;
            }
        }
    if (!updated) {
        System.out.println("Series with series id " + updateId + " was not found!");
        }
    }

//Created a method called deleteSeries
//This allows the user to delete a series at case 4
//The user must first enter the series id and the system will verify if its already created
public void deleteSeries(Scanner Scan, ArrayList<SeriesModel> seriesList) {
    System.out.print("Enter the series id to delete: ");
    int deleteId = Scan.nextInt();
    Scan.nextLine();
    boolean found = false;
    /*
    GeeksforGeeks
    Java for loops
    Answer: line 233
    URL: https://www.geeksforgeeks.org/java/loops-in-java/
    */
    for (int i = 0; i < seriesList.size(); i++) {
        if (seriesList.get(i).getSeriesId() == deleteId) {
            found = true;
            System.out.println("Series found!");
            System.out.println(seriesList.get(i).Printing());
            System.out.println("Are you sure you want to delete series " + deleteId + "? Yes (y) to delete.");
            String confirmation = Scan.nextLine();

            if (confirmation.equalsIgnoreCase("y")) {
                seriesList.remove(i);
                System.out.println("Series with series id " + deleteId + " WAS deleted!");
                } 
            
            else {
                System.out.println("Delete cancelled!");
                }
            break;
            }
        }
    
    if (!found) {
        System.out.println("Series with series id " + deleteId + " was not found!");
        }
    }

//Created a method called seriesReport
//This prints out all of the series in the program as a report at case 5
public void seriesReport(Scanner Scan, ArrayList<SeriesModel> seriesList) {
    if (seriesList.isEmpty()) {
    System.out.println("No series have been captured!");
    }
    
    else {
        System.out.println("SERIES REPORT 2025: ");
        int number = 1;
        //GeeksforGeeks
        //Java for loops
        //Answer: line 271
        //URL: https://www.geeksforgeeks.org/java/loops-in-java/
        for (SeriesModel series : seriesList) {
            System.out.println("-----------------------------------------------");
            System.out.println("Series " + number);
            System.out.println("-----------------------------------------------");
            System.out.println(series.Printing());
            number++;
            
            }
        
        }
    }

//Created a method called exitSeriesApplication
//This exits the application at case 6
public void exitSeriesApplication() {
    System.out.println("-----------------------------------------------------");
    System.out.println("Bye see you soon!");
        
    }
    
 }

//created a new class called SeriesRestrictions
//This class consists of different methods
//Each method has restrictions for a certain part of the series
//For example: restrictions on the series age: Only allowed to be 2,18 or between them
//It also asks the questions to the user with an error if the user enters incorrect information
class SeriesRestrictions {
public static int SeriesIdRestriction(Scanner Scan) {
    //restrictions on the seriesid
    //checks that the user enters a number
    System.out.print("Enter the series ID (NUMBERS ONLY): ");
    /*
    GeeksforGeeks
    While loops
    Answer: Lines 310-316
    URL: https://www.w3schools.com/java/java_while_loop.asp
    */
    while (!Scan.hasNextInt()) {
        System.out.println("Invalid input! Please enter a number");
        Scan.next();
        System.out.print("Enter the series ID (NUMBERS ONLY): ");

        }
    return Scan.nextInt();
    }

public static String SeriesNameRestrictions(Scanner Scan) {
    //restrictions on the seriesname
    //checks that the user does not leave the line empty
    Scan.nextLine();
    System.out.print("Enter series name: ");
    String name = Scan.nextLine();
    //ChatGPT
    //Question: How do you give a while loop where it says a user cant leave a question open
    //Answer: Lines 329-334
    //URL: https://chatgpt.com/c/68b9f88f-1af4-8320-b75f-0b3124df1cbc
    while (name.trim().isEmpty()) {
        System.out.println("Series name cannot be empty!");
        System.out.print("Enter series name: ");
        name = Scan.nextLine();
        }
    return name;
    }

public static int SeriesAgeRestrictions(Scanner Scan) {
    //restrictions on the seriesage
    //checks that the user enters a number and the number must be 2,18 or between them
    int age;
    System.out.print("Enter the series age restriction (2-18): ");
    while (true) {
        if (Scan.hasNextInt()) {
            age = Scan.nextInt();
            Scan.nextLine();
            if (age >= 2 && age <= 18) {
                return age;
                } 
            else {
                System.out.println("You have entered an incorrect series age!");
                System.out.print("Please re-enter the series age: ");
                }
            
            }
        else {
            System.out.print("That's not a number! Please enter a number: ");
            Scan.nextLine();
            }
       }
    }

public static int SeriesEpisodesRestrictions(Scanner Scan) {
    //restrictions on the seriesepisodes
    //checks that the user enters a number
    int episodes;
    System.out.print("Enter the number of episodes: ");
    while (true) {
        if (Scan.hasNextInt()) {
            episodes = Scan.nextInt();
            Scan.nextLine();
            return episodes;
            
            }
        else {
            System.out.print("Invalid input! Please enter a number: ");
            Scan.next();
                
            }
            
          }
    }
}
//class seriesmodel created to get the series details and store them in the arraylist  
class SeriesModel {
    //private variables created that belongs to each object of the class
    private int seriesId;
    private String seriesName;
    private int seriesAge;
    private int seriesNumberOfEpisodes;
    //created a constructor called SeriesModel
    /*
    W3Schools
    Constructors
    Answer: Lines 397-402
    URL: https://www.w3schools.com/java/java_constructors.asp
    */
    public SeriesModel(int seriesId, String seriesName, int seriesAge, int seriesNumberOfEpisodes) {
        //Takes the values passed into the constructor and stores it in the object SeriesModel
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }
    //Creating getters to acess the series details later
    /*
    GeeksforGeeks
    Getters and Setters
    Answer: 411-435
    URL: https://www.geeksforgeeks.org/java/getter-and-setter-in-java/
    */
    public int getSeriesId(){
        return seriesId; }
    public String getSeriesName(){
        return seriesName; }
    public int getSeriesAge(){
        return seriesAge; }
    public int getSeriesNumberOfEpisode(){ 
        return seriesNumberOfEpisodes; }
    
    //Setter created so that the user can update the series details
    public void setSeriesAge(int seriesAge){
        this.seriesAge = seriesAge;
    }
    
    public void setSeriesName(String seriesName){ 
        this.seriesName = seriesName; 
    }
    
    public void setSeriesNumberOfEpisodes(int seriesNumberOfEpisodes){ 
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes; 
    }
    
    public void setSeriesID(int seriesId){ 
        this.seriesId = seriesId; 
    }
//Created a method called printing to print the details of the series
    public String Printing() {
        //printing method created to print out the series details
        return "Series ID: " + seriesId + "\nSeries Name: " + seriesName
                + "\nSeries Age restriction: " + seriesAge
                + "\nNumber of episodes in " + seriesName + " : " + seriesNumberOfEpisodes;
    }
}
    
    

