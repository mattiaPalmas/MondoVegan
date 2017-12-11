package com.exerciseapp.mattiapalmas.solovegan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TravelFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TravelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TravelFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    protected View mView;
    private TextView englishTextView, italianTextView, chineseTextView, germanTextView, frenchTextView, danishTextView, spanishTextView, greekTextView, polishTextView, hindiTextView, japaneseTextView, portugueseTextView, russianTextView, thaiTextView;
    private TextView iAmVeganTextView, iDontEatTextView, listIDontEatTextiew, iEatTextView, listIEatTextView;
    private ImageView englishButton, italianButton, chineseButton, germanButton, frenchButton, danishButton, spanishButton, greekButton, polishButton, hindiButton, japaneseButton, portugueseButton, russianButton, thaiButton;
    private ImageButton iAmVeganSpeaker,iDontEatSpeaker,iEatSpeaker;
    private MediaPlayer mp;

    private int languageIndex;

    public TravelFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TravelFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TravelFragment newInstance(String param1, String param2) {
        TravelFragment fragment = new TravelFragment();
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
        View view = inflater.inflate(R.layout.fragment_travel, container, false);
        this.mView = view;
        initVariables();
        setListerenersFlagsButton();
        setOnSpeakerButtonListener();

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
        languageIndex = 0;

        iAmVeganTextView = mView.findViewById(R.id.i_am_vegan_text);
        iDontEatTextView = mView.findViewById(R.id.i_dont_eat);
        listIDontEatTextiew = mView.findViewById(R.id.list_dont_eat);
        iEatTextView = mView.findViewById(R.id.i_eat);
        listIEatTextView = mView.findViewById(R.id.list_do_eat);

        englishButton = mView.findViewById(R.id.english_image_button);
        italianButton = mView.findViewById(R.id.italian_image_button);
        chineseButton = mView.findViewById(R.id.chinese_image_button);
        germanButton = mView.findViewById(R.id.german_image_button);
        frenchButton = mView.findViewById(R.id.french_image_button);
        danishButton = mView.findViewById(R.id.danish_image_button);
        spanishButton = mView.findViewById(R.id.spanishImageButton);
        greekButton = mView.findViewById(R.id.greek_image_button);
        polishButton = mView.findViewById(R.id.polish_image_button);
        hindiButton = mView.findViewById(R.id.hindi_image_button);
        japaneseButton = mView.findViewById(R.id.japanese_image_button);
        portugueseButton = mView.findViewById(R.id.portuguese_image_button);
        russianButton = mView.findViewById(R.id.russian_image_button);
        thaiButton = mView.findViewById(R.id.thai_image_button);

        englishTextView = mView.findViewById(R.id.english_text_view);
        italianTextView = mView.findViewById(R.id.italian_text_view);
        chineseTextView = mView.findViewById(R.id.chinese_text_view);
        germanTextView = mView.findViewById(R.id.german_text_view);
        frenchTextView = mView.findViewById(R.id.french_text_view);
        danishTextView = mView.findViewById(R.id.danish_text_view);
        spanishTextView = mView.findViewById(R.id.spanish_text_view);
        greekTextView = mView.findViewById(R.id.greek_text_view);
        polishTextView = mView.findViewById(R.id.polish_text_view);
        hindiTextView = mView.findViewById(R.id.hindi_text_view);
        japaneseTextView = mView.findViewById(R.id.japanese_text_view);
        portugueseTextView = mView.findViewById(R.id.portuguese_text_view);
        russianTextView = mView.findViewById(R.id.russian_text_view);
        thaiTextView = mView.findViewById(R.id.thai_text_view);

        iAmVeganSpeaker = mView.findViewById(R.id.i_am_vegan_speaker);
        iDontEatSpeaker = mView.findViewById(R.id.i_dont_eat_speaker);
        iEatSpeaker = mView.findViewById(R.id.i_eat_speaker);
    }

    private void setListerenersFlagsButton() {

        englishButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                languageIndex=0;
                markFlagSelected(englishButton);
                iAmVeganTextView.setText("I am Vegan (" + getString(R.string.i_am_vegan) + ")");
                iDontEatTextView.setText("I don't eat (" + getString(R.string.i_dont_eat) + ")");

                listIDontEatTextiew.setText(
                        "- Meat (" + getString(R.string.meat) +
                                ")\n- Fish (" + getString(R.string.fish) +
                                ")\n- Eggs (" + getString(R.string.eggs) +
                                ")\n- Honey (" + getString(R.string.honey) +
                                ")\n- Milk (" + getString(R.string.milk) + ")" +
                                "\n- Butter (" + getString(R.string.butter) + ")" +
                                "\n- Cream (" + getString(R.string.cream) + ")" +
                                "\n- Dairy products (" + getString(R.string.dairy_product) + ")");

                iEatTextView.setText("I eat (" + getString(R.string.i_eat) + ")");

                listIEatTextView.setText(
                        "- Fruit (" + getString(R.string.fruit) +
                                ")\n- Vegetables (" + getString(R.string.vegetables) +
                                ")\n- Tubers (" + getString(R.string.tubers) +
                                ")\n- Rice (" + getString(R.string.rice) +
                                ")\n- Tofu(" + getString(R.string.tofu) +
                                ")\n - Pasta with no Eggs (" + getString(R.string.pasta_no_eggs) +
                                ")\n - Bread with no milk or eggs (" + getString(R.string.bread_no_milk_or_eggs) +
                                ")\n - Legumes (" + getString(R.string.legumes) +
                                ")\n - Seeds (" + getString(R.string.seeds) +
                                ")\n- Dried fruit (" + getString(R.string.dried_fruit) + ")");
            }
        });

        italianButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                languageIndex=1;
                markFlagSelected(italianButton);
                iAmVeganTextView.setText("Io sono Vegano (" + getString(R.string.i_am_vegan) + ")");
                iDontEatTextView.setText("Io non mangio (" + getString(R.string.i_dont_eat) + ")");

                listIDontEatTextiew.setText(
                        "- Carne (" + getString(R.string.meat) +
                                ")\n- Pesce (" + getString(R.string.fish) +
                                ")\n- Uova (" + getString(R.string.eggs) +
                                ")\n- Miele (" + getString(R.string.honey) +
                                ")\n- Latte (" + getString(R.string.milk) +
                                ")\n- Burro (" + getString(R.string.butter) +
                                ")\n- Panna (" + getString(R.string.cream) +
                                ")\n- prodotti lattiero-caseari (" + getString(R.string.dairy_product) + ")");

                iEatTextView.setText("Io mangio (" + getString(R.string.i_eat) + ")");

                listIEatTextView.setText(
                        "Frutta (" + getString(R.string.fruit) +
                                ")\n- Verdura (" + getString(R.string.vegetables) +
                                ")\n- Tuberi (" + getString(R.string.tubers) +
                                ")\n- Riso (" + getString(R.string.rice) +
                                ")\n- Tofu (" + getString(R.string.tofu) +
                                ")\n - Pasta senza uova (" + getString(R.string.pasta_no_eggs) +
                                ")\n - Pane senza latte o uova (" + getString(R.string.bread_no_milk_or_eggs) +
                                ")\n - Legumi (" + getString(R.string.legumes) +
                                ")\n - Semi (" + getString(R.string.seeds) +
                                ")\n- Frutta secca (" + getString(R.string.dried_fruit) + ")");
            }
        });

        chineseButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                languageIndex=2;
                markFlagSelected(chineseButton);
                iAmVeganTextView.setText("我是純素食者 (" + getString(R.string.i_am_vegan) + ")");
                iDontEatTextView.setText("我不吃 (" + getString(R.string.i_dont_eat) + ")");

                listIDontEatTextiew.setText(
                        "- 肉 (" + getString(R.string.meat) +
                                ")\n- 鱼 (" + getString(R.string.fish) +
                                ")\n- 雞蛋 (" + getString(R.string.eggs) +
                                ")\n- 蜂蜜 (" + getString(R.string.honey) +
                                ")\n- 牛奶 (" + getString(R.string.milk) +
                                ")\n- 黃油 (" + getString(R.string.butter) +
                                ")\n- 奶油 (" + getString(R.string.cream) +
                                ")\n- 乳製品 (" + getString(R.string.dairy_product) + ")");

                iEatTextView.setText("我吃的時候 (" + getString(R.string.i_eat) + ")");

                listIEatTextView.setText(
                        "水果 (" + getString(R.string.fruit) +
                                ")\n- 蔬菜 (" + getString(R.string.vegetables) +
                                ")\n- 塊莖 (" + getString(R.string.tubers) +
                                ")\n- 飯 (" + getString(R.string.rice) +
                                ")\n- 豆腐 (" + getString(R.string.tofu) +
                                ")\n - 意大利面沒有雞蛋 (" + getString(R.string.pasta_no_eggs) +
                                ")\n - 沒有牛奶或雞蛋的麵包 (" + getString(R.string.bread_no_milk_or_eggs) +
                                ")\n - 蔬菜 (" + getString(R.string.legumes) +
                                ")\n - 種子 (" + getString(R.string.seeds) +
                                ")\n- 乾果 (" + getString(R.string.dried_fruit) + ")");
            }
        });

        germanButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                languageIndex=3;
                markFlagSelected(germanButton);
                iAmVeganTextView.setText("Ich bin Veganer (" + getString(R.string.i_am_vegan) + ")");
                iDontEatTextView.setText("Ich will nicht essen (" + getString(R.string.i_dont_eat) + ")");

                listIDontEatTextiew.setText(
                        "- Fleisch (" + getString(R.string.meat) +
                                ")\n- Fisch (" + getString(R.string.fish) +
                                ")\n- Eier (" + getString(R.string.eggs) +
                                ")\n- Honig (" + getString(R.string.honey) +
                                ")\n- Milch (" + getString(R.string.milk) +
                                ")\n- Butter (" + getString(R.string.butter) +
                                ")\n- Sahne (" + getString(R.string.cream) +
                                ")\n- Milchprodukte (" + getString(R.string.dairy_product) + ")");

                iEatTextView.setText("Ich esse (" + getString(R.string.i_eat) + ")");

                listIEatTextView.setText(
                        "Obst (" + getString(R.string.fruit) +
                                ")\n- Gemüse (" + getString(R.string.vegetables) +
                                ")\n- Knollen (" + getString(R.string.tubers) +
                                ")\n- Reis (" + getString(R.string.rice) +
                                ")\n- Tofu (" + getString(R.string.tofu) +
                                ")\n - Nudeln ohne Eier (" + getString(R.string.pasta_no_eggs) +
                                ")\n - Brot ohne Milch oder Eier (" + getString(R.string.bread_no_milk_or_eggs) +
                                ")\n - Hülsenfrüchte (" + getString(R.string.legumes) +
                                ")\n - Samen (" + getString(R.string.seeds) +
                                ")\n- getrocknete Früchte (" + getString(R.string.dried_fruit) + ")");

            }
        });

        frenchButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                languageIndex=4;
                markFlagSelected(frenchButton);
                iAmVeganTextView.setText("Je suis Vegan (" + getString(R.string.i_am_vegan) + ")");
                iDontEatTextView.setText("Je ne mange pas (" + getString(R.string.i_dont_eat) + ")");

                listIDontEatTextiew.setText(
                        "- Viande (" + getString(R.string.meat) +
                                ")\n- Poisson (" + getString(R.string.fish) +
                                ")\n- Œufs (" + getString(R.string.eggs) +
                                ")\n- Miel (" + getString(R.string.honey) +
                                ")\n- Lait (" + getString(R.string.milk) +
                                ")\n- Beurre (" + getString(R.string.butter) +
                                ")\n- Crème (" + getString(R.string.cream) +
                                ")\n- Produits laitiers (" + getString(R.string.dairy_product) + ")");

                iEatTextView.setText("I eat (" + getString(R.string.i_eat) + ")");

                listIEatTextView.setText(
                        "Fruits (" + getString(R.string.fruit) +
                                ")\n- Légumes (" + getString(R.string.vegetables) +
                                ")\n- Tubercules (" + getString(R.string.tubers) +
                                ")\n- Riz (" + getString(R.string.rice) +
                                ")\n- Tofu (" + getString(R.string.tofu) +
                                ")\n- Pâtes sans oeufs (" + getString(R.string.pasta_no_eggs) +
                                ")\n- Pain sans le lait ou les œufs (" + getString(R.string.bread_no_milk_or_eggs) +
                                ")\n- Légume (" + getString(R.string.legumes) +
                                ")\n- Semence (" + getString(R.string.seeds) +
                                ")\n- Fruits secs (" + getString(R.string.dried_fruit) + ")");
            }
        });

        danishButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                languageIndex=5;
                markFlagSelected(danishButton);
                iAmVeganTextView.setText("Jeg er veganer (" + getString(R.string.i_am_vegan) + ")");
                iDontEatTextView.setText("Jeg spiser ikke (" + getString(R.string.i_dont_eat) + ")");

                listIDontEatTextiew.setText(
                        "- Kød (" + getString(R.string.meat) +
                                ")\n- Fisk (" + getString(R.string.fish) +
                                ")\n- Æg (" + getString(R.string.eggs) +
                                ")\n- Honning (" + getString(R.string.honey) +
                                ")\n- Mælk (" + getString(R.string.milk) +
                                ")\n- Smør (" + getString(R.string.butter) +
                                ")\n- Creme (" + getString(R.string.cream) +
                                ")\n- Mælkeprodukter (" + getString(R.string.dairy_product) + ")");

                iEatTextView.setText("Jeg spiser (" + getString(R.string.i_eat) + ")");

                listIEatTextView.setText(
                        "Frugt (" + getString(R.string.fruit) +
                                ")\n- Grøntsager (" + getString(R.string.vegetables) +
                                ")\n- Rodfrugter (" + getString(R.string.tubers) +
                                ")\n- Ris (" + getString(R.string.rice) +
                                ")\n- Tofu (" + getString(R.string.tofu) +
                                ")\n- Pasta uden æg (" + getString(R.string.pasta_no_eggs) +
                                ")\n- Brød uden mælk og æg (" + getString(R.string.bread_no_milk_or_eggs) +
                                ")\n- bælgfrugter (" + getString(R.string.legumes) +
                                ")\n- frø (" + getString(R.string.seeds) +
                                ")\n- Tørret frugt (" + getString(R.string.dried_fruit) + ")");
            }
        });

        spanishButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                languageIndex=6;
                markFlagSelected(spanishButton);
                iAmVeganTextView.setText("Yo soy Vegan (" + getString(R.string.i_am_vegan) + ")");
                iDontEatTextView.setText("No puedo comer (" + getString(R.string.i_dont_eat) + ")");

                listIDontEatTextiew.setText(
                        "- Carne (" + getString(R.string.meat) +
                                ")\n- Pescado (" + getString(R.string.fish) +
                                ")\n- Huevos (" + getString(R.string.eggs) +
                                ")\n- Honning (" + getString(R.string.honey) +
                                ")\n- Miel (" + getString(R.string.milk) +
                                ")\n- Leche (" + getString(R.string.butter) +
                                ")\n- crema (" + getString(R.string.cream) +
                                ")\n- Productos lácteos (" + getString(R.string.dairy_product) + ")");

                iEatTextView.setText("Puedo comer (" + getString(R.string.i_eat) + ")");

                listIEatTextView.setText(
                        "Frutas (" + getString(R.string.fruit) +
                                ")\n- Verduras (" + getString(R.string.vegetables) +
                                ")\n- Patatas (" + getString(R.string.tubers) +
                                ")\n- Arroz (" + getString(R.string.rice) +
                                ")\n- Tofu (" + getString(R.string.tofu) +
                                ")\n- Pastas sin huevos (" + getString(R.string.pasta_no_eggs) +
                                ")\n- Pan con leche o huevos (" + getString(R.string.bread_no_milk_or_eggs) +
                                ")\n- Legumbres (" + getString(R.string.legumes) +
                                ")\n- Semillas (" + getString(R.string.seeds) +
                                ")\n- Frutos secos (" + getString(R.string.dried_fruit) + ")");
            }
        });

        greekButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                languageIndex=7;
                markFlagSelected(greekButton);
                iAmVeganTextView.setText("Είμαι για χορτοφάγους (" + getString(R.string.i_am_vegan) + ")");
                iDontEatTextView.setText("Δεν μπορώ να φάω (" + getString(R.string.i_dont_eat) + ")");

                listIDontEatTextiew.setText(
                        "- Κρέας (" + getString(R.string.meat) +
                                ")\n- ψάρι (" + getString(R.string.fish) +
                                ")\n- αυγά (" + getString(R.string.eggs) +
                                ")\n- μέλι (" + getString(R.string.honey) +
                                ")\n- γάλα (" + getString(R.string.milk) +
                                ")\n- βούτυρο (" + getString(R.string.butter) +
                                ")\n- κρέμα γάλακτος (" + getString(R.string.cream) +
                                ")\n- γαλακτοκομικών προϊόντων (" + getString(R.string.dairy_product) + ")");

                iEatTextView.setText("Έχω φάει (" + getString(R.string.i_eat) + ")");

                listIEatTextView.setText(
                        "καρπός (" + getString(R.string.fruit) +
                                ")\n- λαχανικό (" + getString(R.string.vegetables) +
                                ")\n- κόνδυλοι (" + getString(R.string.tubers) +
                                ")\n- Arroz (" + getString(R.string.rice) +
                                ")\n- ρύζι (" + getString(R.string.tofu) +
                                ")\n- ζυμαρικά χωρίς αυγά (" + getString(R.string.pasta_no_eggs) +
                                ")\n- ψωμί χωρίς γάλα ή αυγά (" + getString(R.string.bread_no_milk_or_eggs) +
                                ")\n- λαχανικό (" + getString(R.string.legumes) +
                                ")\n- σπόρος (" + getString(R.string.seeds) +
                                ")\n- αποξηραμένα φρούτα (" + getString(R.string.dried_fruit) + ")");
            }
        });

        polishButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                languageIndex=8;
                markFlagSelected(polishButton);
                iAmVeganTextView.setText("Jestem Vegan (" + getString(R.string.i_am_vegan) + ")");
                iDontEatTextView.setText("Nie jem (" + getString(R.string.i_dont_eat) + ")");

                listIDontEatTextiew.setText(
                        "- Mięso (" + getString(R.string.meat) +
                                ")\n- Ryba (" + getString(R.string.fish) +
                                ")\n- Jajka (" + getString(R.string.eggs) +
                                ")\n- Kochanie (" + getString(R.string.honey) +
                                ")\n- Mleko (" + getString(R.string.milk) +
                                ")\n- Masło (" + getString(R.string.butter) +
                                ")\n- Krem (" + getString(R.string.cream) +
                                ")\n- Nabiał (" + getString(R.string.dairy_product) + ")");

                iEatTextView.setText("Jem (" + getString(R.string.i_eat) + ")");

                listIEatTextView.setText(
                        "Owoc (" + getString(R.string.fruit) +
                                ")\n- Warzywa (" + getString(R.string.vegetables) +
                                ")\n- Bulwy (" + getString(R.string.tubers) +
                                ")\n- Ryż (" + getString(R.string.rice) +
                                ")\n- Tofu (" + getString(R.string.tofu) +
                                ")\n- Makaron bez jaj (" + getString(R.string.pasta_no_eggs) +
                                ")\n- chleb nie ma mleka ani jaj (" + getString(R.string.bread_no_milk_or_eggs) +
                                ")\n- Rośliny strączkowe (" + getString(R.string.legumes) +
                                ")\n- Posiew (" + getString(R.string.seeds) +
                                ")\n- Suszone owoce (" + getString(R.string.dried_fruit) + ")");
            }
        });

        hindiButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                languageIndex=9;
                markFlagSelected(hindiButton);
                iAmVeganTextView.setText("मु३ो Vegan है। (" + getString(R.string.i_am_vegan) + ")");
                iDontEatTextView.setText("मॅँ नहीं खाया (" + getString(R.string.i_dont_eat) + ")");
                listIDontEatTextiew.setText(
                        "- मांस (" + getString(R.string.meat) +
                                ")\n- मछली (" + getString(R.string.fish) +
                                ")\n- मछली (" + getString(R.string.eggs) +
                                ")\n- शहद (" + getString(R.string.honey) +
                                ")\n- दूध (" + getString(R.string.milk) +
                                ")\n- मक्खन (" + getString(R.string.butter) +
                                ")\n- मलाई (" + getString(R.string.cream) +
                                ")\n- दुग्ध उत्पाद (" + getString(R.string.dairy_product) + ")");

                iEatTextView.setText("मैं खाता हूँ (" + getString(R.string.i_eat) + ")");

                listIEatTextView.setText(
                        "फल (" + getString(R.string.fruit) +
                                ")\n- सब्जियां (" + getString(R.string.vegetables) +
                                ")\n- कंद (" + getString(R.string.tubers) +
                                ")\n- चावल (" + getString(R.string.rice) +
                                ")\n- टोफू (" + getString(R.string.tofu) +
                                ")\n- पास्ता नहीं अंडे (" + getString(R.string.pasta_no_eggs) +
                                ")\n- रोटी कोई दूध या अंडे नहीं (" + getString(R.string.bread_no_milk_or_eggs) +
                                ")\n- फलियां (" + getString(R.string.legumes) +
                                ")\n- बीज (" + getString(R.string.seeds) +
                                ")\n- सूखे फल (" + getString(R.string.dried_fruit) + ")");
            }
        });

        japaneseButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                languageIndex=10;
                markFlagSelected(japaneseButton);
                iAmVeganTextView.setText("私は完全菜食主義者です (" + getString(R.string.i_am_vegan) + ")");
                iDontEatTextView.setText("私は食べてはいけない (" + getString(R.string.i_dont_eat) + ")");

                listIDontEatTextiew.setText(
                        "- 肉 (" + getString(R.string.meat) +
                                ")\n- 魚 (" + getString(R.string.fish) +
                                ")\n- 卵 (" + getString(R.string.eggs) +
                                ")\n- 蜂蜜 (" + getString(R.string.honey) +
                                ")\n- 牛乳 (" + getString(R.string.milk) +
                                ")\n- バター (" + getString(R.string.butter) +
                                ")\n- クリーム (" + getString(R.string.cream) +
                                ")\n- द乳製品です (" + getString(R.string.dairy_product) + ")");

                iEatTextView.setText("私は食べています (" + getString(R.string.i_eat) + ")");

                listIEatTextView.setText(
                        "フルーツ (" + getString(R.string.fruit) +
                                ")\n- 野菜 (" + getString(R.string.vegetables) +
                                ")\n- 塊茎 (" + getString(R.string.tubers) +
                                ")\n- ご飯 (" + getString(R.string.rice) +
                                ")\n- 豆腐 (" + getString(R.string.tofu) +
                                ")\n- パスタなしの卵 (" + getString(R.string.pasta_no_eggs) +
                                ")\n- 牛乳や卵のないパン (" + getString(R.string.bread_no_milk_or_eggs) +
                                ")\n- マメ科植物 (" + getString(R.string.legumes) +
                                ")\n- 種子 (" + getString(R.string.seeds) +
                                ")\n- ドライフルーツ (" + getString(R.string.dried_fruit) + ")");
            }
        });

        portugueseButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                languageIndex=11;
                markFlagSelected(portugueseButton);
                iAmVeganTextView.setText("Eu sou Vegan (" + getString(R.string.i_am_vegan) + ")");
                iDontEatTextView.setText("Eu não comer (" + getString(R.string.i_dont_eat) + ")");

                listIDontEatTextiew.setText(
                        "- Carne (" + getString(R.string.meat) +
                                ")\n- Peixe (" + getString(R.string.fish) +
                                ")\n- ovos (" + getString(R.string.eggs) +
                                ")\n- Mel (" + getString(R.string.honey) +
                                ")\n- Leite (" + getString(R.string.milk) +
                                ")\n- Manteiga (" + getString(R.string.butter) +
                                ")\n- Creme de leite (" + getString(R.string.cream) +
                                ")\n- Produtos lácteos (" + getString(R.string.dairy_product) + ")");

                iEatTextView.setText("Eu comer (" + getString(R.string.i_eat) + ")");

                listIEatTextView.setText(
                        "Frutas (" + getString(R.string.fruit) +
                                ")\n- Legumes (" + getString(R.string.vegetables) +
                                ")\n- Tubérculos (" + getString(R.string.tubers) +
                                ")\n- Arroz (" + getString(R.string.rice) +
                                ")\n- Tofu (" + getString(R.string.tofu) +
                                ")\n- Macarrão sem ovos (" + getString(R.string.pasta_no_eggs) +
                                ")\n- Pão sem leite ou ovos (" + getString(R.string.bread_no_milk_or_eggs) +
                                ")\n- Legumes (" + getString(R.string.legumes) +
                                ")\n- Sementes (" + getString(R.string.seeds) +
                                ")\n- Fruta seca (" + getString(R.string.dried_fruit) + ")");
            }
        });

        russianButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                languageIndex=12;
                markFlagSelected(russianButton);
                iAmVeganTextView.setText("Я веган (" + getString(R.string.i_am_vegan) + ")");
                iDontEatTextView.setText("Я не ем (" + getString(R.string.i_dont_eat) + ")");

                listIDontEatTextiew.setText(
                        "- мясо (" + getString(R.string.meat) +
                                ")\n- Рыба (" + getString(R.string.fish) +
                                ")\n- яйца (" + getString(R.string.eggs) +
                                ")\n- Мед (" + getString(R.string.honey) +
                                ")\n- Молоко (" + getString(R.string.milk) +
                                ")\n- Масло (" + getString(R.string.butter) +
                                ")\n- Крем (" + getString(R.string.cream) +
                                ")\n- Ежедневный продукт (" + getString(R.string.dairy_product) + ")");

                iEatTextView.setText("я ем (" + getString(R.string.i_eat) + ")");

                listIEatTextView.setText(
                        "Фрукты (" + getString(R.string.fruit) +
                                ")\n- Бобовые (" + getString(R.string.vegetables) +
                                ")\n- Клубни (" + getString(R.string.tubers) +
                                ")\n- Рис (" + getString(R.string.rice) +
                                ")\n- Тофу (" + getString(R.string.tofu) +
                                ")\n- Паста без яиц (" + getString(R.string.pasta_no_eggs) +
                                ")\n- Хлеб без молока или яиц (" + getString(R.string.bread_no_milk_or_eggs) +
                                ")\n- Бобовые (" + getString(R.string.legumes) +
                                ")\n- Семена (" + getString(R.string.seeds) +
                                ")\n- Сухофрукт (" + getString(R.string.dried_fruit) + ")");
            }
        });

        thaiButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                languageIndex=13;
                markFlagSelected(thaiButton);
                iAmVeganTextView.setText("ฉันเป็นมังสวิรัติ (" + getString(R.string.i_am_vegan) + ")");
                iDontEatTextView.setText("ฉันไม่กิน (" + getString(R.string.i_dont_eat) + ")");

                listIDontEatTextiew.setText(
                        "- เนื้อ (" + getString(R.string.meat) +
                                ")\n- ปลา (" + getString(R.string.fish) +
                                ")\n- ไข่ (" + getString(R.string.eggs) +
                                ")\n- น้ำผึ้ง (" + getString(R.string.honey) +
                                ")\n- นม (" + getString(R.string.milk) +
                                ")\n- เนย (" + getString(R.string.butter) +
                                ")\n- ครีม (" + getString(R.string.cream) +
                                ")\n- ผลิตภัณฑ์นม (" + getString(R.string.dairy_product) + ")");

                iEatTextView.setText("ฉันกิน (" + getString(R.string.i_eat) + ")");

                listIEatTextView.setText(
                        "ผลไม้\n (" + getString(R.string.fruit) +
                                ")\n- ผัก (" + getString(R.string.vegetables) +
                                ")\n- หัว (" + getString(R.string.tubers) +
                                ")\n- ข้าว (" + getString(R.string.rice) +
                                ")\n- เต้าหู้ (" + getString(R.string.tofu) +
                                ")\n- พาสต้าไม่มีไข่ (" + getString(R.string.pasta_no_eggs) +
                                ")\n- ขนมปังไม่มีนมหรือไข่ (" + getString(R.string.bread_no_milk_or_eggs) +
                                ")\n- พืชตระกูลถั่ว (" + getString(R.string.legumes) +
                                ")\n- เมล็ดพันธุ์พืช (" + getString(R.string.seeds) +
                                ")\n- ผลไม้อบแห้ง (" + getString(R.string.dried_fruit) + ")");
            }
        });
    }

    private void markFlagSelected(ImageView flag) {
        if (flag == englishButton) {
            englishTextView.setBackgroundColor(getResources().getColor(R.color.gold));
            italianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            chineseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            germanTextView.setBackgroundColor(getResources().getColor(R.color.white));
            frenchTextView.setBackgroundColor(getResources().getColor(R.color.white));
            danishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            spanishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            greekTextView.setBackgroundColor(getResources().getColor(R.color.white));
            polishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            hindiTextView.setBackgroundColor(getResources().getColor(R.color.white));
            japaneseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            portugueseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            russianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            thaiTextView.setBackgroundColor(getResources().getColor(R.color.white));
        } else if (flag == italianButton) {
            englishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            italianTextView.setBackgroundColor(getResources().getColor(R.color.gold));
            chineseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            germanTextView.setBackgroundColor(getResources().getColor(R.color.white));
            frenchTextView.setBackgroundColor(getResources().getColor(R.color.white));
            danishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            spanishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            greekTextView.setBackgroundColor(getResources().getColor(R.color.white));
            polishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            hindiTextView.setBackgroundColor(getResources().getColor(R.color.white));
            japaneseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            portugueseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            russianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            thaiTextView.setBackgroundColor(getResources().getColor(R.color.white));
        } else if (flag == chineseButton) {
            englishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            italianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            chineseTextView.setBackgroundColor(getResources().getColor(R.color.gold));
            germanTextView.setBackgroundColor(getResources().getColor(R.color.white));
            frenchTextView.setBackgroundColor(getResources().getColor(R.color.white));
            danishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            spanishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            greekTextView.setBackgroundColor(getResources().getColor(R.color.white));
            polishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            hindiTextView.setBackgroundColor(getResources().getColor(R.color.white));
            japaneseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            portugueseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            russianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            thaiTextView.setBackgroundColor(getResources().getColor(R.color.white));
        } else if (flag == germanButton) {
            englishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            italianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            chineseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            germanTextView.setBackgroundColor(getResources().getColor(R.color.gold));
            frenchTextView.setBackgroundColor(getResources().getColor(R.color.white));
            danishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            spanishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            greekTextView.setBackgroundColor(getResources().getColor(R.color.white));
            polishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            hindiTextView.setBackgroundColor(getResources().getColor(R.color.white));
            japaneseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            portugueseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            russianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            thaiTextView.setBackgroundColor(getResources().getColor(R.color.white));
        } else if (flag == frenchButton) {
            englishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            italianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            chineseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            germanTextView.setBackgroundColor(getResources().getColor(R.color.white));
            frenchTextView.setBackgroundColor(getResources().getColor(R.color.gold));
            danishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            spanishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            greekTextView.setBackgroundColor(getResources().getColor(R.color.white));
            polishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            hindiTextView.setBackgroundColor(getResources().getColor(R.color.white));
            japaneseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            portugueseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            russianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            thaiTextView.setBackgroundColor(getResources().getColor(R.color.white));
        } else if (flag == danishButton) {
            englishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            italianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            chineseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            germanTextView.setBackgroundColor(getResources().getColor(R.color.white));
            frenchTextView.setBackgroundColor(getResources().getColor(R.color.white));
            danishTextView.setBackgroundColor(getResources().getColor(R.color.gold));
            spanishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            greekTextView.setBackgroundColor(getResources().getColor(R.color.white));
            polishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            hindiTextView.setBackgroundColor(getResources().getColor(R.color.white));
            japaneseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            portugueseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            russianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            thaiTextView.setBackgroundColor(getResources().getColor(R.color.white));
        } else if (flag == spanishButton) {
            englishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            italianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            chineseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            germanTextView.setBackgroundColor(getResources().getColor(R.color.white));
            frenchTextView.setBackgroundColor(getResources().getColor(R.color.white));
            danishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            spanishTextView.setBackgroundColor(getResources().getColor(R.color.gold));
            greekTextView.setBackgroundColor(getResources().getColor(R.color.white));
            polishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            hindiTextView.setBackgroundColor(getResources().getColor(R.color.white));
            japaneseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            portugueseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            russianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            thaiTextView.setBackgroundColor(getResources().getColor(R.color.white));
        } else if (flag == greekButton) {
            englishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            italianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            chineseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            germanTextView.setBackgroundColor(getResources().getColor(R.color.white));
            frenchTextView.setBackgroundColor(getResources().getColor(R.color.white));
            danishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            spanishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            greekTextView.setBackgroundColor(getResources().getColor(R.color.gold));
            polishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            hindiTextView.setBackgroundColor(getResources().getColor(R.color.white));
            japaneseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            portugueseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            russianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            thaiTextView.setBackgroundColor(getResources().getColor(R.color.white));
        } else if (flag == polishButton) {
            englishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            italianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            chineseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            germanTextView.setBackgroundColor(getResources().getColor(R.color.white));
            frenchTextView.setBackgroundColor(getResources().getColor(R.color.white));
            danishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            spanishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            greekTextView.setBackgroundColor(getResources().getColor(R.color.white));
            polishTextView.setBackgroundColor(getResources().getColor(R.color.gold));
            hindiTextView.setBackgroundColor(getResources().getColor(R.color.white));
            japaneseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            portugueseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            russianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            thaiTextView.setBackgroundColor(getResources().getColor(R.color.white));
        } else if (flag == hindiButton) {
            englishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            italianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            chineseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            germanTextView.setBackgroundColor(getResources().getColor(R.color.white));
            frenchTextView.setBackgroundColor(getResources().getColor(R.color.white));
            danishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            spanishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            greekTextView.setBackgroundColor(getResources().getColor(R.color.white));
            polishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            hindiTextView.setBackgroundColor(getResources().getColor(R.color.gold));
            japaneseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            portugueseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            russianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            thaiTextView.setBackgroundColor(getResources().getColor(R.color.white));
        } else if (flag == japaneseButton) {
            englishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            italianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            chineseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            germanTextView.setBackgroundColor(getResources().getColor(R.color.white));
            frenchTextView.setBackgroundColor(getResources().getColor(R.color.white));
            danishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            spanishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            greekTextView.setBackgroundColor(getResources().getColor(R.color.white));
            polishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            hindiTextView.setBackgroundColor(getResources().getColor(R.color.white));
            japaneseTextView.setBackgroundColor(getResources().getColor(R.color.gold));
            portugueseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            russianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            thaiTextView.setBackgroundColor(getResources().getColor(R.color.white));
        } else if (flag == portugueseButton) {
            englishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            italianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            chineseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            germanTextView.setBackgroundColor(getResources().getColor(R.color.white));
            frenchTextView.setBackgroundColor(getResources().getColor(R.color.white));
            danishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            spanishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            greekTextView.setBackgroundColor(getResources().getColor(R.color.white));
            polishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            hindiTextView.setBackgroundColor(getResources().getColor(R.color.white));
            japaneseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            portugueseTextView.setBackgroundColor(getResources().getColor(R.color.gold));
            russianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            thaiTextView.setBackgroundColor(getResources().getColor(R.color.white));
        } else if (flag == russianButton) {
            englishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            italianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            chineseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            germanTextView.setBackgroundColor(getResources().getColor(R.color.white));
            frenchTextView.setBackgroundColor(getResources().getColor(R.color.white));
            danishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            spanishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            greekTextView.setBackgroundColor(getResources().getColor(R.color.white));
            polishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            hindiTextView.setBackgroundColor(getResources().getColor(R.color.white));
            japaneseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            portugueseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            russianTextView.setBackgroundColor(getResources().getColor(R.color.gold));
            thaiTextView.setBackgroundColor(getResources().getColor(R.color.white));
        } else if (flag == thaiButton) {
            englishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            italianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            chineseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            germanTextView.setBackgroundColor(getResources().getColor(R.color.white));
            frenchTextView.setBackgroundColor(getResources().getColor(R.color.white));
            danishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            spanishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            greekTextView.setBackgroundColor(getResources().getColor(R.color.white));
            polishTextView.setBackgroundColor(getResources().getColor(R.color.white));
            hindiTextView.setBackgroundColor(getResources().getColor(R.color.white));
            japaneseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            portugueseTextView.setBackgroundColor(getResources().getColor(R.color.white));
            russianTextView.setBackgroundColor(getResources().getColor(R.color.white));
            thaiTextView.setBackgroundColor(getResources().getColor(R.color.gold));
        }
    }

    private void setOnSpeakerButtonListener() {
        iAmVeganSpeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (languageIndex){
                    case 0 :  mp = MediaPlayer.create(getContext(),R.raw.i_am_vegan);
                    break;
                    case 1 : mp = MediaPlayer.create(getContext(),R.raw.io_sono_vegana);
                    break;
                    case 2 : mp = MediaPlayer.create(getContext(),R.raw.io_sono_vegana);
                    break;
                    case 3 : mp = MediaPlayer.create(getContext(),R.raw.io_sono_vegana);
                    break;
                    case 4 : mp = MediaPlayer.create(getContext(),R.raw.io_sono_vegana);
                    break;
                    case 5 : mp = MediaPlayer.create(getContext(),R.raw.io_sono_vegana);
                    break;
                    case 6 : mp = MediaPlayer.create(getContext(),R.raw.yo_soy_vegan);
                    break;

                }

                if (mp != null){
                    mp.start();
                    mp.release();
                }
            }
        });

        iDontEatSpeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (languageIndex){
                    case 0 :  mp = MediaPlayer.create(getContext(),R.raw.i_am_vegan);
                        break;
                    case 1 : mp = MediaPlayer.create(getContext(),R.raw.io_sono_vegana);
                }

                mp.start();
                mp.release();
            }
        });

        iEatSpeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (languageIndex){
                    case 0 :  mp = MediaPlayer.create(getContext(),R.raw.i_am_vegan);
                        break;
                    case 1 : mp = MediaPlayer.create(getContext(),R.raw.io_sono_vegana);
                }

                mp.start();
                mp.release();
            }
        });
    }
}
