/*J Bogorad
Nov 17, 2026
Book searching program
*/
package bogoradsearchingexercise1;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class BogoradSearchingExercise1 {

    public static int linearSearch(ArrayList<Book> bookList, int requestNum) {
        int numChecks = 0;
        for (int i = 0; i < bookList.size(); i++) {
            numChecks++;
            if (bookList.get(i).getReference() == requestNum) {
                return numChecks;
            }
        }
        return -1;
    }

    public static int binarySearch(ArrayList<Book> bookList, int requestNum, int left, int right, int checks) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (bookList.get(middle).getReference() == requestNum) {
            return checks + 1;
        }
        if (bookList.get(middle).getReference() > requestNum) {
            return binarySearch(bookList, requestNum, left, middle - 1, checks + 1);
        } else {
            return binarySearch(bookList, requestNum, middle + 1, right, checks + 1);
        }

    }

    public static String getTitle(ArrayList<Book> bookList, int requestNum, int left, int right) {
        if (left > right) {
            return "";
        }
        int middle = (left + right) / 2;
        if (bookList.get(middle).getReference() == requestNum) {
            return bookList.get(middle).getTitle();
        }
        if (bookList.get(middle).getReference() > requestNum) {
            return getTitle(bookList, requestNum, left, middle - 1);
        } else {
            return getTitle(bookList, requestNum, middle + 1, right);
        }

    }

    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList();
        try {
            File f = new File("src/bogoradsearchingexercise1/booklist.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                int reference = Integer.parseInt(s.nextLine());
                String name = s.nextLine();
                bookList.add(new Book(reference, name));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
        int requestNum = Integer.parseInt(JOptionPane.showInputDialog("Enter the reference number"));
        int linearNum = linearSearch(bookList, requestNum);
        int binaryNum = binarySearch(bookList, requestNum, 0, bookList.size(), 1);
        String title = getTitle(bookList, requestNum, 0, bookList.size());
        String linearMsg = "";
        String binaryMsg = "";
        if(linearNum == -1){
            linearMsg = "Book " + requestNum + " not found";
        }else{
            linearMsg = "Found: " + title + ". " + linearNum + " books processed";
        }
        if(binaryNum == -1){
            binaryMsg = "Book " + requestNum + " not found";
        }else{
            binaryMsg = "Found: " + title + ". " + binaryNum + " books processed";
        }
        JOptionPane.showMessageDialog(null, "Linear:\n" + linearMsg + "\n\nBinary:\n" + binaryMsg);
    }

}
