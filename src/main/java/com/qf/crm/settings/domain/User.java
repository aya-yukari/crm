package com.qf.crm.settings.domain;

/**
 * @ClassName User
 * @Description: TODO
 * @Author chenyu
 * @Date 2020/12/26 10:33
 * @Version 1.0
 */
public class User {

    /* 
        关于字符串中表现的日期及时间
        我们在市场上常用的有两种方式
        日期: 年月日
                yyyy-MM-dd 10位字符串
                
        日期+时间: 年月日时分秒  19为字符串
                   yyyy-MM-dd HH:mm:ss                               
            
     */
    
    /* 
        
        关于登陆
            验证账号和密码
            User user = 执行sql语句select * from tbl_user where loginAct=? and loginPwd=?
            mvc思想业务层在处理业务逻辑的时候遇到与数据库交互的时候要过dao层
            
            user对象null， 说明账号密码错误            
            
            如果user对象不为null，说明账号密码错误            
            
            需要继续向下验证其他的字段信息
            
            从user中get到
            
            expireTime 验证失效时间
            lockState 验证锁定状态
            allowIps 验证浏览器端的ip地址是否有效
            
            
        
     */
    
    public String id;   //编号 主键
    public String loginAct;   //登陆账号
    public String name;   //用户真实姓名
    public String loginPwd;   //登陆密码
    public String email;   //邮箱
    public String expireTime;   //失效时间 19位
    public String lockState;   //锁定状态 0: 锁定  1: 启用
    public String deptno;   //部门编号
    public String allowIps;   //允许访问的ip地址
    public String createTime;   //创建时间 19位
    public String createBy;   //创建人
    public String editTime;   //修改时间 19位
    public String editBy;   //修改人


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginAct() {
        return loginAct;
    }

    public void setLoginAct(String loginAct) {
        this.loginAct = loginAct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getLockState() {
        return lockState;
    }

    public void setLockState(String lockState) {
        this.lockState = lockState;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getAllowIps() {
        return allowIps;
    }

    public void setAllowIps(String allowIps) {
        this.allowIps = allowIps;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy;
    }
}
