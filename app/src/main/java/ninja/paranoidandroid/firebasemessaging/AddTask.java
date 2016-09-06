package ninja.paranoidandroid.firebasemessaging;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddTask extends AppCompatActivity {

    //UI
    private EditText mTaskNameEditText;
    private Spinner mTaskPrioritySpinner;
    private EditText mTaskDateOfCreationEditText;
    private EditText mTaskDateOfCompletitionEditText;
    private EditText mTaskProblemEditText;
    private EditText mTaskNotesEditText;
    private Button mCancelButton;
    private Button mOkButton;

    //Task project key
    private String mTaskProjectKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);


        mTaskProjectKey = getIntent().getStringExtra("TASK_COMPANY_KEY");
        init();

    }


    private void init(){

        mTaskNameEditText = (EditText) findViewById(R.id.et_activity_add_task_name);
        mTaskPrioritySpinner = (Spinner) findViewById(R.id.s_activity_add_task_priority);
        mTaskDateOfCreationEditText = (EditText) findViewById(R.id.et_activity_add_task_date_of_creation);
        mTaskDateOfCompletitionEditText = (EditText) findViewById(R.id.et_activity_add_task_date_of_completition);
        mTaskProblemEditText = (EditText) findViewById(R.id.et_activity_add_task_problem);
        mTaskNotesEditText = (EditText) findViewById(R.id.et_activity_add_task_notes);
        mCancelButton = (Button) findViewById(R.id.b_activity_add_task_cancel);
        mOkButton = (Button) findViewById(R.id.b_activity_add_task_ok);

        setListeners();

    }

    private void setListeners(){

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

}
