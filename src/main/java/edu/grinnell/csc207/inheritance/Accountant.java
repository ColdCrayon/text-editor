package edu.grinnell.csc207.inheritance;

/** An accountant. */
public class Accountant implements Employee {
    private String name;

    private String id;

    /**
     * Constructs a new accountant
     * @param name the accountant's name
     * @param id the accountant's ID
     */
    public Accountant(String name, String id) {
        this.name = "(ACCT) " + name;
        this.id = id;
    }

    /** @return the accountant's name */
    public String getName() {
        return name;
    }

    /** @return the accountant's ID */
    public String getId() {
        return id;
    }

    /** @return the account's salary */
    public int getSalary() {
        return 80000;
    }

    /** @return the account's noise */
    public String makeWorkNoise() {
        return "$$$";
    }
}