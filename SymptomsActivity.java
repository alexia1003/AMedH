package com.example.amedh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SymptomsActivity extends AppCompatActivity {
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        // Initializare Firebase Firestore
        firestore = FirebaseFirestore.getInstance();

        EditText symptomsEditText = findViewById(R.id.symptomsEditText);
        EditText nameEditText = findViewById(R.id.nameEditText);
        EditText contactInfoEditText = findViewById(R.id.contactInfoEditText);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String symptoms = symptomsEditText.getText().toString();
                String name = nameEditText.getText().toString();
                String contactInfo = contactInfoEditText.getText().toString();

                // Verificare daca campurile sunt libere
                if (symptoms.isEmpty() || name.isEmpty() || contactInfo.isEmpty()) {
                    Toast.makeText(SymptomsActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Verificare date de contact
                if (contactInfo.length() < 10) {
                    Toast.makeText(SymptomsActivity.this, "Contact information must be at least 10 characters", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Preia ziua, ora, nume si departament doctor selectat
                String selectedDoctorName = getIntent().getStringExtra("doctorName");
                String selectedDepartment = getIntent().getStringExtra("department");
                int year = getIntent().getIntExtra("year", 0);
                int month = getIntent().getIntExtra("month", 0);
                int dayOfMonth = getIntent().getIntExtra("dayOfMonth", 0);
                int hour = getIntent().getIntExtra("hour", 0);
                int minute = getIntent().getIntExtra("minute", 0);

                // Creare Map pt. a stoca info. pacienti
                Map<String, Object> patientData = new HashMap<>();
                patientData.put("symptoms", symptoms);
                patientData.put("name", name);
                patientData.put("contactInfo", contactInfo);
                patientData.put("doctorName", selectedDoctorName);
                patientData.put("department", selectedDepartment);
                patientData.put("year", year);
                patientData.put("month", month);
                patientData.put("dayOfMonth", dayOfMonth);
                patientData.put("hour", hour);
                patientData.put("minute", minute);

                // Adauga pacient la Firestore
                firestore.collection("patients").add(patientData)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(SymptomsActivity.this, "Patient data added successfully", Toast.LENGTH_SHORT).show();

                                // Navigate back to MainActivity
                                Intent intent = new Intent(SymptomsActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(SymptomsActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });


                // Afisare mesaj toast
                String message = "Programare realizata cu succes!";
                Toast.makeText(SymptomsActivity.this, message, Toast.LENGTH_LONG).show();

                // Navigare inapoi la MainActivity
                Intent intent = new Intent(SymptomsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
