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
        String street = Jsoup.clean(request.getParameter("street"), Whitelist.none()),
            state = Jsoup.clean(request.getParameter("state"), Whitelist.none()),
            type = Jsoup.clean(request.getParameter("type"), Whitelist.none()),
            details = Jsoup.clean(request.getParameter("details"), Whitelist.none());
        int zipCode = Integer.parseInt(request.getParameter("zipCode")),
            price = Integer.parseInt(request.getParameter("price"));

        /**
         * TODO (Josh-hdz): posible validations (ex. one event per address)
         */

        FullEntity taskEntity =
            Entity.newBuilder(keyFactory.newKey())
                .set("type", type)
                .set("details", details)
                .set("price", price)
                .set("street", street)
                .set("state", state)
                .set("zip", zipCode)
                .build();
        datastore.put(taskEntity);

        /**
         * TODO (Josh-hdz): add response to let know front-end wether or not the
         *                  event was added to database
         */
        
    };
}
