package ninja.paranoidandroid.firebasemessaging;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import ninja.paranoidandroid.firebasemessaging.models.CompanyProjects;
import ninja.paranoidandroid.firebasemessaging.models.Project;

public class AddProject extends AppCompatActivity {

    //Log
    private final static String TAG = "AddProject";

    //UI
    private EditText mProjectNameEditText;
    private EditText mProjectStartDateEditText;
    private EditText mProjectEndDateTextView;
    private EditText mProjectDescriptionEditText;
    private EditText mProjectGoalEditText;
    private EditText mProjectBudgetEditText;
    private Button mProjectCancelButton;
    private Button mProjectOkButton;

    //Firebase
    private DatabaseReference mFireBaseReference;

    //Project company key
    private String mProjectCompanyKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);

        mProjectCompanyKey = getIntent().getStringExtra("PROJECT_COMPANY_KEY");

        initView();

    }

    @Override
    protected void onStart() {
        super.onStart();

        mFireBaseReference = FirebaseDatabase.getInstance().getReference();
    }

    private void initView(){

        mProjectNameEditText = (EditText) findViewById(R.id.et_activity_add_project_name);
        mProjectStartDateEditText = (EditText) findViewById(R.id.et_activity_add_project_start_date);
        mProjectEndDateTextView = (EditText) findViewById(R.id.et_activity_add_project_end_date);
        mProjectDescriptionEditText = (EditText) findViewById(R.id.et_activity_add_project_description);
        mProjectGoalEditText = (EditText) findViewById(R.id.et_activty_add_project_goal);
        mProjectBudgetEditText = (EditText) findViewById(R.id.et_activity_add_project_budget);
        mProjectCancelButton = (Button) findViewById(R.id.b_activity_add_project_cancel);
        mProjectOkButton = (Button) findViewById(R.id.b_activity_add_project_ok);

        //Sets button on clik listeners
        setListeners();

    }

    private void setListeners(){

        mProjectCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mProjectOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = mProjectNameEditText.getText().toString();
                String startDate = mProjectStartDateEditText.getText().toString();
                String endDate = mProjectEndDateTextView.getText().toString();
                String description = mProjectDescriptionEditText.getText().toString();
                double budget = Double.parseDouble(mProjectBudgetEditText.getText().toString());

                Project project = createCompanyProject(name, mProjectCompanyKey,startDate, endDate, description, budget);

                DatabaseReference newProjectRef = mFireBaseReference.child("project").push();
                newProjectRef.setValue(project);
                String newProjectKey = newProjectRef.getKey();

                DatabaseReference companyProjectsReference = mFireBaseReference.child("company-projects/" + mProjectCompanyKey + "/" + newProjectKey);
                CompanyProjects companyProjects = createCompanyProjectsItem(name, mProjectCompanyKey, description);
                //Map<String, CompanyProjects> map = new HashMap<String, CompanyProjects>();
               // map.put(newProjectKey, companyProjects);
                companyProjectsReference.setValue(companyProjects);


            }
        });

    }

    private Project createCompanyProject(String name, String companyKey, String startDate, String endDate, String description, double budget){

        Project project = new Project();
        project.setName(name);
        project.setCompanyKey(companyKey);
        project.setStartDate(startDate);
        project.setEndDate(endDate);
        project.setDescription(description);
        project.setBudget(budget);

        return project;
    }

    private CompanyProjects createCompanyProjectsItem(String name, String companyKey,String description){

        CompanyProjects companyProjects = new CompanyProjects();
        companyProjects.setName(name);
        companyProjects.setCompanyKey(companyKey);
        companyProjects.setDescription(description);

        return companyProjects;
    }
}
