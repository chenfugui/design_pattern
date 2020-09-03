package com.cfg.sql;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.*;
/**
 * @description: 描述
 * @author: chenfg
 * @time: 2020/8/26 15:42
 */
public class CalciteDemo {

        public static void main(String[] args) {
            try {
                /**
                 * 用文件的方式
                 * */
//            URL url = Client.class.getResource("/model.json");
//            String str = URLDecoder.decode(url.toString(), "UTF-8");
//            Properties info = new Properties();
//            info.put("model", str.replace("file:", ""));
//            Connection connection = DriverManager.getConnection("jdbc:calcite:", info);


                /**
                 * 测试的时候用字符串
                 * defaultSchema 默认数据库
                 * name 数据库名称
                 * type custom
                 * factory 请求接收类，该类会实例化Schema也就是数据库类，Schema会实例化Table实现类，Table会实例化数据类。
                 * operand 动态参数，ScheamFactory的create方法会接收到这里的数据
                 * */
                String model = "{\"version\":\"1.0\",\"defaultSchema\":\"ops_dmp\",\"schemas\":[{\"name\":\"ops_dmp\",\"type\":\"custom\",\"factory\":\"org.apache.calcite.adapter.jdbc.JdbcSchema$Factory\",\"operand\":{" +
                        "\"jdbcDriver\": \"oracle.jdbc.driver.OracleDriver\",\n" +
                        "\"jdbcPassword\": \"Ufgov1234\",\n" +
                        "\"jdbcUrl\": \"jdbc:oracle:thin:@10.10.65.27:1521:orcl\",\n" +
                        "\"jdbcUser\": \"ops_dmp\"}}]}";
                Connection connection = DriverManager.getConnection("jdbc:calcite:model=inline:" + model);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select  code,name from common_user ");
                while (resultSet.next()) {
                    System.out.println("data => ");
                    System.out.println(resultSet.getObject("code"));
                    System.out.println(resultSet.getObject("name"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}