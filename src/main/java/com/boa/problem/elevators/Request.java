package com.boa.problem.elevators;

/**
 * Created by calverst on 4/19/17.
 */
public class Request {
    private final int start;
    private final int end;
    public Request(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

}
