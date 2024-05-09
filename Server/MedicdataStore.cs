using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
/*
namespace ServerExemplu
{
    public class MedicDataStore
    {
        private readonly FirebaseClient _firebase;

        public MedicDataStore(string firebaseUrl, string firebaseApiKey)
        {
            _firebase = new FirebaseClient(
                firebaseUrl,
                new FirebaseOptions
                {
                    AuthTokenAsyncFactory = () => Task.FromResult(firebaseApiKey)
                });
        }

        public async Task AdaugaMedic(Medic medic)
        {
            await _firebase.Child("Medici").PostAsync(medic);
        }

        public async Task<List<Medic>> GetMedici()
        {
            var medici = await _firebase.Child("Medici").OnceAsync<Medic>();
            return medici.Select(m => m.Object).ToList();
        }
    }
}
*/
