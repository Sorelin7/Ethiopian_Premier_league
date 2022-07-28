package com.group_d.ethiopianpremierleague;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.group_d.ethiopianpremierleague.databinding.ActivityNavigationBinding;

public class Navigation extends Drawerbaseactivity {
    ActivityNavigationBinding activityNavigationBinding;
    private  long backpressbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityNavigationBinding= ActivityNavigationBinding.inflate(getLayoutInflater());
        allocateactivitytitle("Home");
        setContentView(activityNavigationBinding.getRoot());
        String[] disc={"Gambella, Ethiopia – The 30,000 seater Gambella Stadium construction project is nearing completion. The state of the art international grade stadium, saw its blueprints made public only last October, but the progress in the construction is such that the Ethiopian Football Federation president Junedine Bashah, boldly declared on his Twitter account that the stadium would be completed by the end of the year.",
                "Bahir Dar Stadium is a multi-purpose stadium in Bahir Dar, Ethiopia. It is used mostly for football matches although it also has athletics facilities. The stadium has a capacity of 60,000 people. Currently, the stadium is the largest in the country by capacity.HistoryThe construction of Bahir Dar Stadium was started in 2008 by MIDROC Ethiopia. In 2015, the stadium received recognition from CAF and FIFA and hosted its first international matches.In March 2015,Bahir Dar Stadium is a multi-purpose stadium in Bahir Dar, Ethiopia. It is used mostly for football matches although it also has athletics facilities. The stadium has a capacity of 60,000 people. Currently, the stadium is the largest in the country by capacity.HistoryThe construction of Bahir Dar Stadium was started in 2008 by MIDROC Ethiopia. In 2015, the stadium received recognition from CAF and FIFA and hosted its first international matches.In March 2015",
                "National stadium for Ethiopia is to be built mostly on and with excavated land. Will be partially covered and equipped with running track to be able to host large scale athletics events, excluding only the Olympic.\n" +
                        "\n" +
                        "Apart from the central stadium a secondary one is to be built along with indoor and outdoor natatoriums and sports halls. Then comes the new building of the Federal Sports Commission. All buildings will get connected by a central plaza with shade and fountains. Overall, the complex is to cover 60 hectares."};
        int[] im={R.drawable.gambelastadium,R.drawable.bada_stadium,R.drawable.addisa};
        Grid_adapter grid_adapter= new Grid_adapter(Navigation.this,disc,im);
        activityNavigationBinding.gridview.setAdapter(grid_adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.rightmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        if(id==R.id.smenuexit)
        {

            AlertDialog.Builder builder =new AlertDialog.Builder(Navigation.this);
            builder.setMessage("Do you want to exit? ");
            builder.setCancelable(true);
            builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setPositiveButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog alertDialog= builder.create();
            alertDialog.show();
        }
        if(id==R.id.share_menu){
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Check out this cool application");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Your application link here");
            startActivity(Intent.createChooser(sharingIntent, "Share Via"));
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (backpressbtn + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        }
        else
        {
            Toast.makeText(getBaseContext(),"Press back again to exit!", Toast.LENGTH_SHORT).show();
        }
        backpressbtn=System.currentTimeMillis();
    }
}