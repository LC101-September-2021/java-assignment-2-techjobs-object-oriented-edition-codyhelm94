package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job jobOne=new Job();
        Job jobTwo=new Job();
        Assert.assertEquals(  jobOne.getId()+1,jobTwo.getId(),.001);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob=new Job("Product tester",new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"),new CoreCompetency("Persistence"));
        Assert.assertTrue(testJob instanceof Job);
        Assert.assertEquals("Product tester",testJob.getName());
        Assert.assertEquals("ACME",testJob.getEmployer().getValue());
        Assert.assertEquals("Desert",testJob.getLocation().getValue());
        Assert.assertEquals("Quality Control",testJob.getPositionType().getValue());
        Assert.assertEquals("Persistence",testJob.getCoreCompetency().getValue());
        Assert.assertEquals("Product tester", testJob.getName());
    }


    @Test
    public void testJobsForEquality(){
        Job testOne=new Job("Product tester",new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"),new CoreCompetency("Persistence"));
        Job testTwo=new Job("Product tester",new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"),new CoreCompetency("Persistence"));
        Assert.assertFalse(testTwo==testOne);
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

        Assert.assertEquals('\n',testOne.toString().charAt(0));
        Assert.assertEquals('\n',testOne.toString().charAt(testOne.toString().length()-1));
        Assert.assertTrue(testOne.toString().contains("\nID: "+testOne.getId()));
        Assert.assertTrue(testOne.toString().contains("\nName: "+testOne.getName()));
        Assert.assertTrue(testOne.toString().contains("\nEmployer: "+testOne.getEmployer().getValue()));
        Assert.assertTrue(testOne.toString().contains("\nLocation: "+testOne.getLocation().getValue()));
        Assert.assertTrue(testOne.toString().contains("\nPosition Type: "+testOne.getPositionType()));
        Assert.assertTrue(testOne.toString().contains("\nCore Competency: "+testOne.getCoreCompetency().getValue()));
        Assert.assertTrue(testThree.toString().contains("\nName: Data not available"));
        Assert.assertTrue(testTwo.toString().contains("\nEmployer: Data not available"));
        Assert.assertTrue(testTwo.toString().contains("\nLocation: Data not available"));
        Assert.assertTrue(testTwo.toString().contains("\nPosition Type: Data not available"));
        Assert.assertTrue(testTwo.toString().contains("\nCore Competency: Data not available"));
        Assert.assertEquals("OOPS! This job does not seem to exist.",testFour.toString());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testOne=new Job("Product tester",new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"),new CoreCompetency("Persistence"));
        Assert.assertEquals('\n',testOne.toString().charAt(0));
        Assert.assertEquals('\n',testOne.toString().charAt(testOne.toString().length()-1));
    }

}
