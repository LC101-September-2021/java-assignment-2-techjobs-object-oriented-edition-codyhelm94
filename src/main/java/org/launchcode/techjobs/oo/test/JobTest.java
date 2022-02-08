package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job jobOne=new Job();
        Job jobTwo=new Job();
        assertEquals(jobOne.getId()+1,jobTwo.getId(),.001);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob=new Job("Product tester",new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"),new CoreCompetency("Persistence"));
        assertTrue(testJob instanceof Job);
        assertEquals("Product tester",testJob.getName());
        assertEquals("ACME",testJob.getEmployer().getValue());
        assertEquals("Desert",testJob.getLocation().getValue());
        assertEquals("Quality Control",testJob.getPositionType().getValue());
        assertEquals("Persistence",testJob.getCoreCompetency().getValue());
        assertEquals("Product tester", testJob.getName());
    }


    @Test
    public void testJobsForEquality(){
        Job testOne=new Job("Product tester",new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"),new CoreCompetency("Persistence"));
        Job testTwo=new Job("Product tester",new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"),new CoreCompetency("Persistence"));
        assertFalse(testTwo==testOne);
    }

    @Test
    public void testToString(){
        Job testOne=new Job("Product tester",new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"),new CoreCompetency("Persistence"));
        Job testTwo=new Job("Name",new Employer(""), new Location(""),
                new PositionType(""),new CoreCompetency(""));
        Job testThree=new Job("",new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"),new CoreCompetency("Persistence"));
        Job testFour=new Job("",new Employer(""), new Location(""),
                new PositionType(""),new CoreCompetency(""));

        assertEquals('\n',testOne.toString().charAt(0));
        assertEquals('\n',testOne.toString().charAt(testOne.toString().length()-1));
        assertTrue(testOne.toString().contains("\nID: "+testOne.getId()));
        assertTrue(testOne.toString().contains("\nName: "+testOne.getName()));
        assertTrue(testOne.toString().contains("\nEmployer: "+testOne.getEmployer().getValue()));
        assertTrue(testOne.toString().contains("\nLocation: "+testOne.getLocation().getValue()));
        assertTrue(testOne.toString().contains("\nPosition Type: "+testOne.getPositionType()));
        assertTrue(testOne.toString().contains("\nCore Competency: "+testOne.getCoreCompetency().getValue()));
        assertTrue(testThree.toString().contains("\nName: Data not available"));
        assertTrue(testTwo.toString().contains("\nEmployer: Data not available"));
        assertTrue(testTwo.toString().contains("\nLocation: Data not available"));
        assertTrue(testTwo.toString().contains("\nPosition Type: Data not available"));
        assertTrue(testTwo.toString().contains("\nCore Competency: Data not available"));
        assertEquals("OOPS! This job does not seem to exist.",testFour.toString());
    }



}
