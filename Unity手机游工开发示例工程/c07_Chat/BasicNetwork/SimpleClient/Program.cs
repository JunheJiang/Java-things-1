using System;
using System.Text;
using System.Net;  // 必要的网络模块
using System.Net.Sockets;  // 必要的网络模块
namespace SimpleClient{
    class Program{
        static void Main(string[] args){
            try{
                // 设置服务器地址和端口
                IPEndPoint ipe = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 8000);
                // 创建TCP Socket
                Socket client = new Socket(ipe.AddressFamily, SocketType.Stream, ProtocolType.Tcp);
                // 开始连接服务器，程序在这里会堵塞
                client.Connect(ipe);
                Console.WriteLine("连接到服务器");
                // 向服务器发送数据
                string data = "hello,world";
                byte[] bs=UTF8Encoding.UTF8.GetBytes(data);
                client.Send(bs);
                // 用一个数组保存服务器返回的数据
                byte[] rev = new byte[256];
                // 接收到服务器返回的数据，返回值是字节数组的长度
                int length = client.Receive(rev);
                Console.WriteLine(UTF8Encoding.UTF8.GetString(rev, 0, length));
                // 关闭连接
                client.Close();
            }
            catch (Exception e){
                Console.WriteLine(e.Message);
            }
Console.ReadLine();  // 这行代码仅仅为了使程序执行完不要马上退出
        }
    }
}
