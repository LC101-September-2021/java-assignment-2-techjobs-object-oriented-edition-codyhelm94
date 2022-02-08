package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name=name;
        this.employer=employer;
        this.location=location;
        this.positionType=positionType;
        this.coreCompetency=coreCompetency;

    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object j) {  // Two objects are equal if they have the same id.
        if (this == j) return true;
        if (!(j instanceof Job)) return false;
        Job job = (Job) j;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        String thisName;
        String thisEmployer;
        String thisLocation;
        String thisPosition;
        String thisCore;
        if(this.getName().isEmpty()){
             thisName="Data not available";
        }else{
             thisName=this.getName();
        }
        if(this.employer.getValue().isEmpty()){
             thisEmployer="Data not available";
        }else{
             thisEmployer=this.employer.getValue();
        }
        if(this.location.getValue().isEmpty()){
            thisLocation="Data not available";
        }else{
            thisLocation=this.location.getValue();
        }
        if(this.positionType.getValue().isEmpty()){
             thisPosition="Data not available";
        }else{
             thisPosition=this.positionType.getValue();
        }
        if(this.coreCompetency.getValue().isEmpty()){
             thisCore="Data not available";
        }else{
             thisCore=this.coreCompetency.getValue();
        }
        if(this.coreCompetency.getValue().isEmpty()&&this.positionType.getValue().isEmpty()
                &&this.location.getValue().isEmpty()&&this.employer.getValue().isEmpty()&&this.getName().isEmpty()){
            return "OOPS! This job does not seem to exist.";
        }else{
            return "\nID: " + id + "\nName: " + thisName + "\nEmployer: " + thisEmployer + "\nLocation: " + thisLocation +
                    "\nPosition Type: " + thisPosition + "\nCore Competency: " + thisCore + '\n';
        }
    }



}
