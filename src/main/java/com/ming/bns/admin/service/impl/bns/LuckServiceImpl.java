package com.ming.bns.admin.service.impl.bns;

import com.ming.bns.admin.service.bns.LuckService;
import com.ming.bns.admin.vo.bns.LuckVo;
import com.ming.bns.admin.mapper.bns.LuckMapper;
import com.ming.bns.admin.entity.bns.Luck;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 抽奖表
 * @author: Administrator
 * @date: 2020-10-23
 */
@Service
public class LuckServiceImpl implements LuckService {

    @Resource
    private LuckMapper luckMapper;

	@Override
	public Pagination<Luck> selectPage(LuckVo luckVo) {
        Pagination<Luck> pagination = new Pagination<>();
        int count = luckMapper.selectCount(luckVo);
        List<Luck> list = luckMapper.selectPage(luckVo);
        pagination.setPageNo(luckVo.getPageNo());
        pagination.setPageSize(luckVo.getPageSize());
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
    public List<Luck> selectList(LuckVo luckVo) {
        return luckMapper.selectList(luckVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Override
    public Luck selectOne(LuckVo luckVo) {
        return luckMapper.selectOne(luckVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Override
    public int insert(Luck luck) {
        return luckMapper.insert(luck);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Override
    public int update(Luck luck) {
        return luckMapper.update(luck);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Override
    public int delete(Long id) {
        return luckMapper.delete(id);
    }
}
