package ninja.paranoidandroid.firebasemessaging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ninja.paranoidandroid.firebasemessaging.models.Company;
import ninja.paranoidandroid.firebasemessaging.util.Constants;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();

    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();

        if(mFirebaseUser != null){
            Log.i(Constants.Log.TAG_MAIN_ACTIVITY, " we got the user in MainActivity class.");
            Intent intent = new Intent(this, CompanyList.class);
            startActivity(intent);
        }else{
            Log.i(Constants.Log.TAG_MAIN_ACTIVITY, " cant get user in MainActivity class.");
        }


    }
}
