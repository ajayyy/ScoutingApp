package ca.lakeeffect.scoutingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    List<Counter> counters = new ArrayList<>();
    List<CheckBox> checkboxes = new ArrayList<>();
    List<RadioButton> radioButtons = new ArrayList<>();
    List<Button> buttons = new ArrayList<>();
    List<SeekBar> seekbar = new ArrayList<>();

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add all buttons and counters etc.

        counters.add((Counter) findViewById(R.id.goalsCounter));

        checkboxes.add((CheckBox) findViewById(R.id.scaleCheckBox));

        submit = (Button) findViewById(R.id.submitButton);

        //add onClickListeners
    }

    @Override
    public void onClick(View v) {

    }
}
