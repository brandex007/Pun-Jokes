package punjokes.tuxcreation.com.punjokes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

//import com.google.android.gms.plus.PlusOneButton;

/**
 * Created by Android on 11/17/15.
 */
public class About extends AppCompatActivity {
    Button btn1, btn2;
    //PlusOneButton mPlusOneButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        Toolbar myToolbar2 = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar2);

        getSupportActionBar().setTitle("Pun Jokes: About");

        //mPlusOneButton = (PlusOneButton) findViewById(R.id.plus_one_button);

        btn1 = (Button) findViewById(R.id.reviewbtn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=punjokes.tuxcreation.com.punjokes2"));
                startActivity(intent);
            }
        });

        btn2 = (Button) findViewById(R.id.privacypolicy);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://androidprivacypolicy.bitballoon.com"));
                startActivity(intent);
            }
        });
    }

    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;

    protected void onResume() {
        super.onResume();
        // Refresh the state of the +1 button each time the activity receives focus.
        //mPlusOneButton.initialize("https://play.google.com/store/apps/details?id=punjokes.tuxcreations.com.punjokes", PLUS_ONE_REQUEST_CODE);
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
                return true;

            case R.id.submit:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                final Intent intent1 = new Intent(About.this, Submit.class);
                startActivity(intent1);
                return true;

            case R.id.action_favorite:
                final Intent intent2 = new Intent(About.this, Favorites.class);
                startActivity(intent2);

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


}
