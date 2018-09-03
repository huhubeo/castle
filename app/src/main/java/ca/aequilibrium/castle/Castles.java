package ca.aequilibrium.castle;

import android.util.Log;

import java.util.List;

public class Castles {
    public static String TAG = Castles.class.getName();
    enum State {START, LOWER, HIGHER}


    /**
     *  Function calculate number of castles on peak and valley
     *  Assumptions:
     *  Starting position can be peak or valley
     *  Starting series (with same height) can be peaks or valleys
     *  Ending position can be peak or valley
     *  Ending series (with same height) can be peaks or valleys
     *
     * @param heights
     * @return number of castles
     */
    public static int countCastles(int[] heights) {
        int countCastle = 0;

        //using only for testing
        String peaks = "";
        String valleys = "";

        if (heights == null) {
            return 0;
        } else if (heights.length == 1) {
            return 1;
        }

        int start = 0;
        int end = 0;
        State state = State.START;

        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] == heights[i + 1]){
                if (i == heights.length - 2) {
                    //end position
                    if (state == State.LOWER) {
                        //add valleys
                        for (int k = start; k < heights.length; k++) {
                            valleys += heights[k] + " ";
                        }
                    } else if (state == State.HIGHER) {
                        //add peaks
                        for (int k = start; k < heights.length; k++) {
                            peaks += heights[k] + " ";
                        }
                    }
                    countCastle += heights.length - start;
                }
                end = i + 1;
            } else {
                if (i == 0) {
                    state = (heights[i] > heights[i + 1]) ? State.LOWER : State.HIGHER;
                    //first item is valley or peak
                    countCastle++;
                    if (state == State.HIGHER) {
                        valleys += heights[0] + " ";
                    } else {
                        peaks += heights[0] + " ";
                    }
                } else {
                    if (state == State.START) {
                        if (heights[i] > heights[i + 1]) {
                            //from start to i are peaks
                            for (int k = start; k <= i; k++) {
                                peaks += heights[k] + " ";
                            }
                        } else {
                            //from start to i are valleys
                            for (int k = start; k <= i; k++) {
                                valleys += heights[k] + " ";
                            }
                        }
                        state = (heights[i] > heights[i + 1]) ? State.LOWER : State.HIGHER;
                        //including i position so +1
                        countCastle += i + 1 - start;
                    } else {
                        if ((state == State.HIGHER) && heights[i] > heights[i + 1]) {
                            //going up and down now
                            for (int k = start; k <= end; k++) {
                                peaks += heights[k] + " ";
                            }
                            state = State.LOWER;
                            //including end position so +1
                            countCastle += end + 1 - start;
                        }
                        else if ((state == State.LOWER) && heights[i] < heights[i +1]) {
                            //going down and now up
                            for (int k = start; k <= end; k++) {
                                valleys += heights[k] + " ";
                            }
                            state = State.HIGHER;
                            //including end position so +1
                            countCastle += end + 1 - start;
                        }
                    }
                }
                if (i == heights.length - 2) {
                    //last position is valley or peak
                    countCastle++;
                    if (heights[i] > heights[i + 1]) {
                        valleys += heights[i + 1] + " ";
                    } else {
                        peaks += heights[i + 1] + " ";
                    }
                }
                start = i + 1;
                end = i + 1;
            }
        }

        Log.d(TAG, "Peaks: " + peaks);
        Log.d(TAG, "Valleys: " + valleys);

        return countCastle;
    }
}
