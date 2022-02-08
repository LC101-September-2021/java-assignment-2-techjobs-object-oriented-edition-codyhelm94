package org.launchcode.techjobs.oo;

public class JobField {
    private int id;
    private static int nextId = 1;
    private String value;

    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;

        JobField jobField = (JobField) o;

        if (getId() != jobField.getId()) return false;
        return getValue().equals(jobField.getValue());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getValue().hashCode();
        return result;
    }


    // Getters and Setters:

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
