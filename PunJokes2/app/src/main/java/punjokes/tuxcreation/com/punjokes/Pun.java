package punjokes.tuxcreation.com.punjokes;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Android on 11/15/15.
 */
public class Pun extends AppCompatActivity {

    private InterstitialAd interstitial;

    public static final String mPath = "body.txt";
    public static final String mBusinessPath = "business.txt";
    public static final String mCrimePath = "crime.txt";
    public static final String mEducationPath = "education.txt";
    public static final String mEntertaintmentPath = "entertainment.txt";
    public static final String mFoodPath = "food.txt";
    public static final String mHealthPath = "health.txt";
    public static final String mNaturePath = "nature.txt";
    public static final String mPeoplePath = "people.txt";
    public static final String mPlacesPath = "places.txt";
    public static final String mTechnologyPath = "technology.txt";
    public static final String mTransportationPath = "transportation.txt";
    public static final String mWorkPath = "work.txt";
    private QuoteBank mQuoteBank;
    private List<String> mLines;
    private int counter = 0;
    private static int SIZE = 24;
    private String favorites1[] = new String[SIZE];
    private String favorites2[] = new String[SIZE];
    private String favorites3[] = new String[SIZE];
    private String favorites4[] = new String[SIZE];
    private String favorites5[] = new String[SIZE];
    private String favorites6[] = new String[SIZE];
    private String favorites7[] = new String[SIZE];
    private String favorites8[] = new String[SIZE];
    private String favorites9[] = new String[SIZE];
    private String favorites10[] = new String[SIZE];
    private String favorites11[] = new String[SIZE];
    private String favorites12[] = new String[SIZE];
    private String favorites13[] = new String[SIZE];

    public MenuItem star;

    public static int i1, i2;

    private ShareActionProvider shareAction;

    private TextView textView;
    private boolean listedPuns[] = new boolean[SIZE];
    private ArrayList<Integer> punShuffle;
    private int counter2 = 0;
    private int counter3 = 0;
    boolean isFirstRun;

