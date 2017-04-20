package punjokes.tuxcreation.com.punjokes;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public Toolbar myToolbar;
    public static String category = "";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //AppRater.app_launched(this);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();

        Random r = new Random();
        int i1 = r.nextInt(3 - 1) + 1;


        /*
        if(pref.getBoolean("unlocked", false) == false) {
            if (i1 == 3) {
                new AlertDialog.Builder(this)
                        .setTitle("Leave Review?")
                        .setMessage("Leave review to remove ads?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                                editor.putBoolean("unlocked", true);
                                editor.commit();
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=punjokes.tuxcreation.com.punjokes2&hl=en")));
                            }
                        })
                        .setNegativeButton("Not right now", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .show();

            }
        }*/

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        final Button btn1 = (Button) findViewById(R.id.angry_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity.this, Pun.class);
                MainActivity.category = "body";
                startActivity(intent);
            }
        });

        final Button btn2 = (Button) findViewById(R.id.angry_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final Intent intent = new Intent(MainActivity.this, Pun.class);
                MainActivity.category = "business";
                startActivity(intent);

            }
        });
        final Button btn3 = (Button) findViewById(R.id.angry_btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity.this, Pun.class);
                MainActivity.category = "crime";
                startActivity(intent);

            }
        });
        final Button btn4 = (Button) findViewById(R.id.angry_btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity.this, Pun.class);
                MainActivity.category = "education";
                startActivity(intent);


            }
        });
        final Button btn5 = (Button) findViewById(R.id.angry_btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity.this, Pun.class);
                MainActivity.category = "entertainment";
                startActivity(intent);


            }
        });
        final Button btn6 = (Button) findViewById(R.id.angry_btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity.this, Pun.class);
                MainActivity.category = "food";
                startActivity(intent);


            }
        });
        final Button btn7 = (Button) findViewById(R.id.angry_btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity.this, Pun.class);
                MainActivity.category = "health";
                startActivity(intent);


            }
        });
        final Button btn8 = (Button) findViewById(R.id.angry_btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity.this, Pun.class);
                MainActivity.category = "nature";
                startActivity(intent);

            }
        });
        final Button btn9 = (Button) findViewById(R.id.angry_btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity.this, Pun.class);
                MainActivity.category = "people";
                startActivity(intent);


            }
        });
        final Button btn10 = (Button) findViewById(R.id.angry_btn10);
        btn10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity.this, Pun.class);
                MainActivity.category = "places";
                startActivity(intent);


            }
        });
        final Button btn11 = (Button) findViewById(R.id.angry_btn11);
        btn11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity.this, Pun.class);
                MainActivity.category = "technology";
                startActivity(intent);


            }
        });
        final Button btn12 = (Button) findViewById(R.id.angry_btn12);
        btn12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity.this, Pun.class);
                MainActivity.category = "transportation";
                startActivity(intent);


            }
        });
        final Button btn13 = (Button) findViewById(R.id.angry_btn13);
        btn13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity.this, Pun.class);
                MainActivity.category = "work";
                startActivity(intent);


            }
        });


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
                final Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);

                return true;

            case R.id.submit:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                final Intent intent1 = new Intent(MainActivity.this, Submit.class);
                startActivity(intent1);
                return true;

            case R.id.action_favorite:
                final Intent intent2 = new Intent(MainActivity.this, Favorites.class);
                startActivity(intent2);

            return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


}
