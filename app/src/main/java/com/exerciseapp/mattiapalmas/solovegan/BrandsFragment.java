package com.exerciseapp.mattiapalmas.solovegan;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static android.text.Html.fromHtml;
import static com.exerciseapp.mattiapalmas.solovegan.DatabaseHelper.COL_2;
import static com.exerciseapp.mattiapalmas.solovegan.DatabaseHelper.COL_7;
import static com.exerciseapp.mattiapalmas.solovegan.DatabaseHelper.TABLE_NAME;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ComponentsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ComponentsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrandsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View mView;
    private OnFragmentInteractionListener mListener;

    LinearLayout expandedMenuLayout;
    ScrollView categoriesScrollView;
    Button bodyCareBtn;
    private ExpandableListView listView;
    private  ExpandableMenuAdapter menuAdapter;
    private List<String> listTitleHeader;
    private HashMap<String,List<Spanned>> listHash;

    public BrandsFragment() {
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
        View view = inflater.inflate(R.layout.fragment_brands, container, false);
        this.mView = view;
        setHasOptionsMenu(true);

        initVariables();
        onCategoryClicked();
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
        listTitleHeader = new ArrayList<>();
        listHash = new HashMap<>();
        listView = (ExpandableListView) mView.findViewById(R.id.expanded_menu);
        menuAdapter = new ExpandableMenuAdapter(getActivity(),listTitleHeader,listHash);
        listView.setAdapter(menuAdapter);

        expandedMenuLayout = mView.findViewById(R.id.expanded_menu_layout);
        categoriesScrollView = mView.findViewById(R.id.categories_scroll_view);

        bodyCareBtn = mView.findViewById(R.id.body_care_btn);

    }

    private void onCategoryClicked() {
        bodyCareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandedMenuLayout.setVisibility(View.VISIBLE);
                categoriesScrollView.setVisibility(View.GONE);

                listTitleHeader.add("Bleaching cream");
                listTitleHeader.add("Body Oils");
                listTitleHeader.add("Body scrubs");
                listTitleHeader.add("Deodorant");

                List<Spanned> bodyCare = new ArrayList<>();
                String str1 = "- Fair and Flawless<br>- Jolen Creme Bleach<br>- Reviva Laboratories";
                bodyCare.add(fromHtml(str1));

                listHash.put(listTitleHeader.get(0),bodyCare);
            }
        });
    }
}
