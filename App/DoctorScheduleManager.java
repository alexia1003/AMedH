package com.example.amedh;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class DoctorScheduleManager {
    private static DoctorScheduleManager instance;
    private Map<String, DoctorSchedule> doctorSchedules;

    private DoctorScheduleManager() {
        doctorSchedules = new HashMap<>();
        initializeDoctorSchedules();
    }

    public static DoctorScheduleManager getInstance() {
        if (instance == null) {
            instance = new DoctorScheduleManager();
        }
        return instance;
    }

    private void initializeDoctorSchedules() {
        // Initializare program doctori
        doctorSchedules.put("Dr. Flaviu Lupei", new DoctorSchedule(
                new ArrayList<AvailabilityHours>() {{
                    add(new AvailabilityHours("10:00", "12:00"));
                    add(new AvailabilityHours("09:00", "13:00"));
                }}
        ));

        doctorSchedules.put("Dr. Teodora Petrescu", new DoctorSchedule(
                new ArrayList<AvailabilityHours>() {{
                    add(new AvailabilityHours("09:00", "13:00"));
                    add(new AvailabilityHours("12:00", "17:00"));
                }}
        ));

        doctorSchedules.put("Dr. Emma Constantinescu", new DoctorSchedule(
                new ArrayList<AvailabilityHours>() {{
                    add(new AvailabilityHours("08:00", "12:00"));
                    add(new AvailabilityHours("09:00", "13:00"));
                }}
        ));

        doctorSchedules.put("Dr. Simona Grigore", new DoctorSchedule(
                new ArrayList<AvailabilityHours>() {{
                    add(new AvailabilityHours("09:00", "13:00"));
                    add(new AvailabilityHours("12:00", "17:00"));
                }}
        ));

        doctorSchedules.put("Dr. Elena Albu", new DoctorSchedule(
                new ArrayList<AvailabilityHours>() {{
                    add(new AvailabilityHours("10:00", "14:00"));
                    add(new AvailabilityHours("11:00", "15:00"));
                }}
        ));

        doctorSchedules.put("Dr. Olivia Antonescu", new DoctorSchedule(
                new ArrayList<AvailabilityHours>() {{
                    add(new AvailabilityHours("09:00", "12:00"));
                    add(new AvailabilityHours("13:00", "17:00"));
                }}
        ));

        doctorSchedules.put("Dr. Ana Adam", new DoctorSchedule(
                new ArrayList<AvailabilityHours>() {{
                    add(new AvailabilityHours("08:00", "12:00"));
                    add(new AvailabilityHours("10:00", "14:00"));
                }}
        ));

        doctorSchedules.put("Dr. Gavril Ionescu", new DoctorSchedule(
                new ArrayList<AvailabilityHours>() {{
                    add(new AvailabilityHours("09:00", "13:00"));
                    add(new AvailabilityHours("11:00", "15:00"));
                }}
        ));

        doctorSchedules.put("Dr. Liviu Ardelean", new DoctorSchedule(
                new ArrayList<AvailabilityHours>() {{
                    add(new AvailabilityHours("10:00", "14:00"));
                    add(new AvailabilityHours("09:00", "13:00"));
                }}
        ));

        doctorSchedules.put("Dr. Stela Petrescu", new DoctorSchedule(
                new ArrayList<AvailabilityHours>() {{
                    add(new AvailabilityHours("11:00", "15:00"));
                    add(new AvailabilityHours("12:00", "16:00"));
                }}
        ));

        doctorSchedules.put("Dr. Cezara Mihai", new DoctorSchedule(
                new ArrayList<AvailabilityHours>() {{
                    add(new AvailabilityHours("10:00", "14:00"));
                    add(new AvailabilityHours("09:00", "13:00"));
                }}
        ));

        doctorSchedules.put("Dr. Dragos Niculescu", new DoctorSchedule(
                new ArrayList<AvailabilityHours>() {{
                    add(new AvailabilityHours("08:00", "12:00"));
                    add(new AvailabilityHours("10:00", "14:00"));
                }}
        ));

    }

    public DoctorSchedule getDoctorSchedule(String doctorName) {
        return doctorSchedules.get(doctorName);
    }
}

class DoctorSchedule {
    private List<AvailabilityHours> availabilityHours;

    public DoctorSchedule(List<AvailabilityHours> availabilityHours) {
        this.availabilityHours = availabilityHours;
    }

    public List<AvailabilityHours> getAvailabilityHours() {
        return availabilityHours;
    }
}

class AvailabilityHours {
    private String startTime;
    private String endTime;

    public AvailabilityHours(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
