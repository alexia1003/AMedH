using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
  
namespace ServerExemplu
{
    public class Medic
    {
        public string Nume { get; set; }
        public string Specializare { get; set; }
        public string NumarIdentificare { get; set; }
        public string DetaliiContact { get; set; }
        public string Orar { get; set; }

        public Medic(string nume, string specializare, string numarIdentificare, string detaliiContact, string orar)
        {
            Nume = nume;
            Specializare = specializare;
            NumarIdentificare = numarIdentificare;
            DetaliiContact = detaliiContact;
            Orar = orar;
        }
    }
}
