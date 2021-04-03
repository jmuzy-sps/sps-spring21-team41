package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.gson.Gson;
import com.google.sps.data.Event;
import com.google.sps.data.Location;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This Servlet will retrieve events which will eventually be listed on home page.
 */

@WebServlet("/retrieve-events")
public final class EventRetrievalServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind("event").setOrderBy(OrderBy.desc("date")).build();
    QueryResults<Entity> results = datastore.run(query);

    List<Event> events = new ArrayList<>();
    while (results.hasNext()) {
        Entity entity = results.next();

        String type = entity.getString("type");
        String details = entity.getString("details");
        String street = entity.getString("street");
        String state = entity.getString("state");
        String zipCode = entity.getString("zip");
        double price = entity.getDouble("price");
        long date = entity.getLong("date");

        Location address = new Location(street, state, zipCode);

        Event event = new Event(type, details, price, date, address);
        events.add(event);
    }

    Gson gson = new Gson();

    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(events));
  }
}