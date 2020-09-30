package com.ming.bns.admin.service.impl.ppsg;

import com.ming.bns.admin.service.ppsg.LevelService;
import com.ming.bns.admin.mapper.ppsg.LevelMapper;
import com.ming.bns.admin.vo.ppsg.LevelVo;
import com.ming.bns.admin.entity.ppsg.Level;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 等级表
 * @author: Administrator
 * @date: 2020-09-30
 */
@Service
public class LevelServiceImpl implements LevelService {

    @Resource
    private LevelMapper levelMapper;

	@Override
	public Pagination<Level> selectPage(LevelVo levelVo) {
        Pagination<Level> pagination = new Pagination<>();
        int count = levelMapper.selectCount(levelVo);
        List<Level> list = levelMapper.selectPage(levelVo);
        pagination.setPageNo(levelVo.getPageNo());
        pagination.setPageSize(levelVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    @Override
    public List<Level> selectList(LevelVo levelVo) {
        return levelMapper.selectList(levelVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    @Override
    public Level selectOne(LevelVo levelVo) {
        return levelMapper.selectOne(levelVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    @Override
    public int insert(Level level) {
        return levelMapper.insert(level);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    @Override
    public int update(Level level) {
        return levelMapper.update(level);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    @Override
    public int delete(Long id) {
        return levelMapper.delete(id);
    }
}
