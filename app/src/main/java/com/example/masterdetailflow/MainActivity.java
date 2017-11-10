package com.example.masterdetailflow;

import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.masterdetailflow.model.News;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private boolean isTablet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isTablet = getResources().getBoolean(R.bool.is_tablet);
        if (isTablet) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }


        Toast.makeText(this, String.valueOf(isTablet), Toast.LENGTH_SHORT).show();
        showMasterFragment();
    }

    private void showMasterFragment() {
        if (!isTablet) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.am_master_container, new MasterFragment(), MasterFragment.class.getName())
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.am_tablet_master_container,
                            new MasterFragment(), MasterFragment.class.getName())
                    .commit();
        }
    }

    public void showDetailFlowFragment(News news) {
        if (!isTablet) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.am_master_container, DetailFlowFragment.newInstance(news), DetailFlowFragment.class.getName())
                    .addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.am_tablet_detail_flow_container,
                            DetailFlowFragment.newInstance(news), DetailFlowFragment.class.getName())
                    .commit();
        }
    }


}
