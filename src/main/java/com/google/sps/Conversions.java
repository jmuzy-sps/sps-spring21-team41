package com.google.sps;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.DateFormat;

public class Conversions {

public long ToEpochDate(String Date) {
    try {
        return new SimpleDateFormat("MM-dd-yyyy HH:mm").parse(Date).getTime();
    } catch (ParseException e) {
    return 0;
}
}
public static double parseDouble(String Price) throws NumberFormatException{
    double dnum = Double.parseDouble(Price);
    return(dnum);
}
}