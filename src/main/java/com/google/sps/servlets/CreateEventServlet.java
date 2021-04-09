package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 * Servlet that manges create event POST request
 */
@WebServlet("/create-event")
public final class CreateEventServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long epoch;     // Hold date's convertion to epoch (value to be stored in Datastore).
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("event");
        double price = Double.parseDouble(request.getParameter("price"));
        String address = Jsoup.clean(request.getParameter("address"), Whitelist.none()),
            date = Jsoup.clean(request.getParameter("date"), Whitelist.none()),
            state = Jsoup.clean(request.getParameter("state"), Whitelist.none()),
            type = Jsoup.clean(request.getParameter("type"), Whitelist.none()),
            description = Jsoup.clean(request.getParameter("description"), Whitelist.none()),
            zipCode = Jsoup.clean(request.getParameter("zip"), Whitelist.none());

        try{
            epoch = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(date).getTime() / 1000;

            /**
             * TODO (Josh-hdz): posible validations (ex. one event per address)
             */

            FullEntity taskEntity =
                Entity.newBuilder(keyFactory.newKey())
                    .set("type", type)
                    .set("epoch", epoch)
                    .set("description", description)
                    .set("price", price)
                    .set("address", address)
                    .set("state", state)
                    .set("zip", zipCode)
                    .build();
            datastore.put(taskEntity);

            response.sendRedirect("/index.html");
            /**
             * TODO (Josh-hdz): add response to let know front-end wether or not the
             *                  event was added to database
             */

        } catch (java.text.ParseException e) {
            /**
             * This catch is unlikey to run since the date formation is done
             * by html, though it isrequired to compile the servlet.
             */
            response.sendError(1, "Invalid date format");
        }
    };
}