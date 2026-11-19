/*J Bogorad
Nov 17, 2026
Book class*/
package bogoradsearchingexercise1;

public class Book {
    private int reference;
    private String title;
    public Book(){
        reference = 0;
        title = "";
    }
    public Book(int n, String t){
        this();
        reference = n;
        title = t;
    }
    public int getReference(){
        return reference;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String t){
        title = t;
    }
    public void setReference(int n){
        reference = n;
    }
}
