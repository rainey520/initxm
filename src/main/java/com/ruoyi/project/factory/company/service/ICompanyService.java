package com.ruoyi.project.factory.company.service;

import com.ruoyi.project.factory.company.domain.Company;
import java.util.List;

/**
 * 公司 服务层
 * 
 * @author ruoyi
 * @date 2019-10-31
 */
public interface ICompanyService 
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
     * 删除公司信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCompanyByIds(String ids);

	/**
	 * 校验公司名称是否唯一
	 * @param company 公司信息
	 * @return 结果
	 */
    String checkComNameUnique(Company company);
}
