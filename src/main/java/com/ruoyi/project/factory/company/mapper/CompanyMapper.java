package com.ruoyi.project.factory.company.mapper;

import com.ruoyi.project.factory.company.domain.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 公司 数据层
 * 
 * @author ruoyi
 * @date 2019-10-31
 */
public interface CompanyMapper 
{
	/**
     * 查询公司信息
     * 
     * @param id 公司ID
     * @return 公司信息
     */
	public Company selectCompanyById(Integer id);
	
	/**
     * 查询公司列表
     * 
     * @param company 公司信息
     * @return 公司集合
     */
	public List<Company> selectCompanyList(Company company);
	
	/**
     * 新增公司
     * 
     * @param company 公司信息
     * @return 结果
     */
	public int insertCompany(Company company);
	
	/**
     * 修改公司
     * 
     * @param company 公司信息
     * @return 结果
     */
	public int updateCompany(Company company);
	
	/**
     * 删除公司
     * 
     * @param id 公司ID
     * @return 结果
     */
	public int deleteCompanyById(Integer id);
	
	/**
     * 批量删除公司
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCompanyByIds(String[] ids);

	/**
	 * 通过公司名称查询公司信息
	 * @param comName 公司名称
	 * @return 结果
	 */
    Company selectCompanyByComName(@Param("comName") String comName);

}