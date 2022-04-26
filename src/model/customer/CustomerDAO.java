package model.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JDBCUtil;

public class CustomerDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	int check;

	String sql_insert = "insert into customer values(?,?,?,?,?,?)";
	String sql_id_check = "select customer_id from customer where customer_id=?";
	String sql_selectOne = "select * from customer where customer_id=?";
	String sql_update = "update customer set customer_password=?, customer_name=?, phone_number=?, ZIP_code=?, detailed_address=? where customer_id=?";
	String sql_delete = "delete from customer where customer_id=? and customer_password=?";
	String sql_login_check = "select * from customer where customer_id=?";
	String sql_valid_pw = "select * from customer where customer_id=? and phone_number=?";
	String sql_valid_id = "select * from customer where customer_name=? and phone_number=?";
	String sql_updateTemp = "update customer set customer_password=? where customer_id=?";

	public String validationId(CustomerVO vo) { // 유효한 아이디가 있는지 찾기위한 DAO
		// 만약 id 가 존재한다면 id를 반환 아니라면 null
		String id = "";
		try {
			conn = JDBCUtil.connect();
			pstmt = conn.prepareStatement(sql_valid_id);
			pstmt.setString(1, vo.getCustomer_name());
			pstmt.setString(2, vo.getPhone_number());
			ResultSet rs = pstmt.executeQuery(); // 실행
			if (rs.next()) { // 만약 해당 결과가 있다면, id와 전화번호 둘다 일치한다면
				id = rs.getString("customer_id");
				return id;
			}
		} catch (SQLException e) {
			System.out.println("validationId() 문제발생");
			e.printStackTrace();
		}
		return null;
	}

	public boolean validationPw(CustomerVO vo) { // 임시 비밀번호를 위한 DAO
		try {
			conn = JDBCUtil.connect();
			pstmt = conn.prepareStatement(sql_valid_pw);
			pstmt.setString(1, vo.getCustomer_id());
			pstmt.setString(2, vo.getPhone_number());
			System.out.println(sql_valid_pw);
			ResultSet rs = pstmt.executeQuery(); // 실행
			if (rs.next()) { // 만약 해당 결과가 있다면, id와 전화번호 둘다 일치한다면
				return true;
			}
		} catch (SQLException e) {
			System.out.println("validationPw() 문제발생");
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateTemp(CustomerVO vo) { //정보수정
		try {
			conn = JDBCUtil.connect();
			pstmt = conn.prepareStatement(sql_updateTemp);
			pstmt.setString(1, vo.getCustomer_password());
			pstmt.setString(2, vo.getCustomer_id());
			if (pstmt.executeUpdate() >= 1) {
				// 만약 업데이트가 정상적으로 이루어졌다면
				return true;
			}
		} catch (Exception e) {
			System.out.println("정보 수정 문제발생");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return false;
	}

	public boolean insert(CustomerVO vo) { // 회원가입(c)
		try {
			conn = JDBCUtil.connect();
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getCustomer_id());
			pstmt.setString(2, vo.getCustomer_password());
			pstmt.setString(3, vo.getCustomer_name());
			pstmt.setString(4, vo.getPhone_number());
			pstmt.setString(5, vo.getZIP_code());
			pstmt.setString(6, vo.getDetailed_address());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("회원가입 문제발생");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public int id_check(CustomerVO vo) { // 아이디 중복 체크
		try {
			conn = JDBCUtil.connect();
			pstmt = conn.prepareStatement(sql_id_check);
			pstmt.setString(1, vo.getCustomer_id());
			rs = pstmt.executeQuery();

			if (rs.next()) { // 이미 존재하거나 아이디가 공백일때
				check = 0; // 같은 아이디 있음
			} else {
				check = 1; // 같은 아이디 없음
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("아이디 중복확인 문제발생");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return check;
	}

	public CustomerVO login_check(CustomerVO vo) { // 로그인체크
		CustomerVO data = null;
		try {
			conn = JDBCUtil.connect();
			pstmt = conn.prepareStatement(sql_login_check);
			pstmt.setString(1, vo.getCustomer_id());
			rs = pstmt.executeQuery();
			// rs에 데이터 없으면 로그인페이지 이동(아이디 없음)
			// pw비교 O→ 로그인완료 X→로그인페이지로 이동(패스워드 틀림)

			if (rs.next()) {
				if (vo.getCustomer_password().equals(rs.getString("customer_password"))) {
					data = new CustomerVO();
					data.setCustomer_id(rs.getString("customer_id"));
					data.setCustomer_name(rs.getString("customer_name"));
				}
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("로그인 문제발생");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}

	public CustomerVO selectOne(CustomerVO vo) { // 회원정보조회(r)
		CustomerVO data = null;
		try {
			conn = JDBCUtil.connect();
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setString(1, vo.getCustomer_id());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				data = new CustomerVO();
				data.setCustomer_id(rs.getString("customer_id"));
				data.setCustomer_password(rs.getString("customer_password"));
				data.setCustomer_name(rs.getString("customer_name"));
				data.setPhone_number(rs.getString("phone_number"));
				data.setZIP_code(rs.getString("ZIP_code"));
				data.setDetailed_address(rs.getString("detailed_address"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("회원정보 조회 문제발생");
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}

	public int update(CustomerVO vo) { // 정보수정(u)
		try {
			conn = JDBCUtil.connect();
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(6, vo.getCustomer_id());
			pstmt.setString(1, vo.getCustomer_password());
			pstmt.setString(2, vo.getCustomer_name());
			pstmt.setString(3, vo.getPhone_number());
			pstmt.setString(4, vo.getZIP_code());
			pstmt.setString(5, vo.getDetailed_address());
			check = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("정보 수정 문제발생");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return check;
	}

	public boolean delete(CustomerVO vo) { // 탈퇴(d)
		try {
			conn = JDBCUtil.connect();
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setString(1, vo.getCustomer_id());
			pstmt.setString(2, vo.getCustomer_password());
			check = pstmt.executeUpdate();
			if (check == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("탈퇴 문제발생");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return false;
	}
}
