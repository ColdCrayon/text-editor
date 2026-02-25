package edu.grinnell.csc207.inheritance;

import java.util.List;

/** A CEO. */
public class CEO {

    private String name;

    private String id;

    private List<Employee> reportees;

    /**
     * Constructs a new CEO.
     *
     * @param name the CEO's name.
     * @param id the CEO's ID.
     * @param reportees the CEO's direct reports.
     */
    public CEO(String name, String id, List<Employee> reportees) {
        this.name = "(CEO) " + name;
        this.id = id;
        this.reportees = reportees;
    }

    /** @return the CEO's name. */
    public String getName() {
        return name;
    }

    /** @return the CEO's ID. */
    public String getId() {
        return id;
    }

    /** @return the CEO's salary. */
    public int getSalary() {
        return 80000 * 100;
    }

    /** @return the CEO's work noise. */
    public String makeWorkNoise() {
        return "Do More Work More Do More Work More Do More Work";
    }

}
