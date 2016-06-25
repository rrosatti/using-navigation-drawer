package com.example.rodri.usingnavigationdrawer.ui.activity;

import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.rodri.usingnavigationdrawer.R;
import com.example.rodri.usingnavigationdrawer.model.DrawerItem;
import com.example.rodri.usingnavigationdrawer.ui.adapter.DrawerItemAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ListView drawerListView;
    private ActionBarDrawerToggle drawerToggle;

    private CharSequence drawerTitle;
    private CharSequence title;

    private String[] menuTitles;
    private TypedArray menuIcons;

    private ArrayList<DrawerItem> drawerItems;
    private DrawerItemAdapter drawerItemAdapter;

    @SuppressWarnings("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        // Home
        drawerItems.add(new DrawerItem(menuTitles[0], menuIcons.getResourceId(0, -1)));
        // Find People
        drawerItems.add(new DrawerItem(menuTitles[1], menuIcons.getResourceId(1, -1)));
        // Photos
        drawerItems.add(new DrawerItem(menuTitles[2], menuIcons.getResourceId(2, -1)));
        // Communities
        drawerItems.add(new DrawerItem(menuTitles[3], menuIcons.getResourceId(3, -1), "22", true));
        // Pages
        drawerItems.add(new DrawerItem(menuTitles[4], menuIcons.getResourceId(4, -1)));
        // What's Hot
        drawerItems.add(new DrawerItem(menuTitles[5], menuIcons.getResourceId(5, -1), "50+", true));

        menuIcons.recycle();

        drawerItemAdapter = new DrawerItemAdapter(this, 0, drawerItems);
        drawerListView.setAdapter(drawerItemAdapter);

        // Enable Action Bar and making it behave as a Toggle Button
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        // This is just a test
        Toolbar toolbar = new Toolbar(this);
        toolbar.setLogo(R.drawable.ic_drawer);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, //menu toggle icon
                R.string.app_name, // drawer open
                R.string.app_name) { // drawer close


                public void onDrawerClosed(View view) {
                    getActionBar().setTitle(title);
                    // call onPreparedOptionsMenu() to show action bar icons
                    invalidateOptionsMenu();
                }

                public void onDrawerOpened(View drawerView) {
                    getActionBar().setTitle(drawerTitle);
                    // call onPreparedOptionsMenu() to hide action bar icons
                    invalidateOptionsMenu();
                }
        };
        drawerLayout.setDrawerListener(drawerToggle);

        if (savedInstanceState == null) {
            displayView(0);
        }

    }

    public void initialize() {
        drawerTitle = title = getTitle();
        menuTitles = getResources().getStringArray(R.array.nav_drawer_items);
        menuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerListView = (ListView) findViewById(R.id.sliderMenuListView);

        drawerItems = new ArrayList<>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if the drawer is opened, hide the action items
        boolean drawerOpen = drawerLayout.isDrawerOpen(drawerListView);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void setTitle(CharSequence title) {
        this.title = title;
        getActionBar().setTitle(title);
    }

    /**
     * It must be called during the onPostCreate() and onConfigurationChanged(), when using the ActionBarDrawerToggle
     *
     * @param savedInstanceState
     */
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState occurred
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggle
        drawerToggle.onConfigurationChanged(newConfig);
    }
}
