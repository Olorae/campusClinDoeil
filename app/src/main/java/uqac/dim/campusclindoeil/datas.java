package uqac.dim.campusclindoeil;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class datas {


    public static void newUser(FirebaseFirestore db, String email, String mdp, String pseudo) {
        Log.i("DIM", "newUser");
        // Create a new user with a email and mdp name
        Map<String, Object> user = new HashMap<>();
        user.put("email", email);
        user.put("mot_de_passe", mdp);
        user.put("pseudo", pseudo);

        // Add a new document with a generated ID
        db.collection("utilisateur").add(user)
                .addOnSuccessListener(
                        new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                Log.i("DIM", "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                        Log.i("DIM", "Error adding document", e);
                    }
                });
        Log.i("DIM", "id = " + db.document("/utilisateur/AARzZRWSK6pccQjEePbA"));
    }

    public static void readDatas(FirebaseFirestore db){
        Log.i("DIM", "readDatas");
        db.collection("utilisateur").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                Log.i("DIM", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                            Log.i("DIM", "Error getting documents.", task.getException());
                        }
                    }
                });
    }
    public static void protectDatas(FirebaseFirestore db){
        /* Allow read/write access on all documents to any user signed in to the application
        service cloud.firestore {
            match /databases/{database}/documents {
                match /{document=**} {
                    allow read, write: if request.auth != null;
                }
            }
        }
        */

    }
}
