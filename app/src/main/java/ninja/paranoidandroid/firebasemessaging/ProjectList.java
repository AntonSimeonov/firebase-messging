package ninja.paranoidandroid.firebasemessaging;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ninja.paranoidandroid.firebasemessaging.models.CompanyProjects;
import ninja.paranoidandroid.firebasemessaging.models.Project;

public class ProjectList extends AppCompatActivity {

    //Log
    private final static String TAG = "ProjectList";

    //UI
    private ListView mProjectsListView;

    //Firebase
    private DatabaseReference mFirebaseReference;
    private FirebaseListAdapter<CompanyProjects> mProjectListAdapter;

    //Obj members
    private String companyKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();

         companyKey = getIntent().getStringExtra("COMPANY_KEY");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ProjectList.this, AddProject.class);
                intent.putExtra("PROJECT_COMPANY_KEY", companyKey);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        mFirebaseReference = FirebaseDatabase.getInstance().getReference().child("company-projects/" + companyKey);

        mProjectListAdapter = new FirebaseListAdapter<CompanyProjects>(this, CompanyProjects.class, R.layout.project_listview_row, mFirebaseReference) {

            private TextView mProjectName;
            private TextView mProjectDescription;

            @Override
            protected void populateView(View v, CompanyProjects model, int position) {

                mProjectName = (TextView) v.findViewById(R.id.tv_project_listview_row_name);
                mProjectDescription = (TextView) v.findViewById(R.id.tv_project_listview_row_description);

                mProjectName.setText(model.getName());
                mProjectDescription.setText(model.getDescription());

            }
        };

        mProjectsListView.setAdapter(mProjectListAdapter);
    }

    private void initView(){

        mProjectsListView = (ListView) findViewById(R.id.lv_content_project_list_projects);
        setListViewOnitemClickListener();
    }

    private void setListViewOnitemClickListener(){

        mProjectsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String key = mProjectListAdapter.getRef(i).getKey();
                Intent intent = new Intent(ProjectList.this, ProjectSpace.class);
                intent.putExtra("PROJECT_KEY", key);
                startActivity(intent);

            }
        });

    }
}
