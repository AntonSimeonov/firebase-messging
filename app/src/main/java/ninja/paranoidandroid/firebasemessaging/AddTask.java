package ninja.paranoidandroid.firebasemessaging;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ninja.paranoidandroid.firebasemessaging.models.ProjectTasks;
import ninja.paranoidandroid.firebasemessaging.models.Task;

public class AddTask extends AppCompatActivity {

    //Log
    private final static String TAG = "Add task";

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

    //Firebase
    private DatabaseReference mFireBaseReference;


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

    @Override
    protected void onStart() {
        super.onStart();

        mFireBaseReference = FirebaseDatabase.getInstance().getReference();
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

                Log.i(TAG, "Ok is clicked");

                String name = mTaskNameEditText.getText().toString();
                String dateOfCreation = mTaskDateOfCreationEditText.getText().toString();
                String dateOfCompletition = mTaskDateOfCompletitionEditText.getText().toString();
                String problem = mTaskProblemEditText.getText().toString();
                String notes = mTaskNotesEditText.getText().toString();

                Task task = createProjectTask(name, dateOfCreation, dateOfCompletition, problem, notes);

                DatabaseReference newTaskRef = mFireBaseReference.child("task").push();
                newTaskRef.setValue(task);
                String newTaskKey = newTaskRef.getKey();

                DatabaseReference projectTasksReference = mFireBaseReference.child("project-tasks/" + mTaskProjectKey +"/" + newTaskKey);
                ProjectTasks projectTasks = createProjectTasksitem(name, dateOfCreation, dateOfCompletition);
                projectTasksReference.setValue(projectTasks);
            }
        });

    }

    private Task createProjectTask(String name, String dateOfCreation, String dateOfCompletition, String problem, String notes){

        Task task = new Task();
        task.setName(name);
        task.setDateOfCreation(dateOfCreation);
        task.setDateOfCompletion(dateOfCompletition);
        task.setProblem(problem);
        task.setNotes(notes);

        return task;
    }

    private ProjectTasks createProjectTasksitem(String name, String dateOfCreation, String dateOfCompletition){

        ProjectTasks projectTasks = new ProjectTasks();
        projectTasks.setName(name);
        projectTasks.setStartDate(dateOfCompletition);
        projectTasks.setEndDate(dateOfCompletition);

        return projectTasks;
    }

}
