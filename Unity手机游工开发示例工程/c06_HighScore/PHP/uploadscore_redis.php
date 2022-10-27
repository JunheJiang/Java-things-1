<?php

// 连接数据库, 输入地址，用户名，密码和数据库名称
$myHandler=mysqli_connect( "localhost" ,"root" ,"123456", "myscoresdb" );
if ( mysqli_connect_errno()) // 如果连接数据库失败
{
    echo mysqli_connect_error();
    die();
    exit(0);
}

// 确保数据库文本使用UTF-8格式
mysqli_query($myHandler,"set names utf8") ;

// 读入由Unity传输来的用户名和分数, 使用mysqli_real_escape_string校验用户名合法性(防止SQL注入)
$UserID=mysqli_real_escape_string($myHandler, $_POST["name"]);	// user name
$hiscore=$_POST["score"];  // user score

// 插入新数据
$sql="insert into hiscores value( NULL, '$UserID','$hiscore')";
mysqli_query($myHandler,$sql) or die("SQL ERROR : ".$requestSQL);

// 添加代码，将数据同时写入到redis中
$id = mysqli_insert_id($myHandler);  // 获取用户id
$redis = new Redis();
$redis->connect("127.0.0.1", 6379);  // 连接到Redis
$redis->lPush("rankid", $id);
// 将用户数据写入Redis,键名是user.和ID编号的结合
$redis->hMset("user.$id", array("id"=>$id, "name"=>$UserID, "score"=>$hiscore) );

//关闭数据库
mysqli_close($myHandler); 



// 将结果发送给Unity
echo 'upload '.$UserID.":".$hiscore;

?>


