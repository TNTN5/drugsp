package com.drugsp.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DB_util {
	  private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	    private static final String URL="jdbc:mysql://localhost:3306/drug?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	    private static final String USERNAME="root";
	    private static final String PASSWORD="root";
	    //获取连接对象
	    private static Connection getConnection() {
	        Connection conn=null;
	        try {
	            Class.forName(DRIVER);
	            try {
	                conn= DriverManager.getConnection(URL, USERNAME, PASSWORD);
	                return conn;
	            } catch (SQLException e) {
	                System.out.println("连接失败");
	                e.printStackTrace();
	            }
	        } catch (ClassNotFoundException e) {
	            System.out.println("驱动注册失败");
	            e.printStackTrace();
	        }
	        return null;
	    }
	    //增删改
	    public  int Update(String sql ,Object[] obj){
	        Connection conn=null;
	        PreparedStatement ps=null;
	        try {
	            conn=getConnection();
	            ps=conn.prepareStatement(sql);
	            if (obj!=null) {
	                for (int i = 0; i < obj.length; i++) {
	                    ps.setObject(i+1, obj[i]);
	                }
	            }
	            return ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            closeDB(null, ps, conn);
	        }
	        return 0;
	    }
	    //查
	    public  List<Map<String, String>> select(String sql, Object[] obj) {
	        Connection conn=null;
	        PreparedStatement ps=null;
	        ResultSet rs=null;

            //将结果集放到List<Map<String, String>>中
            List<Map<String, String>> list=new ArrayList<Map<String,String>>();
	        try {
	            conn=getConnection();
	            ps=conn.prepareStatement(sql);
	            if (obj!=null) {
	                for (int i = 0; i < obj.length; i++) {
	                    ps.setObject(i+1, obj[i]);
	                }
	            }
	            rs= ps.executeQuery();
	            ResultSetMetaData rd=rs.getMetaData();			//获取结果集的表结构
	            while (rs.next()) {
	                Map<String, String> map=new LinkedHashMap<String, String>();
	                //ResultSetMetaData.getColumnCount();     获取表的列数
	                //ResultSetMetaData.getColumnName(int index);     根据索引获得列名
	                for (int i = 1; i <= rd.getColumnCount(); i++) {
	                    map.put(rd.getColumnName(i), rs.getString(i));
	                };
	                list.add(map);
	            }
	            return list;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            closeDB(rs, ps, conn);
	        }
	        return list;
	    }
	    //关闭资源
	    private static void closeDB(ResultSet rs, PreparedStatement ps, Connection conn) {
	        try {
	            if(rs!=null) {rs.close();}
	            if(ps!=null) {ps.close();}
	            if(conn!=null) {conn.close();}
	        } catch (SQLException e) {
	            System.out.println("资源关闭失败");
	        }
	    }
}
