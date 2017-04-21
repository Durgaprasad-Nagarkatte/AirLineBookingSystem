package com.company.akshay.flightbooking;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.resource;

/**
 * Created by Durgaprasad on 4/21/2017.
 */

public class FlightAdapter extends ArrayAdapter<FlightDetails> {
    public FlightAdapter(Context context, ArrayList<FlightDetails> flights) {
        super(context, 0, flights);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        FlightDetails flightDetails = getItem(position);


        TextView flightName = (TextView)listItemView.findViewById(R.id.airLineName);
        flightName.setText(flightDetails.getmFlightName());

        TextView flightSource = (TextView)listItemView.findViewById(R.id.src);
        String source = flightDetails.getmSource();
        flightSource.setText(source.substring(0,3).toUpperCase());

        TextView flightDestination = (TextView)listItemView.findViewById(R.id.dest);
        String destination = flightDetails.getmDestination();
        flightDestination.setText(destination.substring(0,3).toUpperCase());

        TextView flightDepartureTime = (TextView)listItemView.findViewById(R.id.dept_time);
        flightDepartureTime.setText(flightDetails.getmDeparture());

        TextView flightArrivalTime = (TextView)listItemView.findViewById(R.id.arrival_time);
        flightArrivalTime.setText(flightDetails.getmArrival());

        TextView price = (TextView)listItemView.findViewById(R.id.price);
        price.setText(Integer.toString(flightDetails.getmPrice()));

        return listItemView;
    }
}
