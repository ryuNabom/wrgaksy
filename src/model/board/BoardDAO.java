package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class BoardDAO {

    Connection conn = null;
    PreparedStatement pstmt = null;

    String sql_selectOne = "select * from board where board_number=?";
    String sql_selectAll = "select * from board order by board_number desc";
    String sql_selectSearch = "select * from board where board_title like ? or board_content like ? order by board_number desc";
    String sql_selectFav = "select * from board order by board_fav desc";
    String sql_selectMine = "select * from board where customer_id=? order by board_number desc";
    String sql_insert = "insert into board values (null,?,now(),?,?,0)";
    String sql_delete = "delete from board where board_number=?";
    String sql_update = "update board set board_fav = board_fav+1 where board_number=?";

    public BoardVO selectOne(BoardVO data) { //게시글 상세보기
        conn = JDBCUtil.connect();
        try {
            pstmt = conn.prepareStatement(sql_selectOne);
            pstmt.setInt(1,data.getBoard_number());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            BoardVO vo = new BoardVO();
            vo.setBoard_number(rs.getInt("board_number"));
            vo.setCustomer_id(rs.getString("customer_id"));
            vo.setBoard_date(rs.getString("board_date"));
            vo.setBoard_title(rs.getString("board_title"));
            vo.setBoard_content(rs.getString("board_content"));
            vo.setBoard_fav(rs.getInt("board_fav"));
            return vo;
        } catch (SQLException e) {
            System.out.println("BoardDAO의 selectOne()에서 문제 발생!");
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return null;
    }

    public ArrayList<BoardVO> selectAll() { //전체 데이터 조회
        conn = JDBCUtil.connect();
        ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
        try {
            pstmt = conn.prepareStatement(sql_selectAll);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                BoardVO vo = new BoardVO();
                vo.setBoard_number(rs.getInt("board_number"));
                vo.setCustomer_id(rs.getString("customer_id"));
                vo.setBoard_date(rs.getString("board_date"));
                vo.setBoard_title(rs.getString("board_title"));
                vo.setBoard_content(rs.getString("board_content"));
                vo.setBoard_fav(rs.getInt("board_fav"));
                System.out.println("dao : "+vo);
                datas.add(vo);
            }
        } catch (SQLException e) {
            System.out.println("BoardDAO의 SelectAll()에서 문제 발생!");
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return datas;
    }

    public ArrayList<BoardVO> selectSearch(String keyword) { //키워드 검색 결과 조회
        conn = JDBCUtil.connect();
        ArrayList<BoardVO> datas = new ArrayList<BoardVO>();

        try {
            pstmt = conn.prepareStatement(sql_selectSearch);
            pstmt.setString(1,"%"+keyword+"%");
            pstmt.setString(2,"%"+keyword+"%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                BoardVO vo = new BoardVO();
                vo.setBoard_number(rs.getInt("board_number"));
                vo.setCustomer_id(rs.getString("customer_id"));
                vo.setBoard_date(rs.getString("board_date"));
                vo.setBoard_title(rs.getString("board_title"));
                vo.setBoard_content(rs.getString("board_content"));
                vo.setBoard_fav(rs.getInt("board_fav"));
                datas.add(vo);
            }
        } catch (SQLException e) {
            System.out.println("BoardDAO의 SelectSearch()에서 문제 발생!");
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return datas;
    }

    public ArrayList<BoardVO> selectFav() { //좋아요 순으로 결과 조회
        conn = JDBCUtil.connect();
        ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
        try {
            pstmt = conn.prepareStatement(sql_selectFav);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                BoardVO vo = new BoardVO();
                vo.setBoard_number(rs.getInt("board_number"));
                vo.setCustomer_id(rs.getString("customer_id"));
                vo.setBoard_date(rs.getString("board_date"));
                vo.setBoard_title(rs.getString("board_title"));
                vo.setBoard_content(rs.getString("board_content"));
                vo.setBoard_fav(rs.getInt("board_fav"));
                datas.add(vo);
            }
        } catch (SQLException e) {
            System.out.println("BoardDAO의 SelectFav()에서 문제 발생!");
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return datas;
    }

    public ArrayList<BoardVO> selectMine(BoardVO vo) { //내가 작성한 글 조회
        conn = JDBCUtil.connect();
        ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
        try {
            pstmt = conn.prepareStatement(sql_selectMine);
            pstmt.setString(1,vo.getCustomer_id());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                BoardVO vo_re = new BoardVO();
                vo_re.setBoard_number(rs.getInt("board_number"));
                vo_re.setCustomer_id(rs.getString("customer_id"));
                vo_re.setBoard_date(rs.getString("board_date"));
                vo_re.setBoard_title(rs.getString("board_title"));
                vo_re.setBoard_content(rs.getString("board_content"));
                vo_re.setBoard_fav(rs.getInt("board_fav"));
                datas.add(vo_re);
            }
        } catch (SQLException e) {
            System.out.println("BoardDAO의 SelectMine()에서 문제 발생!");
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return datas;
    }

    public boolean insert(BoardVO vo) { //게시글 데이터 입력
        conn = JDBCUtil.connect();
        try {
            pstmt = conn.prepareStatement(sql_insert);
            pstmt.setString(1, vo.getCustomer_id());
            pstmt.setString(2, vo.getBoard_title());
            pstmt.setString(3, vo.getBoard_content());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("BoardDAO의 insert()에서 문제 발생!");
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return true;
    }

    public boolean delete(BoardVO vo) { //게시글 데이터 삭제
        conn = JDBCUtil.connect();
        try {
            pstmt = conn.prepareStatement(sql_delete);
            pstmt.setInt(1, vo.getBoard_number());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("BoardDAO의 delete()에서 문제 발생!");
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return true;
    }

    public boolean update(BoardVO vo) { //좋아요 +1 업데이트
        conn = JDBCUtil.connect();
        try {
            pstmt = conn.prepareStatement(sql_update);
            pstmt.setInt(1, vo.getBoard_number());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("BoardDAO의 update()에서 문제발생!");
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return true;
    }
}