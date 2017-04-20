package com.boa.problem.elevators;

/**
 * Created by calverst on 4/19/17.
 */
public interface ProblemSetup {
    Solver parse(String data) throws ValidationException;
}
