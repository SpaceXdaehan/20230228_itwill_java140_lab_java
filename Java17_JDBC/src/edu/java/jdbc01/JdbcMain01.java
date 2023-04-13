package edu.java.jdbc01;

// JDK 클래스, 인터페이스
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Oracle JDBC 라이브러리 클래스
import oracle.jdbc.OracleDriver;

// OracleConnect 인터페이스에서 static로 선언된 모든 상수 이름들을 임포트.
import static edu.java.jdbc.oracle.OracleConnect.*;

/*
 * JDBC(Java Database Connectivity):
 * 자바 프로그램에서 데이터베이스를 연결하고, SQL 문장들을 실행하는 방법.
 * 
 * 1. Oracle JDBC 라이브러리를 다운로드하고 자바 프로젝트에 라이브러리를 포함.
 *    (1) 라이브러리 다운로드.
 *    (2) 이클립스 프로젝트 폴더에 lib 폴더 생성.
 *    (3) 다운로드한 라이브러리 jar 파일을 lib 폴더에 복사.
 *    (4) jar 파일을 프로젝트의 빌드 패스에 추가(Add to build path).
 * 2. 오라클 데이터베이스 서버에 접속하기 위한 정보들(URL, USER, PASSWORD)을 상수로 정의.
 * 3. 프로그램에서 오라클 JDBC 라이브러리를 사용할 수 있도록 드라이버 등록(라이브러리를 메모리 로딩).
 * 4. 데이터베이스 서버에 접속(Connection).
 * 5. Statement 타입 객체 생성.
 *    - DB 서버에서 실행할 SQL 문장을 작성, 실행하는 객체.
 * 6. Statement 객체의 메서드를 사용해서 SQL 문장을 DB 서버로 전송하고, 그 결과를 처리.
 *    - executeQuery(): DQL. select 문장.
 *    - executeUpdate(): DML. insert, update, delete 문장.
 * 7. 결과 처리 - 화면 출력.
 * 8. 사용했던 모든 리소스들(Connection, Statement)을 해제(close).
 */

public class JdbcMain01 {

    public static void main(String[] args) {
        
        Connection conn = null;
        Statement stmt = null;
        try {
            // 3. Oracle JDBC driver(라이브러리) 등록.
            DriverManager.registerDriver(new OracleDriver());
            System.out.println("오라클 드라이버 등록 성공");
            
            // 4. DB 서버에 접속
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("conn=" + conn);
            
            // 5. Statement 객체 생성.
            String sql = "select * from blogs"; // JDBC에서 SQL 문장은 세미콜론(;)을 사용하지 않음!
            stmt = conn.prepareStatement(sql);
            System.out.println("stmt=" + stmt);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제 - 리소스가 생성된 순서의 반대로 close를 호출.
            try {
                stmt.close();
                conn.close();
                System.out.println("오라클 DB 접속 해제 성공");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
