package com.google.sps;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.gson.Gson;
import com.google.sps.Form;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/list-event-data")
public class ListEventDataServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind("Form").setOrderBy(OrderBy.desc("timestamp")).build();
    QueryResults<Entity> results = datastore.run(query);

    List<Form> forms = new ArrayList<>();
    while (results.hasNext()) {
        Entity entity = results.next();
        
        long id = entity.getKey().getId();      
        String type = entity.getString("type");
        long date = entity.getLong("date");
        double price= entity.getDouble("price");
        String zip = entity.getString("zip");
        String description = entity.getString("description");
        String address = entity.getString("address");
        String state = entity.getString("state");
        long timestamp = entity.getLong("timestamp");

       Form form = new Form(id, type, date, price, zip, description, address, state, timestamp);
      forms.add(form);
    }

    Gson gson = new Gson();

    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(forms));
  }
}