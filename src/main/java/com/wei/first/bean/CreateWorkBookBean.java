package com.wei.first.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * FileName：创建普通的POI导入导出模板格式
 *
 * @author 魏俊杰
 * @date 14:05 2019/6/24
 */
public class CreateWorkBookBean implements Serializable {

    private Integer sheetIndex;

    private String sheetName;

    private Set<String> sheetTitle;

    private List<Object> sheetContent;

    public Integer getSheetIndex() {
        return sheetIndex;
    }

    public void setSheetIndex(Integer sheetIndex) {
        this.sheetIndex = sheetIndex;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public Set<String> getSheetTitle() {
        return sheetTitle;
    }

    public void setSheetTitle(Set<String> sheetTitle) {
        this.sheetTitle = sheetTitle;
    }

    public List<Object> getSheetContent() {
        return sheetContent;
    }

    public void setSheetContent(List<Object> sheetContent) {
        this.sheetContent = sheetContent;
    }

    public CreateWorkBookBean(Integer sheetIndex, String sheetName, Set<String> sheetTitle, List<Object> sheetContent) {
        this.sheetIndex = sheetIndex;
        this.sheetName = sheetName;
        this.sheetTitle = sheetTitle;
        this.sheetContent = sheetContent;
    }

    public CreateWorkBookBean() {
    }
}
