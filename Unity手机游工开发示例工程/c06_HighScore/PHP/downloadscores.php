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

// 查询
$requestSQL = "SELECT * FROM hiscores ORDER by score DESC LIMIT 20 ";

$result = mysqli_query($myHandler,$requestSQL) or die("SQL ERROR : ".$requestSQL);
$num_results = mysqli_num_rows($result);

// 创建数组，用于保存查询到的数据
$arr =array();
// 将查询结果写入到数组中
for($i = 0; $i < $num_results; $i++)
{
    $row = mysqli_fetch_array($result ,MYSQLI_ASSOC); // 获得一行数据

    $id=$row['id'];  // 获得ID
    $arr[$id]['id']=$row['id'];  // 将ID存入数组
    $arr[$id]['name']=$row['name'];  // 将用户名存入数组
    $arr[$id]['score']=$row['score'];	// 将分数存入数组
}

mysqli_free_result($result);  // 释放SQL查询结果
mysqli_close($myHandler);  // 关闭数据库

// 向Unity发送JSON格式的数据
echo  json_encode($arr);
?>


