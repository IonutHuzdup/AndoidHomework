package com.example.secondhomework;


import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyConfigSingleton {
    private static VolleyConfigSingleton instance;
    private RequestQueue requestQueue;
    private static Context context;

    private VolleyConfigSingleton(Context context) {
        this.context = context;
        requestQueue = getRequestQueue();

    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }

        return requestQueue;
    }


    public static synchronized VolleyConfigSingleton getInstance(Context context) {
        if (instance == null) {
            instance = new VolleyConfigSingleton(context);
        }
        return instance;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }

}
