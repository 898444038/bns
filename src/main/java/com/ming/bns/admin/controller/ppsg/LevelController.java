package com.ming.bns.admin.controller.ppsg;

import com.ming.bns.admin.service.ppsg.LevelService;
import com.ming.bns.admin.vo.ppsg.LevelVo;
import com.ming.bns.admin.entity.ppsg.Level;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ming.bns.admin.aspect.log.Log;
import java.util.List;

/**
 * 等级表
 * @author: Administrator
 * @date: 2020-09-30
 */
@RestController
@RequestMapping("/ppsg/level")
public class LevelController {

    @Autowired
    private LevelService levelService;

    @Log("ppsg.Level")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(LevelVo levelVo){
        Pagination<Level> pagination = levelService.selectPage(levelVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    @Log("ppsg.Level")
    @GetMapping("/selectList")
    public ResultMsg selectList(LevelVo levelVo){
        return ResultMsg.success(levelService.selectList(levelVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    @Log("ppsg.Level")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(LevelVo levelVo){
        return ResultMsg.success(levelService.selectOne(levelVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    @Log("ppsg.Level")
    @PostMapping("/insert")
    public ResultMsg insert(Level level){
        if(level == null){
            return ResultMsg.failed();
        }
        int i = levelService.insert(level);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    @Log("ppsg.Level")
    @PostMapping("/update")
    public ResultMsg update(Level level){
        if(level == null || level.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = levelService.update(level);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-09-30
	 */
    @Log("ppsg.Level")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = levelService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
