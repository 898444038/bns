package com.ming.bns.admin.service.impl.ppsg;

import com.ming.bns.admin.mapper.ppsg.GeneralsMapper;
import com.ming.bns.admin.service.ppsg.GeneralsService;
import com.ming.bns.admin.vo.ppsg.GeneralsVo;
import com.ming.bns.admin.entity.ppsg.Generals;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 武将表
 * @author: Administrator
 * @date: 2020-10-23
 */
@Service
public class GeneralsServiceImpl implements GeneralsService {

    @Resource
    private GeneralsMapper generalsMapper;

	@Override
	public Pagination<Generals> selectPage(GeneralsVo generalsVo) {
        Pagination<Generals> pagination = new Pagination<>();
        int count = generalsMapper.selectCount(generalsVo);
        List<Generals> list = generalsMapper.selectPage(generalsVo);
        pagination.setPageNo(generalsVo.getPageNo());
        pagination.setPageSize(generalsVo.getPageSize());
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
    public List<Generals> selectList(GeneralsVo generalsVo) {
        return generalsMapper.selectList(generalsVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Override
    public Generals selectOne(GeneralsVo generalsVo) {
        return generalsMapper.selectOne(generalsVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Override
    public int insert(Generals generals) {
        return generalsMapper.insert(generals);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Override
    public int update(Generals generals) {
        return generalsMapper.update(generals);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-10-23
	 */
    @Override
    public int delete(Long id) {
        return generalsMapper.delete(id);
    }
}
