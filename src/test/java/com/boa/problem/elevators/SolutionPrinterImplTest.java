package com.boa.problem.elevators;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by calverst on 4/19/17.
 */
public class SolutionPrinterImplTest {
    @Test
    public void scenarioOne() throws ValidationException {
        SolutionPrinter printer = new SolutionPrinterImpl();
        Assert.assertEquals("10 8 1 (9)", printer.print(Arrays.asList(10,8,1)));
    }
}
