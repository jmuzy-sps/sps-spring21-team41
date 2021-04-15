package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
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
        Query.newEntityQueryBuilder().setKind("event").setOrderBy(OrderBy.desc("epoch")).build();
    QueryResults<Entity> results = datastore.run(query);

    List<Event> events = new ArrayList<>();
    while (results.hasNext()) {
        Entity entity = results.next();

        String type = entity.getString("type");
        String description = entity.getString("description");
        String address = entity.getString("address");
        String city = entity.getString("city");
        String state = entity.getString("state");
        String zipCode = entity.getString("zip");
        double latitude = entity.getDouble("latitude");
        double longitude = entity.getDouble("longitude");
        double price = entity.getDouble("price");
        long epoch = entity.getLong("epoch");

        Location fullAddress = new Location(address, city, state, zipCode, latitude, longitude);

        Event event = new Event(type, description, price, epoch, fullAddress);
        events.add(event);
    }

    Gson gson = new Gson();

    response.setContentType("application/json;");
    response.setCharacterEncoding("utf-8");
    response.getWriter().println(gson.toJson(events));
  }
}