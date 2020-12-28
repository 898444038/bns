package com.ming.bns.admin.controller.sys;

import com.ming.bns.admin.entity.sys.User;
import com.ming.bns.admin.vo.sys.UserVo;
import com.ming.bns.admin.service.sys.UserService;

import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ming.bns.admin.aspect.log.Log;
import java.util.List;

/**
 * 用户表
 * @author: Administrator
 * @date: 2020-12-16
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Log("sys.User")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(UserVo userVo){
        Pagination<User> pagination = userService.selectPage(userVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-16
	 */
    @Log("sys.User")
    @GetMapping("/selectList")
    public ResultMsg selectList(UserVo userVo){
        return ResultMsg.success(userService.selectList(userVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-16
	 */
    @Log("sys.User")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(UserVo userVo){
        return ResultMsg.success(userService.selectOne(userVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-16
	 */
    @Log("sys.User")
    @PostMapping("/insert")
    public ResultMsg insert(User user){
        if(user == null){
            return ResultMsg.failed();
        }
        int i = userService.insert(user);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-16
	 */
    @Log("sys.User")
    @PostMapping("/update")
    public ResultMsg update(User user){
        if(user == null || user.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = userService.update(user);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-16
	 */
    @Log("sys.User")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = userService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
