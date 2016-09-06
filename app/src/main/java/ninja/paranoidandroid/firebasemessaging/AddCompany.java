package ninja.paranoidandroid.firebasemessaging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ninja.paranoidandroid.firebasemessaging.models.Company;

public class AddCompany extends AppCompatActivity {

    //UI
    private EditText mCompanyNameEditText;
    private EditText mCompanyEmailEditText;
    private EditText mCompanyDescriptionEditText;
    private Button mCancelButton;
    private Button mOkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_company);

        initView();
        setViewListeners();
    }

    private void initView(){

        mCompanyNameEditText = (EditText) findViewById(R.id.et_activity_add_company_name);
        mCompanyEmailEditText = (EditText) findViewById(R.id.et_activity_add_company_email);
        mCompanyDescriptionEditText = (EditText) findViewById(R.id.et_activity_add_company_description);
        mCancelButton = (Button) findViewById(R.id.b_activity_add_company_cancel);
        mOkButton = (Button) findViewById(R.id.b_activity_add_company_ok);

    }

    private void setViewListeners(){

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AddCompany.this, CompanyList.class);
                startActivity(intent);

            }
        });

        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Company company = new Company();
                company.setName(mCompanyNameEditText.getText().toString());
                company.setEmail(mCompanyEmailEditText.getText().toString());
                company.setDescription(mCompanyDescriptionEditText.getText().toString());

                DatabaseReference firebaseReference = FirebaseDatabase.getInstance().getReference();
                firebaseReference.child("company").push().setValue(company);

                Intent intent = new Intent(AddCompany.this, CompanyList.class);
                startActivity(intent);

            }
        });

    }
}
