package matriks.keepactivities;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
Button Check;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button Check=(Button) findViewById(R.id.Check);

        assert Check != null;
        Check.setOnClickListener(new View.OnClickListener() {
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onClick(View v) {
        boolean enabled;

        if (Build.VERSION.SDK_INT >= 17)
        {
            enabled = Settings.System.getInt(getContentResolver(), Settings.System.ALWAYS_FINISH_ACTIVITIES, 0) == 1;
            if(enabled==true){
            Toast.makeText(
                    getBaseContext(),
                    "Open",
                    Toast.LENGTH_SHORT).show();}//if
            else
            {
                Toast.makeText(
                        getBaseContext(),
                        "Close",
                        Toast.LENGTH_SHORT).show();
            }//else
        }

        else {
            enabled = Settings.Global.getInt(getContentResolver(), Settings.Global.ALWAYS_FINISH_ACTIVITIES, 0) == 1;
        }
    }
});




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
