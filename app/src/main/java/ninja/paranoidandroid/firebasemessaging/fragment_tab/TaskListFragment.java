package ninja.paranoidandroid.firebasemessaging.fragment_tab;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ninja.paranoidandroid.firebasemessaging.ProjectSpace;
import ninja.paranoidandroid.firebasemessaging.R;
import ninja.paranoidandroid.firebasemessaging.models.Company;
import ninja.paranoidandroid.firebasemessaging.models.ProjectTasks;
import ninja.paranoidandroid.firebasemessaging.models.Task;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TaskListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TaskListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaskListFragment extends Fragment {

    //Log
    private final static String TAG = "task list fragment";

    //UI
    private ListView mTaskListView;

    //Firebase
    private DatabaseReference mFirebaseReference;
    private FirebaseListAdapter<ProjectTasks> mFirebaseListAdapter;

    private static final String POSITION = "position";

    private Context mContext;
    private ProjectSpace mProjectSpaceRef;



    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TaskListFragment() {
        // Required empty public constructor
    }


    public static TaskListFragment newInstance(int position) {
        TaskListFragment fragment = new TaskListFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);
        mTaskListView = (ListView) view.findViewById(R.id.lv_fragment_task_list);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        mProjectSpaceRef = (ProjectSpace) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onStart() {
        super.onStart();

        mFirebaseReference = FirebaseDatabase.getInstance().getReference().child("project-tasks/" + mProjectSpaceRef.getmProjectKey());
        mFirebaseListAdapter = new FirebaseListAdapter<ProjectTasks>(mProjectSpaceRef, ProjectTasks.class, R.layout.task_listview_row, mFirebaseReference) {

            private TextView mName;


            @Override
            protected void populateView(View v, ProjectTasks model, int position) {

                mName = (TextView) v.findViewById(R.id.tv_task_listview_row_name);
                mName.setText(model.getName());
            }
        };
        mTaskListView.setAdapter(mFirebaseListAdapter);

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);


    }
}
