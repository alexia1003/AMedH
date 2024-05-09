package com.example.amedh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class DateTimeSelectionActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private TimePicker timePicker;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_selection);

        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = datePicker.getYear();
                int month = datePicker.getMonth();
                int dayOfMonth = datePicker.getDayOfMonth();
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                // Trimite ziua si ora selectata la SymptomsActivity
                Intent intent = new Intent(DateTimeSelectionActivity.this, SymptomsActivity.class);
                intent.putExtra("year", year);
                intent.putExtra("month", month);
                intent.putExtra("dayOfMonth", dayOfMonth);
                intent.putExtra("hour", hour);
                intent.putExtra("minute", minute);

                String selectedDoctorName = getIntent().getStringExtra("doctorName");
                String selectedDepartment = getIntent().getStringExtra("department");

                intent.putExtra("doctorName", selectedDoctorName);
                intent.putExtra("department", selectedDepartment);

                startActivity(intent);
            }
        });
    }
}
