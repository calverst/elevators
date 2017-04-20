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
        Solver solver = setup.parse("A:6:12-8,6-8");
        Assert.assertNotNull(solver);
        Assert.assertTrue(solver instanceof ModeA);
        ModeA m = (ModeA) solver;
        Assert.assertEquals(6, m.start);
        Assert.assertEquals(2, m.requests.size());
        Assert.assertEquals(12, m.requests.get(0).getStart());
        Assert.assertEquals(8, m.requests.get(0).getEnd());
        Assert.assertEquals(6, m.requests.get(1).getStart());
        Assert.assertEquals(8, m.requests.get(1).getEnd());
    }

    @Test
    public void basicValidB() throws ValidationException {
        Solver solver = setup.parse("B:6:12-8,6-8");
        Assert.assertNotNull(solver);
        Assert.assertTrue(solver instanceof ModeB);
        ModeB m = (ModeB) solver;
        Assert.assertEquals(6, m.start);
        Assert.assertEquals(2, m.requests.size());
        Assert.assertEquals(12, m.requests.get(0).getStart());
        Assert.assertEquals(8, m.requests.get(0).getEnd());
        Assert.assertEquals(6, m.requests.get(1).getStart());
        Assert.assertEquals(8, m.requests.get(1).getEnd());
    }

    @Test(expected=ValidationException.class)
    public void basicInvalidMode() throws ValidationException {
        Solver solver = setup.parse("V:6:1-8,6-8");
        Assert.assertNotNull(solver);
    }

    @Test(expected=ValidationException.class)
    public void basicInvalidFormat1() throws ValidationException {
        Solver solver = setup.parse("V6:1-8,6-8");
        Assert.assertNotNull(solver);
    }

    @Test(expected=ValidationException.class)
    public void basicInvalidFormat2() throws ValidationException {
        Solver solver = setup.parse("V:6:18,6-8");
        Assert.assertNotNull(solver);
    }

    @Test(expected=ValidationException.class)
    public void basicInvalidFormat3() throws ValidationException {
        Solver solver = setup.parse("V:6:1-86-8");
        Assert.assertNotNull(solver);
    }

    @Test(expected=ValidationException.class)
    public void basicInvalidFormat4() throws ValidationException {
        Solver solver = setup.parse("V:6:1-8,68");
        Assert.assertNotNull(solver);
    }

    @Test(expected=InvalidFloorException.class)
    public void basicInvalidValue() throws ValidationException {
        Solver solver = setup.parse("A:6:55-8,6-8");
        Assert.assertNotNull(solver);
    }
}
