/**********************************/
/* Table Name: userinfo */
/**********************************/
CREATE TABLE userinfo(
		user_Id                       		VARCHAR2(20)		 NOT NULL,
		user_password                 		VARCHAR2(20)		 NOT NULL,
		user_name                     		VARCHAR2(20)		 NOT NULL,
		user_phone                    		VARCHAR2(20)		 NOT NULL,
		user_email                    		VARCHAR2(50)		 NOT N ULL,
		user_address                  		VARCHAR2(100)		 NULL 
);

COMMENT ON TABLE userinfo is 'userinfo';
COMMENT ON COLUMN userinfo.user_Id is 'user_Id';
COMMENT ON COLUMN userinfo.user_password is 'user_password';
COMMENT ON COLUMN userinfo.user_name is 'user_name';
COMMENT ON COLUMN userinfo.user_phone is 'user_phone';
COMMENT ON COLUMN userinfo.user_email is 'user_email';
COMMENT ON COLUMN userinfo.user_address is 'user_address';


/**********************************/
/* Table Name: category */
/**********************************/
CREATE TABLE category(
		category_no                   		NUMBER(10)		 NULL ,
		category_name                 		VARCHAR2(20)		 NOT NULL
);

COMMENT ON TABLE category is 'category';
COMMENT ON COLUMN category.category_no is 'category_no';
COMMENT ON COLUMN category.category_name is 'category_name';


/**********************************/
/* Table Name: product */
/**********************************/
CREATE TABLE product(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(50)		 NOT NULL,
		p_price                       		NUMBER(10)		 NOT NULL,
		p_image                       		VARCHAR2(100)		 DEFAULT defult		 NOT NULL,
		p_desc                        		VARCHAR2(300)		 NULL ,
		p_click_count                 		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		category_no                   		NUMBER(10)		 NULL 
);

CREATE SEQUENCE product_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

COMMENT ON TABLE product is 'product';
COMMENT ON COLUMN product.p_no is 'p_no';
COMMENT ON COLUMN product.p_name is 'p_name';
COMMENT ON COLUMN product.p_price is 'p_price';
COMMENT ON COLUMN product.p_image is 'p_image';
COMMENT ON COLUMN product.p_desc is 'p_desc';
COMMENT ON COLUMN product.p_click_count is 'p_click_count';
COMMENT ON COLUMN product.category_no is 'category_no';


/**********************************/
/* Table Name: orders */
/**********************************/
CREATE TABLE orders(
		o_no                          		NUMBER(10)		 NULL ,
		o_desc                        		VARCHAR2(100)		 NULL ,
		o_date                        		DATE		 DEFAULT sysdate		 NULL ,
		o_price                       		NUMBER(10)		 NULL ,
		user_Id                       		VARCHAR2(20)		 NULL 
);

COMMENT ON TABLE orders is 'orders';
COMMENT ON COLUMN orders.o_no is 'o_no';
COMMENT ON COLUMN orders.o_desc is 'o_desc';
COMMENT ON COLUMN orders.o_date is 'o_date';
COMMENT ON COLUMN orders.o_price is 'o_price';
COMMENT ON COLUMN orders.user_Id is 'user_Id';


/**********************************/
/* Table Name: order_item */
/**********************************/
CREATE TABLE order_item(
		oi_no                         		NUMBER(10)		 NULL ,
		oi_qty                        		NUMBER(10)		 NULL ,
		o_no                          		NUMBER(10)		 NULL ,
		p_no                          		NUMBER(10)		 NULL 
);

COMMENT ON TABLE order_item is 'order_item';
COMMENT ON COLUMN order_item.oi_no is 'oi_no';
COMMENT ON COLUMN order_item.oi_qty is 'oi_qty';
COMMENT ON COLUMN order_item.o_no is 'o_no';
COMMENT ON COLUMN order_item.p_no is 'p_no';


/**********************************/
/* Table Name: cart */
/**********************************/
CREATE TABLE cart(
		cart_no                       		NUMBER(10)		 NULL ,
		p_no                          		NUMBER(10)		 NULL ,
		cart_qty                      		NUMBER(10)		 DEFAULT 0		 NULL ,
		user_Id                       		VARCHAR2(20)		 NULL 
);

COMMENT ON TABLE cart is 'cart';
COMMENT ON COLUMN cart.cart_no is 'cart_no';
COMMENT ON COLUMN cart.p_no is 'p_no';
COMMENT ON COLUMN cart.cart_qty is 'cart_qty';
COMMENT ON COLUMN cart.user_Id is 'user_Id';


/**********************************/
/* Table Name: board */
/**********************************/
CREATE TABLE board(
		board_no                      		NUMBER(10)		 NULL ,
		board_title                   		VARCHAR2(100)		 NOT NULL,
		board_writer                  		VARCHAR2(20)		 NOT NULL,
		board_content                 		VARCHAR2(200)		 NOT NULL,
		board_regdate                 		DATE		 DEFAULT sysdate		 NULL ,
		board_readcount               		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		board_group_no                		NUMBER(10)		 NOT NULL,
		board_step                    		NUMBER(10)		 NOT NULL,
		board_depth                   		NUMBER(10)		 DEFAULT 0		 NULL ,
		user_Id                       		VARCHAR2(20)		 NULL 
);

