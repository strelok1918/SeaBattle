package com.SeaBattle;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import com.SeaBattle.core.Point;

import java.util.ArrayList;

public class General extends Activity
{
    FieldAdapter field = new FieldAdapter(this);
    private void generateField() {
        GridView myField = (GridView)findViewById(R.id.myShipsField);
        myField.setNumColumns(10);
        myField.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        myField.setHorizontalSpacing(2);
        myField.setVerticalSpacing(2);

        ArrayList<TextView> myFieldButtons = new ArrayList<TextView>();
        for(int i = 0; i < 100; i++) {
            TextView button = new TextView(this);
            button.setBackgroundColor(Color.LTGRAY);
            button.setWidth(30);
            button.setHeight(30);
            button.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
            button.setOnClickListener(fieldButtonClick);
            myFieldButtons.add(button);
        }

        field.init(myFieldButtons);
        myField.setAdapter(field);
    }

     View.OnClickListener fieldButtonClick = new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Point p = new Point(0, 0).getPointByNum(field.getPosition(view));

             Toast.makeText(getApplicationContext(), p.toString(), Toast.LENGTH_LONG).show();
         }
     };
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_field);
        generateField();
    }
}
