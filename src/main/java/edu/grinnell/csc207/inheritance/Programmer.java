package edu.grinnell.csc207.inheritance;

/** A programmer. */
public class Programmer implements Employee {

    private String name;

    private String id;

    /**
     * Constructs a new programmer.
     *
     * @param name the programmer's name.
     * @param id the programmer's ID.
     */
    public Programmer(String name, String id) {
        this.name = "(PROG) " + name;
        this.id = id;
    }

    /** @return the programmer's name. */
    public String getName() {
        return name;
    }

    /** @return the programmer's ID. */
    public String getId() {
        return id;
    }

    /** @return the programmer's salary. */
    public int getSalary() {
        return 80000 * 2;
    }

    /** @return the programmer's work noise. */
    public String makeWorkNoise() {
        return "Clack clack clack";
    }

}
