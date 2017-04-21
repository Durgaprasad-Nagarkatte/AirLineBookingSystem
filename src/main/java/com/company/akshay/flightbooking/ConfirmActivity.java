package com.company.akshay.flightbooking;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.company.akshay.flightbooking.Data.UserContract;
import com.company.akshay.flightbooking.Data.UserDbHelper;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int _planeId = Integer.parseInt(extras.getString("airline_id"));
        String planeName = extras.getString("airline_name");
        Log.i("Airline", planeName);
        int price = Integer.parseInt(extras.getString("airline_price"));

        TextView flightName = (TextView)findViewById(R.id.flightname);
        flightName.setText("Flight no is :" + _planeId + " Airline name :  "  + planeName );

        UserDbHelper mDbHelper = new UserDbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserContract.UserEntry.AIR_LINE_NAME, planeName);
        values.put(UserContract.UserEntry.AIR_LINE_ID, _planeId);
        long newRowId = db.insert(UserContract.UserEntry.TABLE_NAME, null, values);
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving user", Toast.LENGTH_SHORT).show();
        }
        else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "User saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
            TextView priceText = (TextView) findViewById(R.id.price);
            priceText.setText("You have been charged " + price + " and your PNR No is" + newRowId);
        }
    }

    public void mainActivity(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
