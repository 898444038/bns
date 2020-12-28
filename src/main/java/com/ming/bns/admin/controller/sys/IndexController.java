package com.ming.bns.admin.controller.sys;

import com.ming.bns.admin.aspect.log.Log;
import com.ming.bns.admin.entity.sys.User;
import com.ming.bns.admin.service.sys.UserService;
import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import com.ming.bns.admin.vo.sys.UserVo;
import com.ming.bns.system.jwt.JwtUtils;
import com.ming.tools.sys.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author: Administrator
 * @date: 2020-12-16
 */
@RestController
@RequestMapping("/auth")
public class IndexController {

    @Autowired
    private UserService userService;

    @Log("sys.User")
	@PostMapping("/getToken")
    public ResultMsg getToken(@RequestBody UserVo userVo){
        if (StringUtils.isBlank(userVo.getEmail()) || StringUtils.isBlank(userVo.getPassword())){
            return ResultMsg.failed("用户名或密码不能为空");
        }
        userVo.setPassword(MD5Utils.md5(userVo.getPassword()));
        User user = userService.selectOne(userVo);
        if(user == null){
            return ResultMsg.failed("用户未注册");
        }
        return ResultMsg.success(JwtUtils.getToken(user));
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

}
