package com.boa.problem.elevators;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Created by calverst on 4/19/17.
 */
public class ModeBTest {

    private ProblemSetup setup;
    private ModeB solver;
    private SolutionPrinter printer;

    @Before
    public void setup() {
        setup = new ProblemSetupImpl(Elevator.MAX_FLOOR);
        solver = new ModeB();
        printer = new SolutionPrinterImpl();
    }

    @Test
    public void testScenarioOne() throws ValidationException {
        InputData data = setup.parse("10:8-1");
        Assert.assertEquals("10 8 1 (9)", printer.print(solver.solve(data)));
    }

    @Test
    public void testScenarioTwo() throws ValidationException {
        InputData data = setup.parse("9:1-5,1-6,1-5");
        Assert.assertEquals("9 1 5 6 (13)", printer.print(solver.solve(data)));
    }

    @Test
    public void testScenarioThree() throws ValidationException {
        InputData data = setup.parse("2:4-1,4-2,6-8");
        Assert.assertEquals("2 4 2 1 6 8 (12)", printer.print(solver.solve(data)));
    }

    @Test
    public void testScenarioFour() throws ValidationException {
        InputData data = setup.parse("3:7-9,3-7,5-8,7-11,11-1");
        Assert.assertEquals("3 5 7 8 9 11 1 (18)", printer.print(solver.solve(data)));
    }

    @Test
    public void testScenarioFive() throws ValidationException {
        InputData data = setup.parse("7:11-6,10-5,6-8,7-4,12-7,8-9");
        Assert.assertEquals("7 11 10 6 5 6 8 12 7 4 8 9 (30)", printer.print(solver.solve(data)));
    }

    @Test
    public void testScenarioSix() throws ValidationException {
        InputData data = setup.parse("6:1-8,6-8");
        Assert.assertEquals("6 1 6 8 (12)", printer.print(solver.solve(data)));
    }

    @Test
    public void testRequestAscTrue() throws ValidationException {
        Request req = new Request(2,1);
        ModeB b = new ModeB();
        Assert.assertTrue(b.ascending(req));
    }

    @Test
    public void testRequestAscFalse() throws ValidationException {
        ModeB b = new ModeB();
        Request req = new Request(1,2);
        Assert.assertFalse(b.ascending(req));
    }

    @Test
    public void testRequestSameDirection() throws ValidationException {
        Request previous = new Request(2,1);
        Request current = new Request(6,5);
        ModeB b = new ModeB();
        Assert.assertTrue(b.sameDirection(previous, current));
    }

    @Test
    public void testRequestOppositeDirection() throws ValidationException {
        Request previous = new Request(2,1);
        Request current = new Request(5,6);
        ModeB b = new ModeB();
        Assert.assertFalse(b.sameDirection(previous, current));
    }

    @Test
    public void testAddIfNotMatchesAdd() throws ValidationException {
        ModeB b = new ModeB();
        b.solve(new InputData(1,new LinkedList<Request>()));
        List<Integer> solution = new LinkedList<Integer>();
        b.addIfNotMatches(2, solution);
        Assert.assertEquals(1, solution.size());
        Assert.assertEquals(2, solution.get(0).intValue());
    }

    @Test
    public void testAddIfNotMatchesSkip() throws ValidationException {
        ModeB b = new ModeB();
        b.solve(new InputData(1,new LinkedList<Request>()));
        List<Integer> solution = new LinkedList<Integer>();
        b.addIfNotMatches(1, solution);
        Assert.assertEquals(0, solution.size());
    }

    @Test
    public void testAddBasedOnCurrentAsc() throws ValidationException {
        ModeB b = new ModeB();
        List<Integer> solution = new LinkedList<Integer>();
        NavigableSet<Integer> floors = new TreeSet<Integer>();
        floors.add(2);
        floors.add(3);
        b.addBasedOnCurrent(false, solution, floors);
        Assert.assertEquals(2, solution.size());
        Assert.assertEquals(2, solution.get(0).intValue());
        Assert.assertEquals(3, solution.get(1).intValue());
    }

    @Test
    public void testAddBasedOnCurrentDesc() throws ValidationException {
        ModeB b = new ModeB();
        List<Integer> solution = new LinkedList<Integer>();
        NavigableSet<Integer> floors = new TreeSet<Integer>();
        floors.add(2);
        floors.add(3);
        b.addBasedOnCurrent(true, solution, floors);
        Assert.assertEquals(2, solution.size());
        Assert.assertEquals(3, solution.get(0).intValue());
        Assert.assertEquals(2, solution.get(1).intValue());
    }

}
