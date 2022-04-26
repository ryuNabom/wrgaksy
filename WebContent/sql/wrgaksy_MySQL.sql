show table status;

select * from product;
select * from customer;
select * from board;
select * from order_single;
select * from order_detail;

create table customer (	-- 고객정보
	customer_id				varchar(20)	primary key,
	customer_password	varchar(20)	not null,
	customer_name			varchar(10)	not null,
	phone_number			varchar(20)	not null,
	ZIP_code						varchar(10)	not null,
	detailed_address			varchar(50)	not null
);

------------------------------------------------------------------------------------

create table board (		-- 신청게시판
	board_number	INT						primary key auto_increment,
	customer_id		VARCHAR(20),
	board_date			DATE					not null,
	board_title			VARCHAR(50)		not null,
	board_content		VARCHAR(300)		not null,
	board_fav			INT						default 0,
	
	foreign key (customer_id) references customer (customer_id)
	on delete set null		-- 게시글 작성자가  회원 탈퇴해도 게시글 남아있음
);

------------------------------------------------------------------------------------

create table order_single (		-- 단품주문
	single_number	INT					primary key auto_increment,
	customer_id		VARCHAR(20)	not null,
	single_date			DATE				not null,
	
	foreign key (customer_id) references customer (customer_id)
	on delete cascade		-- 고객 탈퇴시 주문 내역 삭제
);

------------------------------------------------------------------------------------

create table order_detail (		-- 상세주문
	detail_number			INT	primary key auto_increment,
	single_number		INT	not null,
	product_number		INT	not null,
	product_count		INT	default 1,
	
	check (product_count > 0),			-- 주문 수량이 0이거나 음수일 수 없음
	
	foreign key (single_number) references order_single (single_number)
	on delete cascade,			-- 단품 주문 내역 삭제시 그 안의 상세 주문 내역 삭제
	
	foreign key (product_number) references product (product_number)
	-- 고객이 주문한 상품은 삭제 불가능
);

------------------------------------------------------------------------------------

create table product (	-- 상품
	product_number		INT						primary key auto_increment,
	product_name			VARCHAR(50)		not null,
	product_price			INT						not null,
	product_type			VARCHAR(20)		not null,
	details						VARCHAR(300)		not null,
	product_image		VARCHAR(300)		not null,
	
	check (product_type in('국','메인','반찬'))			-- 이 세 가지 외의 상품 분류는 없음
);

------------------------------------------------------------------------------------

create table order_subscription (		-- 구독주문
	subscription_number INT					primary key auto_increment,
	customer_id				VARCHAR(20)	not null,
	product_set_number	INT					not null,
	subscription_date		DATE				not null,
	subscription_price		INT					default 250000,
	starting_date				DATE				not null,
	expiration_date			DATE				not null,
	soup_check					VARCHAR(20)	not null,
	
	check (soup_check in('포함','미포함')),
	
	foreign key (customer_id) references customer (customer_id)
	on delete cascade,			-- 고객 탈퇴시 주문 내역 삭제
	
	foreign key (product_set_number) references product_set (product_set_number)
	-- 고객이 주문한 상품은 삭제 불가능
);

------------------------------------------------------------------------------------

create table product_set (		-- 밥상
	product_set_number	INT						primary key auto_increment,
	product_set_1st			VARCHAR(300)		not null,
	product_set_2nd			VARCHAR(300)		not null,
	product_set_3rd			VARCHAR(300)		not null,
	product_set_4th			VARCHAR(300)		not null,
	soup_check					VARCHAR(20)		not null,
	
	check (soup_check in('포함','미포함'))
);

drop table customer;
drop table board;
drop table order_single;
drop table order_detail;
drop table product;
drop table order_subscription;
drop table product_set;
