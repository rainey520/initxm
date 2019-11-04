package com.ruoyi.project.factory.company.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.factory.company.domain.Company;
import com.ruoyi.project.factory.company.service.ICompanyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公司 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-10-31
 */
@Controller
@RequestMapping("/factory/company")
public class CompanyController extends BaseController
{
    private String prefix = "factory/company";
	
	@Autowired
	private ICompanyService companyService;
	
	@RequiresPermissions("factory:company:view")
	@GetMapping()
	public String company()
	{
	    return prefix + "/company";
	}
	
	/**
	 * 查询公司列表
	 */
	@RequiresPermissions("factory:company:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Company company)
	{
		startPage();
        List<Company> list = companyService.selectCompanyList(company);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出公司列表
	 */
	@RequiresPermissions("factory:company:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Company company)
    {
    	List<Company> list = companyService.selectCompanyList(company);
        ExcelUtil<Company> util = new ExcelUtil<Company>(Company.class);
        return util.exportExcel(list, "company");
    }
	
	/**
	 * 新增公司
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存公司
	 */
	@RequiresPermissions("factory:company:add")
	@Log(title = "公司", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Company company)
	{		
		return toAjax(companyService.insertCompany(company));
	}

	/**
	 * 修改公司
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Company company = companyService.selectCompanyById(id);
		mmap.put("company", company);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存公司
	 */
	@RequiresPermissions("factory:company:edit")
	@Log(title = "公司", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Company company)
	{		
		return toAjax(companyService.updateCompany(company));
	}
	
	/**
	 * 删除公司
	 */
	@RequiresPermissions("factory:company:remove")
	@Log(title = "公司", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(companyService.deleteCompanyByIds(ids));
	}

	/**
	 * 校验公司名称是否唯一
	 *
	 * @param company
	 * @return
	 */
	@PostMapping("/checkComNameUnique")
	@ResponseBody
	public String checkComNameUnique(Company company) {
		return companyService.checkComNameUnique(company);
	}
}
