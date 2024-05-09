package com.example.amedh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class ChooseDoctorActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Map<String, String[]> departmentDoctorMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_doctor);

        radioGroup = findViewById(R.id.radiogroup_doctors);

        // Initializeaza map-ul departament-doctor
        departmentDoctorMap = new HashMap<>();
        departmentDoctorMap.put("Medicina Interna", new String[]{"Dr. Flaviu Lupei", "Dr. Teodora Petrescu"});
        departmentDoctorMap.put("Cardiologie", new String[]{"Dr. Emma Constantinescu", "Dr. Simona Grigore"});
        departmentDoctorMap.put("Dermatologie", new String[]{"Dr. Elena Albu", "Dr. Olivia Antonescu"});
        departmentDoctorMap.put("Oftalmologie", new String[]{"Dr. Ana Adam", "Dr. Gavril Ionescu"});
        departmentDoctorMap.put("Pediatrie", new String[]{"Dr. Liviu Ardelean", "Dr. Stela Petrescu"});
        departmentDoctorMap.put("Medicina generala", new String[]{"Dr. Cezara Mihai", "Dr. Dragos Niculescu"});

        String department = getIntent().getStringExtra("department");

        // Preia doctoi pt. departamentul selectat din map
        String[] doctors = departmentDoctorMap.get(department);

        // Adauga doctori la radio group
        addDoctors(doctors);

        Button nextButton = findViewById(R.id.button_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton selectedRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                String selectedDoctorName = selectedRadioButton.getText().toString();

                Intent intent = new Intent(ChooseDoctorActivity.this, DoctorAvailabilityActivity.class);
                intent.putExtra("doctorName", selectedDoctorName);
                intent.putExtra("department", department);
                startActivity(intent);
            }
        });
    }

    private void addDoctors(String[] doctors) {
        if (doctors != null) {
            for (int i = 0; i < doctors.length; i++) {
                String doctor = doctors[i];
                RadioButton radioButton = new RadioButton(this);
                radioButton.setText(doctor);
                radioButton.setTextSize(18);
                radioGroup.addView(radioButton);
            }
        }
    }


}


