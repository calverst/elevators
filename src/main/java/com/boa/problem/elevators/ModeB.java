package com.boa.problem.elevators;

import java.util.*;

/**
 * Created by calverst on 4/19/17.
 */
public class ModeB implements Solver {
    private int start;
    @Override
    public List<Integer> solve(InputData data) {
        List<Integer> solution = new LinkedList<Integer>();
        start = data.getStart();
        solution.add(start);
        Request previous = null;
        NavigableSet<Integer> floors = new TreeSet<Integer>();
        Boolean asc = null;
        for (Request current:data.getRequests()) {
            asc = ascending(current);
            if (previous == null) {
                previous = current;
            } else {
                if (!sameDirection(previous,current)) {
                    if (floors.size() > 0) {
                        start = addBasedOnCurrent(ascending(previous),solution,floors);
                    }
                    previous = current;
                }
            }
            floors.add(current.getStart());
            floors.add(current.getEnd());
        }
        addBasedOnCurrent(asc,solution,floors);
        return solution;
    }
    public void addIfNotMatches(Integer current, List<Integer> solution) {
        if (start != current) {
            solution.add(current);
        }
    }
    public int addBasedOnCurrent(Boolean ascending, List<Integer> solution, NavigableSet<Integer> floors) {
        int end = 0;
        if (ascending != null) {
            if (ascending) {
                end = floors.first();
                Integer last = floors.pollLast();
                addIfNotMatches(last,solution);
                for (last = floors.pollLast(); last != null; last = floors.pollLast()) {
                    solution.add(last);
                }
            } else {
                end = floors.last();
                Integer first = floors.pollFirst();
                addIfNotMatches(first,solution);
                for (first = floors.pollFirst(); first != null; first = floors.pollFirst()) {
                    solution.add(first);
                }
            }
        }
        return end;
    }
    //not handling start==end case assuming as invalid
    public boolean ascending(Request current) {
        return current.getStart()-current.getEnd() > 0;
    }
    public boolean sameDirection(Request previous, Request current) {
        return ascending(previous) == ascending(current);
    }
}
