package edu.uco.ythiam.p4younouss_t;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class RegisterActivity extends Activity {
    TextView nameText, passwordText, birthDateText, genderText, skillsText, classificationText;
    String name, password, birthDate, gender, skills, classification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Bundle b = getIntent().getExtras();
        name = b.getString("name");
        nameText = (TextView) findViewById(R.id.name);
        nameText.setText(name);
        password = b.getString("password");
        passwordText = (TextView) findViewById(R.id.password);
        passwordText.setText(password);
        birthDate = b.getString("birthDate", birthDate);
        birthDateText = (TextView) findViewById(R.id.birthDate);
        birthDateText.setText(birthDate);
        gender = b.getString("gender");
        genderText = (TextView) findViewById(R.id.gender);
        genderText.setText(gender);
        skills = b.getString("skills");
        skillsText = (TextView) findViewById(R.id.skills);
        skillsText.setText(skills);
        classification = b.getString("classification");
        classificationText = (TextView) findViewById(R.id.classification);
        classificationText.setText(classification);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
