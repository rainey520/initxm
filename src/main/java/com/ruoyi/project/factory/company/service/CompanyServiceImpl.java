package com.ruoyi.project.factory.company.service;

import com.ruoyi.common.constant.CompanyConstants;
import com.ruoyi.common.support.Convert;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.factory.company.domain.Company;
import com.ruoyi.project.factory.company.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公司 服务层实现
 *
 * @author ruoyi
 * @date 2019-10-31
 */
@Service
public class CompanyServiceImpl implements ICompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    /**
     * 查询公司信息
     *
     * @param id 公司ID
     * @return 公司信息
     */
    @Override
    public Company selectCompanyById(Integer id) {
        return companyMapper.selectCompanyById(id);
    }

    /**
     * 查询公司列表
     *
     * @param company 公司信息
     * @return 公司集合
     */
    @Override
    public List<Company> selectCompanyList(Company company) {
        return companyMapper.selectCompanyList(company);
    }

    /**
     * 新增公司
     *
     * @param company 公司信息
     * @return 结果
     */
    @Override
    public int insertCompany(Company company) {
        return companyMapper.insertCompany(company);
    }

    /**
     * 修改公司
     *
     * @param company 公司信息
     * @return 结果
     */
    @Override
    public int updateCompany(Company company) {
        return companyMapper.updateCompany(company);
    }

    /**
     * 删除公司对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCompanyByIds(String ids) {
        return companyMapper.deleteCompanyByIds(Convert.toStrArray(ids));
    }

    /**
     * 校验公司名称是否存在
     *
     * @param company 公司信息
     * @return 结果
     */
    @Override
    public String checkComNameUnique(Company company) {
        if (StringUtils.isEmpty(company.getComName())) {
            return CompanyConstants.COM_NAME_NOT_UNIQUE;
        }
        Company companyInfo = companyMapper.selectCompanyByComName(company.getComName());
        if (!StringUtils.isNull(companyInfo) && !companyInfo.getId().equals(company.getId())) {
            return CompanyConstants.COM_NAME_NOT_UNIQUE;
        }
        return CompanyConstants.COM_NAME_UNIQUE;
    }
}
