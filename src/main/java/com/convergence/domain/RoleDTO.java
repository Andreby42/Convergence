package com.convergence.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RoleDTO implements Serializable {
    private Integer roleId;

    private Date createTime;

    private String description;

    private String name;

    private String roleKey;

    private Integer status;

    private Date updateTime;

    private List<ResourceDTO> resources;
    private static final long serialVersionUID = 1L;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
        this.description = description == null ? null : description.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey == null ? null : roleKey.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<ResourceDTO> getResources() {
        return resources;
    }

    public void setResources(List<ResourceDTO> resources) {
        this.resources = resources;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((resources == null) ? 0 : resources.hashCode());
        result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
        result = prime * result + ((roleKey == null) ? 0 : roleKey.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        RoleDTO other = (RoleDTO) obj;
        if (createTime == null) {
            if (other.createTime != null) return false;
        } else if (!createTime.equals(other.createTime)) return false;
        if (description == null) {
            if (other.description != null) return false;
        } else if (!description.equals(other.description)) return false;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;
        if (resources == null) {
            if (other.resources != null) return false;
        } else if (!resources.equals(other.resources)) return false;
        if (roleId == null) {
            if (other.roleId != null) return false;
        } else if (!roleId.equals(other.roleId)) return false;
        if (roleKey == null) {
            if (other.roleKey != null) return false;
        } else if (!roleKey.equals(other.roleKey)) return false;
        if (status == null) {
            if (other.status != null) return false;
        } else if (!status.equals(other.status)) return false;
        if (updateTime == null) {
            if (other.updateTime != null) return false;
        } else if (!updateTime.equals(other.updateTime)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "RoleDTO [roleId=" + roleId + ", createTime=" + createTime + ", description="
                + description + ", name=" + name + ", roleKey=" + roleKey + ", status=" + status
                + ", updateTime=" + updateTime + ", resources=" + resources + "]";
    }

}
