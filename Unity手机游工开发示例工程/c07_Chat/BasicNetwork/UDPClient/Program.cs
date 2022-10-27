using System;
using System.Text;
using System.Net;
using System.Net.Sockets;

// UDP客户端示例
namespace UDPClient
{
    class Program
    {
        static void Main(string[] args)
        {
            Socket client = new Socket(AddressFamily.InterNetwork, SocketType.Dgram, ProtocolType.Udp);

            byte[] buffer = UTF8Encoding.UTF8.GetBytes("hello,world");

            // 不需要连接服务器，直接向服务器地址发送数据
            client.SendTo(buffer, new IPEndPoint(IPAddress.Parse("127.0.0.1"), 8001));  

            byte[] revbuffer = new byte[256];
            int length = client.Receive(revbuffer);

            Console.WriteLine("收到:" + UTF8Encoding.UTF8.GetString(revbuffer, 0, length));

            Console.ReadLine();
        }
    }
}
