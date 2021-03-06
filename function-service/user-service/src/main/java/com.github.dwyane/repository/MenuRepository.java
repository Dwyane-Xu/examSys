package com.github.dwyane.repository;

import com.github.dwyane.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassNanme: MenuRepository
 * @Description: 菜单repository
 * @Author: xujinzhao
 * @Date: 2020/2/16 16:01
 */
public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByIdIn(List<Long> ids);
}
