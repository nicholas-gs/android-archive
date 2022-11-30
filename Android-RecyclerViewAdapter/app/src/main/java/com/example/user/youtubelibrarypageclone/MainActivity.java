package com.example.user.youtubelibrarypageclone;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity implements BottomNavigationViewEx.OnNavigationItemSelectedListener{

    private BottomNavigationViewEx bottomNav;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.main_container);

        bottomNav = findViewById(R.id.main_bottomNav);
        bottomNav.enableAnimation(false);
        bottomNav.enableShiftingMode(false);
        bottomNav.enableItemShiftingMode(false);
        bottomNav.setTextSize(9);
        bottomNav.setOnNavigationItemSelectedListener(this);

        bottomNav.setCurrentItem(4);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.bottomNav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new HomeFragment())
                        .commit();
                break;
            case R.id.bottomNav_trending:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new TrendingFragment())
                        .commit();
                break;
            case R.id.bottomNav_subscriptions:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new SubscriptionsFragment())
                        .commit();
                break;
            case R.id.bottomNav_inbox:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new InboxFragment())
                        .commit();
                break;
            case R.id.bottomNav_library:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new LibraryFragment())
                        .commit();
                break;
        }
        return true;
    }
}