    private RatingBar ratingBar;
    SharedPreferences pref;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pun, menu);
        star = menu.findItem(R.id.action_favoritestar);

        if(!isFirstRun) {
            init();
        }

        MenuItem shareItem = menu.findItem(R.id.menu_item_share);

        shareAction = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(intent.EXTRA_TEXT, "\"" + mLines.get(i1) + "\"\n\nSent from Pun Jokes: Funny Puns by Tux Creation\nhttps://play.google.com/store/apps/details?id=punjokes.tuxstudios.com.punjokes&hl=en");

        shareAction.setShareIntent(intent);


        return true;
    }




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pun);

        Toolbar myToolbar3 = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar3);

        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();

        for (int i2 = 0; i2 < SIZE - 1; i2++) {
            listedPuns[i2] = false;
        }

        // Create the interstitial.
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId("ca-app-pub-5962251618264934/2852873803");

        interstitial.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });

        requestNewInterstitial();

        mQuoteBank = new QuoteBank(this);

        textView = (TextView) findViewById(R.id.textView);


        Random r = new Random();
        i1 = r.nextInt(SIZE);

        switch (MainActivity.category) {
            case "body":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mPath);


                break;
            case "business":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mBusinessPath);
                break;
            case "crime":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mCrimePath);
                break;
            case "education":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mEducationPath);
                break;
            case "entertainment":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mEntertaintmentPath);
                break;
            case "food":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mFoodPath);
                break;
            case "health":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mHealthPath);
                break;
            case "nature":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mNaturePath);
                break;
            case "people":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mPeoplePath);
                break;
            case "places":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mPlacesPath);
                break;
            case "technology":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mTechnologyPath);
                break;
            case "transportation":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mTransportationPath);
                break;
            case "work":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mWorkPath);
                break;
            default:
                break;
        }

        textView.setText(mLines.get(i1));

        favorites1 = new String[SIZE];
        favorites2 = new String[SIZE];
        favorites3 = new String[SIZE];
        favorites4 = new String[SIZE];
        favorites5 = new String[SIZE];
        favorites6 = new String[SIZE];
        favorites7 = new String[SIZE];
        favorites8 = new String[SIZE];
        favorites9 = new String[SIZE];
        favorites10 = new String[SIZE];
        favorites11 = new String[SIZE];
        favorites12 = new String[SIZE];
        favorites13 = new String[SIZE];

        // Save and Load array
        favorites1 = loadArray("favorites1", this);
        favorites2 = loadArray("favorites2", this);
        favorites3 = loadArray("favorites3", this);
        favorites4 = loadArray("favorites4", this);
        favorites5 = loadArray("favorites5", this);
        favorites6 = loadArray("favorites6", this);
        favorites7 = loadArray("favorites7", this);
        favorites8 = loadArray("favorites8", this);
        favorites9 = loadArray("favorites9", this);
        favorites10 = loadArray("favorites10", this);
        favorites11 = loadArray("favorites11", this);
        favorites12 = loadArray("favorites12", this);
        favorites13 = loadArray("favorites13", this);


        if(favorites1 == null || favorites1.length < SIZE){
            favorites1 = new String[SIZE];

            for(int i =0; i < SIZE; i++){
                favorites1[i] = "false";
            }
        }
        if(favorites2 == null || favorites2.length < SIZE){
            favorites2 = new String[SIZE];
            for(int i =0; i < SIZE; i++){
                favorites2[i] = "false";
            }
        }
        if(favorites3 == null || favorites3.length < SIZE){
            favorites3 = new String[SIZE];
            for(int i =0; i < SIZE; i++){
                favorites3[i] = "false";
            }
        }
        if(favorites4 == null || favorites4.length < SIZE){
            favorites4 = new String[SIZE];
            for(int i =0; i < SIZE; i++){
                favorites4[i] = "false";
            }
        }
        if(favorites5 == null || favorites5.length < SIZE){
            favorites5 = new String[SIZE];
            for(int i =0; i < SIZE; i++){
                favorites5[i] = "false";
            }
        }
        if(favorites6 == null || favorites6.length < SIZE){
            favorites6 = new String[SIZE];
            for(int i =0; i < SIZE; i++){
                favorites6[i] = "false";
            }
        }
        if(favorites7 == null || favorites7.length < SIZE){
            favorites7 = new String[SIZE];
            for(int i =0; i < SIZE; i++){
                favorites7[i] = "false";
            }

        }
        if(favorites8 == null || favorites8.length < SIZE){
            favorites8 = new String[SIZE];
            for(int i =0; i < SIZE; i++){
                favorites8[i] = "false";
            }
        }
        if(favorites9 == null || favorites9.length < SIZE){
            favorites9 = new String[SIZE];
            for(int i =0; i < SIZE; i++){
                favorites9[i] = "false";
            }
        }
        if(favorites10 == null || favorites10.length < SIZE){
            favorites10 = new String[SIZE];
            for(int i =0; i < SIZE; i++){
                favorites10[i] = "false";
            }
        }
        if(favorites11 == null || favorites11.length < SIZE){
            favorites11 = new String[SIZE];
            for(int i =0; i < SIZE; i++){
                favorites11[i] = "false";
            }

        }
        if(favorites12 == null || favorites12.length < SIZE){
            favorites12 = new String[SIZE];
            for(int i =0; i < SIZE; i++){
                favorites12[i] = "false";
            }
        }
        if(favorites13 == null || favorites13.length < SIZE){
            favorites13 = new String[SIZE];
            for(int i =0; i < SIZE; i++){
                favorites13[i] = "false";
            }

        }

        for(int i = 0; i < SIZE; i++){
            if(favorites1[i] == null || favorites1[i].isEmpty()){
                favorites1[i] = "false";
            }
            if(favorites2[i] == null || favorites2[i].isEmpty()){
                favorites2[i] = "false";
            }
            if(favorites3[i] == null || favorites3[i].isEmpty()){
                favorites3[i] = "false";
            }
            if(favorites4[i] == null || favorites4[i].isEmpty()){
                favorites4[i] = "false";
            }
            if(favorites5[i] == null || favorites5[i].isEmpty()){
                favorites5[i] = "false";
            }
            if(favorites6[i] == null || favorites6[i].isEmpty()){
                favorites6[i] = "false";
            }
            if(favorites7[i] == null || favorites7[i].isEmpty()){
                favorites7[i] = "false";
            }
            if(favorites8[i] == null || favorites8[i].isEmpty()){
                favorites8[i] = "false";
            }
            if(favorites9[i] == null || favorites9[i].isEmpty()){
                favorites9[i] = "false";
            }
            if(favorites10[i] == null || favorites10[i].isEmpty()){
                favorites10[i] = "false";
            }
            if(favorites11[i] == null || favorites11[i].isEmpty()){
                favorites11[i] = "false";
            }
            if(favorites12[i] == null || favorites12[i].isEmpty()){
                favorites12[i] = "false";
            }
            if(favorites13[i] == null || favorites1[i].isEmpty()){
                favorites13[i] = "false";
            }
        }




        final Button btn1 = (Button) findViewById(R.id.next);
        btn1.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        star.setIcon(R.drawable.starblank);

                                        i1 = randomExcluded();

                                        textView.setText(mLines.get(i1));
                                        invalidateOptionsMenu();
                                        counter++;

                                        counter3++;


                                        /*
                                        if (pref.getBoolean("unlocked", false) == false){
                                            if (counter == 4) {
                                                Random r2 = new Random();
                                                i2 = r2.nextInt(11) + 1;

                                                Log.d("i2", "" + i2);
                                                counter = 0;

                                                if (i2 > 5) {
                                                    if (interstitial.isLoaded())
                                                        interstitial.show();
                                                }
                                            }
                                        }*/

                                        if(counter3 == 10){
                                            Random r2 = new Random();
                                            i2 = r2.nextInt(11) + 1;

                                            counter = 0;

                                        }


                                        switch (MainActivity.category) {
                                            case "body":
                                                if(favorites1[i1] != null) {
                                                    if (favorites1[i1].equals("true")) {
                                                        star.setIcon(R.drawable.staryellow);
                                                    }
                                                    else {
                                                        star.setIcon(R.drawable.starblank);
                                                    }
                                                }else {
                                                    star.setIcon(R.drawable.starblank);
                                                }
                                                break;
                                            case "business":
                                                if(favorites2[i1] != null) {
                                                    if (favorites2[i1].equals("true")) {
                                                        star.setIcon(R.drawable.staryellow);
                                                    }
                                                    else {
                                                        star.setIcon(R.drawable.starblank);
                                                    }
                                                }else {
                                                    star.setIcon(R.drawable.starblank);
                                                }
                                                break;
                                            case "crime":
                                                if(favorites3[i1] != null) {
                                                    if (favorites3[i1].equals("true")) {
                                                        star.setIcon(R.drawable.staryellow);
                                                    }
                                                    else {
                                                        star.setIcon(R.drawable.starblank);
                                                    }
                                                }else {
                                                    star.setIcon(R.drawable.starblank);
                                                }
                                                break;
                                            case "education":
                                                if(favorites4[i1] != null) {
                                                    if (favorites4[i1].equals("true")) {
                                                        star.setIcon(R.drawable.staryellow);
                                                    }
                                                    else {
                                                        star.setIcon(R.drawable.starblank);
                                                    }
                                                }else {
                                                    star.setIcon(R.drawable.starblank);
                                                }
                                                break;
                                            case "entertainment":
                                                if(favorites5[i1] != null) {
                                                    if (favorites5[i1].equals("true")) {
                                                        star.setIcon(R.drawable.staryellow);
                                                    }
                                                    else {
                                                        star.setIcon(R.drawable.starblank);
                                                    }
                                                }else {
                                                    star.setIcon(R.drawable.starblank);
                                                }
                                                break;
                                            case "food":
                                                if(favorites6[i1] != null) {
                                                    if (favorites6[i1].equals("true")) {
                                                        star.setIcon(R.drawable.staryellow);
                                                    }
                                                    else {
                                                        star.setIcon(R.drawable.starblank);
                                                    }
                                                }else {
                                                    star.setIcon(R.drawable.starblank);
                                                }
                                                break;
                                            case "health":
                                                if(favorites7[i1] != null) {
                                                    if (favorites7[i1].equals("true")) {
                                                        star.setIcon(R.drawable.staryellow);
                                                    }
                                                    else {
                                                        star.setIcon(R.drawable.starblank);
                                                    }
                                                }else {
                                                    star.setIcon(R.drawable.starblank);
                                                }
                                                break;
                                            case "nature":
                                                if(favorites8[i1] != null) {
                                                    if (favorites8[i1].equals("true")) {
                                                        star.setIcon(R.drawable.staryellow);
                                                    }
                                                    else {
                                                        star.setIcon(R.drawable.starblank);
                                                    }
                                                }else {
                                                    star.setIcon(R.drawable.starblank);
                                                }
                                                break;
                                            case "people":
                                                if(favorites9[i1] != null) {
                                                    if (favorites9[i1].equals("true")) {
                                                        star.setIcon(R.drawable.staryellow);
                                                    }
                                                    else {
                                                        star.setIcon(R.drawable.starblank);
                                                    }
                                                }else {
                                                    star.setIcon(R.drawable.starblank);
                                                }
                                                break;
                                            case "places":
                                                if(favorites10[i1] != null) {
                                                    if (favorites10[i1].equals("true")) {
                                                        star.setIcon(R.drawable.staryellow);
                                                    }
                                                    else {
                                                        star.setIcon(R.drawable.starblank);
                                                    }
                                                }else {
                                                    star.setIcon(R.drawable.starblank);
                                                }
                                                break;
                                            case "technology":
                                                if(favorites11[i1] != null) {
                                                    if (favorites11[i1].equals("true")) {
                                                        star.setIcon(R.drawable.staryellow);
                                                    }
                                                    else {
                                                        star.setIcon(R.drawable.starblank);
                                                    }
                                                }else {
                                                    star.setIcon(R.drawable.starblank);
                                                }
                                                break;
                                            case "transportation":
                                                if(favorites12[i1] != null) {
                                                    if (favorites12[i1].equals("true")) {
                                                        star.setIcon(R.drawable.staryellow);
                                                    }
                                                    else {
                                                        star.setIcon(R.drawable.starblank);
                                                    }
                                                }else {
                                                    star.setIcon(R.drawable.starblank);
                                                }
                                                break;
                                            case "work":
                                                if(favorites13[i1] != null) {
                                                    if (favorites13[i1].equals("true")) {
                                                        star.setIcon(R.drawable.staryellow);
                                                    }
                                                    else {
                                                        star.setIcon(R.drawable.starblank);
                                                    }
                                                }else {
                                                    star.setIcon(R.drawable.starblank);
                                                }
                                                break;
                                            default:
                                                break;
                                        }

                                        saveArray(favorites1, "favorites1", Pun.this);
                                        saveArray(favorites2, "favorites2", Pun.this);
                                        saveArray(favorites3, "favorites3", Pun.this);
                                        saveArray(favorites4, "favorites4", Pun.this);
                                        saveArray(favorites5, "favorites5", Pun.this);
                                        saveArray(favorites6, "favorites6", Pun.this);
                                        saveArray(favorites7, "favorites7", Pun.this);
                                        saveArray(favorites8, "favorites8", Pun.this);
                                        saveArray(favorites9, "favorites9", Pun.this);
                                        saveArray(favorites10, "favorites10", Pun.this);
                                        saveArray(favorites11, "favorites11", Pun.this);
                                        saveArray(favorites12, "favorites12", Pun.this);
                                        saveArray(favorites13, "favorites13", Pun.this);
                                    }
                                }

        );


    }


    public boolean saveArray(String[] array, String arrayName, Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("preferencename", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(arrayName + "_size", array.length);
        for (int i = 0; i < array.length; i++)
            editor.putString(arrayName + "_" + i, array[i]);


        return editor.commit();
    }

    public String[] loadArray(String arrayName, Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("preferencename", 0);
        int size = prefs.getInt(arrayName + "_size", 0);
        String array[] = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = prefs.getString(arrayName + "_" + i, null);
            //if (array[i] == null)
        }
        return array;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.about:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                final Intent intent = new Intent(Pun.this, About.class);
                startActivity(intent);

                return true;


            case R.id.submit:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                final Intent intent1 = new Intent(Pun.this, Submit.class);
                startActivity(intent1);
                return true;

            case R.id.action_favorite:
                final Intent intent2 = new Intent(Pun.this, Favorites.class);
                startActivity(intent2);

                return true;

            case R.id.action_favoritestar:

                switch (MainActivity.category) {
                    case "body":
                        if(favorites1[i1] != null){
                            if (favorites1[i1].equals("true")) {
                                favorites1[i1] = "false";
                                star.setIcon(R.drawable.starblank);
                            }
                            else {
                                favorites1[i1] = "true";
                                star.setIcon(R.drawable.staryellow);
                            }
                        }
                        else {
                            favorites1[i1] = "true";
                            star.setIcon(R.drawable.staryellow);
                        }

                        Log.d("myTag", " " + favorites1[i1]);
                        break;
                    case "business":
                        if(favorites2[i1] != null){
                            if (favorites2[i1].equals("true")) {
                                favorites2[i1] = "false";
                                star.setIcon(R.drawable.starblank);
                            }
                            else {
                                favorites2[i1] = "true";
                                star.setIcon(R.drawable.staryellow);
                            }
                        }
                        else {
                            favorites2[i1] = "true";
                            star.setIcon(R.drawable.staryellow);
                        }

                        Log.d("myTag", " " + favorites2[i1]);
                        break;
                    case "crime":
                        if(favorites3[i1] != null){
                            if (favorites3[i1].equals("true")) {
                                favorites3[i1] = "false";
                                star.setIcon(R.drawable.starblank);
                            }
                            else {
                                favorites3[i1] = "true";
                                star.setIcon(R.drawable.staryellow);
                            }
                        }
                        else {
                            favorites3[i1] = "true";
                            star.setIcon(R.drawable.staryellow);
                        }
                        break;
                    case "education":
                        if(favorites4[i1] != null){
                            if (favorites4[i1].equals("true")) {
                                favorites4[i1] = "false";
                                star.setIcon(R.drawable.starblank);
                            }
                            else {
                                favorites4[i1] = "true";
                                star.setIcon(R.drawable.staryellow);
                            }
                        }
                        else {
                            favorites4[i1] = "true";
                            star.setIcon(R.drawable.staryellow);
                        }
                        break;
                    case "entertainment":
                        if(favorites5[i1] != null){
                            if (favorites5[i1].equals("true")) {
                                favorites5[i1] = "false";
                                star.setIcon(R.drawable.starblank);
                            }
                            else {
                                favorites5[i1] = "true";
                                star.setIcon(R.drawable.staryellow);
                            }
                        }
                        else {
                            favorites5[i1] = "true";
                            star.setIcon(R.drawable.staryellow);
                        }
                        break;
                    case "food":
                        if(favorites6[i1] != null){
                            if (favorites6[i1].equals("true")) {
                                favorites6[i1] = "false";
                                star.setIcon(R.drawable.starblank);
                            }
                            else {
                                favorites6[i1] = "true";
                                star.setIcon(R.drawable.staryellow);
                            }
                        }
                        else {
                            favorites6[i1] = "true";
                            star.setIcon(R.drawable.staryellow);
                        }
                        break;
                    case "health":
                        if(favorites7[i1] != null){
                            if (favorites7[i1].equals("true")) {
                                favorites7[i1] = "false";
                                star.setIcon(R.drawable.starblank);
                            }
                            else {
                                favorites7[i1] = "true";
                                star.setIcon(R.drawable.staryellow);
                            }
                        }
                        else {
                            favorites7[i1] = "true";
                            star.setIcon(R.drawable.staryellow);
                        }
                        break;
                    case "nature":
                        if(favorites8[i1] != null){
                            if (favorites8[i1].equals("true")) {
                                favorites8[i1] = "false";
                                star.setIcon(R.drawable.starblank);
                            }
                            else {
                                favorites8[i1] = "true";
                                star.setIcon(R.drawable.staryellow);
                            }
                        }
                        else {
                            favorites8[i1] = "true";
                            star.setIcon(R.drawable.staryellow);
                        }
                        break;
                    case "people":
                        if(favorites9[i1] != null){
                            if (favorites9[i1].equals("true")) {
                                favorites9[i1] = "false";
                                star.setIcon(R.drawable.starblank);
                            }
                            else {
                                favorites9[i1] = "true";
                                star.setIcon(R.drawable.staryellow);
                            }
                        }
                        else {
                            favorites9[i1] = "true";
                            star.setIcon(R.drawable.staryellow);
                        }
                        break;
                    case "places":
                        if(favorites10[i1] != null){
                            if (favorites10[i1].equals("true")) {
                                favorites10[i1] = "false";
                                star.setIcon(R.drawable.starblank);
                            }
                            else {
                                favorites10[i1] = "true";
                                star.setIcon(R.drawable.staryellow);
                            }
                        }
                        else {
                            favorites10[i1] = "true";
                            star.setIcon(R.drawable.staryellow);
                        }
                        break;
                    case "technology":
                        if(favorites11[i1] != null){
                            if (favorites11[i1].equals("true")) {
                                favorites11[i1] = "false";
                                star.setIcon(R.drawable.starblank);
                            }
                            else {
                                favorites11[i1] = "true";
                                star.setIcon(R.drawable.staryellow);
                            }
                        }
                        else {
                            favorites11[i1] = "true";
                            star.setIcon(R.drawable.staryellow);
                        }
                        break;
                    case "transportation":
                        if(favorites12[i1] != null){
                            if (favorites12[i1].equals("true")) {
                                favorites12[i1] = "false";
                                star.setIcon(R.drawable.starblank);
                            }
                            else {
                                favorites12[i1] = "true";
                                star.setIcon(R.drawable.staryellow);
                            }
                        }
                        else {
                            favorites12[i1] = "true";
                            star.setIcon(R.drawable.staryellow);
                        }
                        break;
                    case "work":
                        if(favorites13[i1] != null){
                            if (favorites13[i1].equals("true")) {
                                favorites13[i1] = "false";
                                star.setIcon(R.drawable.starblank);
                            }
                            else {
                                favorites13[i1] = "true";
                                star.setIcon(R.drawable.staryellow);
                            }
                        }
                        else {
                            favorites13[i1] = "true";
                            star.setIcon(R.drawable.staryellow);
                        }
                        break;
                    default:
                        break;



                }


                saveArray(favorites1, "favorites1", Pun.this);
                saveArray(favorites2, "favorites2", Pun.this);
                saveArray(favorites3, "favorites3", Pun.this);
                saveArray(favorites4, "favorites4", Pun.this);
                saveArray(favorites5, "favorites5", Pun.this);
                saveArray(favorites6, "favorites6", Pun.this);
                saveArray(favorites7, "favorites7", Pun.this);
                saveArray(favorites8, "favorites8", Pun.this);
                saveArray(favorites9, "favorites9", Pun.this);
                saveArray(favorites10, "favorites10", Pun.this);
                saveArray(favorites11, "favorites12", Pun.this);
                saveArray(favorites12, "favorites13", Pun.this);
                saveArray(favorites13, "favorites13", Pun.this);

                return true;

            case R.id.menu_item_share:


                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void init() {
        Log.d("myTag", " " + i1);



        switch (MainActivity.category) {
            case "body":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mPath);

                if(favorites1 != null && favorites1.length == SIZE) {
                    if (favorites1[i1].equals("true"))
                        star.setIcon(R.drawable.staryellow);
                }
                break;
            case "business":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mBusinessPath);
                if(favorites2 != null && favorites2.length == SIZE) {
                    if (favorites2[i1].equals("true"))
                        star.setIcon(R.drawable.staryellow);

                }
                break;
            case "crime":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mCrimePath);
                if(favorites3 != null && favorites3.length == SIZE) {
                    if (favorites3[i1].equals("true"))
                        star.setIcon(R.drawable.staryellow);
                    break;
                }
            case "education":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mEducationPath);
                if(favorites4 != null && favorites4.length == SIZE) {
                    if (favorites4[i1].equals("true"))
                        star.setIcon(R.drawable.staryellow);

                }
                break;
            case "entertainment":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mEntertaintmentPath);
                if(favorites5 != null && favorites5.length == SIZE) {
                    if (favorites5[i1].equals("true"))
                        star.setIcon(R.drawable.staryellow);

                }
                break;
            case "food":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mFoodPath);
                if(favorites6 != null && favorites6.length == SIZE) {
                    if (favorites6[i1].equals("true"))
                        star.setIcon(R.drawable.staryellow);

                }
                break;
            case "health":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mHealthPath);
                if(favorites7 != null && favorites7.length == SIZE) {
                    if (favorites7[i1].equals("true"))
                        star.setIcon(R.drawable.staryellow);
                }
                break;
            case "nature":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mNaturePath);
                if(favorites8 != null && favorites8.length == SIZE) {
                    if (favorites8[i1].equals("true"))
                        star.setIcon(R.drawable.staryellow);
                }
                break;
            case "people":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mPeoplePath);
                if(favorites9 != null && favorites9.length == SIZE) {
                    if (favorites9[i1].equals("true"))
                        star.setIcon(R.drawable.staryellow);
                }
                break;
            case "places":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mPlacesPath);
                if(favorites10 != null && favorites10.length == SIZE) {
                    if (favorites10[i1].equals("true"))
                        star.setIcon(R.drawable.staryellow);
                }
                break;
            case "technology":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mTechnologyPath);
                if(favorites11 != null && favorites11.length == SIZE) {
                    if (favorites11[i1].equals("true"))
                        star.setIcon(R.drawable.staryellow);
                }
                break;
            case "transportation":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mTransportationPath);
                if(favorites12 != null && favorites12.length == SIZE) {
                    if (favorites12[i1].equals("true"))
                        star.setIcon(R.drawable.staryellow);
                }
                break;
            case "work":
                mQuoteBank = new QuoteBank(this);
                mLines = mQuoteBank.readLine(mWorkPath);
                if(favorites13 != null && favorites13.length == SIZE) {
                    if (favorites13[i1].equals("true"))
                        star.setIcon(R.drawable.staryellow);

                }
                break;
            default:
                break;
        }
    }

    public int randomExcluded() {
        if(counter2 == 0){
            counter2++;
            punShuffle = new ArrayList<>();
            for (int i = 1; i <= SIZE; ++i) punShuffle.add(i);
            Collections.shuffle(punShuffle);
        }else if(counter2 == SIZE-1) {
            counter2 = 0;
        } else{
            counter2++;
        }

        Log.d("counter", "" + counter2);

        return punShuffle.get(counter2) - 1;

    }

    public void alertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(
                Pun.this);
        builder.setTitle("Remove Ads");
        builder.setMessage("Upgrade to premium version to remove ads?");
        builder.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        //Toast.makeText(getApplicationContext(),"No is clicked",Toast.LENGTH_LONG).show();
                    }
                });
        builder.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        //Toast.makeText(getApplicationContext(),"Yes is clicked",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=punjokes.tuxstudios.com.punjokespremium&hl=en"));
                        startActivity(intent);
                    }
                });
        builder.show();
    }



    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();

        interstitial.loadAd(adRequest);
    }


}
