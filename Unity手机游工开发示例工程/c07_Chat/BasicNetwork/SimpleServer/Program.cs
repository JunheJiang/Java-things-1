using System;
using System.Net;
using System.Net.Sockets;

// TCP 服务器简单示例
namespace SimpleServer
{
    class Program
    {
        static void Main(string[] args)
        {
            // 服务器ip地址
            string ip = "127.0.0.1";
            // 服务器端口
            int port = 8000;

            try
            {
                IPEndPoint ipe = new IPEndPoint(IPAddress.Any, port);
                // 创建Socket
                Socket listener = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
                // 将Socket绑定到终端地址上
                listener.Bind(ipe);
                // 开始监听
                listener.Listen(128);
                Console.WriteLine("开始监听");
                // 开始接受客户端请求 程序在这里会堵塞
                Socket mySocket=listener.Accept();
                Console.WriteLine("新的连接来自 {0}", mySocket.RemoteEndPoint);
                byte[] bs = new byte[256];
                int n = mySocket.Receive(bs);
                // 将客户端发来的数据返回给客户端
                mySocket.Send(bs, n, SocketFlags.None);
                // 半闭与客户端的连接
                mySocket.Close();
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            Console.ReadLine();
        }
    }
}
