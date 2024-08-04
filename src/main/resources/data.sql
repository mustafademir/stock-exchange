INSERT INTO STOCKS (id, name, description, current_price)  VALUES(1,'Intel','Intel stock', 10.50);
INSERT INTO STOCKS (id, name, description, current_price)  VALUES(2,'test','example stock', 30.50);
INSERT INTO STOCK_EXCHANGES (id, name, description, live_in_market)  VALUES(1,'NASDAQ','NASDAQ stock exchange', true);
INSERT INTO STOCK_EXCHANGES (id, name, description, live_in_market)  VALUES(2,'test1','test1 stock exchange', true);
INSERT INTO STOCK_EXCHANGES (id, name, description, live_in_market)  VALUES(3,'test2','test2 stock exchange', true);

INSERT INTO STOCK_EXCHANGE_MAPPING VALUES(1,1);
INSERT INTO STOCK_EXCHANGE_MAPPING VALUES(2,1);
INSERT INTO STOCK_EXCHANGE_MAPPING VALUES(3,1);





