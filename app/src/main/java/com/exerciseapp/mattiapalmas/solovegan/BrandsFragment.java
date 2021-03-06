package com.exerciseapp.mattiapalmas.solovegan;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static android.text.Html.fromHtml;
import static com.exerciseapp.mattiapalmas.solovegan.DatabaseHelper.TABLE_BRANDS;


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

    private LinearLayout expandedMenuLayout, mainFragmentBrands, searchFragmentLayout;
    private ScrollView categoriesScrollView;
    private Button searchBtn, categoriesBtn, bodyCareBtn, bathingBtn, cosmeticsBtn, fragranceBtn, hairCareBtn, nailCareBtn, personalCareBtn, shavingSupplyBtn, SkinCareBtn, sunCareBtn, bathroomCareBtn, kitchenCareBtn, generalHousholdBtn, laundryCareBtn, officeSuppliesBtn;
    private ExpandableListView expandableListView;
    private ExpandableMenuAdapter menuAdapter;
    private List<String> listTitleHeader;
    private HashMap<String, List<Spanned>> listHash;
    private ArrayList<String> brandsList;
    private ArrayAdapter<String> adapter;
    private ListView listViewBrands;
    private SearchView searchViewBrands;
    private ArrayList<String> brandsData;
    private DatabaseHelper myDataBase;

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
        addAllBrands();
        onSearchOrCategoriesCLicked();
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
        expandableListView = (ExpandableListView) mView.findViewById(R.id.expanded_menu);
        menuAdapter = new ExpandableMenuAdapter(getActivity(), listTitleHeader, listHash);
        expandableListView.setAdapter(menuAdapter);

        searchFragmentLayout = mView.findViewById(R.id.search_fragment_layout);
        mainFragmentBrands = mView.findViewById(R.id.main_fragment_brands_layout);
        expandedMenuLayout = mView.findViewById(R.id.expanded_menu_layout);
        categoriesScrollView = mView.findViewById(R.id.categories_scroll_view);

        searchBtn = mView.findViewById(R.id.search_btn);
        categoriesBtn = mView.findViewById(R.id.categories_btn);

        brandsList = new ArrayList<>();
        listViewBrands = mView.findViewById(R.id.list_view_brands);

        brandsData = new ArrayList<>();
        myDataBase = new DatabaseHelper(getContext());
    }

    private void onCategoryClicked() {
        if (categoriesScrollView.getVisibility() == View.VISIBLE) {
            bodyCareBtn = mView.findViewById(R.id.body_care_btn);
            bodyCareBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listHash.clear();
                    listTitleHeader.clear();
                    listTitleHeader.add("Body Oils");
                    listTitleHeader.add("Body scrubs");
                    listTitleHeader.add("Body Wraps");
                    listTitleHeader.add("Deodorant");
                    listTitleHeader.add("Depilatory");
                    listTitleHeader.add("Foot care");
                    String str1 = "";
                    ArrayList<String> brands = new ArrayList<>();

                    List<Spanned> bodyOils = new ArrayList<>();
                    brands = myDataBase.getBrandsByCategoryType("Body Oils");
                    str1 = buildBrandsString(brands);
                    bodyOils.add(fromHtml(str1));
                    listHash.put(listTitleHeader.get(0), bodyOils);

                    List<Spanned> bodyScrub = new ArrayList<>();
                    brands = myDataBase.getBrandsByCategoryType("Body scrubs");
                    str1 = buildBrandsString(brands);
                    bodyScrub.add(fromHtml(str1));
                    listHash.put(listTitleHeader.get(1), bodyScrub);

                    List<Spanned> bodyWraps = new ArrayList<>();
                    brands = myDataBase.getBrandsByCategoryType("Body Wraps");
                    str1 = buildBrandsString(brands);
                    bodyWraps.add(fromHtml(str1));
                    listHash.put(listTitleHeader.get(2), bodyWraps);

                    List<Spanned> deodorant = new ArrayList<>();
                    brands = myDataBase.getBrandsByCategoryType("Deodorant");
                    str1 = buildBrandsString(brands);
                    deodorant.add(fromHtml(str1));
                    listHash.put(listTitleHeader.get(3), deodorant);

                    List<Spanned> depilatory = new ArrayList<>();
                    brands = myDataBase.getBrandsByCategoryType("Depilatory");
                    str1 = buildBrandsString(brands);
                    depilatory.add(fromHtml(str1));
                    listHash.put(listTitleHeader.get(4), depilatory);

                    List<Spanned> footCare = new ArrayList<>();
                    brands = myDataBase.getBrandsByCategoryType("Foot Care");
                    str1 = buildBrandsString(brands);
                    footCare.add(fromHtml(str1));
                    listHash.put(listTitleHeader.get(5), footCare);


                    menuAdapter.notifyDataSetChanged();
                    expandedMenuLayout.setVisibility(View.VISIBLE);
                    categoriesScrollView.setVisibility(View.GONE);
                }

                private String buildBrandsString(ArrayList<String> brands) {
                   String brandsString = "";
                    for (String brand : brands) {
                        brandsString = brandsString + "<br>- " + brand;
                    }
                    return brandsString;
                }
            });

            bathingBtn = mView.findViewById(R.id.bathing_btn);
            bathingBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    listHash.clear();
                    listTitleHeader.clear();
                    listTitleHeader.add("Bath Bombs");
                    listTitleHeader.add("Bath Oils");
                    listTitleHeader.add("Bath Salts");
                    listTitleHeader.add("Body Wash");
                    String str1 = "";

                    List<Spanned> bathBombs = new ArrayList<>();
                    str1 = "- Test<br>- Test<br>- Test";
                    bathBombs.add(fromHtml(str1));

                    listHash.put(listTitleHeader.get(0), bathBombs);

                    List<Spanned> bathOils = new ArrayList<>();
                    str1 = "- Fair and Flawless<br>- Jolen Creme Bleach<br>- Reviva Laboratories";
                    bathOils.add(fromHtml(str1));

                    listHash.put(listTitleHeader.get(1), bathOils);

                    List<Spanned> bathSalts = new ArrayList<>();
                    str1 = "- Fair and Flawless<br>- Jolen Creme Bleach<br>- Reviva Laboratories";
                    bathSalts.add(fromHtml(str1));

                    listHash.put(listTitleHeader.get(2), bathSalts);

                    List<Spanned> bodyWash = new ArrayList<>();
                    str1 = "- Fair and Flawless<br>- Jolen Creme Bleach<br>- Reviva Laboratories";
                    bodyWash.add(fromHtml(str1));

                    listHash.put(listTitleHeader.get(3), bodyWash);
                    menuAdapter.notifyDataSetChanged();
                    expandedMenuLayout.setVisibility(View.VISIBLE);
                    categoriesScrollView.setVisibility(View.GONE);
                }
            });
        }
    }

    private void onSearchOrCategoriesCLicked() {

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainFragmentBrands.setVisibility(View.GONE);
                searchFragmentLayout.setVisibility(View.VISIBLE);
                setOnSearchApply();
            }
        });

        categoriesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainFragmentBrands.setVisibility(View.GONE);
                categoriesScrollView.setVisibility(View.VISIBLE);
                onCategoryClicked();
            }
        });
    }

    private void setOnSearchApply() {
        final ArrayList<String> filterBrandsList = new ArrayList<>();
        searchViewBrands = mView.findViewById(R.id.search_view_brands);
        searchViewBrands.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (brandsData.size() == 0) {
                    brandsData.add("No components found");
                } else {
                    brandsData = myDataBase.onSearchBrandsApply(s);
                    if (brandsData.size() == 0) {
                        brandsData.add("No components found");
                    }
                }
                setAdapterListView(brandsData);
                deleteDuplicateAndOrderBrands();

                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(searchBtn.getWindowToken(), 0);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (s.length() == 0) {
                    addAllBrands();
                } else {
                    brandsData = myDataBase.onSearchBrandsApply(s);
                    deleteDuplicateAndOrderBrands();

                    if (brandsData.size() == 0) {
                        brandsData.add("No components found");
                    }
                    setAdapterListView(brandsData);
                }
                return false;
            }
        });
    }

    private void addAllBrands() {
        brandsData = myDataBase.getAllDataFromDataBase("SELECT * FROM " + TABLE_BRANDS);
        deleteDuplicateAndOrderBrands();
        setAdapterListView(brandsData);
    }

    private void setAdapterListView(ArrayList<String> arrayStrings) {
        adapter = new ArrayAdapter<String>(getContext(), R.layout.list_item, R.id.itemTextView, arrayStrings);
        listViewBrands.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void deleteDuplicateAndOrderBrands(){
        Set<String> hs = new HashSet<>();
        hs.addAll(brandsData);
        brandsData.clear();
        brandsData.addAll(hs);
        Collections.sort(brandsData, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareToIgnoreCase(t1);
            }
        });
    }
}
