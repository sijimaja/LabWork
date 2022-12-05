package com.example.profilemanager;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button googleMaps;
    EditText editTextTextPersonName2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editTextTextPersonName2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        googleMaps = findViewById(R.id.googleMaps);
        googleMaps.setOnClickListener(view -> {
            Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?=" + editTextTextPersonName2.getText());
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });
    }

    public void OnSetAvatarButton(View view) {

        Intent intent = new Intent(getApplicationContext(), profileActivity.class);
        startActivityForResult (intent,0);
    }

    @SuppressLint("NonConstantResourceId")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;

        ImageView avatarImage = (ImageView) findViewById(R.id.logoImage);

        String drawableName = "ic_logo_00";
        switch (data.getIntExtra("imageID", R.id.logoImage)) {
            case R.id.canada:
                drawableName = "flag_ca";
                break;
            case R.id.france:
                drawableName = "flag_fr";
                break;
            case R.id.japan:
                drawableName = "flag_jp";
                break;
            case R.id.korea:
                drawableName = "flag_kr";
                break;
            case R.id.egypt:
                drawableName = "flag_eg";
                break;
            case R.id.spain:
                drawableName = "flag_sp";
                break;
            case R.id.turkey:
                drawableName = "flag_tr";
                break;
            case R.id.us:
                drawableName = "flag_us";
                break;
            case R.id.uk:
                drawableName = "flag_uk";
                break;
            default:
                drawableName = "ic_logo_00";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable",
                getPackageName());
        avatarImage.setImageResource(resID);
    }

}