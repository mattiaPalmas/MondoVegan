package com.exerciseapp.mattiapalmas.solovegan;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static com.exerciseapp.mattiapalmas.solovegan.DatabaseHelper.COMPONENTS_NAME;
import static com.exerciseapp.mattiapalmas.solovegan.DatabaseHelper.COMPONENTS_TYPE;
import static com.exerciseapp.mattiapalmas.solovegan.DatabaseHelper.TABLE_COMPONENTS;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ComponentsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ComponentsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ENumberFragment extends Fragment {
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
    private ArrayList<String> componentsData;
    private DatabaseHelper myDataBase;
    private SearchView searchView;
    private TextView allSubMenu, foodSubMenu, fabricsSubMenu, productsSubMenu;

    private TextView nameComponentTextView, descriptionTextView, isVeganTextView;
    private ImageView imageViewComp;
    private LinearLayout mainLayout, componentSelectLayout;
    private ImageButton backImageButton;

    private int menuItemSelected;

    public ENumberFragment() {
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
        View view = inflater.inflate(R.layout.fragment_enumber, container, false);
        this.mView = view;
        setHasOptionsMenu(true);

        initVariables();
        setListComponents();
        onSearchViewClicked();
        setOnListItemClicked();
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
        componentsData = new ArrayList<>();
        myDataBase = new DatabaseHelper(getContext());
        searchView = mView.findViewById(R.id.search_view);

        allSubMenu = mView.findViewById(R.id.all_submenu);
        foodSubMenu = mView.findViewById(R.id.food_submenu);
        fabricsSubMenu = mView.findViewById(R.id.fabrics_submenu);
        productsSubMenu = mView.findViewById(R.id.products_submenu);

        mainLayout = getActivity().findViewById(R.id.main_layout);
        componentSelectLayout = getActivity().findViewById(R.id.component_select_layout);
        imageViewComp = getActivity().findViewById(R.id.image_view_comp);
        nameComponentTextView = getActivity().findViewById(R.id.name_component_text_view);
        descriptionTextView = getActivity().findViewById(R.id.description_text_view);
        descriptionTextView.setMovementMethod(new ScrollingMovementMethod());
        isVeganTextView = getActivity().findViewById(R.id.is_vegan_text_view);
        backImageButton = getActivity().findViewById(R.id.back_image_button);

    }

    private void setListComponents() {
        componentsData = myDataBase.getAllDataFromDataBase("SELECT * FROM " + TABLE_COMPONENTS + " WHERE " + COMPONENTS_TYPE + " = 'eNumber'");
        setAdapterListView(componentsData);
    }



    private void addDifferentColorToItemSelected() {
        switch (menuItemSelected){
            case 0 :
                allSubMenu.setBackgroundColor(getResources().getColor(R.color.kakichiaro));
                foodSubMenu.setBackgroundColor(getResources().getColor(R.color.zafferanoProfondo));
                fabricsSubMenu.setBackgroundColor(getResources().getColor(R.color.zafferanoProfondo));
                productsSubMenu.setBackgroundColor(getResources().getColor(R.color.zafferanoProfondo));
                break;
            case 1 :
                allSubMenu.setBackgroundColor(getResources().getColor(R.color.zafferanoProfondo));
                foodSubMenu.setBackgroundColor(getResources().getColor(R.color.kakichiaro));
                fabricsSubMenu.setBackgroundColor(getResources().getColor(R.color.zafferanoProfondo));
                productsSubMenu.setBackgroundColor(getResources().getColor(R.color.zafferanoProfondo));
                break;
            case 2 :
                allSubMenu.setBackgroundColor(getResources().getColor(R.color.zafferanoProfondo));
                foodSubMenu.setBackgroundColor(getResources().getColor(R.color.zafferanoProfondo));
                fabricsSubMenu.setBackgroundColor(getResources().getColor(R.color.kakichiaro));
                productsSubMenu.setBackgroundColor(getResources().getColor(R.color.zafferanoProfondo));
                break;
            case 3 :
                allSubMenu.setBackgroundColor(getResources().getColor(R.color.zafferanoProfondo));
                foodSubMenu.setBackgroundColor(getResources().getColor(R.color.zafferanoProfondo));
                fabricsSubMenu.setBackgroundColor(getResources().getColor(R.color.zafferanoProfondo));
                productsSubMenu.setBackgroundColor(getResources().getColor(R.color.kakichiaro));
                break;
        }
    }

    private void onSearchViewClicked() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String searchText) {
                componentsData = myDataBase.onSearchComponentsApply(searchText, " AND TYPE = 'eNumber'");
                if (componentsData.size() == 0) {
                    componentsData.add("No components found");
                }

                setAdapterListView(componentsData);

                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(searchView.getWindowToken(), 0);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String searchText) {
                if (searchText.length() == 0) {
                    componentsData = myDataBase.onSearchComponentsApply(searchText, " AND TYPE = 'eNumber'");
                    setAdapterListView(componentsData);
                } else {
                    componentsData = myDataBase.onSearchComponentsApply(searchText, " AND TYPE = 'eNumber'");

                    if (componentsData.size() == 0) {
                        componentsData.add("No components found");
                    }
                    setAdapterListView(componentsData);
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

    private void setOnListItemClicked() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // When clicked, show a toast with the TextView text
                Object obj = listView.getAdapter().getItem(position);
                componentsData = myDataBase.getDetailsComponent("SELECT * FROM " + TABLE_COMPONENTS + " WHERE " + COMPONENTS_NAME + " = '" + obj.toString() + "'");

                nameComponentTextView.setText(componentsData.get(0));
                descriptionTextView.setText(componentsData.get(1));

                Map<String, Integer> map = new HashMap<String, Integer>();
                map.put("vegan", R.drawable.v_vegan);
                map.put("not_vegan", R.drawable.not_vegan);
                map.put("can_be_both", R.drawable.can_be_both);


                if (componentsData.get(2).equals("1")) {
                    imageViewComp.setImageResource(map.get("vegan"));
                    isVeganTextView.setText("This component is Vegan");
                    isVeganTextView.setTextColor(getResources().getColor(R.color.colorPrimary));
                } else if (componentsData.get(3).equals("1")) {
                    isVeganTextView.setTextColor(getResources().getColor(R.color.red));
                    isVeganTextView.setText("This component is NOT Vegan");
                    imageViewComp.setImageResource(map.get("not_vegan"));
                } else {
                    isVeganTextView.setTextColor(getResources().getColor(R.color.zafferanoProfondo));
                    isVeganTextView.setText("This component CAN BE BOTH Vegan or Not");
                    imageViewComp.setImageResource(map.get("can_be_both"));
                }


                mainLayout.setVisibility(View.GONE);
                componentSelectLayout.setVisibility(View.VISIBLE);

                backImageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainLayout.setVisibility(View.VISIBLE);
                        componentSelectLayout.setVisibility(View.GONE);
                        descriptionTextView.setText("");
                        descriptionTextView.scrollTo(1,1);
                    }
                });
            }
        });
    }
}
