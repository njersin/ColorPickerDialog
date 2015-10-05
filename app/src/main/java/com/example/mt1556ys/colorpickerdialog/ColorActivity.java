package com.example.mt1556ys.colorpickerdialog;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ColorActivity extends AppCompatActivity implements ColorPickerDialog.ColorDialogListener {

    int backgroundColor;
    Button chooseColorButton;
    View background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);


        backgroundColor = Color.rgb(11, 25, 25);

        background = findViewById(android.R.id.content);

        background.setBackgroundColor(backgroundColor);

        chooseColorButton = (Button) findViewById(R.id.color_dialog_button);
        chooseColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorPickerDialog dialog = new ColorPickerDialog();
                dialog.show(getFragmentManager(), dialog.getClass().getName());
            }
        });
    }

    @Override
    public void onNewColorSelected(int color) {
        backgroundColor = color;
        background.setBackgroundColor(backgroundColor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_color, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
