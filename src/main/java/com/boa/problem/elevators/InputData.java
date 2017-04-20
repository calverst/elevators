package com.boa.problem.elevators;

import java.util.List;

/**
 * Created by calverst on 4/20/17.
 */
public class InputData {
    private final Integer start;
    private final List<Request> requests;
    public InputData(Integer start, List<Request> requests) {
        this.start = start;
        this.requests = requests;
    }

    public Integer getStart() {
        return start;
    }

    public List<Request> getRequests() {
        return requests;
    }
}