CREATE SEQUENCE board_board_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE SEQUENCE board_board_depth_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

COMMENT ON TABLE board is 'board';
COMMENT ON COLUMN board.board_no is 'board_no';
COMMENT ON COLUMN board.board_title is 'board_title';
COMMENT ON COLUMN board.board_writer is 'board_writer';
COMMENT ON COLUMN board.board_content is 'board_content';
COMMENT ON COLUMN board.board_regdate is 'board_regdate';
COMMENT ON COLUMN board.board_readcount is 'board_readcount';
COMMENT ON COLUMN board.board_group_no is 'board_group_no';
COMMENT ON COLUMN board.board_step is 'board_step';
COMMENT ON COLUMN board.board_depth is 'board_depth';
COMMENT ON COLUMN board.user_Id is 'user_Id';


/**********************************/
/* Table Name: delivery */
/**********************************/
CREATE TABLE delivery(
		d_address                     		VARCHAR2(100)		 NULL ,
		d_phone                       		VARCHAR2(20)		 NULL ,
		d_name                        		VARCHAR2(20)		 NULL ,
		user_Id                       		VARCHAR2(20)		 NULL 
);

COMMENT ON TABLE delivery is 'delivery';
COMMENT ON COLUMN delivery.d_address is 'd_address';
COMMENT ON COLUMN delivery.d_phone is 'd_phone';
COMMENT ON COLUMN delivery.d_name is 'd_name';
COMMENT ON COLUMN delivery.user_Id is 'user_Id';


/**********************************/
/* Table Name: product_reply */
/**********************************/
CREATE TABLE product_reply(
		pr_no                         		NUMBER(10)		 NULL ,
		pr_content                    		VARCHAR2(200)		 NOT NULL,
		pr_regdate                    		DATE		 DEFAULT sysdate		 NULL ,
		pr_group_no                   		NUMBER(10)		 NOT NULL,
		pr_step                       		NUMBER(10)		 NOT NULL,
		pr_depth                      		NUMBER(10)		 DEFAULT 0		 NULL ,
		p_no                          		NUMBER(10)		 NULL ,
		user_Id                       		VARCHAR2(20)		 NULL 
);

COMMENT ON TABLE product_reply is 'product_reply';
COMMENT ON COLUMN product_reply.pr_no is 'pr_no';
COMMENT ON COLUMN product_reply.pr_content is 'pr_content';
COMMENT ON COLUMN product_reply.pr_regdate is 'pr_regdate';
COMMENT ON COLUMN product_reply.pr_group_no is 'pr_group_no';
COMMENT ON COLUMN product_reply.pr_step is 'pr_step';
COMMENT ON COLUMN product_reply.pr_depth is 'pr_depth';
COMMENT ON COLUMN product_reply.p_no is 'p_no';
COMMENT ON COLUMN product_reply.user_Id is 'user_Id';



ALTER TABLE userinfo ADD CONSTRAINT IDX_userinfo_PK PRIMARY KEY (user_Id);

ALTER TABLE category ADD CONSTRAINT IDX_category_PK PRIMARY KEY (category_no);

ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (p_no);
ALTER TABLE product ADD CONSTRAINT IDX_product_FK0 FOREIGN KEY (category_no) REFERENCES category (category_no);

ALTER TABLE orders ADD CONSTRAINT IDX_orders_PK PRIMARY KEY (o_no);
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK0 FOREIGN KEY (user_Id) REFERENCES userinfo (user_Id);

ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_PK PRIMARY KEY (oi_no);
ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_FK0 FOREIGN KEY (p_no) REFERENCES product (p_no);
ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_FK1 FOREIGN KEY (o_no) REFERENCES orders (o_no);

ALTER TABLE cart ADD CONSTRAINT IDX_cart_PK PRIMARY KEY (cart_no);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK0 FOREIGN KEY (p_no) REFERENCES product (p_no);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK1 FOREIGN KEY (user_Id) REFERENCES userinfo (user_Id);

ALTER TABLE board ADD CONSTRAINT IDX_board_PK PRIMARY KEY (board_no);
ALTER TABLE board ADD CONSTRAINT IDX_board_FK0 FOREIGN KEY (user_Id) REFERENCES userinfo (user_Id);

ALTER TABLE delivery ADD CONSTRAINT IDX_delivery_FK0 FOREIGN KEY (user_Id) REFERENCES userinfo (user_Id);

ALTER TABLE product_reply ADD CONSTRAINT IDX_product_reply_PK PRIMARY KEY (pr_no);
ALTER TABLE product_reply ADD CONSTRAINT IDX_product_reply_FK0 FOREIGN KEY (p_no) REFERENCES product (p_no);
ALTER TABLE product_reply ADD CONSTRAINT IDX_product_reply_FK1 FOREIGN KEY (user_Id) REFERENCES userinfo (user_Id);

