/*
* Author : Patrick Love
* Purpose: Display names of students and their grades based on two files using parallel arrays
*          Using the arrays we will find who has the highest, lowest and the average of grades for everyone
*
*Date    : 03/27/2019
* */


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Grades {
    public static void main(String [] args) throws IOException {


        File namesFile = Paths.get(".", "resources", "Names.txt").normalize().toFile();
        File gradesFile = Paths.get(".", "resources", "Grades.txt").normalize().toFile();

        // File file = new File(fileName);             // create a File object


        if (namesFile.exists())                          // check that the file exists
        {                                             // before trying to create a
            // Scanner to read the file
            // Create a Scanner from the file.
            // This statement can cause a FileNotFoundException.
            Scanner namesInputFile = new Scanner(namesFile);
            Scanner gradesInputFile = new Scanner(gradesFile);

            // For each line in the file, read in the line and display it with the line number
            int lineNum = 0;

            // Use the results of calling the hasNext method to
            // determine if you are at the end of the file before
            // reading the next line of the file.
            String [] names= new String[20];
            int [] grades= new int[20];

            while (namesInputFile.hasNext()) {
                names[lineNum] = namesInputFile.nextLine();   // read the next line
                grades[lineNum] = gradesInputFile.nextInt();


                // Output the line read to the screen for the user
                System.out.println(lineNum + ": " + names[lineNum]);
                lineNum++;
            }

            // When we're done reading the file,
            // close the Scanner object attached to the file
            namesInputFile.close();
            gradesInputFile.close();

            System.out.println("\nThe number of people who earned A's is " + findNumberOfAs(grades));
            System.out.println("The number of people who earned B's is " + findNumberOfBs(grades));
            System.out.print(getMinimum(grades,names));
            System.out.print(getMaximum(grades,names));
            System.out.println("\nThe average of grades is " + getAverage(grades));



            // loop to prompt for individual grades...
        }


    }

    public static int findNumberOfAs(int [] g) {
        int total=0;
        for  (int i=0; i<g.length; i++){
            if (findLetterGrade(g[i])=='A'){
                total++;
            }
        }
        return total;

    }

    public static int findNumberOfBs(int [] g) {
        int total=0;
        for  (int i=0; i<g.length; i++){
            if (findLetterGrade(g[i])=='B'){
                total++;
            }
        }
        return total;

    }


    public static char findLetterGrade(int score) {
        // test to find the letter grade a person receives
        if (score>= 90) {
            return 'A';
        }
        else if (score>=80) {
            return 'B';
        }
        else if (score>=70) {
            return 'C';

        }
        else if (score>=60) {
            return 'D';

        }
        else {
            return 'F';
        }
    }

    // find minimum grade
    public static <string> int getMinimum(int [] g, string[] s) {
        int lowestGrade = g[0];
        for (int i = 1; i < g.length; i++) {
            if (lowestGrade > g[i]) {
                i++;
                lowestGrade = g[i];
            }
            System.out.print("The student scoring the lowest grade is: ");
            for (i = 0; i < g.length; i++) {
                if (g[i] == lowestGrade) {
                    System.out.print(s[i] + " with ");
                }
            }
        } return lowestGrade;// end method getMinimum
    }
    // find maximum grade
    public static <string> int getMaximum(int[] g, string[] s) {
        int highestGrade=g[0];
        for (int i=1;i<g.length;i++) {
            if(highestGrade<g[i]) {
                highestGrade = g[i];
            }
            System.out.print("\nThe student scoring the highest grade is: ");
            for (i=0; i<g.length;i++) {
                if(g[i]==highestGrade) {
                    System.out.print(s[i] +" with ");
                }
            }
        } return highestGrade;
    } // end method getMaximum


    // find the average of grades
    public static double getAverage(int[] g){
        double sum = 0.0;
        for(int i=0;i<g.length;i++){
            sum += g[i];
        }
        return sum/20;
    } // end method getAverage



}
