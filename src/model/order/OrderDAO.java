package model.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class OrderDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	String sql_insertS = "insert into order_single values (null,?,now())";
	String sql_insertD = "insert into order_detail values(null,(select max(single_number) from order_single),?,?)";
	String sql_selectAll = "select * from order_single order by single_number desc";
	String sql_selectSearch ="select * from order_single where single_number=?"; 
	String sql_delete = "delete from order_single where single_number=?"; //order_detail 테이블과 제약조건으로 묶여있기 때문에 상세주문도 같이 삭제 

	public boolean insert(OrderSet os) { //단품&상세 주문 데이터 입력
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insertS);
			pstmt.setString(1, os.getSingle().getCustomer_id());
			pstmt.executeUpdate();
			for (int i = 0; i < os.getDetails().size(); i++) {
				pstmt = conn.prepareStatement(sql_insertD);
				pstmt.setInt(1, os.getDetails().get(i).getProduct_number());
				pstmt.setInt(2, os.getDetails().get(i).getProduct_count());
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("OrderDAO의 insert()에서 문제 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public ArrayList<OrderSet> selectAll() { //전체 데이터 조회
		ArrayList<OrderSet> orders = new ArrayList<OrderSet>();
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderSet os = new OrderSet();
				Order_singleVO s = new Order_singleVO();
				ArrayList<Order_detailVO> details = new ArrayList<Order_detailVO>();
				s.setSingle_number(rs.getInt("single_number"));
				s.setCustomer_id(rs.getString("customer_id"));
				s.setSingle_date(rs.getString("single_date"));
				String sql = "select * from order_detail where single_number=? order by detail_number desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, s.getSingle_number());
				ResultSet rs2 = pstmt.executeQuery();
				while (rs2.next()) {
					Order_detailVO d = new Order_detailVO();
					d.setDetail_number(rs2.getInt("detatil_number"));
					d.setSingle_number(rs2.getInt("single_number"));
					d.setProduct_number(rs2.getInt("product_number"));
					d.setProduct_count(rs2.getInt("product_count"));
					details.add(d);
				}
				os.setSingle(s);
				os.setDetails(details);
				orders.add(os);
			}
		} catch (SQLException e) {
			System.out.println("OrderDAO selectAll()에서 문제발생!");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return orders;
	}
	
	public OrderSet selectSearch(int keyword) { //키워드(single_number)검색 단품&상세 주문 데이터 조회
		OrderSet order = new OrderSet();
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectSearch);
			pstmt.setInt(1,keyword);
			rs = pstmt.executeQuery();
			rs.next();
			Order_singleVO s = new Order_singleVO();
			ArrayList<Order_detailVO> details = new ArrayList<Order_detailVO>();
			s.setSingle_number(rs.getInt("single_number"));
			s.setCustomer_id(rs.getString("customer_id"));
			s.setSingle_date(rs.getString("single_date"));
			String sql = "select * from order_detail where single_number=? order by detail_number desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, s.getSingle_number());
			ResultSet rs2 = pstmt.executeQuery();
			while (rs2.next()) {
				Order_detailVO d = new Order_detailVO();
				d.setDetail_number(rs2.getInt("detatil_number"));
				d.setSingle_number(rs2.getInt("single_number"));
				d.setProduct_number(rs2.getInt("product_number"));
				d.setProduct_count(rs2.getInt("product_count"));
				details.add(d);
			}
			order.setSingle(s);
			order.setDetails(details);
		} catch (SQLException e) {
			System.out.println("OrderDAO selectSearch()에서 문제발생!");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return order;
	}
	
	public boolean delete(OrderSet os){ //단품&상세 주문 데이터 삭제
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setInt(1, os.getSingle().getSingle_number());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("OrderDAO delete()에서 문제발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
}
