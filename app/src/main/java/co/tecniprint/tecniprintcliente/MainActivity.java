package co.tecniprint.tecniprintcliente;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.stephentuso.welcome.WelcomeHelper;

import java.util.Objects;

import co.tecniprint.tecniprintcliente.otros.MyWelcomeActivity;

public class MainActivity extends AppCompatActivity {
    private static final int EMPEZAR = 2;
    private TextView txtMain;

    private WelcomeHelper welcomeScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);

        welcomeScreen = new WelcomeHelper(this, MyWelcomeActivity.class);
        welcomeScreen.show(savedInstanceState, EMPEZAR);
        welcomeScreen.forceShow();

        txtMain = findViewById(R.id.txt_main);



    }





}
