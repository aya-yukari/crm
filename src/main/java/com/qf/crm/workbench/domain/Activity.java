package com.qf.crm.workbench.domain;

/**
 * @ClassName Activity
 * @Description: TODO
 * @Author chenyu
 * @Date 2020/12/29 10:00
 * @Version 1.0
 */
public class Activity {

    public String id; //主键
    public String owner; //所有者 外键 关联tbl_user
    public String name; //市场活动名称
    public String startDate; // 开始 年月日 10位
    public String endDate; // 结束日期 年月日 10位
    public String cost; // 成本
    public String description; // 描述
    public String createTime; // 创建时间 年月日 时分秒 19位
    public String createBy; // 创建人 
    public String editTime; // 修改时间   年月日 时分秒 19位
    public String editBy; //修改人

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"")
        .append(id).append('\"');
        sb.append(",\"owner\":\"")
        .append(owner).append('\"');
        sb.append(",\"name\":\"")
        .append(name).append('\"');
        sb.append(",\"startDate\":\"")
        .append(startDate).append('\"');
        sb.append(",\"endDate\":\"")
        .append(endDate).append('\"');
        sb.append(",\"cost\":\"")
        .append(cost).append('\"');
        sb.append(",\"description\":\"")
        .append(description).append('\"');
        sb.append(",\"createTime\":\"")
        .append(createTime).append('\"');
        sb.append(",\"createBy\":\"")
        .append(createBy).append('\"');
        sb.append(",\"editTime\":\"")
        .append(editTime).append('\"');
        sb.append(",\"editBy\":\"")
        .append(editBy).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
