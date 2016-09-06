package ninja.paranoidandroid.firebasemessaging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ninja.paranoidandroid.firebasemessaging.models.Company;
import ninja.paranoidandroid.firebasemessaging.models.Project;
import ninja.paranoidandroid.firebasemessaging.models.Task;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        //initFireBaseDb();
        getOutFromInitialisation();

    }

    private void getOutFromInitialisation(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    private void initFireBaseDb(){

        Company company = initCompanyNote("paranoidandroid", "office@paranoidandroid.ninja", "IT company");

        Project project = new Project();
        project.setCompanyKey("KQokG0mlwzoMafhRhJG");
        project.setName("TEst name");
        project.setBudget(6363);
        project.setDescription("opisanieto e tuk");
        project.setStartDate("22/22/34535");
        project.setEndDate("44/33/3543");
        project.setGoal("pari");


        DatabaseReference firebaseReference = FirebaseDatabase.getInstance().getReference();
        //firebaseReference.child("company").push().setValue(company);

        firebaseReference.child("project").push().setValue(project);

    }

    private Company initCompanyNote(String name, String email, String description){

        Company company = new Company();
        company.setName(name);
        company.setEmail(email);
        company.setDescription(description);

        return company;
    }

}
