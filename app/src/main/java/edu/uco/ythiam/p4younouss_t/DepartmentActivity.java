package edu.uco.ythiam.p4younouss_t;

import android.app.Activity;
import android.content.ClipData;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;
import android.view.ActionMode;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView;
import android.widget.Toast;
import android.net.Uri;
public class DepartmentActivity extends Activity {
    ListView departments;
    ActionMode actionMode;
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        Intent intent = getIntent();
        departments = (ListView) findViewById(R.id.departments);
        departments.setOnItemLongClickListener(new myListener());
        List<String> departmentsArray = new ArrayList<String>();
        departmentsArray.add("Biology");
        departmentsArray.add("Chemistry");
        departmentsArray.add("Computer Science");
        departmentsArray.add("Engineering");
        departmentsArray.add("Funeral Services");
        departmentsArray.add("Mathematics & Statistics");
        departmentsArray.add("Nursing");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,departmentsArray);
        departments.setAdapter(adapter);
        registerForContextMenu(departments);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_department, menu);
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
    public class myListener implements OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id){
            int itemPosition = position;
            value = (String) departments.getItemAtPosition(position);
            MyActionModeCallback actionCallback = new   MyActionModeCallback();
            actionMode = startActionMode(actionCallback);
            //actionMode.setTitle(R.string.title_activity_department);
            return true;
        }
    }
    public class MyActionModeCallback implements ActionMode.Callback{
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu){
            mode.getMenuInflater().inflate(R.menu.action, menu);
            return true;
        }
        @Override
        public boolean onPrepareActionMode (ActionMode mode, Menu menu){
            return false;
        }
        @Override
                    public boolean onActionItemClicked (ActionMode mode, MenuItem item){
                        if(value == "Biology") {
                            if (item.getItemId() == R.id.call) {
                                Intent intent = new Intent(Intent.ACTION_DIAL);
                                intent.setData(Uri.parse("tel:(405) 974-5017"));
                                startActivity(intent);
                            }
                            if (item.getItemId() == R.id.web) {
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://biology.uco.edu"));
                                startActivity(intent);
                            }
                        }
                        if(value == "Chemistry") {
                            if (item.getItemId() == R.id.call) {
                                Intent intent = new Intent(Intent.ACTION_DIAL);
                                intent.setData(Uri.parse("tel:(405) 231-1718"));
                                startActivity(intent);
                            }
                            if (item.getItemId() == R.id.web) {
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http:/chemistry.uco.edu"));
                                startActivity(intent);
                            }
                        }
            if(value == "Computer Science") {
                if (item.getItemId() == R.id.call) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel: (405) 974-5716"));
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.web) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uco.edu/cms/academics/computer-science/"));
                    startActivity(intent);
                }
            }
            if(value == "Engineering") {
                if (item.getItemId() == R.id.call) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel: (405) 974-5718 "));
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.web) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uco.edu/cms/academics/engineering-and-physics/"));
                    startActivity(intent);
                }
            }
            if(value == "Funeral Services") {
                if (item.getItemId() == R.id.call) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:(405) 974-5001"));
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.web) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uco.edu/cms/academics/funeral-service/"));
                    startActivity(intent);
                }
            }
            if(value == "Mathematics & Statistics") {
                if (item.getItemId() == R.id.call) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel: (405) 974-5294"));
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.web) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.math.uco.edu/"));
                    startActivity(intent);
                }
            }
            if(value == "Nursing") {
                if (item.getItemId() == R.id.call) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:(405) 974-5000"));
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.web) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uco.edu/cms/academics/nursing/"));
                    startActivity(intent);
                }
            }
            return true;
        }
        @Override
        public void onDestroyActionMode (ActionMode mode){

        }

    }

}
