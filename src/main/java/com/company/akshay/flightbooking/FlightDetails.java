package com.company.akshay.flightbooking;

/**
 * Created by Durgaprasad on 4/21/2017.
 */

public class FlightDetails {

    private int mFlightId;
    private String mFlightName;
    private String mSource;
    private String mDestination;
    private String mDeparture;
    private String mArrival;
    private int mPrice;

    public FlightDetails(int nmFlightId, String nmFlightName, String nmSource, String nmDestination, String nmDeparture, String nmArrival, int nmPrice) {
        this.mFlightId = nmFlightId;
        this.mFlightName = nmFlightName;
        this.mSource = nmSource;
        this.mDestination = nmDestination;
        this.mDeparture = nmDeparture;
        this.mArrival = nmArrival;
        this.mPrice = nmPrice;
    }

    public int getmFlightId() {
        return mFlightId;
    }

    public String getmFlightName() {
        return mFlightName;
    }

    public String getmSource() {
        return mSource;
    }

    public String getmDestination() {
        return mDestination;
    }

    public String getmDeparture() {
        return mDeparture;
    }

    public String getmArrival() {
        return mArrival;
    }

    public int getmPrice() {
        return mPrice;
    }
}
