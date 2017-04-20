package com.boa.problem.elevators;

/**
 * Created by calverst on 4/19/17.
 */
public class InvalidFloorException extends ValidationException {
    public InvalidFloorException(int floor) {
        super(""+floor);
    }
}
