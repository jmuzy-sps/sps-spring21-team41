package com.google.sps.servlets;

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

/**
 * Servlet that manges create event POST request
 */
@WebServlet("/create-event")
public final class CreateEventServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("event");
        double price = Double.parseDouble(request.getParameter("price"));
        long date = Long.parseLong(request.getParameter("date"));
        String address = Jsoup.clean(request.getParameter("address"), Whitelist.none()),
            state = Jsoup.clean(request.getParameter("state"), Whitelist.none()),
            type = Jsoup.clean(request.getParameter("type"), Whitelist.none()),
            details = Jsoup.clean(request.getParameter("description"), Whitelist.none()),
            zipCode = Jsoup.clean(request.getParameter("zip"), Whitelist.none());

        /**
         * TODO (Josh-hdz): posible validations (ex. one event per address)
         */

        FullEntity taskEntity =
            Entity.newBuilder(keyFactory.newKey())
                .set("type", type)
                .set("date", date)
                .set("details", details)
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
        
    };
}