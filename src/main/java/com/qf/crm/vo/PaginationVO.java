package com.qf.crm.vo;

import java.util.List;

/**
 * @ClassName PaginationVO
 * @Description: TODO
 * @Author chenyu
 * @Date 2020/12/30 11:58
 * @Version 1.0
 */
public class PaginationVO<T> {
    
    private int total;
    private List<T> dataList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"total\":")
        .append(total);
        sb.append(",\"dataList\":")
        .append(dataList);
        sb.append('}');
        return sb.toString();
    }
}
