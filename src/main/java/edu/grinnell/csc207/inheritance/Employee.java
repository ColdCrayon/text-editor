package edu.grinnell.csc207.inheritance;

/** An employee. */
public interface Employee {

    /** @return the employee's name. */
    String getName();

    /** @return the employee's ID. */
    String getId();

    /** @return the employee's salary. */
    int getSalary();

    /** @return the noise the employee makes while working. */
    String makeWorkNoise();

}
