package model.subscription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JDBCUtil;

public class Order_suscriptionDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql_inclusion = "select product_set_number from product_set where soup_check='미포함' ORDER BY rand() LIMIT 1";
	String sql_exclusion = "select product_set_number from product_set where soup_check='포함' ORDER BY rand() LIMIT 1";
	String sql_insert = "insert into order_subscription values (null,?,?,now(),?,(select date_add(now(),interval 1 day)),(select date_add(now(),interval 31 day)),?)";
	String sql_selectOne = "select * from order_subscription where customer_id=?";
	String sql_selectProductSet = "select * from product_set where product_set_number=?";
	String sql_selectIsExist = "select * from order_subscription where customer_id=? and now() between ? and ?";

	public Product_setVO selectRandom(Order_subscriptionVO vo) {
		Product_setVO data = new Product_setVO();
		conn = JDBCUtil.connect();
		try {
			if (vo.getSoup_check().equals("미포함")) {
				// soup_check="미포함" 조건인 product_set_number 중 랜덤으로 1개의 번호 추출
				pstmt = conn.prepareStatement(sql_inclusion);
				rs = pstmt.executeQuery();
			} else {
				pstmt = conn.prepareStatement(sql_exclusion);
				rs = pstmt.executeQuery();
			}
			rs.next(); // 밥상 구독하기 버튼 클릭시 랜덤으로 생성된 product_number
			int product_set_number = rs.getInt("product_set_number");
			pstmt = conn.prepareStatement(sql_selectProductSet);
			pstmt.setInt(1, product_set_number);
			rs = pstmt.executeQuery();
			rs.next();
			data.setProduct_set_number(rs.getInt("product_set_number"));
			data.setProduct_set_1st(rs.getString("product_set_1st"));
			data.setProduct_set_2nd(rs.getString("product_set_2nd"));
			data.setProduct_set_3rd(rs.getString("product_set_3rd"));
			data.setProduct_set_4th(rs.getString("product_set_4th"));
			data.setSoup_check(rs.getString("soup_check"));
		} catch (SQLException e) {
			System.out.println("Order_supscriptionDAO의 selectRandom()에서 문제 발생!");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}

	public boolean insert(Order_subscriptionVO vo) { // 구독정보 Order_subscription 테이블에 입력
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setInt(2, vo.getProduct_set_number());
			pstmt.setString(1, vo.getCustomer_id());
			if (vo.getSoup_check().equals("미포함")) {
				pstmt.setInt(3, 190000);
			} else {
				pstmt.setInt(3, 220000); // 22만원으로 수정
			}
			pstmt.setString(4, vo.getSoup_check());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Order_supscriptionDAO의 insert()에서 문제 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}

	public Order_subscriptionVO selectOne(Order_subscriptionVO vo) { // customer_id를 통해 전체 Order_subscriptionVO 데이터 검색
		Order_subscriptionVO data = null;
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setString(1, vo.getCustomer_id());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				data = new Order_subscriptionVO();
				data.setSubscription_number(rs.getInt("subscription_number"));
				data.setProduct_set_number(rs.getInt("product_set_number"));
				data.setCustomer_id(rs.getString("customer_id"));
				data.setSubscription_date(rs.getString("subscription_date"));
				data.setSubscription_price(rs.getInt("subscription_price"));
				data.setStarting_date(rs.getString("starting_date"));
				data.setExpiration_date(rs.getString("expiration_date"));
				data.setSoup_check(rs.getString("soup_check"));
			}
		} catch (SQLException e) {
			System.out.println("Order_supscriptionDAO의 selectOne()에서 문제 발생!");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}

	public Product_setVO selectProductSet(Order_subscriptionVO vo) { // customer_id에 해당하는 밥상 번호를 통해 밥상정보 검색
		Product_setVO data = new Product_setVO();
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectProductSet);
			pstmt.setInt(1, vo.getProduct_set_number());
			rs = pstmt.executeQuery();
			rs.next();
			data.setProduct_set_number(rs.getInt("product_set_number"));
			data.setProduct_set_1st(rs.getString("product_set_1st"));
			data.setProduct_set_2nd(rs.getString("product_set_2nd"));
			data.setProduct_set_3rd(rs.getString("product_set_3rd"));
			data.setProduct_set_4th(rs.getString("product_set_4th"));
			data.setSoup_check(rs.getString("soup_check"));
		} catch (SQLException e) {
			System.out.println("Order_supscriptionDAO의 selectProductSet()에서 문제 발생!");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}

	// 구독 주문시 이미 구독 주문 테이블의 기간내에 다시 신청할 경우 신청 불가하도록
	public boolean selectIsExist(Order_subscriptionVO vo) {
		// 주문 날짜를 기준으로 만약 해당 기간내에 상품이 존재한다면 ? 주문이 불가하다 한뒤 세션에서 구독정보 없애준다
		conn = JDBCUtil.connect();

		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setString(1, vo.getCustomer_id());
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return false; // 상품을 주문한 기록이 없으면 주문 insert 실행
			}
			pstmt = conn.prepareStatement(sql_selectIsExist);
			pstmt.setString(1, vo.getCustomer_id());
			String starting_date = rs.getString("subscription_date");
			String expiration_date = rs.getString("expiration_date");
			System.out.println(starting_date + "~" + expiration_date);
			pstmt.setString(2, starting_date);
			pstmt.setString(3, expiration_date);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Order_supscriptionDAO의 selectIsExist()에서 문제 발생!");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return false;
	}
}
