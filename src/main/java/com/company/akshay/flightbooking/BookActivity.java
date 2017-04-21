package com.company.akshay.flightbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BookActivity extends AppCompatActivity {

    Button confirmBooking;
    EditText fromAddress;
    EditText toAddress;
    EditText date;
    EditText noOfPassengers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        confirmBooking = (Button) findViewById(R.id.confirmBooking);
        fromAddress = (EditText) findViewById(R.id.fromAddress);
        toAddress = (EditText) findViewById(R.id.toAddress);
        date = (EditText)findViewById(R.id.date);
        noOfPassengers = (EditText)findViewById(R.id.passenger);

        confirmBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FlightBookingActivity.class);
                Bundle extras = new Bundle();
                extras.putString("from_address", fromAddress.getText().toString());
                extras.putString("to_address", toAddress.getText().toString());
                extras.putString("date", date.getText().toString());
                extras.putString("no_of_passengers", noOfPassengers.getText().toString());
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

    }
}
