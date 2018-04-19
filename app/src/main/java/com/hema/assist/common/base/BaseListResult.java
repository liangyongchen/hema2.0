package com.hema.assist.common.base;

import com.hema.assist.common.network.ResultCode;

import java.util.List;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/3/2:上午11:49
 * Email: 656266591@qq.com Desc:
 */
public class BaseListResult<T> {
    private String message;
    private String code;
    private boolean sucess;
    private ListModel<T> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSucess() {
        return this.equals(ResultCode.RESULT_CODE_SUCCESS_00);
    }

    public ListModel<T> getData() {
        return data;
    }

    public void setData(ListModel<T> data) {
        this.data = data;
    }

    public class ListModel<E> {
        public PageModel getPage() {
            return page;
        }

        public void setPage(PageModel page) {
            this.page = page;
        }

        public List<E> getItems() {
            return items;
        }

        public void setItems(List<E> items) {
            this.items = items;
        }

        /**
         * 分页信息
         */
        private PageModel page;

        /**
         * 数据列表
         */
        private List<E> items;
    }

    public class PageModel {
        private int pageIndex;
        private int pageSize;
        private int totalCount;
        private int totalPage;

        public int getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(int pageIndex) {
            this.pageIndex = pageIndex;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public boolean enableLoadMore() {
            return pageIndex < totalPage;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }
    }
}
