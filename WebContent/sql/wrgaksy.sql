SELECT * FROM product;

CREATE TABLE customer (			--고객정보
	customer_id			VARCHAR2(20)	CONSTRAINT PK_customer PRIMARY KEY,
	customer_password	VARCHAR2(20)	NOT NULL,
	customer_name		VARCHAR2(10)	NOT NULL,
	phone_number		VARCHAR2(20)	NOT NULL,
	ZIP_code			VARCHAR2(10)	NOT NULL,
	detailed_address	VARCHAR2(50)	NOT NULL
);

------------------------------------------------------------------------------------

CREATE TABLE board (			--신청게시판
	board_number		NUMBER			CONSTRAINT PK_board PRIMARY KEY,
	customer_id			VARCHAR2(20),
	board_date			DATE			NOT NULL,
	board_title			VARCHAR2(50)	NOT NULL,
	board_content		VARCHAR2(300)	NOT NULL,
	board_fav			NUMBER			DEFAULT 0,
	
	CONSTRAINTS FK_customer_TO_board FOREIGN KEY (customer_id) REFERENCES  customer (customer_id)
	ON DELETE SET NULL			--게시글 작성자가  회원 탈퇴해도 게시글 남아있음
);

------------------------------------------------------------------------------------

CREATE TABLE order_single (			--단품주문
	single_number		NUMBER			CONSTRAINT PK_ORDER_SINGLE PRIMARY KEY,
	customer_id			VARCHAR2(20)	NOT NULL,
	single_date			DATE			NOT NULL,
	
	CONSTRAINTS FK_customer_TO_single FOREIGN KEY (customer_id) REFERENCES  customer (customer_id)
	ON DELETE CASCADE			--고객 탈퇴시 주문 내역 삭제
);

------------------------------------------------------------------------------------

CREATE TABLE order_detail (			--상세주문
	detail_number		NUMBER			CONSTRAINT PK_ORDER_DETAIL PRIMARY KEY,
	single_number		NUMBER			NOT NULL,
	product_number		NUMBER			NOT NULL,
	product_count		NUMBER			DEFAULT 1,
	
	CONSTRAINTS CH_count CHECK (product_count > 0),			--주문 수량이 0이거나 음수일 수 없음
	
	CONSTRAINTS FK_single_TO_detail FOREIGN KEY (single_number) REFERENCES  order_single (single_number)
	ON DELETE CASCADE,			--단품 주문 내역 삭제시 그 안의 상세 주문 내역 삭제
	
	CONSTRAINTS FK_product_TO_detail FOREIGN KEY (product_number) REFERENCES  product (product_number)
	--고객이 주문한 상품은 삭제 불가능
);

------------------------------------------------------------------------------------

CREATE TABLE product (			--상품
	product_number		NUMBER			CONSTRAINT PK_PRODUCT PRIMARY KEY,
	product_name		VARCHAR2(50)	NOT NULL,
	product_price		NUMBER			NOT NULL,
	product_type		VARCHAR2(20)	NOT NULL,
	details				VARCHAR2(300)	NOT NULL,
	product_image		VARCHAR2(300)	NOT NULL,
	
	CONSTRAINTS CH_type CHECK (product_type IN('국','메인','반찬'))			--이 세 가지 외의 상품 분류는 없음
);

------------------------------------------------------------------------------------

CREATE TABLE order_subscription (			--구독주문
	subscription_number NUMBER			CONSTRAINT PK_ORDER_SUBSCRIPTION PRIMARY KEY,
	customer_id			VARCHAR2(20)	NOT NULL,
	product_set_number	NUMBER			NOT NULL,
	subscription_date	DATE			NOT NULL,
	subscription_price	NUMBER			DEFAULT 250000,
	starting_date		DATE			NOT NULL,
	expiration_date		DATE			NOT NULL,
	
	CONSTRAINTS FK_customer_TO_subscription FOREIGN KEY (customer_id) REFERENCES  customer (customer_id)
	ON DELETE CASCADE,			--고객 탈퇴시 주문 내역 삭제
	
	CONSTRAINTS FK_set_TO_subscription FOREIGN KEY (product_set_number) REFERENCES product_set (product_set_number)
	--고객이 주문한 상품은 삭제 불가능
);

------------------------------------------------------------------------------------

CREATE TABLE product_set (			--밥상
	product_set_number	NUMBER			CONSTRAINT PK_SET PRIMARY KEY,
	product_set_1st		VARCHAR2(300)	NOT NULL,
	product_set_2nd		VARCHAR2(300)	NOT NULL,
	product_set_3rd		VARCHAR2(300)	NOT NULL,
	product_set_4th		VARCHAR2(300)	NOT NULL,
	soup_check			VARCHAR2(20)    NOT NULL,
	
	CONSTRAINTS CH_soup CHECK (soup_check IN('포함','미포함'))
);

SELECT * FROM product;

DROP TABLE customer;
DROP TABLE board;
DROP TABLE order_single;
DROP TABLE order_detail;
DROP TABLE product;
DROP TABLE order_subscription;
DROP TABLE product_set;
