package punjokes.tuxcreation.com.punjokes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

/**
 * Created by brandon on 11/30/15.
 */


public class Favorites extends AppCompatActivity {

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

    TextView textView;

    private QuoteBank mQuoteBank;
    private List<String> mLines, mLines2, mLines3,mLines4,mLines5,mLines6,mLines7,
    mLines8,mLines9,mLines10,mLines11,mLines12,mLines13;

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

    boolean isFirstRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorites);

        Toolbar myToolbar2 = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar2);

        getSupportActionBar().setTitle("Pun Jokes: Favorites");

        textView = (TextView) findViewById(R.id.textView);

        mQuoteBank = new QuoteBank(this);

        final TextView textView = (TextView) findViewById(R.id.textView);

        mQuoteBank = new QuoteBank(this);
        mLines = mQuoteBank.readLine(mPath);

        mQuoteBank = new QuoteBank(this);
        mLines2 = mQuoteBank.readLine(mBusinessPath);

        mQuoteBank = new QuoteBank(this);
        mLines3 = mQuoteBank.readLine(mCrimePath);

        mQuoteBank = new QuoteBank(this);
        mLines4 = mQuoteBank.readLine(mEducationPath);

        mQuoteBank = new QuoteBank(this);
        mLines5 = mQuoteBank.readLine(mEntertaintmentPath);

        mQuoteBank = new QuoteBank(this);
        mLines6 = mQuoteBank.readLine(mFoodPath);

        mQuoteBank = new QuoteBank(this);
        mLines7 = mQuoteBank.readLine(mHealthPath);

        mQuoteBank = new QuoteBank(this);
        mLines8 = mQuoteBank.readLine(mNaturePath);

        mQuoteBank = new QuoteBank(this);
        mLines9 = mQuoteBank.readLine(mPeoplePath);

        mQuoteBank = new QuoteBank(this);
        mLines10 = mQuoteBank.readLine(mPlacesPath);

        mQuoteBank = new QuoteBank(this);
        mLines11 = mQuoteBank.readLine(mTechnologyPath );

        mQuoteBank = new QuoteBank(this);
        mLines12 = mQuoteBank.readLine(mTransportationPath );

        mQuoteBank = new QuoteBank(this);
        mLines13 = mQuoteBank.readLine(mWorkPath);

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





        textView.setText("");

        textView.append("\nHUMAN BODY: \n");
        for(int i = 0; i<SIZE; i++) {

            if(favorites1[i] != null) {
                if (favorites1[i].equals("true"))
                    textView.append("\"" + mLines.get(i) + "\"" + "\n\n");
            }

        }

        textView.append("\nBUSINESS: \n");
        for(int i = 0; i<SIZE; i++) {

            if(favorites2[i] != null) {
                if (favorites2[i].equals("true"))
                    textView.append("\"" + mLines2.get(i) + "\"" + "\n\n");
            }

        }

        textView.append("\nCRIME: \n");
        for(int i = 0; i<SIZE; i++) {

            if(favorites3[i] != null) {
                if (favorites3[i].equals("true"))
                    textView.append("\"" + mLines3.get(i) + "\"" + "\n\n");
            }

        }

        textView.append("\nEDUCATION: \n");
        for(int i = 0; i<SIZE; i++) {

            if(favorites4[i] != null) {
                if (favorites4[i].equals("true"))
                    textView.append("\"" + mLines4.get(i) + "\"" + "\n\n");
            }

        }

        textView.append("\nENTERTAINMENT: \n");
        for(int i = 0; i<SIZE; i++) {

            if(favorites5[i] != null) {
                if (favorites5[i].equals("true"))
                    textView.append("\"" + mLines5.get(i) + "\"" + "\n\n");
            }

        }

        textView.append("\nFOOD: \n");
        for(int i = 0; i<SIZE; i++) {

            if(favorites6[i] != null) {
                if (favorites6[i].equals("true"))
                    textView.append("\"" + mLines6.get(i) + "\"" + "\n\n");
            }

        }

        textView.append("\nHEALTH: \n");
        for(int i = 0; i<SIZE; i++) {

            if(favorites7[i] != null) {
                if (favorites7[i].equals("true"))
                    textView.append("\"" + mLines7.get(i) + "\"" + "\n\n");
            }

        }

        textView.append("\nNATURE: \n");
        for(int i = 0; i<SIZE; i++) {

            if(favorites8[i] != null) {
                if (favorites8[i].equals("true"))
                    textView.append("\"" + mLines8.get(i) + "\"" + "\n\n");
            }

        }

        textView.append("\nPEOPLE: \n");
        for(int i = 0; i<SIZE; i++) {

            if(favorites9[i] != null) {
                if (favorites9[i].equals("true"))
                    textView.append("\"" + mLines9.get(i) + "\"" + "\n\n");
            }

        }

        textView.append("\nPLACES: \n");
        for(int i = 0; i<SIZE; i++) {
            if(favorites10[i] != null) {
                if (favorites10[i].equals("true"))
                    textView.append("\"" + mLines10.get(i) + "\"" + "\n\n");
            }

        }

        textView.append("\nTECHNOLOGY: \n");
        for(int i = 0; i<SIZE; i++) {

            if(favorites11[i] != null) {
                if (favorites11[i].equals("true"))
                    textView.append("\"" + mLines11.get(i) + "\"" + "\n\n");
            }

        }

        textView.append("\nTRANSPORTATION: \n");
        for(int i = 0; i<SIZE; i++) {

            if(favorites12[i] != null) {
                if (favorites12[i].equals("true"))
                    textView.append("\"" + mLines12.get(i) + "\"" + "\n\n");
            }

        }

        textView.append("\nWORK: \n");
        for(int i = 0; i<SIZE; i++) {

            if(favorites13[i] != null) {
                if (favorites13[i].equals("true"))
                    textView.append("\"" + mLines13.get(i) + "\"" + "\n\n");
            }

        }

    }

    public String[] loadArray(String arrayName, Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("preferencename", 0);
        int size = prefs.getInt(arrayName + "_size", 0);
        String array[] = new String[size];
        for(int i=0;i<size;i++)
            array[i] = prefs.getString(arrayName + "_" + i, "false");
        return array;
    }

    public boolean saveArray(String[] array, String arrayName, Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("preferencename", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(arrayName + "_size", array.length);
        for (int i = 0; i < array.length; i++)
            editor.putString(arrayName + "_" + i, array[i]);


        return editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.about:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                final Intent intent = new Intent(Favorites.this, About.class);
                startActivity(intent);

                return true;

            case R.id.submit:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                final Intent intent1 = new Intent(Favorites.this, Submit.class);
                startActivity(intent1);
                return true;

            case R.id.action_favorite:
                final Intent intent2 = new Intent(Favorites.this, Favorites.class);
                startActivity(intent2);

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}
