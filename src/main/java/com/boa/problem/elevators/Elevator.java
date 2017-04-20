package com.boa.problem.elevators;

/**
 * Created by calverst on 4/19/17.
 */
public class Elevator {

    public static final int MAX_FLOOR = 12;

    public static void main(String[] args) throws ValidationException {
        ProblemSetup problem = new ProblemSetupImpl(MAX_FLOOR);
        Solver solver = problem.parse(args[0]);
        SolutionPrinter printer = new SolutionPrinterImpl();
        System.out.println(printer.print(solver.solve()));
    }
}
