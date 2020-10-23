package com.ming.bns.admin.service.impl.bns;

import com.ming.bns.admin.vo.bns.LuckItemVo;
import com.ming.bns.admin.entity.bns.LuckItem;
import com.ming.bns.admin.mapper.bns.LuckItemMapper;
import com.ming.bns.admin.service.bns.LuckItemService;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 抽奖项表
 * @author: Administrator
 * @date: 2020-10-23
 */
@Service
public class LuckItemServiceImpl implements LuckItemService {

    @Resource
    private LuckItemMapper luckItemMapper;

	@Override
	public Pagination<LuckItem> selectPage(LuckItemVo luckItemVo) {
        Pagination<LuckItem> pagination = new Pagination<>();
        int count = luckItemMapper.selectCount(luckItemVo);
        List<LuckItem> list = luckItemMapper.selectPage(luckItemVo);
        pagination.setPageNo(luckItemVo.getPageNo());
        pagination.setPageSize(luckItemVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Override
    public List<LuckItem> selectList(LuckItemVo luckItemVo) {
        return luckItemMapper.selectList(luckItemVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Override
    public LuckItem selectOne(LuckItemVo luckItemVo) {
        return luckItemMapper.selectOne(luckItemVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Override
    public int insert(LuckItem luckItem) {
        return luckItemMapper.insert(luckItem);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Override
    public int update(LuckItem luckItem) {
        return luckItemMapper.update(luckItem);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Override
    public int delete(Long id) {
        return luckItemMapper.delete(id);
    }
}
