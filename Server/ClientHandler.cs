using System;
using System.Net.Sockets;
using System.Text;
using System.Threading;

namespace ServerExemplu
{
    class ClientHandler
    {
        private Socket _sk = null;
        private int _idx = -1;
        private Thread _th = null;
        private bool _shouldRun = true;
        private bool _isRunning = true;
        private ServerCore _server;

        public ClientHandler(Socket sk, int id, ServerCore server)
        {
            _sk = sk;
            _idx = id;
            _server = server;
        }

        public void InitClient()
        {
            if (_th != null)
                return;

            _th = new Thread(Run);
            _th.Start();
        }

        public void StopClient()
        {
            if (_th == null)
                return;

            _sk.Close();
            _shouldRun = false;
        }

        private void Run()
        {
            while (_shouldRun)
            {
                byte[] rawMsg = new byte[10];
                try
                {
                    int bCount = _sk.Receive(rawMsg);
                    string msg = Encoding.UTF8.GetString(rawMsg);
                    if (bCount > 0)
                        Console.WriteLine("Client " + _idx + ": " + msg);
                    HandleMsg(msg);
                }
                catch (Exception ex)
                {
                    // Handle exceptions
                    Console.WriteLine("Exception occurred in client handler: " + ex.Message);
                    return;
                }
                Thread.Sleep(1);
            }
            _isRunning = false;
        }

        private void HandleMsg(string msg)
        {
          //
        }

        public bool IsAlive()
        {
            return _isRunning;
        }
    }
}
