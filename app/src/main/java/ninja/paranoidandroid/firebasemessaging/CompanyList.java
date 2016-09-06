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

import ninja.paranoidandroid.firebasemessaging.models.Company;

public class CompanyList extends AppCompatActivity {

    //UI
    private ListView mCompanyListView;

    //Firebase
    private DatabaseReference mFirebaseReference;
    private FirebaseListAdapter<Company> mFirebaseListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);
        init();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CompanyList.this, AddCompany.class);
                startActivity(intent);

//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    private void init(){

        mCompanyListView = (ListView) findViewById(R.id.lv_content_company_list_company_list);
        setClickListeners();
    }

    private void setClickListeners(){

        mCompanyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String key = mFirebaseListAdapter.getRef(i).getKey();
                Intent intent = new Intent(CompanyList.this, ProjectList.class);
                intent.putExtra("COMPANY_KEY", key);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        mFirebaseReference = FirebaseDatabase.getInstance().getReference().child("company");

        mFirebaseListAdapter = new FirebaseListAdapter<Company>(this, Company.class, R.layout.company_listview_row, mFirebaseReference) {

             //Row UI
             private TextView mCompanyName;
            private TextView mCompanyDescription;
            @Override
            protected void populateView(View v, Company model, int position) {

                mCompanyName = (TextView) v.findViewById(R.id.tv_company_listview_row_name);
                mCompanyDescription = (TextView) v.findViewById(R.id.tv_company_listview_row_description);
                mCompanyName.setText(model.getName());
                mCompanyDescription.setText(model.getDescription());

            }

        };

        mCompanyListView.setAdapter(mFirebaseListAdapter);

    }
}
