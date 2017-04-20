package com.boa.problem.elevators;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by calverst on 4/19/17.
 */
public class Elevator {

    public static final int MAX_FLOOR = 12;
    private final static String MODE_A = "A";
    private final static String MODE_B = "B";

    public static void main(String[] args) throws ValidationException, IOException {
        Solver solver = null;
        if (MODE_A.equals(args[1])) {
            solver = new ModeA();
        } else if (MODE_B.equals(args[1])) {
            solver = new ModeB();
        } else {
            throw new ValidationException("Unknown Mode");
        }
        ProblemSetup problem = new ProblemSetupImpl(MAX_FLOOR);
        SolutionPrinter printer = new SolutionPrinterImpl();
        File file = new File(args[0]);
        if (file.exists() && file.canRead()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                InputData data = problem.parse(line);
                System.out.println(printer.print(solver.solve(data)));
            }
        } else {
            throw new IOException("File cannot be read");
        }
    }
}
