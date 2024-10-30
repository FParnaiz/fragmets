package com.example.fragmets;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button boton1;
    Button boton2;
    private String boton_elegido;
    private String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.getString("fragment") != null) {
            boton_elegido=savedInstanceState.getString("fragment");}
        if (isLandscapeMode()) {

            if (savedInstanceState != null && savedInstanceState.getString("fragment") != null) {
                boton_elegido=savedInstanceState.getString("fragment");
                msg="El último boton apretado es el "+boton_elegido+"!";
            }else{
                msg="Pon el modo vertical para apretar un boton";
            }


            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

                return insets;
            });
            setContentView(R.layout.activity_main);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            FirstFragment fragment = FirstFragment.newInstance(msg,"#985d38");
            FirstFragment fragment2 = FirstFragment.newInstance("Yo solo existo en lansacape!","#623532");
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.replace(R.id.frame1, fragment);
            fragmentTransaction.replace(R.id.frame2, fragment2);
            fragmentTransaction.commit();
        }
        else {


        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            return insets;
        });
        boton1 = findViewById(R.id.button);
        boton1.setOnClickListener(v -> {
            boton1();
                });
        boton2 = findViewById(R.id.button2);
        boton2.setOnClickListener(v -> {
            boton2();
                });
       }
    }
    private void boton1() {
        boton_elegido="1";

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FirstFragment fragment = FirstFragment.newInstance("Has apretado el boton1!","#985d38");
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }
    private void boton2(){
            boton_elegido="2";
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            FirstFragment fragment2 = FirstFragment.newInstance("Has apretado el boton2!","#623532");
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.replace(R.id.frame, fragment2);
            fragmentTransaction.commit();




    }
    private boolean isLandscapeMode() {
        // Get the current configuration
        int orientation = getResources().getConfiguration().orientation;
        return orientation == Configuration.ORIENTATION_LANDSCAPE;
    }
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);


        if(boton_elegido!=null){
        savedInstanceState.putString("fragment",boton_elegido);}

    }
}