package inputs;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Textbook {

    private String title;
    private String author;
    private int pages;
    private UniClass associatedClass;

    public Textbook() {
        this.title = null;
        this.author = null;
        this.pages = 0;
        associatedClass = new UniClass();
    }

    public Textbook(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        associatedClass = new UniClass();
    }

    public void addUniClass(UniClass uc) {
        if (!associatedClass.equals(uc)) {
            associatedClass = uc;
            associatedClass.addTextbook(this);
        }
    }

    public void removeUniClass(UniClass uc) {
        if (associatedClass.equals(uc)) {
            associatedClass.removeTextbook(this);
            associatedClass = new UniClass();
        }
    }

    public void setDetails(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public UniClass getAssociatedClass() {
        return associatedClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Textbook textbook = (Textbook) o;
        return pages == textbook.pages && Objects.equals(title, textbook.title) &&
                Objects.equals(author, textbook.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, pages);
    }

    @Override
    public String toString() {
        return "Textbook: " + title + " by " + author + ", " + pages + " pages long.\n\n";
    }

    public String toStringFull() {
        return "Textbook: " + title + " by " + author + ", " + pages + " pages long.\n" + "Used in: " + associatedClass.getName() + "\n\n";
    }
}
