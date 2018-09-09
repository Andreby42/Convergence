package com.convergence.domain.model;

import java.io.Serializable;
import java.util.Date;

import com.convergence.domain.ResourceDTO;


public class ResourceModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer reourceId;

	private Date createTime;

	private String description;

	private String icon;

	private Integer isHide;

	private Integer level;

	private String name;

	private Integer sort;

	private String sourceKey;

	private String sourceUrl;

	private Integer type;

	private Date updateTime;

	private Integer parentId;
	
	private ResourceModel parent;
	
	


	public ResourceModel getParent() {
		return parent;
	}

	public void setParent(ResourceModel parent) {
		this.parent = parent;
	}

	public Integer getReourceId() {
		return reourceId;
	}

	public void setReourceId(Integer reourceId) {
		this.reourceId = reourceId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getIsHide() {
		return isHide;
	}

	public void setIsHide(Integer isHide) {
		this.isHide = isHide;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getSourceKey() {
		return sourceKey;
	}

	public void setSourceKey(String sourceKey) {
		this.sourceKey = sourceKey;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
