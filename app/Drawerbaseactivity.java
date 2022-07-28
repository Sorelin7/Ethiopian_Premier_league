package com.group_d.ethiopianpremierleague;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;


public class Drawerbaseactivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
 DrawerLayout drawerLayout;
    SharedPrefs sharedPreferences;

    @Override
    protected void attachBaseContext(Context newBase) {
        sharedPreferences = new SharedPrefs(newBase);
        String languageCode = sharedPreferences.getLocale();
        Context context = LanguageConfig.changeLanguage(newBase, languageCode);
        super.attachBaseContext(context);
    }

    @Override
    public void setContentView(View view) {
        drawerLayout=(DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawerbaseactivity,null);
        FrameLayout container= drawerLayout.findViewById(R.id.activitycontainer);
        container.addView(view);
                super.setContentView(drawerLayout);
        Toolbar toolbar= drawerLayout.findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        NavigationView navigationView=drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.menu_drawer_open,R.string.menu_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
   drawerLayout.closeDrawer(GravityCompat.START);
        switch(item.getItemId()){
            case R.id.affanoro:
                if (sharedPreferences.getLocale() == "en") {
                    sharedPreferences.setLocale("om");
                }
                else if(sharedPreferences.getLocale() == "am") {
                    sharedPreferences.setLocale("om");
                }
                else {
                    sharedPreferences.setLocale("om");
                }
               recreate();
                break;
            case R.id.affanam:
                if (sharedPreferences.getLocale() == "en") {
                    sharedPreferences.setLocale("am");
                }
                else if(sharedPreferences.getLocale() == "or") {
                    sharedPreferences.setLocale("am");
                }
                else {
                    sharedPreferences.setLocale("am");
                }
                recreate();

                break;
            case R.id.english:
                if (sharedPreferences.getLocale() == "om") {
                    sharedPreferences.setLocale("en");
                }
                else if(sharedPreferences.getLocale() == "am") {
                    sharedPreferences.setLocale("en");
                }
                else {
                    sharedPreferences.setLocale("en");
                }
            recreate();
                break;

//                startActivity( new Intent(this , Navigation.class));
//                overridePendingTransition(0,0);
//                break;
            case R.id.smenuhome:
                startActivity( new Intent(this , Navigation.class));
                overridePendingTransition(0,0);
                break;
            case R.id.steam:
                startActivity( new Intent(this , Team.class));
                overridePendingTransition(0,0);
                break;
            case R.id.smatches:
                startActivity( new Intent(this ,Matches.class));
                overridePendingTransition(0,0);
                break;
            case R.id.smenuexit:
                int id =item.getItemId();
                if(id==R.id.smenuexit)
                {
                    AlertDialog.Builder builder =new AlertDialog.Builder(Drawerbaseactivity.this);
                    builder.setMessage("Do you want to exit?");
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
                break;
            case R.id.Youtube:
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(intent);
            break;


        }

        return false;
    }
    protected void allocateactivitytitle(String titlestring)
    {
       if(getSupportActionBar() != null)
       {
           getSupportActionBar().setTitle(titlestring);
       }
    }
}