package edu.grinnell.csc207.inheritance;

import java.util.List;

/** A manager. */
public class Manager implements Employee {

    private String name;

    private String id;

    private List<Employee> reportees;

    /**
     * Constructs a new manager.
     *
     * @param name the manager's name.
     * @param id the manager's ID.
     * @param reportees the manager's direct reports.
     */
    public Manager(String name, String id, List<Employee> reportees) {
        this.name = "(MGR) " + name;
        this.id = id;
        this.reportees = reportees;
    }

    /** @return the manager's name. */
    public String getName() {
        return name;
    }

    /** @return the manager's ID. */
    public String getId() {
        return id;
    }

    /** @return the manager's salary. */
    public int getSalary() {
        return 120000 * 3;
    }

    /** @return the manager's work noise. */
    public String makeWorkNoise() {
        return "Do Work Do Work Do Work";
    }

}
