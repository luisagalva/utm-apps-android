package com.example.act7;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.text.TextRunShaper;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Scene scene1, scene2;
    private Transition transition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup mSceneRoot = (ViewGroup) findViewById(R.id.scene_root);
        scene1 = Scene.getSceneForLayout(mSceneRoot, R.layout.initial_layout, this);
        scene2 = Scene.getSceneForLayout(mSceneRoot, R.layout.final_layout, this);
        Button desc = (Button) findViewById(R.id.description);
        TextView text = (TextView) findViewById(R.id.text1);

        transition = new Fade();
        transition.setDuration(2000);
        desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.go(scene2, transition);
            }
        });

    }
}