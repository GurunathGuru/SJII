package com.integro.sjii;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.messaging.FirebaseMessaging;
import com.integro.sjii.adapter.SlideAdapter;
import com.integro.sjii.firebase.MyFirebaseMessagingService;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Intent intent;
    Intent intent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(getApplicationContext(), NotificationActivity.class);
        intent1 = new Intent(getApplicationContext(), PrincipalMsgActivity.class);

        FirebaseMessaging.getInstance().subscribeToTopic("sjii");

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new SlideAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.news2);
        tabLayout.getTabAt(2).setIcon(R.drawable.notifications);
        tabLayout.getTabAt(3).setIcon(R.drawable.web2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        @SuppressLint("CutPasteId")
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final int color = ContextCompat.getColor(getApplicationContext(), R.color.colorWhite);
        final int color3 = ContextCompat.getColor(getApplicationContext(), R.color.colorOrange);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(color3, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(color, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void getRectorMessage(View view) {
        intent1.putExtra("tag", "Rector");
        startActivity(intent1);
    }

    public void getDirectorMessage(View view) {
        intent1.putExtra("tag", "Principal");
        startActivity(intent1);
    }

    public void getFinanceMessage(View view) {
        intent1.putExtra("tag", "Finance Officer");
        startActivity(intent1);
    }

    public void getEvents(View view) {
        Toast.makeText(getApplicationContext(), "coming soon", Toast.LENGTH_SHORT).show();
    }

    public void getNewsLetter(View view) {
        Intent intent = new Intent(getApplicationContext(), NewsLetterActivity.class);
        startActivity(intent);
    }

    public void getAnnouncements(View view) {
        Intent intent = new Intent(getApplicationContext(), AnnouncementsActivity.class);
        startActivity(intent);
    }

    public void getFacilities(View view) {
        Intent intent = new Intent(getApplicationContext(), FacilitiesActivity.class);
        startActivity(intent);
    }

    public void getInstitutions(View view) {
        Intent intent = new Intent(getApplicationContext(), InstitutionActivity.class);
        startActivity(intent);
    }

    public void getAlumni(View view) {
        Intent intent = new Intent(getApplicationContext(), AlumniActivity.class);
        startActivity(intent);
    }

    public void getPTA(View view) {
        Intent intent = new Intent(getApplicationContext(), SjiiPTAActivity.class);
        startActivity(intent);
    }

    public void aboutUs(View view) {
        Intent intent = new Intent(getApplicationContext(), AboutUsActivity.class);
        startActivity(intent);
    }

    public void visionAndMission(View view) {
        Intent intent = new Intent(getApplicationContext(), VisionActivity.class);
        startActivity(intent);
    }

    public void faculty(View view) {
        Intent intent = new Intent(getApplicationContext(), FacultyActivity.class);
        startActivity(intent);
    }

    public void management(View view) {
        Intent intent = new Intent(getApplicationContext(), ManagementActivity.class);
        startActivity(intent);
    }

    public void videos(View view) {
        Toast.makeText(getApplicationContext(), "coming soon", Toast.LENGTH_SHORT).show();
    }


    public void sendEmail(View view) {
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("mailto:?subject=" + " " + "&body=" + " " + "&to=" + "info@sjcc.edu.in");
        testIntent.setData(data);
        startActivity(testIntent);
    }

    public void getLogin(View view) {
        String url = "https://sjii.pupilpod.in/";
        Intent intent = new Intent(getApplicationContext(), WebActivity.class);
        intent.putExtra("TAG", url);
        startActivity(intent);
    }

    public void getE_Learning(View view) {
        String url = "https://sjihsbangalore.com/login.php";
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(getResources().getColor(R.color.colorBlue));
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }

    public void address(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Address");
        AlertDialog.Builder builder = alertDialogBuilder.setMessage("St. Joseph’s Indian High School\n 23, Vittal Mallya Road,\nBangalore – 560 001").setCancelable(false)
                .setPositiveButton("Go to Map", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String url = "https://www.google.com/maps/dir//12.96888,77.5948954/@12.96888,77.594895,9z?hl=en-US";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void getDial(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        final CharSequence[] phone = new CharSequence[]{"+91080 2229 2622", "+91 080 2222 9052","+91 080 4097 7838", "+91 080 4101 0013"};
        final CharSequence[] optionsChosen = phone;
        builder.setItems(optionsChosen, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (optionsChosen[item].equals("+91 080 2229 2622")) {
                    String phone = "+91 080 2229 2622";
                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                    startActivity(callIntent);

                } else if (optionsChosen[item].equals("+91 080 2222 9052  ")) {
                    String phone = "+91 080 2222 9052  ";
                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                    startActivity(callIntent);

                } else if (optionsChosen[item].equals("+91 080 4097 7838")) {
                    String phone = "+91 080 4097 7838";
                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                    startActivity(callIntent);

                } else if (optionsChosen[item].equals("+91 080 4101 0013")) {
                    String phone = "+91 080 4101 0013";
                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                    startActivity(callIntent);
                }
            }
        });
        builder.show();
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Exit");
        AlertDialog.Builder builder = alertDialogBuilder.setMessage("Do you really want to exit?").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        System.exit(0);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}