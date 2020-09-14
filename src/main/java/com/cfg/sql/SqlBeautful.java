package com.cfg.sql;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLDbTypedObject;
import com.alibaba.druid.util.DruidDataSourceUtils;
import com.alibaba.druid.util.JdbcUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @description: 描述
 * @author: chenfg
 * @time: 2020/9/3 16:10
 */
public class SqlBeautful {

    public static void main(String[] args) throws SQLException {
       String beautfulSql =  SQLUtils.format("select id, name as '姓名', age as '年龄', sex '性别', birthday from student s left join classroom c on s.classroom_id = c.id left join teacher t on s.chinese_id = t.id where s.name = 'a' ", "oracle");
        System.out.println(beautfulSql);

       //DataSource dataSource = initDruidDataSource();
        //通过druid jdbcUtil工具类执行查询
        //List<Map<String,Object>> result = JdbcUtils.executeQuery(conn,sql,paramList);
        //为sql添加条件
        //SQLUtils.addCondition();
        //获取分页sql
        //PagerUtils.limit()
        String sql = PagerUtils.limit("select * from common_user","oracle",1,10);
        System.out.println(sql);
        /*List<Map<String,Object>> result = JdbcUtils.executeQuery(dataSource,sql);
        for (Map<String, Object> stringObjectMap : result) {
            System.out.println(stringObjectMap);
        }*/

    }


    public static  DataSource initDruidDataSource() {
        String driverClassName="oracle.jdbc.driver.OracleDriver";
        String url="jdbc:oracle:thin:@10.10.65.27:1521:orcl";
        String username="ops_dmp";
        String password="Ufgov1234";
        String validationQuery="select 1 from dual";
        String dialect="org.hibernate.dialect.Oracle10gDialect";
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }


}