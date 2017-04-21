package com.company.akshay.flightbooking;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.company.akshay.flightbooking.Data.UserContract;
import com.company.akshay.flightbooking.Data.UserDbHelper;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class ViewActivity extends AppCompatActivity {

    private UserDbHelper mDbHelper;
    EditText pnrNumber;
    int PNR;
    Button search;
    TextView textView5;
    TextView textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        pnrNumber = (EditText)findViewById(R.id.editText);
        search = (Button)findViewById (R.id.search);

        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        mDbHelper = new UserDbHelper(this);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PNR = Integer.parseInt(pnrNumber.getText().toString());
                Log.i("PNR Value", Integer.toString(PNR));
                displayDatabaseInfo();
            }
        });

    }

    private void displayDatabaseInfo() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                UserContract.UserEntry._ID,
                UserContract.UserEntry.AIR_LINE_NAME,
                UserContract.UserEntry.AIR_LINE_ID,
        };

        // Perform a query on the pets table
        Cursor cursor = db.query(
                UserContract.UserEntry.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                   // The sort order

        //TextView displayView = (TextView) findViewById(R.id.text_view_pet);

        try {
            // Create a header in the Text View that looks like this:
            //
            // The pets table contains <number of rows in Cursor> pets.
            // _id - name - breed - gender - weight
            //
            // In the while loop below, iterate through the rows of the cursor and display
            // the information from each column in this order.
            //displayView.setText("The pets table contains " + cursor.getCount() + " pets.\n\n");
            //displayView.append(PetEntry._ID + " - " +
            //       PetEntry.COLUMN_PET_NAME + " - " +
            //        PetEntry.COLUMN_PET_BREED + " - " +
            //        PetEntry.COLUMN_PET_GENDER + " - " +
            //        PetEntry.COLUMN_PET_WEIGHT + "\n");

            // Figure out the index of each column
            int idColumnIndex = cursor.getColumnIndex(UserContract.UserEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(UserContract.UserEntry.AIR_LINE_NAME);
            int airlineIdColumnIndex = cursor.getColumnIndex(UserContract.UserEntry.AIR_LINE_ID);


            // Iterate through all the returned rows in the cursor
            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentairlineID = cursor.getString(airlineIdColumnIndex);
                if(currentID == PNR){
                textView5.setText(currentName);
                    textView6.setText(currentairlineID);
                Log.i("Current Name",currentName);
                }

            }
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }
}
