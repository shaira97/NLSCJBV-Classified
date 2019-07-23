package unsw.Infs3605.Mydegree;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class year3_Term2 extends Fragment {

    static RecyclerView recyclerView;
    RecyclerView recyclerView2;
    RecyclerView recyclerView3;
    RecyclerView recyclerView4;
    RecyclerView recyclerView5;
    RecyclerView recyclerView6;
    static year3_RecyclerViewAdapter adapter;
    static year3_RecyclerViewAdapter adapter2;
    static year3_RecyclerViewAdapter adapter3;
    static year3_RecyclerViewAdapter adapter4;
    static year3_RecyclerViewAdapter adapter5;
    static year3_RecyclerViewAdapter adapter6;
    static List<Course> courseList;
    List<Course> courseList2;
    List<Course> courseList3;
    List<Course> courseList4;
    List<Course> courseList5;
    List<Course> courseList6;
    static CourseDatabaseHelper dbHelper;
    Dialog dialog;
    List<String> t3Avail;
    List<String> t3Unavail;
    Toast toast;



    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private year3_Term2.OnFragmentInteractionListener mListener;

    public year3_Term2() {

    }


    public static year3_Term2 newInstance(String param1, String param2) {
        year3_Term2 fragment = new year3_Term2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.activity_term2, container, false);

        //Initialise Core Course recyclerview
        courseList = new ArrayList<>();
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        final CourseDatabaseHelper dbHelper = new CourseDatabaseHelper(getActivity());
        courseList = dbHelper.getAllCoreCourses();
        adapter = new year3_RecyclerViewAdapter(getActivity(), courseList);
        recyclerView.setAdapter(adapter);

        //Initialise Business core recyclerview
        courseList3 = new ArrayList<>();
        recyclerView3 = rootView.findViewById(R.id.BCrecyclerView);
        recyclerView3.setHasFixedSize(true);
        recyclerView3.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        courseList3 = dbHelper.getAllBusCoreCourses();
        adapter3 = new year3_RecyclerViewAdapter(getActivity(), courseList3);
        recyclerView3.setAdapter(adapter3);

        //Initialise Free elective recyclerview
        courseList2 = new ArrayList<>();
        recyclerView2 = rootView.findViewById(R.id.recyclerView2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        courseList2 = dbHelper.getAllFECourses();
        adapter2 = new year3_RecyclerViewAdapter(getActivity(), courseList2);
        recyclerView2.setAdapter(adapter2);

        //Initialise selected course recyclerview
        courseList4 = new ArrayList<>();
        recyclerView4 = rootView.findViewById(R.id.recyclerView4);
        recyclerView4.setHasFixedSize(true);
        recyclerView4.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        courseList4 = dbHelper.getAllT2Y3Courses();
        adapter4 = new year3_RecyclerViewAdapter(getActivity(), courseList4);
        recyclerView4.setAdapter(adapter4);

        //Initialise GE course recyclerview
        courseList5 = new ArrayList<>();
        recyclerView5 = rootView.findViewById(R.id.recyclerView3);
        recyclerView5.setHasFixedSize(true);
        recyclerView5.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        courseList5 = dbHelper.getGECourses();
        adapter5 = new year3_RecyclerViewAdapter(getActivity(), courseList5);
        recyclerView5.setAdapter(adapter5);

        //Initialise PE course recyclerview
        courseList6 = new ArrayList<>();
        recyclerView6 = rootView.findViewById(R.id.PErecyclerView);
        recyclerView6.setHasFixedSize(true);
        recyclerView6.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        courseList6 = dbHelper.getAllPECourses();
        adapter6 = new year3_RecyclerViewAdapter(getActivity(), courseList6);
        recyclerView6.setAdapter(adapter6);

        //Button
        final Button enrolButton = (Button) rootView.findViewById(R.id.enrolButton);
        enrolButton.setVisibility(View.INVISIBLE);
        int count = adapter4.getItemCount();
        if (count == 3) {
            enrolButton.setVisibility(View.VISIBLE);
        }
        enrolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CourseDatabaseHelper dbHelper = new CourseDatabaseHelper(getActivity());

                dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.activity_course_success);
                ImageView closeButton = (ImageView) dialog.findViewById(R.id.closeButton);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                TextView remainingCourses = (TextView) dialog.findViewById(R.id.remainingCourses);
                String remainingDesc = dbHelper.getRemainingCoreCourses() + " core(s) \n" + dbHelper.getRemainingBusCoreCourses() + " Business core(s) \n" + dbHelper.getRemainingPECourses() + " Prescribed elective(s) \n" + dbHelper.getRemainingFECourses() + " Free elective(s) \n" + dbHelper.getRemainingGECourses() + " General education(s)";
                remainingCourses.setText(remainingDesc);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

//                        final Dialog dialog2 = new Dialog(getActivity());
//                        dialog2.setContentView(R.layout.badge_notif);
//                        ImageView closeButton = (ImageView) dialog2.findViewById(R.id.closeButton);
//                        dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                        dialog2.show();
//                        closeButton.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                dialog2.dismiss();
//                                enrolButton.setVisibility(View.INVISIBLE);
//                            }
//                        });
//
//                        Button viewButton = (Button) dialog2.findViewById(R.id.viewButton);
//                        viewButton.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                Intent intent = new Intent(getActivity(),RewardBoardNew.class);
//                                startActivity(intent);
//                            }
//                        });

                        t3Unavail = dbHelper.getT3RemUnavail();
                        dbHelper.updateDisable(t3Unavail);

                        if (dbHelper.getIsCompleted("INFS1602") == 1) {
                            dbHelper.updatePrereq("INFS2621");
                            dbHelper.updatePrereq("INFS3603");
                            dbHelper.updatePrereq("INFS3617");
                            dbHelper.updatePrereq("INFS2631");
                            dbHelper.updatePrereq("INFS3632");
                            if (dbHelper.getIsCompleted("INFS1603") == 1) {
                                dbHelper.updatePrereq("INFS2603");
                            }
                        }

                        if (dbHelper.getIsCompleted("INFS1603") == 1) {
                            dbHelper.updatePrereq("INFS2608");
                            if (dbHelper.getIsCompleted("INFS1609") == 1) {
                                dbHelper.updatePrereq("INFS2605");
                            }
                        }

                        if (dbHelper.getIsCompleted("INFS2603") == 1) {
                            dbHelper.updatePrereq("INFS3604");
                        }

                        if (dbHelper.getIsCompleted("INFS3634") == 1) {
                            dbHelper.updatePrereq("INFS3605");
                        }

                        if (dbHelper.getIsCompleted("INFS2605") == 1) {
                            dbHelper.updatePrereq("INFS3634");
                        }

                        if (dbHelper.getIsCompleted("INFS2605") == 1) {
                            dbHelper.updatePrereq("INFS3830");
                            dbHelper.updatePrereq("INFS3873");
                        }




                        t3Avail = dbHelper.getT3RemAvail();
                        dbHelper.updateEnable(t3Avail);
                        Fragment fragment = (Fragment) (getActivity()).getSupportFragmentManager().getFragments().get(2);
                        FragmentTransaction fragmentTransaction = (getActivity()).getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.detach(fragment);
                        fragmentTransaction.attach(fragment);
                        fragmentTransaction.commit();
                    }


                    ;

                });

            }

            ;
        });

        return rootView;

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
        if (context instanceof year3_Term2.OnFragmentInteractionListener) {
            mListener = (year3_Term2.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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

