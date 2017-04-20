package punjokes.tuxcreation.com.punjokes;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


/**
 * Created by brandon on 4/26/16.
 */
public class Submit extends AppCompatActivity {
    Button btn1;
    //PlusOneButton mPlusOneButton;
    String name;
    String pun;
    GMailSender sender;
    String message;
    private InterstitialAd interstitial2;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit);

        final Context context = getApplicationContext();
        final CharSequence text = "Thanks!";
        final int duration = Toast.LENGTH_SHORT;


        // Create the interstitial.
        interstitial2 = new InterstitialAd(this);
        interstitial2.setAdUnitId("ca-app-pub-5962251618264934/2852873803");

        interstitial2.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });

        requestNewInterstitial();


        Toolbar myToolbar2 = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar2);

        getSupportActionBar().setTitle("Pun Jokes: Submit a Pun");


        final EditText editText1 = (EditText) findViewById(R.id.editText1);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);

        sender = new GMailSender("punjokessender@gmail.com", "punjokes1");

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.
                Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);


        btn1 = (Button) findViewById(R.id.submitBtn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pun = editText1.getText().toString();
                name = editText2.getText().toString();
                Log.d("my tags", name + "\n" + pun);

                try {
                    new MyAsyncClass().execute();

                   if (interstitial2.isLoaded())
                        interstitial2.show();

                        submitEnded();

                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), ex.toString(), 100).show();
                }


            }
        });
    }

    public void submitEnded(){
        Toast.makeText(getApplicationContext(), "Thanks!", 100).show();
        final Intent intent3 = new Intent(Submit.this, MainActivity.class);
        startActivity(intent3);
    }

    class MyAsyncClass extends AsyncTask<Void, Void, Void> {

        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(Submit.this);
            pDialog.setMessage("Please wait...");
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... mApi) {
            try {
                // Add subject, Body, your mail Id, and receiver mail Id.
                message = pun + "          - " + name;
                sender.sendMail("Pun Submission", message, "punjokessender@gmail.com", "tuxcreations7777@gmail.com");



            }

            catch (Exception ex) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            pDialog.cancel();
        }
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
                final Intent intent = new Intent(Submit.this, About.class);
                startActivity(intent);

                return true;

            case R.id.submit:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...

                return true;

            case R.id.action_favorite:
                final Intent intent2 = new Intent(Submit.this, Favorites.class);
                startActivity(intent2);

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();

        interstitial2.loadAd(adRequest);
    }



}
