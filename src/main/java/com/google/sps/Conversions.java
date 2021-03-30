package com.google.sps;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.DateFormat;

public class Conversions {

    public long ToEpochDate(String Date) {
        try {
            return new SimpleDateFormat("MM-dd-yyyy HH:mm").parse(Date).getTime();
        } 
        catch (ParseException e) {
        return 0;
        }
    }
}