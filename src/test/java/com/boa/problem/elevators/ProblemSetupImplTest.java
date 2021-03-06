package com.boa.problem.elevators;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by calverst on 4/19/17.
 */
public class ProblemSetupImplTest {
    private ProblemSetup setup;

    @Before
    public void setup() {
        setup = new ProblemSetupImpl(Elevator.MAX_FLOOR);
    }

    @Test
    public void basicValidA() throws ValidationException {
        InputData data = setup.parse("6:12-8,6-8");
        Assert.assertNotNull(data);
        Assert.assertEquals(6, data.getStart().intValue());
        Assert.assertEquals(2, data.getRequests().size());
        Assert.assertEquals(12, data.getRequests().get(0).getStart());
        Assert.assertEquals(8, data.getRequests().get(0).getEnd());
        Assert.assertEquals(6, data.getRequests().get(1).getStart());
        Assert.assertEquals(8, data.getRequests().get(1).getEnd());
    }

    @Test
    public void basicValidB() throws ValidationException {
        InputData data = setup.parse("6:12-8,6-8");
        Assert.assertNotNull(data);
        Assert.assertEquals(6, data.getStart().intValue());
        Assert.assertEquals(2, data.getRequests().size());
        Assert.assertEquals(12, data.getRequests().get(0).getStart());
        Assert.assertEquals(8, data.getRequests().get(0).getEnd());
        Assert.assertEquals(6, data.getRequests().get(1).getStart());
        Assert.assertEquals(8, data.getRequests().get(1).getEnd());
    }

    @Test(expected=ValidationException.class)
    public void basicInvalidMode() throws ValidationException {
        InputData data = setup.parse("V:6:1-8,6-8");
        Assert.assertNotNull(data);
    }

    @Test(expected=ValidationException.class)
    public void basicInvalidFormat1() throws ValidationException {
        InputData data = setup.parse("V6:1-8,6-8");
        Assert.assertNotNull(data);
    }

    @Test(expected=ValidationException.class)
    public void basicInvalidFormat2() throws ValidationException {
        InputData data = setup.parse("6:18,6-8");
        Assert.assertNotNull(data);
    }

    @Test(expected=ValidationException.class)
    public void basicInvalidFormat3() throws ValidationException {
        InputData data = setup.parse("6:1-86-8");
        Assert.assertNotNull(data);
    }

    @Test(expected=ValidationException.class)
    public void basicInvalidFormat4() throws ValidationException {
        InputData data = setup.parse("6:1-8,68");
        Assert.assertNotNull(data);
    }

    @Test(expected=InvalidFloorException.class)
    public void basicInvalidValue() throws ValidationException {
        InputData data = setup.parse("6:55-8,6-8");
        Assert.assertNotNull(data);
    }
}
