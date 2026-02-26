package edu.grinnell.csc207.inheritance;

public abstract class AbstractEmployee implements Employee{
        protected String name;
        protected String id;
        protected int salary;

        public AbstractEmployee(String name, String id, int salary){
            this.name = name;
            this.id = id;
            this.salary = salary;
        }

    /** @return the employee's name. */
    @Override
    public String getName(){
        return this.name;
    }

    /** @return the employee's ID. */
    @Override
    public String getId(){
        return this.id;
    }

    /** @return the employee's salary. */
    @Override
    public int getSalary(){
        return this.salary;
    }

    /** @return the noise an employee makes */
    @Override
    public abstract String makeWorkNoise();

}

