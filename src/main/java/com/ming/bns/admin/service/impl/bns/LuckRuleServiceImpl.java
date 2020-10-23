package com.ming.bns.admin.service.impl.bns;

import com.ming.bns.admin.mapper.bns.LuckRuleMapper;
import com.ming.bns.admin.vo.bns.LuckRuleVo;
import com.ming.bns.admin.service.bns.LuckRuleService;
import com.ming.bns.admin.entity.bns.LuckRule;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 抽奖规则表
 * @author: Administrator
 * @date: 2020-10-23
 */
@Service
public class LuckRuleServiceImpl implements LuckRuleService {

    @Resource
    private LuckRuleMapper luckRuleMapper;

	@Override
	public Pagination<LuckRule> selectPage(LuckRuleVo luckRuleVo) {
        Pagination<LuckRule> pagination = new Pagination<>();
        int count = luckRuleMapper.selectCount(luckRuleVo);
        List<LuckRule> list = luckRuleMapper.selectPage(luckRuleVo);
        pagination.setPageNo(luckRuleVo.getPageNo());
        pagination.setPageSize(luckRuleVo.getPageSize());
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
    public List<LuckRule> selectList(LuckRuleVo luckRuleVo) {
        return luckRuleMapper.selectList(luckRuleVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Override
    public LuckRule selectOne(LuckRuleVo luckRuleVo) {
        return luckRuleMapper.selectOne(luckRuleVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Override
    public int insert(LuckRule luckRule) {
        return luckRuleMapper.insert(luckRule);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Override
    public int update(LuckRule luckRule) {
        return luckRuleMapper.update(luckRule);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Override
    public int delete(Long id) {
        return luckRuleMapper.delete(id);
    }
}
