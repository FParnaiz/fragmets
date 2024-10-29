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

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (isLandscapeMode()) {
            Log.d("FragmentTransaction", "lansacape");
            FrameLayout frame1;
            FrameLayout frame2;
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            Log.d("FragmentTransaction", "lansacape");
            setContentView(R.layout.activity_main);
            Log.d("FragmentTransaction", "lansacape3");
            Log.d("FragmentTransaction", "lansacape4");
            FragmentManager fragmentManager = getSupportFragmentManager();
            Log.d("FragmentTransaction", "lansacape5");
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Log.d("FragmentTransaction", "lansacape6");
            FirstFragment fragment = FirstFragment.newInstance("Has apretado el boton1!","#985d38");
            Log.d("FragmentTransaction", "lansacape7");
            FirstFragment fragment2 = FirstFragment.newInstance("Has apretado el boton2!","#623532");
            Log.d("FragmentTransaction", "lansacape8");
            fragmentTransaction.replace(R.id.frame1, fragment);
            Log.d("FragmentTransaction", "Replacing frame1 with fragment1");

            fragmentTransaction.replace(R.id.frame2, fragment2);
            Log.d("FragmentTransaction", "Replacing frame2 with fragment2");
            fragmentTransaction.commit();
        }
        else {
            Button boton1;
            Button boton2;
            FrameLayout frame;
        super.onCreate(savedInstanceState);
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
        frame= findViewById(R.id.frame);}
    }
    private void boton1() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FirstFragment fragment = FirstFragment.newInstance("Has apretado el boton1!","#985d38");
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }
    private void boton2(){
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
}