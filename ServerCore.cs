using System;
using System.Net;
using System.Net.Sockets;
using System.Threading;

namespace ServerExemplu
{
    class ServerCore : ServerSocket
    {
        private Thread _th = null;
        private bool _shouldRun = true;

        public void CreateServer(int port)
        {
            createSocket(port);
            _th = new Thread(Run);
            _th.Start();
        }

        public void StopServer()
        {
            closeSocket();
        }

        private void Run()
        {
            while (_shouldRun)
            {
                try
                {
                    Socket sk = acceptConnection();
                    if (sk == null)
                        return;

                    Console.WriteLine("Accepted connection from: " + sk.RemoteEndPoint);
                    ClientHandler cl = new ClientHandler(sk, ClientDataStore.instance.clientCount, this);
                    cl.InitClient();
                    ClientDataStore.instance.addClient(cl);
                }
                catch (Exception ex)
                {
                    // Handle exceptions
                    Console.WriteLine("Exception occurred: " + ex.Message);
                    return;
                }

                Thread.Yield();
            }
        }
    }
}
