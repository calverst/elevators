package com.boa.problem.elevators;

import java.util.List;

/**
 * Created by calverst on 4/19/17.
 */
public class SolutionPrinterImpl implements SolutionPrinter {
    @Override
    public String print(List<Integer> solution) {
        String out = "";
        int current = 0;
        int sum = 0;
        for (Integer floor:solution) {
            out+=floor+" ";
            if (current == 0) {
                current = floor;
            } else {
                sum += Math.abs(current-floor);
                current = floor;
            }
        }
        return out+"("+sum+")";
    }
}
