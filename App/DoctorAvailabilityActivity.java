package com.example.amedh;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DoctorAvailabilityActivity extends AppCompatActivity {

    //private static final String SERVER_IP = "---";
    private static final String SERVER_IP = "---";
    //private static final String SERVER_IP = "---";

    private static final int SERVER_PORT = 8000;

    private TextView resultTextView;
    private Button selectDateButton;
    private String chosenDoctorName;
    private String department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_availability);

        resultTextView = findViewById(R.id.resultTextView);
        selectDateButton = findViewById(R.id.selectDateButton);
        chosenDoctorName = getIntent().getStringExtra("doctorName");
        department = getIntent().getStringExtra("department"); // Retrieve department

        new CheckDoctorAvailabilityTask().execute(chosenDoctorName);

        resultTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSymptomsActivity();
            }
        });

        // Selectare data
        selectDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoctorAvailabilityActivity.this, DateTimeSelectionActivity.class);
                intent.putExtra("doctorName", chosenDoctorName);
                intent.putExtra("department", department);
                startActivity(intent);
            }
        });
    }

    private void navigateToSymptomsActivity() {
        // Navigare la SymptomsActivity
        Intent intent = new Intent(DoctorAvailabilityActivity.this, SymptomsActivity.class);
        startActivity(intent);
    }

    private class CheckDoctorAvailabilityTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String doctorName = params[0];

            try {
                Socket socket = new Socket(SERVER_IP, SERVER_PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Trimite request la server
                out.println("check-doctor-availability " + doctorName);

                // Primire raspuns de la server
                String response = in.readLine();

                // Inchide conexiunea
                out.close();
                in.close();
                socket.close();

                return response;
            } catch (IOException e) {
                e.printStackTrace();
                return "Error: " + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            resultTextView.setText(result);
        }
    }
}

