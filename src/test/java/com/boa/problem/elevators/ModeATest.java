package com.boa.problem.elevators;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by calverst on 4/19/17.
 */
public class ModeATest {

    private ProblemSetup setup;
    private ModeA solver;
    private SolutionPrinter printer;

    @Before
    public void setup() {
        setup = new ProblemSetupImpl(Elevator.MAX_FLOOR);
        solver = new ModeA();
        printer = new SolutionPrinterImpl();
    }

    @Test
    public void scenarioOne() throws ValidationException {
        InputData data = setup.parse("10:8-1");
        Assert.assertEquals("10 8 1 (9)", printer.print(solver.solve(data)));
    }

    @Test
    public void scenarioTwo() throws ValidationException {
        InputData data = setup.parse("9:1-5,1-6,1-5");
        Assert.assertEquals("9 1 5 1 6 1 5 (30)", printer.print(solver.solve(data)));
    }

    @Test
    public void scenarioThree() throws ValidationException {
        InputData data = setup.parse("2:4-1,4-2,6-8");
        Assert.assertEquals("2 4 1 4 2 6 8 (16)", printer.print(solver.solve(data)));
    }

    @Test
    public void scenarioFour() throws ValidationException {
        InputData data = setup.parse("3:7-9,3-7,5-8,7-11,11-1");
        Assert.assertEquals("3 7 9 3 7 5 8 7 11 1 (36)", printer.print(solver.solve(data)));
    }

    @Test
    public void scenarioFive() throws ValidationException {
        InputData data = setup.parse("7:11-6,10-5,6-8,7-4,12-7,8-9");
        Assert.assertEquals("7 11 6 10 5 6 8 7 4 12 7 8 9 (40)", printer.print(solver.solve(data)));
    }

    @Test
    public void scenarioSix() throws ValidationException {
        InputData data = setup.parse("6:1-8,6-8");
        Assert.assertEquals("6 1 8 6 8 (16)", printer.print(solver.solve(data)));
    }
}
