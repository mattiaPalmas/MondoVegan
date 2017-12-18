package com.exerciseapp.mattiapalmas.solovegan;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements ScanFragment.OnFragmentInteractionListener, TravelFragment.OnFragmentInteractionListener, ComponentsFragment.OnFragmentInteractionListener {

    LinearLayout scanLayout, travelLayout, componentsLayout, mainLayout, componentSelectLayout;
    TextView descriptionTextView;
    final android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
    DatabaseHelper myDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ScanFragment scanFragment = new ScanFragment();
        fragmentTransaction.replace(R.id.fragment_container, scanFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        initVariables();
        prepareMenuClickable();
        setUpDataBase();
    }

    private void initVariables() {
        scanLayout = findViewById(R.id.scan_menu_layout);
        travelLayout = findViewById(R.id.travel_menu_layout);
        componentsLayout = findViewById(R.id.components_menu_layout);

        componentSelectLayout = findViewById(R.id.component_select_layout);
        mainLayout = findViewById(R.id.main_layout);
        myDataBase = new DatabaseHelper(this);

        descriptionTextView = findViewById(R.id.description_text_view);
    }

    private void prepareMenuClickable() {


        scanLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ScanFragment scanFragment = new ScanFragment();
                fragmentTransaction.replace(R.id.fragment_container, scanFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        travelLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                TravelFragment travelFragment = new TravelFragment();
                fragmentTransaction.replace(R.id.fragment_container, travelFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        componentsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ComponentsFragment componentsFragment = new ComponentsFragment();
                fragmentTransaction.replace(R.id.fragment_container, componentsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackPressed() {
        if (componentSelectLayout.getVisibility() == View.VISIBLE) {
            mainLayout.setVisibility(View.VISIBLE);
            componentsLayout.setVisibility(View.GONE);
            descriptionTextView.setText("");
            descriptionTextView.scrollTo(1,1);
            return;
        }
        super.onBackPressed();
    }

    private void setUpDataBase() {
        Cursor res = myDataBase.getAllData();
        if (res.getCount() == 0) {
            // list of fabrics
            myDataBase.insertData("Aba", "a fabric woven from goat and camel hair.", false, true, false, "fabrics");
            myDataBase.insertData("Acrylic", "a synthetic fabric.", true, false, false, "fabrics");
            myDataBase.insertData("Aertex", "a trademark for a loosely woven cotton fabric that is used to make shirts and underwear.", true, false, false, "fabrics");
            myDataBase.insertData("alpaca", "a thin glossy fabric made of the wool of the alpaca, or a rayon or cotton imitation.", false, true, false, "fabrics");
            myDataBase.insertData("Baize", "a bright green fabric napped to resemble felt; used to cover gaming tables.", false, false, true, "fabrics");
            myDataBase.insertData("Batiste", "a thin plain-weave cotton or linen fabric; used for shirts or dresses.", true, false, false, "fabrics");
            myDataBase.insertData("Broadcloth", "is a dense woollen cloth. Modern broadcloth can be composed of cotton, silk, or polyester, but traditionally broadcloth was made solely of wool.", false, false, true, "fabrics");
            myDataBase.insertData("Brocade", "thick heavy expensive material with a raised pattern, a class of richly decorative shuttle-woven fabrics, often made in colored silks and with or without sulaimangold and silver threads.", false, true, false, "fabrics");
            myDataBase.insertData("Buckram", "a coarse cotton fabric stiffened with glue; used in bookbinding and to stiffen clothing.", true, false, false, "fabrics");
            myDataBase.insertData("Bunting", "a loosely woven fabric used for flags, etc.", true, false, false, "fabrics");
            myDataBase.insertData("Calico", "a plain-woven textile made from unbleached, and often not fully processed, cotton.", true, false, false, "fabrics");
            myDataBase.insertData("Cambric", "a finely woven white linen.", true, false, false, "fabrics");
            myDataBase.insertData("Camelhair", "a soft tan cloth made with the hair of a camel.", false, true, false, "fabrics");
            myDataBase.insertData("Camlet", "a fabric of Asian origin; originally made of silk and camel’s hair.", false, true, false, "fabrics");
            myDataBase.insertData("Canvas", "heavy closely woven fabric (used for clothing or chairs or sails or tents).", true, false, false, "fabrics");
            myDataBase.insertData("Cashmere", "a soft fabric made from the wool of the Cashmere goat", false, true, false, "fabrics");
            myDataBase.insertData("Cerecloth (altar cloth)", "a waterproof waxed cloth once used as a shroud (also called altar cloth, used in churches).", false, true, false, "fabrics");
            myDataBase.insertData("Challis", "a soft lightweight fabric (usually printed)A soft, lightweight, usually printed fabric made of wool, cotton, or rayon.", false, false, true, "fabrics");
            myDataBase.insertData("Chambray or cambric", "Initially made of linen (flax), then cotton in the 19th century, it is also called batiste. Cambric is used for linens, shirtings, handkerchieves and as fabric for lace and needlework.", true, false, false, "fabrics");
            myDataBase.insertData("Chenille", "a heavy fabric woven with chenille cord; used in rugs and bedspreads, commonly manufactured from cotton, but can also be made using acrylic, rayon and olefin.", true, false, false, "fabrics");
            myDataBase.insertData("Chiffon", "a sheer fabric of silk or rayon.", false, false, true, "fabrics");
            myDataBase.insertData("Chino", "a coarse twilled cotton fabric used for uniforms.", true, false, false, "fabrics");
            myDataBase.insertData("Chintz", "a brightly printed and glazed cotton fabric", true, false, false, "fabrics");
            myDataBase.insertData("Cord, Corduroy", "a cut pile fabric with vertical ribs; usually made of cotton.", true, false, false, "fabrics");
            myDataBase.insertData("Cotton", "fabric woven from cotton fibers.", true, false, false, "fabrics");
            myDataBase.insertData("Cotton flannel, Canton flannel", "a stout cotton fabric with nap on only one side.", true, false, false, "fabrics");
            myDataBase.insertData("Crepe, Crape, Crepe de Chine", "a silk, wool, or polyester fabric of a gauzy texture, having a peculiar crisp or crimpy appearance.", false, false, true, "fabrics");
            myDataBase.insertData("Cretonne", "an unglazed heavy fabric; brightly printed; used for slipcovers and draperies , from hemp or linen", true, false, false, "fabrics");
            myDataBase.insertData("Damask", "a fabric of linen or cotton or silk or wool with a reversible pattern woven into it.", false, false, true, "fabrics");
            myDataBase.insertData("Denim, Dungaree, Jean", "a coarse durable twill-weave cotton fabric.", true, false, false, "fabrics");
            myDataBase.insertData("Diaper", "a fabric (usually cotton or linen) with a distinctive woven pattern of small repeated figures.", true, false, false, "fabrics");
            myDataBase.insertData("Dimity", "a strong cotton fabric with a raised pattern; used for bedcovers and curtains", true, false, false, "fabrics");
            myDataBase.insertData("Doeskin", "a fine smooth soft woolen fabric.", false, true, false, "fabrics");
            myDataBase.insertData("Duck", "a heavy cotton fabric of plain weave; used for clothing and tents.", true, false, false, "fabrics");
            myDataBase.insertData("Duffel, duffle", "a coarse heavy woolen fabric.", false, true, false, "fabrics");
            myDataBase.insertData("Elastic", "an elastic fabric made of yarns containing an elastic material.", true, false, false, "fabrics");
            myDataBase.insertData("Etamine, Etamin", "a soft cotton or worsted fabric with an open mesh; used for curtains or clothing etc.", true, false, false, "fabrics");
            myDataBase.insertData("Faille", "a ribbed woven fabric of silk or rayon or cotton.", false, false, true, "fabrics");
            myDataBase.insertData("Felt", "a fabric made of compressed matted animal fibers.", false, true, false, "fabrics");
            myDataBase.insertData("Fiber, Fibre, Vulcanized fiber", "a leatherlike material made by compressing layers of paper or cloth.", true, false, false, "fabrics");
            myDataBase.insertData("Flannel", "a soft light woolen fabric; used for clothing.", false, true, false, "fabrics");
            myDataBase.insertData("Flannelette", "a cotton fabric imitating flannel.", true, false, false, "fabrics");
            myDataBase.insertData("Fleece", "a soft bulky fabric with deep pile; used chiefly for clothing.", true, false, false, "fabrics");
            myDataBase.insertData("Foulard", "a light plain-weave or twill-weave silk or silklike fabric (usually with a printed design).", false, false, true, "fabrics");
            myDataBase.insertData("Frieze", "a heavy woolen fabric with a long nap.", false, true, false, "fabrics");
            myDataBase.insertData("Fustian", "a strong cotton and linen fabric with a slight nap.", true, false, false, "fabrics");
            myDataBase.insertData("Gabardine", "a tough, tightly woven fabric used to make suits, overcoats, trousers, uniforms, windbreakers, and other garments, traditionally worsted wool, but may also be cotton, texturized polyester, or a blend.", false, false, true, "fabrics");
            myDataBase.insertData("Georgette", "a thin silk dress material.", false, true, false, "fabrics");
            myDataBase.insertData("Gingham", "a clothing fabric in a plaid weave.", true, false, false, "fabrics");
            myDataBase.insertData("Grogram", "a coarse fabric of silk mixed with wool or mohair and often stiffened with gum.", false, true, false, "fabrics");
            myDataBase.insertData("Grosgrain", "a silk or silklike fabric with crosswise ribs.", false, false, true, "fabrics");
            myDataBase.insertData("Haircloth, hair", "cloth woven from horsehair or camelhair; used for upholstery or stiffening in garments.", false, true, false, "fabrics");
            myDataBase.insertData("Horsehair", "fabric made from horsehair fibers; used for upholstery.", false, true, false, "fabrics");
            myDataBase.insertData("Jersey", "a slightly elastic machine-knit fabric , originally made of wool, but is now made of wool, cotton, and synthetic fibres.", false, false, true, "fabrics");
            myDataBase.insertData("Khaki", "a sturdy twilled cloth of a yellowish brown color used especially for military uniforms, usually made from cotton and linen.", true, false, false, "fabrics");
            myDataBase.insertData("Lame", "a fabric interwoven with threads of metal.", true, false, false, "fabrics");
            myDataBase.insertData("Leather", "a durable and flexible material created by the tanning of putrescible animal rawhide and skin, primarily cattlehide (cows).", false, true, false, "fabrics");
            myDataBase.insertData("Leatherette, Imitation leather", "fabric made to look like leather.", true, false, false, "fabrics");
            myDataBase.insertData("Linen", "a fabric woven with fibers from the flax plant.", true, false, false, "fabrics");
            myDataBase.insertData("Linsey-woolsey", "a rough fabric of linen warp and wool or cotton woof.", false, false, true, "fabrics");
            myDataBase.insertData("Lint", "cotton or linen fabric with the nap raised on one side; used to dress wounds.", true, false, false, "fabrics");
            myDataBase.insertData("Lisle", "a fabric woven with lisle thread (a type of cotton).", false, true, false, "fabrics");
            myDataBase.insertData("Mackinaw", "a heavy woolen cloth heavily napped and felted, often with a plaid design.", false, true, false, "fabrics");
            myDataBase.insertData("Mackintosh, Macintosh", "a lightweight waterproof (usually rubberized) fabric.", true, false, false, "fabrics");
            myDataBase.insertData("Madras", "a light patterned cotton cloth.", true, false, false, "fabrics");
            myDataBase.insertData("Marseille", "strong cotton fabric with a raised pattern; used for bedspreads.", true, false, false, "fabrics");
            myDataBase.insertData("Mohair", "fabric made with yarn made from the silky hair of the Angora goat.", false, true, false, "fabrics");
            myDataBase.insertData("Moire, Watered-silk", "silk fabric with a wavy surface pattern.", false, true, false, "fabrics");
            myDataBase.insertData("Moleskin", "a durable cotton fabric with a velvety nap.", true, false, false, "fabrics");
            myDataBase.insertData("Monk’s cloth", "a heavy cloth in basket weave , made from cotton.", true, false, false, "fabrics");
            myDataBase.insertData("Moquette", "a thick velvety synthetic fabric used for carpets and soft upholstery.", true, false, false, "fabrics");
            myDataBase.insertData("Moreen", "a heavy fabric of wool (or wool and cotton) used especially in upholstery.", false, true, false, "fabrics");
            myDataBase.insertData("Motley", "a multicolored woolen fabric woven of mixed threads in 14th to 17th century England.", false, true, false, "fabrics");
            myDataBase.insertData("Mousseline de sole", "a gauze-like fabric of silk or rayon.", false, false, true, "fabrics");
            myDataBase.insertData("Muslin", "plain-woven cotton fabric.", true, false, false, "fabrics");
            myDataBase.insertData("Nankeen", "a kind of pale yellowish cloth, originally made at Nanjing from a yellow variety of cotton, but subsequently manufactured from ordinary cotton which is then dyed.", true, false, false, "fabrics");
            myDataBase.insertData("Ninon", "a fine strong sheer silky fabric made of silk or rayon or nylon.", false, false, true, "fabrics");
            myDataBase.insertData("Nylon", "a synthetic fabric.", true, false, false, "fabrics");
            myDataBase.insertData("Oilcloth", "cloth treated on one side with a drying oil or synthetic resin.", true, false, false, "fabrics");
            myDataBase.insertData("Organdie, Organdy", "a sheer stiff muslin.", true, false, false, "fabrics");
            myDataBase.insertData("Organza", "a fabric made of silk or a silklike fabric that resembles organdy.", false, false, true, "fabrics");
            myDataBase.insertData("Orlon", "an acrylic fiber or the lightweight crease-resistant fabric made with Orlon yarns.", true, false, false, "fabrics");
            myDataBase.insertData("Paisley", "a soft wool fabric with a colorful swirled pattern of curved shapes.", false, true, false, "fabrics");
            myDataBase.insertData("Percale", "a fine closely woven cotton fabric.", true, false, false, "fabrics");
            myDataBase.insertData("Pilot cloth", "a thick blue cloth used to make overcoats and coats for sailors etc.", true, false, false, "fabrics");
            myDataBase.insertData("Pique", "tightly woven fabric with raised cords (normally with cotton).", true, false, false, "fabrics");
            myDataBase.insertData("Plush", "a textile having a cut nap or pile the same as fustian or velvet. Originally the pile of plush consisted of mohair or worsted yarn, but now silk by itself or with a cotton backing is used for plush, the distinction from velvet being found in the longer and less dense pile of plush. Modern plush are commonly manufactured from synthetic fibres such as polyester.", false, false, true, "fabrics");
            myDataBase.insertData("Polyester", "any of a large class of synthetic fabrics.", true, false, false, "fabrics");
            myDataBase.insertData("Pongee", "a soft thin cloth woven from raw silk (or an imitation).", false, false, true, "fabrics");
            myDataBase.insertData("Rayon", "a synthetic silklike fabric.", true, false, false, "fabrics");
            myDataBase.insertData("Rep, Repp", "a fabric with prominent rounded crosswise ribs, made of silk, wool, or cotton.", false, false, true, "fabrics");
            myDataBase.insertData("Russet", "a reddish brown homespun fabric , a coarse cloth made of wool and dyed with woad and madder to give it a subdued grey or brown shade.", false, true, false, "fabrics");
            myDataBase.insertData("Sarcenet, Sarsenet", "a fine soft silk fabric often used for linings.", false, true, false, "fabrics");
            myDataBase.insertData("Samite", "a heavy silk fabric (often woven with silver or gold threads); used to make clothing in the Middle Ages.", false, true, false, "fabrics");
            myDataBase.insertData("Sateen", "a cotton fabric with a satiny finish.", true, false, false, "fabrics");
            myDataBase.insertData("Satin", "a smooth fabric of silk or rayon; has a glossy face and a dull back.", false, false, true, "fabrics");
            myDataBase.insertData("Screening", "fabric of metal or plastic mesh.", true, false, false, "fabrics");
            myDataBase.insertData("Scrim", "a very light textile made from cotton, or sometimes flax. Its light weight and translucence means it is often used for making curtains. The fabric can also be used for bookbinding and upholstery.", true, false, false, "fabrics");
            myDataBase.insertData("Seersucker", "a thin, puckered, all-cotton fabric, commonly striped or checkered, used to make clothing for spring and summer wear.", true, false, false, "fabrics");
            myDataBase.insertData("Serge", "a twilled woolen fabric.", false, true, false, "fabrics");
            myDataBase.insertData("Shag", "a fabric with long coarse nap , a rug or carpet that has a deep pile, giving it a shaggy appearance.", false, true, false, "fabrics");
            myDataBase.insertData("Shantung", "a heavy silk fabric with a rough surface (or a cotton imitation).", false, false, true, "fabrics");
            myDataBase.insertData("Shark skin, Shagreen", "a type of rawhide consisting of rough untanned skin, formerly made from a horse’s back or that of an onager (wild ass). Shagreen is now commonly made of the skins of sharks and rays.", false, true, false, "fabrics");
            myDataBase.insertData("Silesie", "a sturdy twill-weave cotton fabric; used for pockets and linings.", true, false, false, "fabrics");
            myDataBase.insertData("Silk", "a fabric made from the fine threads produced by certain insect larvae.", false, true, false, "fabrics");
            myDataBase.insertData("Spandex", "an elastic synthetic fabric.", true, false, false, "fabrics");
            myDataBase.insertData("Sponge cloth", "any soft porous fabric (especially in a loose honeycomb weave).", false, false, true, "fabrics");
            myDataBase.insertData("Stammel", "a coarse woolen cloth formerly used for undergarments and usually dyed bright red.", false, true, false, "fabrics");
            myDataBase.insertData("Suede leather", "a type of leather with a napped finish, commonly used for jackets, shoes, shirts, purses, furniture and other items. Suede leather is made from the underside of the skin, primarily lamb, although goat, pig, calf and deer are commonly used.", false, true, false, "fabrics");
            myDataBase.insertData("Swan’s down", "soft woolen fabric used especially for baby clothes.", false, true, false, "fabrics");
            myDataBase.insertData("Taffeta", "a crisp, smooth plain woven fabric made from silk or synthetic fibres.", false, false, true, "fabrics");
            myDataBase.insertData("Tammy", "plain-woven (often glazed) fabric of wool or wool and cotton used especially formerly for linings and garments and curtains.", false, true, false, "fabrics");
            myDataBase.insertData("Tapa, tappa", "a paperlike cloth made in the South Pacific by pounding tapa bark.", true, false, false, "fabrics");
            myDataBase.insertData("Tapestry, Tapis", "a heavy textile with a woven design; used for curtains and upholstery, Most weavers use a naturally based warp thread such as linen or cotton. The weft threads are usually wool or cotton, but may include silk, gold, silver, or other alternatives.", false, false, true, "fabrics");
            myDataBase.insertData("Toweling", "any of various fabrics (linen or cotton) used to make towels.", true, false, false, "fabrics");
            myDataBase.insertData("Tweed", "thick woolen fabric used for clothing; originated in Scotland.", false, true, false, "fabrics");
            myDataBase.insertData("Ultrasuede", "a synthetic suede cloth.", true, false, false, "fabrics");
            myDataBase.insertData("Velcro", "nylon fabric used as a fastening.", true, false, false, "fabrics");
            myDataBase.insertData("Velour", "heavy fabric that resembles velvet , and it is usually made from cotton but can also be made from synthetic materials such as polyester.", true, false, false, "fabrics");
            myDataBase.insertData("Velvet", "a silky densely piled fabric with a plain back , it can be made from many different kinds of fibres, traditionally silk. Velvet made entirely from silk has market prices of several hundred US dollars per yard. Cotton can also be used, though this often results in a slightly less luxurious fabric. Velvet can also be made from fibers such as linen, mohair, and wool. More recently, synthetic velvets have been developed, mostly polyester, nylon, viscose, acetate, and mixtures of different synthetics, or synthetics and natural fibers (for example viscose mixed with silk). A small percentage of spandex is sometimes added to give stretch.", false, false, true, "fabrics");
            myDataBase.insertData("Velveteen", "a usually cotton fabric with a short pile imitating velvet.", true, false, false, "fabrics");
            myDataBase.insertData("Vicuna", "a soft wool fabric made from the fleece of the vicuna.", false, true, false, "fabrics");
            myDataBase.insertData("Viscose, Viscone rayon", "a rayon fabric made from viscose (cellulose xanthate) fibers.", true, false, false, "fabrics");
            myDataBase.insertData("Viyella", "a fabric made from a twilled mixture of cotton and wool.", false, true, false, "fabrics");
            myDataBase.insertData("Voile", "a light semitransparent , soft, sheer fabric, usually made of 100% cotton or cotton blends including linen or polyester.", true, false, false, "fabrics");
            myDataBase.insertData("Whipcord", "a strong worsted or cotton fabric made of hard-twisted yarns with a diagonal cord or rib.", false, false, true, "fabrics");
            myDataBase.insertData("Wincey", "a plain or twilled fabric of wool and cotton used especially for warm shirts or skirts and pajamas.", false, true, false, "fabrics");
            myDataBase.insertData("Wire cloth", "fabric woven of metallic wire.", true, false, false, "fabrics");
            myDataBase.insertData("Wool, Woolen, Woollen", "a fabric made from the hair of sheep.", false, true, false, "fabrics");
            myDataBase.insertData("Worsted", "a woolen fabric with a hard textured surface and no nap; woven of worsted yarns.", false, true, false, "fabrics");


            myDataBase.insertData("Acetate (B)", " Vitamin A", false, false, true, "food");
            myDataBase.insertData("Product", "Test product", false, false, true, "product");
            myDataBase.insertData("Fabrics", "Test fabrics", false, true, false, "fabrics");
        }
    }
}
