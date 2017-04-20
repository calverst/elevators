package com.boa.problem.elevators;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by calverst on 4/19/17.
 */
public class ProblemSetupImpl implements ProblemSetup {
    private final static String COLON = ":";
    private final static String COMMA = ",";
    private final static String DASH = "-";
    private final static String MODE_A = "A";
    private final static String MODE_B = "B";

    private final int max;

    public final static Pattern INPUT_PATTERN = Pattern.compile("^[AB]:\\d+:\\d+-\\d+(,\\d+-\\d+)*$");
    //could also add the full regex validation, which seem overkill here
    //private final static Pattern INPUT_PATTERN = Pattern.compile("^[AB]:[1-9]|1[0-2]:..............");

    public ProblemSetupImpl(int max) {
        this.max = max;
    }

    @Override
    public Solver parse(String data) throws ValidationException{
        if (INPUT_PATTERN.matcher(data).matches()) {
            String[] out = data.split(COLON);
            if (out.length != 3) {
                throw new UnexpectedCountException(out.length);
            }
            if (MODE_A.equals(out[0])) {
                return new ModeA(validFloor(Integer.parseInt(out[1])), produceRequests(out[2]));
            } else if (MODE_B.equals(out[0])) {
                return new ModeB(validFloor(Integer.parseInt(out[1])), produceRequests(out[2]));
            } else {
                throw new ValidationException("Unknown Mode");
            }
        } else {
            throw new ValidationException(data);
        }
    }
    public int validFloor(int floor) throws InvalidFloorException {
        if (floor < 1 || floor > max) {
            throw new InvalidFloorException(floor);
        }
        return floor;
    }
    public List<Request> produceRequests(String data) throws UnexpectedCountException, InvalidFloorException {
        String[] out = data.split(COMMA);
        if (out.length == 0) {
            throw new UnexpectedCountException(out.length);
        }
        List<Request> outList = new LinkedList<Request>();
        for (String s:out) {
            outList.add(produceRequest(s));
        }
        return outList;
    }
    public Request produceRequest(String data) throws UnexpectedCountException, InvalidFloorException {
        String[] out = data.split(DASH);
        if (out.length != 2) {
            throw new UnexpectedCountException(out.length);
        }
        return new Request(validFloor(Integer.parseInt(out[0])),validFloor(Integer.parseInt(out[1])));
    }
}
