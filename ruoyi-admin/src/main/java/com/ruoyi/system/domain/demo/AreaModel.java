package com.ruoyi.system.domain.demo;

public class AreaModel {
    /**
     * 编号
     */
    private Long id;

    /**
     * 父编号
     */
    private Long parentId;

    /**
     * 区域名称
     */
    private String areaName;

    /**
     * 区域代码
     */
    private String areaCode;

    /**
     * 名称首字母
     */
    private String simplePy;

    /**
     * 名称全拼
     */
    private String pinYin;

    /**
     * 是否有子节点（0无 1有）
     */
    private Integer isTreeLeaf = 1;

    public AreaModel() {

    }

    public AreaModel(int id, int parentId, String areaName, String areaCode, String simplePy, String pinYin, Integer isTreeLeaf) {
        this.id = Long.valueOf(id);
        this.parentId = Long.valueOf(parentId);
        this.areaName = areaName;
        this.areaCode = areaCode;
        this.simplePy = simplePy;
        this.pinYin = pinYin;
        this.isTreeLeaf = isTreeLeaf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getSimplePy() {
        return simplePy;
    }

    public void setSimplePy(String simplePy) {
        this.simplePy = simplePy;
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }

    public Integer getIsTreeLeaf() {
        return isTreeLeaf;
    }

    public void setIsTreeLeaf(Integer isTreeLeaf) {
        this.isTreeLeaf = isTreeLeaf;
    }
}
