package ca.lakeeffect.scoutingapp;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    List<Counter> counters = new ArrayList<>();
    List<CheckBox> checkboxes = new ArrayList<>();
    List<RadioGroup> radiogroups = new ArrayList<>();
    List<Button> buttons = new ArrayList<>();
    List<SeekBar> seekbars = new ArrayList<>();

    Button submit;

    int robotNum = 0000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add all buttons and counters etc.

        counters.add((Counter) findViewById(R.id.goalsCounter));

        checkboxes.add((CheckBox) findViewById(R.id.scaleCheckBox));

        submit = (Button) findViewById(R.id.submitButton);

        //add onClickListeners

        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == submit){
            saveData();
        }
    }

    public void saveData(){
        File sdCard = Environment.getExternalStorageDirectory();
        File dir = new File (sdCard.getAbsolutePath() + "/ScoutingData/");

        File file = new File(dir, robotNum + ".txt");

        FileOutputStream f = null;
        try {
            f = new FileOutputStream(file);

            OutputStreamWriter myOutWriter = new OutputStreamWriter(f);

            for(Counter counter: counters){
                myOutWriter.append("counter " + getResources().getResourceEntryName(counter.getId()) + " " + counter.count + "\n");
            }

            for(CheckBox checkbox: checkboxes){
                myOutWriter.append("checkbox " + getResources().getResourceEntryName(checkbox.getId()) + " " + checkbox.isChecked() + "\n");
            }

            for(RadioGroup radiogroup: radiogroups){
                myOutWriter.append("radiogroup " + getResources().getResourceEntryName(radiogroup.getId()) + " " + radiogroup.indexOfChild(findViewById(radiogroup.getCheckedRadioButtonId())) + "\n");
            }

//            TODO: Write button data, might not be needed
//            for(Button button: buttons){
//                myOutWriter.append("button " + getResources().getResourceEntryName(button.getId()) + " " + counter.count + "\n");
//            }

            for(SeekBar seekbar: seekbars){
                myOutWriter.append("seekbar " + getResources().getResourceEntryName(seekbar.getId()) + " " + seekbar.getProgress() + "\n");
            }

            myOutWriter.close();

            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
