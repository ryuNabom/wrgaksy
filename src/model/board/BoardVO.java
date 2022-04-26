package model.board;

public class BoardVO {
	private int board_number;
	private String customer_id;
	private String board_date;
	private String board_title;
	private String board_content;
	private int board_fav;

	public int getBoard_number() {
		return board_number;
	}

	public void setBoard_number(int board_number) {
		this.board_number = board_number;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getBoard_date() {
		return board_date;
	}

	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public int getBoard_fav() {
		return board_fav;
	}

	public void setBoard_fav(int board_fav) {
		this.board_fav = board_fav;
	}

	@Override
	public String toString() {
		return "BoardVO [board_number=" + board_number + ", customer_id=" + customer_id + ", board_date=" + board_date
				+ ", board_title=" + board_title + ", board_content=" + board_content + ", board_fav=" + board_fav
				+ "]";
	}
}