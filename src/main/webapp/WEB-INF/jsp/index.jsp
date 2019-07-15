<%--
  Created by IntelliJ IDEA.
  User: liuting
  Date: 2019/7/14
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>linux防火墙开放3306端口</h1>
    <p style="color: blue">
        # 首先进入/etc/sysconfig 查看是否有iptables文件
       cd /etc/sysconfig

        # 若没有iptables文件 则执行以下命令 再查看就会有iptables文件了
        yum install iptables-services

        # 编辑iptables文件 在图中位置添加下面一句话(位置一定要对)
        # 注意：增加的开放3306端口的语句一定要在icmp-host-prohibited之前
        # 若是以后想开放其他端口也是在这里添加 只需要将3306替换成其他端口号
        -A INPUT -m state --state NEW -m tcp -p tcp --dport 3306 -j ACCEPT

        # 重启防火墙
        systemctl restart iptables.service

        # 查看防火墙状态
        service iptables status</p>
<h1>linux commond==>mysql重启</h1>
<P style="color: blue">service mysql restart</P>

</body>
</html>
