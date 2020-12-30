package com.qf.crm.workbench.domain;

/**
 * @ClassName ActivityRemark
 * @Description: TODO
 * @Author chenyu
 * @Date 2020/12/29 10:03
 * @Version 1.0
 */
public class ActivityRemark {

    public String id;
    public String noteContent; //备注信息
    public String createTime;
    public String createBy;
    public String editTime;
    public String editBy;
    public String editFlag; // 是否修改过的标记
    public String activityId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
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

    public String getEditFlag() {
        return editFlag;
    }

    public void setEditFlag(String editFlag) {
        this.editFlag = editFlag;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"")
        .append(id).append('\"');
        sb.append(",\"noteContent\":\"")
        .append(noteContent).append('\"');
        sb.append(",\"createTime\":\"")
        .append(createTime).append('\"');
        sb.append(",\"createBy\":\"")
        .append(createBy).append('\"');
        sb.append(",\"editTime\":\"")
        .append(editTime).append('\"');
        sb.append(",\"editBy\":\"")
        .append(editBy).append('\"');
        sb.append(",\"editFlag\":\"")
        .append(editFlag).append('\"');
        sb.append(",\"activityId\":\"")
        .append(activityId).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
