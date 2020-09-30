package com.ming.bns.admin.service.impl.bns;

import com.ming.bns.admin.vo.bns.StatisticsItemVo;
import com.ming.bns.admin.mapper.bns.StatisticsItemMapper;
import com.ming.bns.admin.entity.bns.StatisticsItem;
import com.ming.bns.admin.service.bns.StatisticsItemService;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 统计项
 * @author: Administrator
 * @date: 2020-08-12
 */
@Service
public class StatisticsItemServiceImpl implements StatisticsItemService {

    @Resource
    private StatisticsItemMapper statisticsItemMapper;

	@Override
	public Pagination<StatisticsItem> selectPage(StatisticsItemVo statisticsItemVo) {
        Pagination<StatisticsItem> pagination = new Pagination<>();
        int count = statisticsItemMapper.selectCount(statisticsItemVo);
        List<StatisticsItem> list = statisticsItemMapper.selectPage(statisticsItemVo);
        pagination.setPageNo(statisticsItemVo.getPageNo());
        pagination.setPageSize(statisticsItemVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Override
    public List<StatisticsItem> selectList(StatisticsItemVo statisticsItemVo) {
        return statisticsItemMapper.selectList(statisticsItemVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Override
    public StatisticsItem selectOne(StatisticsItemVo statisticsItemVo) {
        return statisticsItemMapper.selectOne(statisticsItemVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Override
    public int insert(StatisticsItem statisticsItem) {
        return statisticsItemMapper.insert(statisticsItem);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Override
    public int update(StatisticsItem statisticsItem) {
        return statisticsItemMapper.update(statisticsItem);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-12
	 */
    @Override
    public int delete(Long id) {
        return statisticsItemMapper.delete(id);
    }
}
