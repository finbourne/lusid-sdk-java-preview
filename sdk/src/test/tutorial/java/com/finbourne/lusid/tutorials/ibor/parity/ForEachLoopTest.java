package com.finbourne.lusid.tutorials.ibor.parity;

import java.util.ArrayList;

public class ForEachLoopTest {

    @LusidFeature(value = "Apply For loop")
    public void apply_bitemporal_portfolio_change() throws Exception
    {
        // Reflections API doesn't work for this file completely when we add the ForLoop...
        ArrayList<String> test = new ArrayList<String>();
        test.forEach(t ->
                System.out.print("Test")
        );

    }

    @LusidFeature(value = "Test method 2")
    public void inBitemporal() {

    }
}
