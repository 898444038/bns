package com.ming.bns.admin.service.impl.bns;

import com.ming.bns.admin.vo.bns.UpdateLogVo;
import com.ming.bns.admin.service.bns.UpdateLogService;
import com.ming.bns.admin.entity.bns.UpdateLog;
import com.ming.bns.admin.mapper.bns.UpdateLogMapper;

import com.ming.bns.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 更新日志
 * @author: Administrator
 * @date: 2020-08-26
 */
@Service
public class UpdateLogServiceImpl implements UpdateLogService {

    @Resource
    private UpdateLogMapper updateLogMapper;

	@Override
	public Pagination<UpdateLog> selectPage(UpdateLogVo updateLogVo) {
        Pagination<UpdateLog> pagination = new Pagination<>();
        int count = updateLogMapper.selectCount(updateLogVo);
        List<UpdateLog> list = updateLogMapper.selectPage(updateLogVo);
        pagination.setPageNo(updateLogVo.getPageNo());
        pagination.setPageSize(updateLogVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    @Override
    public List<UpdateLog> selectList(UpdateLogVo updateLogVo) {
        return updateLogMapper.selectList(updateLogVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    @Override
    public UpdateLog selectOne(UpdateLogVo updateLogVo) {
        return updateLogMapper.selectOne(updateLogVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    @Override
    public int insert(UpdateLog updateLog) {
        return updateLogMapper.insert(updateLog);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    @Override
    public int update(UpdateLog updateLog) {
        return updateLogMapper.update(updateLog);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-26
	 */
    @Override
    public int delete(Long id) {
        return updateLogMapper.delete(id);
    }
}
