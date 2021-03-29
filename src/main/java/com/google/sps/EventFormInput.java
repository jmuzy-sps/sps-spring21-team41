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


@WebServlet("/get-info")
public class EventFormInput extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
     // Sanitize user input to remove HTML tags and JavaScript.
    String Type = Jsoup.clean(request.getParameter("type"), Whitelist.none());
    String Date = Jsoup.clean(request.getParameter("date"), Whitelist.none());
    double Price = Double.valueOf(request.getParameter("price"));
    String State = Jsoup.clean(request.getParameter("state"), Whitelist.none());
    String Address = Jsoup.clean(request.getParameter("address"), Whitelist.none());
    String Zip = Jsoup.clean(request.getParameter("zip"), Whitelist.none());

    //connverts Date to Epoch Time//
    Conversions StoredDate = new Conversions();
    long epochDate = StoredDate.ToEpochDate(Date);


    System.out.println(Price);

    System.out.println(epochDate);


    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Form");
    FullEntity eventEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("type", Type)
            .set("date",epochDate)
            .set("price",Price)
            .set("state",State)
            .set("address",Address)
            .set("zip",Zip)
            .build();
    datastore.put(eventEntity);
    response.sendRedirect("/index.html");
  }
}