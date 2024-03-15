package uqac.dim.campusclindoeil;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
//import com.google.firebase.appcheck.FirebaseAppCheck;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

//export GOOGLE_APPLICATION_CREDENTIALS="C:\\Users\\Coralie\\Documents\\Informatique mobile\\Travail_de_fin_session\\CampusClinDOeil\\app\\google-services.json"

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            FileInputStream refreshToken = new FileInputStream("C:\\Users\\Coralie\\Documents\\Informatique mobile\\Travail_de_fin_session\\CampusClinDOeil\\app\\google-services.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setApiKey("AIzaSyDsMtqg6hYXrBraCQjY0ivGYQmS4vTbpk4")
                .setApplicationId("1:124036809723:android:1ba5df6557e9bb3b87015e")
                .setDatabaseUrl("https://campus-clin-d-oeil-default-rtdb.firebaseio.com/")
                .build();

        FirebaseApp.initializeApp(this, options, "Campus Clin D\'oeil");

        /*
        FirebaseApp.initializeApp(this);
        FirebaseAppCheck firebaseAppCheck;
        firebaseAppCheck = FirebaseAppCheck.getInstance();
        firebaseAppCheck.installAppCheckProviderFactory(
                PlayIntegrityAppCheckProviderFactory.getInstance());
        */
    }

}