/*
T_ROLE
*/
CREATE TABLE t_role (
  id        INT(20)     NOT NULL AUTO_INCREMENT
  COMMENT '编号',
  role_name VARCHAR(60) NOT NULL
  COMMENT '角色名称',
  note      VARCHAR(1024) COMMENT '备注',
  PRIMARY KEY (id)
);

/*

T_USER

 */
CREATE TABLE t_user (
  id        BIGINT(20)  NOT NULL AUTO_INCREMENT
  COMMENT '编号',
  user_name VARCHAR(60) NOT NULL
  COMMENT '用户名称',
  cnname    VARCHAR(60) NOT NULL
  COMMENT '姓名',
  sex       TINYINT(3)  NOT NULL
  COMMENT '性别',
  mobile    VARCHAR(20) NOT NULL
  COMMENT '手机号码',
  email     VARCHAR(60) COMMENT '电子邮件',
  note      VARCHAR(1024) COMMENT '备注',
  PRIMARY KEY (id)
);

/*
t_user_role
 */
CREATE TABLE t_user_role (
  user_id BIGINT(20) NOT NULL
  COMMENT '用户编号',
  role_id INT(20)    NOT NULL
  COMMENT '角色编号',
  PRIMARY KEY (user_id, role_id)
);

ALTER TABLE t_user_role
  ADD CONSTRAINT FK_Reference_1 FOREIGN KEY (user_id)
REFERENCES t_user (id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;

ALTER TABLE t_user_rule
  ADD CONSTRAINT FK_Reference_2 FOREIGN KEY (role_id)
REFERENCES t_role (id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;


/*

级联学生关系建表语句

*/
DROP TABLE IF EXISTS t_lecture;
DROP TABLE IF EXISTS t_studeng;
DROP TABLE IF EXISTS t_student_health_female;
DROP TABLE IF EXISTS t_studeng_health_male;
DROP TABLE IF EXISTS t_studeng_lecture;
DROP TABLE IF EXISTS t_studeng_selfcard;


/*

t_lecture

*/
CREATE TABLE t_lecture (
  id           INT(20)     NOT NULL AUTO_INCREMENT
  COMMENT '编号',
  lecture_name VARCHAR(60) NOT NULL
  COMMENT '课程名称',
  note         VARCHAR(1024) COMMENT '备注',
  PRIMARY KEY (id)
);

/*

t_student

*/
CREATE TABLE t_student (
  id          INT(20)     NOT NULL AUTO_INCREMENT
  COMMENT '编号',
  cnname      VARCHAR(60) NOT NULL
  COMMENT '姓名',
  sex         TINYINT(3)  NOT NULL
  COMMENT '性别',
  selfcard_no INT(20)     NOT NULL
  COMMENT '学生证号',
  note        VARCHAR(1024) COMMENT '备注',
  PRIMARY KEY (id)
);


/*

t_studeng_health_female

*/
CREATE TABLE t_studeng_health_female (
  id         INT(20)       NOT NULL AUTO_INCREMENT
  COMMENT '编号',
  student_id VARCHAR(60)   NOT NULL
  COMMENT '学生编号',
  check_date VARCHAR(60)   NOT NULL
  COMMENT '检查日期',
  heart      VARCHAR(60)   NOT NULL
  COMMENT '心',
  liver      VARCHAR(60)   NOT NULL
  COMMENT '肝',
  spleen     VARCHAR(60)   NOT NULL
  COMMENT '脾',
  lung       VARCHAR(60)   NOT NULL
  COMMENT '肺',
  kidney     VARCHAR(60)   NOT NULL
  COMMENT '肾',
  uterus     VARCHAR(60)   NOT NULL
  COMMENT '子宫',
  note       VARCHAR(1024) NOT NULL
  COMMENT '备注',
  PRIMARY KEY (id)
);

/*

t_studeng_health_male

*/
CREATE TABLE t_studeng_health_female (
  id         INT(20)       NOT NULL AUTO_INCREMENT
  COMMENT '编号',
  student_id VARCHAR(60)   NOT NULL
  COMMENT '学生编号',
  check_date VARCHAR(60)   NOT NULL
  COMMENT '检查日期',
  heart      VARCHAR(60)   NOT NULL
  COMMENT '心',
  liver      VARCHAR(60)   NOT NULL
  COMMENT '肝',
  spleen     VARCHAR(60)   NOT NULL
  COMMENT '脾',
  lung       VARCHAR(60)   NOT NULL
  COMMENT '肺',
  kidney     VARCHAR(60)   NOT NULL
  COMMENT '肾',
  prostate   VARCHAR(60)   NOT NULL
  COMMENT '前列腺',
  note       VARCHAR(1024) NOT NULL
  COMMENT '备注',
  PRIMARY KEY (id)
);

/*

t_studeng_lecture

*/
CREATE TABLE t_student_lecture (
  id         INT(20)        NOT NULL  AUTO_INCREMENT
  COMMENT '编号',
  student_id INT(20)        NOT NULL
  COMMENT '学生编号',
  lecture_id INT(20)        NOT NULL
  COMMENT '课程编号',
  grade      DECIMAL(16, 2) NOT NULL
  COMMENT '评分',
  note       VARCHAR(1024) COMMENT '备注',
  PRIMARY KEY (id)
);

/*

t_student_selfcard

*/

CREATE TABLE t_studeng_selfcard (
  id         INT(20)     NOT NULL  AUTO_INCREMENT
  COMMENT '编号',
  student_id INT(20)     NOT NULL
  COMMENT '学生编号',
  native     VARCHAR(60) NOT NULL
  COMMENT '籍贯',
  issue_date DATE        NOT NULL
  COMMENT '发证日期',
  end_date   DATE        NOT NULL
  COMMENT '结束日期',
  note       VARCHAR(1024) COMMENT '备注',
  PRIMARY KEY (id)
);