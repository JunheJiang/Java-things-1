using System;
using System.Text;
using System.Net;
using System.Net.Sockets;

//UDP 服务器示例
namespace UDPServer
{
    class Program
    {
        static void Main(string[] args)
        {
            // 创建UDP Socket
            Socket server = new Socket(AddressFamily.InterNetwork, SocketType.Dgram, ProtocolType.Udp);
            // 将Socket绑定到8001端口
            server.Bind(new IPEndPoint(IPAddress.Any, 8001));

            byte[] buffer = new byte[256];
            EndPoint remoteIP = new IPEndPoint(IPAddress.Any, 0);
            // 开始接收数据，UDP不保证可靠性，因此可能收不到或重复收到
            int length = server.ReceiveFrom(buffer, SocketFlags.None, ref remoteIP);  

            IPEndPoint remote = ((IPEndPoint)remoteIP);
            Console.WriteLine("从{0}:{1}收到远方数据({2}):{3}", remote.Address, remote.Port, length,
                UTF8Encoding.UTF8.GetString(buffer, 0, length)); // 打印收到的数据
            server.SendTo(buffer, length, SocketFlags.None, remoteIP);  // 返回数据给客户端
            server.Close(); // 关闭服务器

            Console.ReadLine();
        }
    }
}
