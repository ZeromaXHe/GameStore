// 插入数据后，会导致单元测试中插入过程主键冲突。目前还没研究出原因
-- INSERT INTO user_tbl (id, username, password) VALUES (1, 'root', 'root');