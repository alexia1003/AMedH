using System;
using System.Collections.Generic;

namespace ServerExemplu
{
    public class DoctorSchedule
    {
        public List<AvailabilityHours> AvailabilityHours { get; set; }

        public DoctorSchedule(List<AvailabilityHours> hours)
        {
            AvailabilityHours = hours;
        }

        public bool IsAvailable(DateTime date)
        {
            foreach (var hours in AvailabilityHours)
            {
                if (hours.ContainsTime(date))
                {
                    return true;
                }
            }
            return false;
        }
    }

    public class DoctorAvailabilityManager
    {
        private static DoctorAvailabilityManager _instance = new DoctorAvailabilityManager();
        private Dictionary<string, DoctorSchedule> _doctorSchedules;

        private DoctorAvailabilityManager()
        {
            _doctorSchedules = new Dictionary<string, DoctorSchedule>();
            InitializeDoctorSchedules();
        }
        public static DoctorAvailabilityManager Instance
        {
            get
            {
                if (_instance == null)
                    _instance = new DoctorAvailabilityManager();
                return _instance;
            }
        }
        private void InitializeDoctorSchedules()
        {
            _doctorSchedules["Dr. Flaviu Lupei"] = new DoctorSchedule(new List<AvailabilityHours>
            {
                new AvailabilityHours("10:00", "12:00"),
                new AvailabilityHours("09:00", "13:00")
            });

            _doctorSchedules["Dr. Teodora Petrescu"] = new DoctorSchedule(new List<AvailabilityHours>
            {
                new AvailabilityHours("09:00", "13:00"),
                new AvailabilityHours("12:00", "17:00")
            }); 

            _doctorSchedules["Dr. Emma Constantinescu"] = new DoctorSchedule(new List<AvailabilityHours>
            {
                new AvailabilityHours("08:00", "12:00"),
                new AvailabilityHours("09:00", "13:00")
            });

            _doctorSchedules["Dr. Simona Grigore"] = new DoctorSchedule(new List<AvailabilityHours>
            {
                new AvailabilityHours("09:00", "13:00"),
                new AvailabilityHours("12:00", "17:00")
            });

            _doctorSchedules["Dr. Elena Albu"] = new DoctorSchedule(new List<AvailabilityHours>
            {       
                new AvailabilityHours("10:00", "14:00"),
                new AvailabilityHours("11:00", "15:00")
            });

            _doctorSchedules["Dr. Olivia Antonescu"] = new DoctorSchedule(new List<AvailabilityHours>
            {
                new AvailabilityHours("09:00", "12:00"),
                new AvailabilityHours("13:00", "17:00")
            });

            _doctorSchedules["Dr. Ana Adam"] = new DoctorSchedule(new List<AvailabilityHours>
            {
                new AvailabilityHours("08:00", "12:00"),
                new AvailabilityHours("10:00", "14:00")
            });

            _doctorSchedules["Dr. Gavril Ionescu"] = new DoctorSchedule(new List<AvailabilityHours>
            {
                new AvailabilityHours("09:00", "13:00"),
                new AvailabilityHours("11:00", "15:00")
            });

            _doctorSchedules["Dr. Liviu Ardelean"] = new DoctorSchedule(new List<AvailabilityHours>
            {
                new AvailabilityHours("10:00", "14:00"),
                new AvailabilityHours("09:00", "13:00")
            });

            _doctorSchedules["Dr. Stela Petrescu"] = new DoctorSchedule(new List<AvailabilityHours>
            {
                new AvailabilityHours("11:00", "15:00"),
                new AvailabilityHours("12:00", "16:00")
            });

            _doctorSchedules["Dr. Cezara Mihai"] = new DoctorSchedule(new List<AvailabilityHours>
            {
                new AvailabilityHours("10:00", "14:00"),
                new AvailabilityHours("09:00", "13:00")
            });

            _doctorSchedules["Dr. Dragos Niculescu"] = new DoctorSchedule(new List<AvailabilityHours>
            {
                new AvailabilityHours("08:00", "12:00"),
                new AvailabilityHours("10:00", "14:00")
            });

        }

        public DoctorSchedule GetDoctorSchedule(string doctorName)
        {
            return _doctorSchedules.TryGetValue(doctorName, out var schedule) ? schedule : null;
        }
    }

    public class AvailabilityHours
    {
        public string StartTime { get; set; }
        public string EndTime { get; set; }

        public AvailabilityHours(string startTime, string endTime)
        {
            StartTime = startTime;
            EndTime = endTime;
        }

        public bool ContainsTime(DateTime dateTime)
        {
            var time = dateTime.TimeOfDay;
            var startTime = TimeSpan.Parse(StartTime);
            var endTime = TimeSpan.Parse(EndTime);
            return (time >= startTime && time < endTime);
        }
    }
}
