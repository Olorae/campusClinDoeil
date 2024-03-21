package uqac.dim.campusclindoeil;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.cloud.firestore.Firestore;


//export GOOGLE_APPLICATION_CREDENTIALS="C:\\Users\\Coralie\\Documents\\Informatique mobile\\Travail_de_fin_session\\CampusClinDOeil\\app\\google-services.json"

public class MainActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    //private DocumentReference mDocRef = FirebaseFirestore.getInstance().collection("utilisateur").document("AARzZRWSK6pccQjEePbA");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bouton).setOnClickListener(this::boutonClicked);
    }

    private void boutonClicked(View v) {
        datas.newUser(db, "coralie.tremblay", "sagym8", "olorae");
        datas.readDatas(db);
    }
}