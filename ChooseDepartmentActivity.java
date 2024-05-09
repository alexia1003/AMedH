package com.example.amedh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseDepartmentActivity extends AppCompatActivity {

    private Button chooseDoctorButton;
    private int selectedImageButtonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_department);

        chooseDoctorButton = findViewById(R.id.button_choose_doctor);

        findViewById(R.id.imageButton1).setOnClickListener(imageButtonClickListener);
        findViewById(R.id.imageButton2).setOnClickListener(imageButtonClickListener);
        findViewById(R.id.imageButton3).setOnClickListener(imageButtonClickListener);
        findViewById(R.id.imageButton4).setOnClickListener(imageButtonClickListener);
        findViewById(R.id.imageButton5).setOnClickListener(imageButtonClickListener);
        findViewById(R.id.imageButton6).setOnClickListener(imageButtonClickListener);

        chooseDoctorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedImageButtonId != 0) {
                    Intent intent = new Intent(ChooseDepartmentActivity.this, ChooseDoctorActivity.class);
                    String department = getDepartmentName(selectedImageButtonId);
                    intent.putExtra("department", department);
                    startActivity(intent);
                } else {
                    Toast.makeText(ChooseDepartmentActivity.this, "Te rog alege un department", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private View.OnClickListener imageButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            selectedImageButtonId = v.getId();
            resetButtonBorders();
            //v.setBackgroundResource(R.drawable.selected_border);
        }
    };

    private void resetButtonBorders() {
        findViewById(R.id.imageButton1).setBackgroundResource(0);
        findViewById(R.id.imageButton2).setBackgroundResource(0);
        findViewById(R.id.imageButton3).setBackgroundResource(0);
        findViewById(R.id.imageButton4).setBackgroundResource(0);
        findViewById(R.id.imageButton5).setBackgroundResource(0);
        findViewById(R.id.imageButton6).setBackgroundResource(0);
    }

    // Selecteaza un departament pe baza imaginii
    private String getDepartmentName(int selectedButtonId) {
        if (selectedButtonId == R.id.imageButton1) {
            return "Cardiologie";
        } else if (selectedButtonId == R.id.imageButton2) {
            return "Dermatologie";
        } else if (selectedButtonId == R.id.imageButton3) {
            return "Medicina Interna";
        } else if (selectedButtonId == R.id.imageButton4) {
            return "Oftalmologie";
        } else if (selectedButtonId == R.id.imageButton5) {
            return "Pediatrie";
        } else if (selectedButtonId == R.id.imageButton6) {
            return "Medicina generala";
        } else {
            return "";
        }
    }

}
