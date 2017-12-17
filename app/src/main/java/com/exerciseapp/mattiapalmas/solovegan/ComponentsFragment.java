package com.exerciseapp.mattiapalmas.solovegan;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ComponentsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ComponentsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ComponentsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View mView;
    private OnFragmentInteractionListener mListener;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private ArrayList<String> componentsName;
    private DatabaseHelper myDataBase;
    private SearchView searchView;
    private TextView allSubMenu, foodSubMenu, fabricsSubMenu, productsSubMenu;

    public ComponentsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ComponentsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ComponentsFragment newInstance(String param1, String param2) {
        ComponentsFragment fragment = new ComponentsFragment();
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
        View view = inflater.inflate(R.layout.fragment_components, container, false);
        this.mView = view;
        setHasOptionsMenu(true);

        initVariables();
        setListComponents();
        //getAllData();
        onSearchViewClicked();
        onSubMenuClicked();
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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


    private void initVariables() {
        listView = mView.findViewById(R.id.list_view);
        componentsName = new ArrayList<>();
        myDataBase = new DatabaseHelper(getContext());
        searchView = mView.findViewById(R.id.search_view);

        allSubMenu = mView.findViewById(R.id.all_submenu);
        foodSubMenu = mView.findViewById(R.id.food_submenu);
        fabricsSubMenu = mView.findViewById(R.id.fabrics_submenu);
        productsSubMenu = mView.findViewById(R.id.products_submenu);
    }

    private void setListComponents() {
        componentsName = myDataBase.getAllRecordsName();
        setAdapterListView(componentsName);
    }

    public void getAllData() {
        Cursor res = myDataBase.getAllData();

        if (res.getCount() == 0) {
            Toast.makeText(getContext(), "No data found", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("name: " + res.getString(1) + "\n");
            buffer.append("details: " + res.getString(2) + "\n");
            if (res.getString(3).equals("1")) {
                buffer.append("is vegan?: YES \n");
            } else {
                buffer.append("is vegan?: NO \n");
            }

            if (res.getString(4).equals("1")) {
                buffer.append("is not vegan?: YES \n");
            } else {
                buffer.append("is not vegan?: NO \n");
            }

            if (res.getString(5).equals("1")) {
                buffer.append("can be both? YES \n");
            } else {
                buffer.append("can be both?: NO \n");
            }
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle("Database");
        builder.setMessage(buffer);
        builder.show();
    }


    private void onSubMenuClicked() {
        allSubMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                componentsName = myDataBase.getAllRecordsName();
                setAdapterListView(componentsName);
            }
        });

        foodSubMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                componentsName = myDataBase.getFoodsRecordsName();
                setAdapterListView(componentsName);
            }
        });

        fabricsSubMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        productsSubMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void onSearchViewClicked() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String searchText) {
                componentsName = myDataBase.onSearchApply(searchText);
                setAdapterListView(componentsName);

                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(searchView.getWindowToken(), 0);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (s.length() == 0) {
                    componentsName = myDataBase.getAllRecordsName();
                    setAdapterListView(componentsName);
                } else {
                    componentsName = myDataBase.onSearchApply(s);
                    setAdapterListView(componentsName);
                }
                return false;
            }
        });
    }

    private void setAdapterListView(ArrayList<String> arrayStrings) {
        adapter = new ArrayAdapter<String>(getContext(), R.layout.list_item, R.id.itemTextView, arrayStrings);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
