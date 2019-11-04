package com.ruoyi.project.factory.company.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 公司表 tab_company
 * 
 * @author ruoyi
 * @date 2019-10-31
 */
public class Company extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 公司主键 */
	private Integer id;
	/** 公司名称 */
	private String comName;
	/** 公司地址 */
	private String comAddress;
	/** 创建时间 */
	private Date createTime;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setComName(String comName) 
	{
		this.comName = comName;
	}

	public String getComName() 
	{
		return comName;
	}
	public void setComAddress(String comAddress) 
	{
		this.comAddress = comAddress;
	}

	public String getComAddress() 
	{
		return comAddress;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("comName", getComName())
            .append("comAddress", getComAddress())
            .append("createTime", getCreateTime())
            .toString();
    }
}
