package com.boa.problem.elevators;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by calverst on 4/19/17.
 */
public class ModeA implements Solver {
    //Mode base class seem overkill
    protected int start;
    protected final List<Request> requests;
    public ModeA(int start, List<Request> requests) {
        this.start = start;
        this.requests = requests;
    }
    @Override
    public List<Integer> solve() {
        List<Integer> solution = new LinkedList<Integer>();
        solution.add(start);
        for (Request request:requests) {
            if (request.getStart() != start) {
                solution.add(request.getStart());
            }
            solution.add(request.getEnd());
            start = request.getEnd();
        }
        return solution;
    }
}
