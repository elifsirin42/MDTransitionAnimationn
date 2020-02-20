package com.example.mdtransitionanimationn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //Let's declare some objects here.
    //Grid Layout is a ViewGroup means that is view that compat other views or other objects.
    //So we have to declare a ViewGroup to declare GridLayout.
    ViewGroup myGridLayout;
    ImageView imgPig;
    ImageView imgCat;
    ImageView imgzebra;
    ImageView imgAnimals;
    Button btnTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myGridLayout = findViewById(R.id.myGridLayout);
        imgPig = findViewById(R.id.imgPig);
        imgCat = findViewById(R.id.imgCat);
        imgzebra = findViewById(R.id.imgZebra);
        imgAnimals = findViewById(R.id.imgAnimals);
        btnTransition = findViewById(R.id.btnTransition);

        btnTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //If we can change the new Fade from new Explode, We provide change the animation.
                //So the images are fading thanks to this new Fade metod.
                //If we can change the new Slide methot, The images are slideing on the screen.
                TransitionManager.beginDelayedTransition(myGridLayout, new Slide());

                revealOrHideTheImages(imgPig, imgCat, imgzebra, imgAnimals);
            }
        });

    }
    //View.. ImageViews means that this method can accept that as many objects as that we want.
   //ImageViews class is the sub class of View class.So imageViews is a View.
    private void revealOrHideTheImages(View... imageViews){

        for (View view : imageViews){

            //If the Image is VISIBLE,isImageViewVisible returns true.Otherwise returns false.
            boolean isImageVisible = view.getVisibility() == View.VISIBLE;

            //? means that if statement. If the view is visible,the view returned invisible by this method.
            //Otherwise returned visible by this method.
            view.setVisibility(isImageVisible ? View.INVISIBLE : View.VISIBLE);


        }

    }
}
