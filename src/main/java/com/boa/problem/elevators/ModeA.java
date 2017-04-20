package com.boa.problem.elevators;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by calverst on 4/19/17.
 */
public class ModeA implements Solver {
    @Override
    public List<Integer> solve(InputData data) {
        List<Integer> solution = new LinkedList<Integer>();
        int start = data.getStart();
        solution.add(start);
        for (Request request:data.getRequests()) {
            if (request.getStart() != start) {
                solution.add(request.getStart());
            }
            solution.add(request.getEnd());
            start = request.getEnd();
        }
        return solution;
    }
}
