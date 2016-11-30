package com.brp.model.pageutil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> {
	private Integer page = 1;// 页码，默认是第一页
	private Integer size = 10;// 每页显示的记录数，默认是15
	private Integer count;// 总记录数
	private Integer pageCount;// 总页数
	private List<T> items;// 对应的当前页记录
	private Boolean isPage = true;
	private Map<String, Object> params = new HashMap<>();// 其他的参数我们把它分装成一个Map对象

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;

		int pageCount = count / size;
		if (count % size > 0)
			pageCount++;
		this.setPageCount(pageCount);
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public Boolean getIsPage() {
		return isPage;
	}

	public void setIsPage(Boolean isPage) {
		this.isPage = isPage;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
/*	@Override
	public String toString() {
		int lastItemIndex = page * size;
		if(lastItemIndex>count) lastItemIndex = count;
		return String.format("当前第%d-%d项 第%d/%d页 共%d项 每页显示%d项", (page - 1) * size + 1, lastItemIndex, page, pageCount,
				count, size);
	}*/
}
