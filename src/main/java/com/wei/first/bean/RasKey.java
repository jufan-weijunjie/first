package com.wei.first.bean;

/**
 * @ProjectName: all_my_use
 * @Package: com.wei.example.bean.ras
 * @Description: java类作用描述
 * @Author: 魏俊杰
 * @CreateDate: 2018/5/4 13:58
 * @UpdateUser: 魏俊杰
 * @Version: 1.0
 * Copyright: Copyright (c) 2018
 */
public class RasKey {
    /**主键自增id**/
    private Integer id;
    /**公钥**/
    private String strpk;
    /**私钥**/
    private String strprivk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStrpk() {
        return strpk;
    }

    public void setStrpk(String strpk) {
        this.strpk = strpk;
    }

    public String getStrprivk() {
        return strprivk;
    }

    public void setStrprivk(String strprivk) {
        this.strprivk = strprivk;
    }

    @Override
    public String toString() {
        return "RasKey{" +
                "id=" + id +
                ", strpk='" + strpk + '\'' +
                ", strprivk='" + strprivk + '\'' +
                '}';
    }
}
