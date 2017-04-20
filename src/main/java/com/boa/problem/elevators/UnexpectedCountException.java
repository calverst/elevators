package com.boa.problem.elevators;

/**
 * Created by calverst on 4/19/17.
 */
public class UnexpectedCountException extends ValidationException {
    public UnexpectedCountException(int count) {
        super(""+count);
    }
}
