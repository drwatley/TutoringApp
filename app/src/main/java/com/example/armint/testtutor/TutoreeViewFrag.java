package com.example.armint.testtutor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * This class is the fragments that will contain "matches"
 * as a list fragment activity, which is nested into the UserView
 * activity that frames it.
 *
 * This is the second tab and will contain the matches for the user or "tutor" that
 * wants to helps someone, matched to a student/tutoree/ or someone that needs help.
 */
public class TutoreeViewFrag extends ListFragment {

    private DBConnection con = new DBConnection();

    /*
    protected String[] people = {"Armin", "Brandon", "Justin", "D'arcy",
            "Albert", "Joanne", "Jen", "Johno",
            "Alex", "Dave", "Logan", "Iksoo",
            "anotherPerson", "SomeOtherPerson",
            "whatever", "tired", "right", "now",
            "shit"}; */

    protected String[] people = con.getNames();
    protected String[] descrip = con.getDescription();

    /*
    protected String[] descrip = {"Armin's a pretty sweet person, learn from him.",
            "Brandon's a pretty sweet person, learn from him.",
            "Justin's a pretty sweet person, learn from him.",
            "D'arcy's a pretty sweet person, learn from him.",
            "Albert's a pretty sweet person, learn from him.",
            "Joanne's a pretty sweet person, learn from him.",
            "Jen's a pretty sweet person, learn from him.",
            "Johno's a pretty sweet person, learn from him.",
            "Alex's a pretty sweet person, learn from him.",
            "Dave's a pretty sweet person, learn from him.",
            "Logan's a pretty sweet person, learn from him.",
            "Iksoo's a pretty sweet person, learn from him.",
            "Another's a pretty sweet person, learn from him.",
            "Some's a pretty sweet person, learn from him.",
            "Whatever's a pretty sweet person, learn from him.",
            "Tired's a pretty sweet person, learn from him.",
            "Right's a pretty sweet person, learn from him.",
            "Now's a pretty sweet person, learn from him.",
            "Shit's a pretty sweet person, learn from him."}; */


    //Required ctor.
    public TutoreeViewFrag() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        con = new DBConnection();
        people = con.getNames();
        descrip = con.getDescription();
        //String[][] tutoreeInfo = con.getTutoreeInfo(getContext());
        //people = tutoreeInfo[0];
        //descrip = tutoreeInfo[1];
        return inflater.inflate(R.layout.fragment_tutoree_view, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //con = new DBConnection();
        //people = con.getNames();
        //descrip = con.getDescription();

        TutorArrayAdapter adapter = new TutorArrayAdapter(getActivity(), 0, people, descrip);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(listHandler);
    }

    //adpater for the listview. detects clicks and sich
    private AdapterView.OnItemClickListener listHandler = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
        }
    };
}
