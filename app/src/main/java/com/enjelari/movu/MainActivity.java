package com.enjelari.movu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.enjelari.movu.fragments.FavoriteFragment;
import com.enjelari.movu.fragments.HomeFragment;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {
    private final static int ID_HOME = 1;
    private final static int ID_FAVORITE = 2;
    private final static int ID_SETTINGS = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomNavigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_FAVORITE, R.drawable.ic_favorite));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_SETTINGS, R.drawable.ic_settings));

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

            }
        });

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;
                switch (item.getId()) {
                    case ID_HOME :
                        fragment = new HomeFragment();
                        break;
                    case ID_FAVORITE :
                        fragment = new FavoriteFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
            }
        });

        bottomNavigation.show(ID_HOME,true);
    }
}
