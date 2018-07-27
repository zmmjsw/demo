package com.test.demo.util;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName: PageResult
 * @Description: TODO(分页返回)
 * @author zhumingming
 * @date 2018年6月4日 下午4:18:07
 *
 */
@ApiModel(value="分页数据")
public class PageResult<T> {
	@ApiModelProperty(value="总条数")
	private Long total;
	@ApiModelProperty(value="信息列表")
	private List<T> rows;
	@ApiModelProperty(value="总页数")
	private Integer pages;
	
	

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	

	public PageResult(Long total, List<T> rows, Integer pages) {
		super();
		this.total = total;
		this.rows = rows;
		this.pages = pages;
	}

	public PageResult() {
		super();
	}

}
