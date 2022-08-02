// 本文件没有用上，创建 Schema 貌似没有效果（可能是内存数据库不行？有时间用文件数据库试下）。
// 不需要建表是因为貌似 jpa 会自动根据 @Entity 生成表？如果加上的话会重复
-- CREATE SCHEMA IF NOT EXISTS game_store; // 创建 schema
--
-- CREATE TABLE game_store.user_tbl
-- (
--     id       INTEGER      NOT NULL AUTO_INCREMENT,
--     username VARCHAR(128) NOT NULL,
--     password VARCHAR(128) NOT NULL,
--     PRIMARY KEY (id)
-- );