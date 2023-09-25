package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        // 자동임포트 : alt + enter
        Connection conn = null; // DB 접속하는 객체
        Statement stmt = null; // SQL 전송하는 객체
        ResultSet rs = null; // 결과 받아오는 객체

        String url = "jdbc:mysql://localhost:3306/board?serverTimezone=UTC";
        String user = "root";
        String pass = "";


        try {
            // 1. 드라이버 세팅
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connection 획득
            conn = DriverManager.getConnection(url, user, pass);

            //3. Statement 생성
            stmt = conn.createStatement();

//            System.out.println("3번까지 문제 없이 실행");

            //4. SQL 처리하고 결과 ResultSet에 받아오기
            String sql = "SELECT * FROM article";
            rs = stmt.executeQuery(sql);

            rs.next(); // 화살표를 한칸 내림.

            // 첫번재 행의 id 꺼내오기
            int id = rs.getInt("id");
            System.out.println("첫번째 행의 id : " + id);

            // 첫번째 행의 title 꺼내오기.
            String title = rs.getString("title");
            System.out.println("첫번째 행의 title : " + title);

            // 두번째 행의 title 꺼내오기.
            rs.next(); // 화살표 한칸 내림
            String title2 = rs.getString("title");
            System.out.println("두번째 행의 title : " + title2);

            // 세번째 행의 content 꺼내오기

//            while(rs.next()) {
//                System.out.println(rs.getString("title"));
//                System.out.println(rs.getString("content")); // 문자열로 리턴
//                System.out.println(rs.getInt("id")); // 문자열로 리턴
//                System.out.println("========================");
//            }

        } catch(Exception e) {
            System.out.println("접속 시도중 문제 발생!!");
        }
    }
}