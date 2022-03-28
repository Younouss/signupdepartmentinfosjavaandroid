package edu.uco.ythiam.p4younouss_t;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button signUp, departmentInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signUp = (Button) findViewById(R.id.signUp);
        departmentInfo = (Button) findViewById(R.id.deptInfo);
        MyListener listen =  new MyListener();
        signUp.setOnClickListener(listen);
        departmentInfo.setOnClickListener(listen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    private class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(v == signUp) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
            if(v == departmentInfo) {
                Intent intent = new Intent(MainActivity.this, DepartmentActivity.class);
                startActivity(intent);
            }
        }
    }
}
