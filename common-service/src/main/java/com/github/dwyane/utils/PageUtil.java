package com.github.dwyane.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * @ClassNanme: PageUtil
 * @Description: 分页工具类
 * @Author: xujinzhao
 * @Date: 2020/2/8 00:53
 */
public class PageUtil {

    /**
     * 降序
     */
    private static final String DESC = "descending";

    /**
     * 升序
     */
    private static final String ASC = "ascending";

    public static PageRequest Pageable(String pageNum, String pageSize, String sort, String order) {
        return PageRequest.of(Integer.parseInt(pageNum), Integer.parseInt(pageSize),
                order.equals(DESC) ? Sort.Direction.DESC : Sort.Direction.ASC, sort);
    }
}
