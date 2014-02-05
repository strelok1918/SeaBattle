package com.SeaBattle;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import com.main.java.mvn_driven.SeaBattle.R;

public class General extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.my_field);
        GridView myField = (GridView)findViewById(R.id.myShipsField);
        myField.setNumColumns(10);

    }
}
