package edu.uco.ythiam.p4younouss_t;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SignupActivity extends Activity {
    DateFormat f = DateFormat.getDateInstance();
    Calendar calendar = Calendar.getInstance();
    TextView birthDateView;
    String name, password, birthDate = "", gender = "", skills = "", classification;
    EditText nameText, passwordText;
    Button DateOfBirth, register;
    RadioButton male, female;
    CheckBox androidD, java, c, swift, ios;
    Spinner classificationSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Intent intent = getIntent();
        nameText = (EditText) findViewById(R.id.name);
        passwordText = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.register);
        DateOfBirth = (Button)findViewById(R.id.dateOfBirth);
        androidD = (CheckBox) findViewById(R.id.androidD);
        java = (CheckBox) findViewById(R.id.java);
        c = (CheckBox) findViewById(R.id.c);
        swift = (CheckBox) findViewById(R.id.swift);
        ios = (CheckBox) findViewById(R.id.ios);
        classificationSpinner = (Spinner) findViewById(R.id.classification);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        DateOfBirth.setOnClickListener(new MyListener());
        //birthDateView.setText(f.format(calendar.getTime()));
        //birthDate += f.format(calendar.getTime());
        Spinner classification = (Spinner) findViewById(R.id.classification);
        List<String> categories = new ArrayList<String>();
        categories.add("");
        categories.add("Freshman");
        categories.add("Sophomore");
        categories.add("Junior");
        categories.add("Senior");
        categories.add("Graduate");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        classification.setAdapter(adapter);
        register.setOnClickListener(new MyListener());
    }
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            //birthDateView.setText(f.format(calendar.getTime()));
            birthDate += f.format(calendar.getTime());
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signup, menu);
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
    public class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            if(v == DateOfBirth) {
                new DatePickerDialog(SignupActivity.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
            if(v == register) {
                Bundle bundle = new Bundle();
                name = nameText.getText().toString();
                password = passwordText.getText().toString();
                //birthDate = birthDateView.getText().toString();

                classification = classificationSpinner.getSelectedItem().toString();
                if(male.isChecked()){
                    gender += male.getText().toString();
                }
                else if(female.isChecked()){
                    gender += female.getText().toString();
                }
                if(androidD.isChecked()){
                    skills += androidD.getText().toString() + " ";
                }
                if(java.isChecked()){
                    skills += java.getText().toString() + " ";
                }
                if(c.isChecked()){
                    skills += c.getText().toString() + " ";
                }
                if(swift.isChecked()){
                    skills += swift.getText().toString() + " ";
                }
                if(ios.isChecked()){
                    skills += ios.getText().toString();
                }
                bundle.putString("name",name);
                bundle.putString("password", password);
                bundle.putString("birthDate",birthDate);
                bundle.putString("gender", gender);
                bundle.putString("skills", skills);
                bundle.putString("classification", classification);
                Intent intent = new Intent(SignupActivity.this, RegisterActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    }
}
