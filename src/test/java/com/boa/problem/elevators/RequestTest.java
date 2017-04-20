package com.boa.problem.elevators;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by calverst on 4/19/17.
 */
public class RequestTest {
    @Test
    public void requestTest() throws ValidationException {
        Request req = new Request(1,2);
        Assert.assertEquals(1,req.getStart());
        Assert.assertEquals(2,req.getEnd());
    }
}
