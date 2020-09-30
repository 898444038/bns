package com.ming.bns.admin.controller.bns;

import com.ming.bns.admin.aspect.log.Log;
import com.ming.bns.admin.utils.Pagination;
import com.ming.bns.admin.utils.ResultMsg;
import com.ming.bns.admin.vo.bns.MaterialVo;
import com.ming.bns.admin.service.bns.MaterialService;
import com.ming.bns.admin.entity.bns.Material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * 材料
 * @author: Administrator
 * @date: 2020-07-16
 */
@RestController
@RequestMapping("/bns/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

	/**
	 * 查询分页列表
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
	@Log("Material")
	@GetMapping("/selectPage")
	public ResultMsg selectPage(MaterialVo materialVo){
		Pagination<Material> materialList = materialService.selectPage(materialVo);
		return ResultMsg.success(materialList);
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
	@Log("Material")
    @GetMapping("/selectList")
    public ResultMsg selectList(MaterialVo materialVo){
		materialVo.setDelFlag(false);
        return ResultMsg.success(materialService.selectList(materialVo));
    }

	@Log("Material")
	@GetMapping("/simpleList")
	public ResultMsg simpleList(MaterialVo materialVo){
		materialVo.setDelFlag(false);
		List<Material> list = materialService.simpleList(materialVo);

		materialVo = new MaterialVo();
		materialVo.setDelFlag(false);
		materialVo.setName("炽热白青封印符");

		List<Material> list2 = materialService.simpleList(materialVo);
		Material fyf = new Material();
		if(list2!=null && list2.size()>0){
			fyf = list2.get(0);
		}
		Map<String,Object> map = new HashMap<>();
		map.put("list",list);
		map.put("fyf",fyf);
		return ResultMsg.success(map);
	}

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
	@Log("Material")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(MaterialVo materialVo){
        return ResultMsg.success(materialService.selectOne(materialVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
	@Log("Material")
    @PostMapping("/insert")
    public ResultMsg insert(Material material){
    	if(material == null){
    		return ResultMsg.failed();
		}
		material.setCreateTime(new Date());
    	material.setDelFlag(false);
		int i = materialService.insert(material);
    	if(i>0){
			return ResultMsg.success();
		}
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
	@Log("Material")
    @PostMapping("/update")
    public ResultMsg update(Material material){
    	if(material == null || material.getId() == null){
			return ResultMsg.failed("ID不能为空！");
		}
        int i = materialService.update(material);
		if(i>0){
			return ResultMsg.success();
		}
		return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-07-16
	 */
	@Log("Material")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
		if(id == null){
			return ResultMsg.failed("ID不能为空！");
		}
		MaterialVo materialVo = new MaterialVo();
		materialVo.setId(id);
		materialVo.setDelFlag(true);
        int i = materialService.update(materialVo);
		if(i>0){
			return ResultMsg.success();
		}
		return ResultMsg.failed();
    }

    private void init(){
    	List<Material> list = new ArrayList<>();
    	list.add(new Material("极龙手镯1段(剑士)",new BigDecimal("0"),8));
    	list.add(new Material("极龙手镯1段(拳师)",new BigDecimal("943"),8));
    	list.add(new Material("极龙手镯1段(召唤)",new BigDecimal("822"),8));
    	list.add(new Material("极龙手镯1段(气功)",new BigDecimal("0"),8));
    	list.add(new Material("极龙手镯1段(力士)",new BigDecimal("2588"),8));
    	list.add(new Material("极龙手镯1段(刺客)",new BigDecimal("0"),8));
    	list.add(new Material("极龙手镯1段(灵剑士)",new BigDecimal("690"),8));
    	list.add(new Material("极龙手镯1段(咒术)",new BigDecimal("0"),8));
    	list.add(new Material("极龙手镯1段(气宗)",new BigDecimal("0"),8));
    	list.add(new Material("极龙手镯1段(枪手)",new BigDecimal("1988"),8));
    	list.add(new Material("极龙手镯1段(斗士)",new BigDecimal("0"),8));
    	list.add(new Material("极龙手镯1段(弓手)",new BigDecimal("988"),8));

		list.add(new Material("极虎手镯1段(剑士)",new BigDecimal("0"),8));
		list.add(new Material("极虎手镯1段(拳师)",new BigDecimal("0"),8));
		list.add(new Material("极虎手镯1段(召唤)",new BigDecimal("780"),8));
		list.add(new Material("极虎手镯1段(气功)",new BigDecimal("0"),8));
		list.add(new Material("极虎手镯1段(力士)",new BigDecimal("2588"),8));
		list.add(new Material("极虎手镯1段(刺客)",new BigDecimal("2588"),8));
		list.add(new Material("极虎手镯1段(灵剑士)",new BigDecimal("952"),8));
		list.add(new Material("极虎手镯1段(咒术)",new BigDecimal("2588"),8));
		list.add(new Material("极虎手镯1段(气宗)",new BigDecimal("999"),8));
		list.add(new Material("极虎手镯1段(枪手)",new BigDecimal("0"),8));
		list.add(new Material("极虎手镯1段(斗士)",new BigDecimal("1200"),8));
		list.add(new Material("极虎手镯1段(弓手)",new BigDecimal("0"),8));

//		list.add(new Material("三光手镯1段",new BigDecimal(""),6));
//		list.add(new Material("三天手镯1段",new BigDecimal(""),6));
//		list.add(new Material("梵天手镯1段",new BigDecimal(""),4));
//		list.add(new Material("阎魔手镯1段",new BigDecimal(""),4));
//		list.add(new Material("梵天手镯12段",new BigDecimal(""),18));
//		list.add(new Material("阎魔手镯12段",new BigDecimal(""),18));

		list.add(new Material("苦痛破天魂1段",new BigDecimal("430"),4));
		list.add(new Material("毁灭破天魂1段",new BigDecimal("487"),4));
		list.add(new Material("苦痛建元魂1段",new BigDecimal("398"),4));
		list.add(new Material("毁灭建元魂1段",new BigDecimal("387"),4));
		list.add(new Material("苦痛泰云魂1段",new BigDecimal("440"),12));
    	list.add(new Material("毁灭泰云魂1段",new BigDecimal("540"),12));
		list.add(new Material("苦痛天乾魂1段",new BigDecimal("400"),6));
		list.add(new Material("毁灭天乾魂1段",new BigDecimal("450"),6));
		list.add(new Material("苦痛梦幻魂1段",new BigDecimal("743"),12));
		list.add(new Material("毁灭梦幻魂1段",new BigDecimal("850"),12));
		list.add(new Material("苦痛南天魂1段",new BigDecimal("810"),12));
		list.add(new Material("毁灭南天魂1段",new BigDecimal("3230"),12));

		list.add(new Material("白鹿灵1段",new BigDecimal("280"),4));
		list.add(new Material("凤凰灵1段",new BigDecimal("285"),4));
		list.add(new Material("黄龙灵1段",new BigDecimal("3400"),0));

		list.add(new Material("雷龙星1段",new BigDecimal("370"),6));
		//list.add(new Material("晨晖星1段",new BigDecimal("880"),6));
		list.add(new Material("金雷星1段",new BigDecimal("1765"),0));

		list.add(new Material("齐天手套1段",new BigDecimal("810"),0));
		list.add(new Material("银河手套1段",new BigDecimal("1888"),12));
		list.add(new Material("铁腕手套1段",new BigDecimal("297"),12));
		list.add(new Material("斩杀手套1段",new BigDecimal("279"),2));
		list.add(new Material("帝王手套8段",new BigDecimal("930"),10));
		list.add(new Material("帝王手套1段",new BigDecimal("148"),2));
		list.add(new Material("帝王手套12段",new BigDecimal("1600"),26));
		list.add(new Material("天佑手套1段",new BigDecimal("677"),12));

		list.add(new Material("神山腰带1段",new BigDecimal("1396"),0));
    	list.add(new Material("狂天腰带1段",new BigDecimal("499"),12));
		list.add(new Material("圣天腰带1段",new BigDecimal("285"),6));
		list.add(new Material("永恒腰带8段",new BigDecimal("800"),0));
		list.add(new Material("永恒腰带1段",new BigDecimal("96"),18));
		list.add(new Material("永恒腰带12段",new BigDecimal("0"),24));



//    	list.add(new Material("邪花耳环1段",new BigDecimal("0"),12));
//    	list.add(new Material("邪花项链1段",new BigDecimal("0"),12));
//    	list.add(new Material("暗海戒指1段",new BigDecimal("0"),12));
//    	list.add(new Material("泰天耳环1段",new BigDecimal("0"),12));
//    	list.add(new Material("泰天项链1段",new BigDecimal("0"),12));


//    	list.add(new Material("烛魔戒指1段",new BigDecimal(""),2));
//    	list.add(new Material("烛魔耳环1段",new BigDecimal(""),2));
//    	list.add(new Material("烛魔项链1段",new BigDecimal(""),2));
//    	list.add(new Material("烛魔戒指8段",new BigDecimal(""),5));
//    	list.add(new Material("烛魔耳环8段",new BigDecimal(""),5));
//    	list.add(new Material("烛魔项链8段",new BigDecimal(""),5));
//		list.add(new Material("烛魔戒指12段",new BigDecimal(""),8));
//		list.add(new Material("烛魔耳环12段",new BigDecimal(""),8));
//		list.add(new Material("烛魔项链12段",new BigDecimal(""),8));
//		list.add(new Material("烛魔武器1段",new BigDecimal(""),2));
//		list.add(new Material("烛魔武器8段",new BigDecimal(""),8));
//		list.add(new Material("烛魔武器12段",new BigDecimal(""),20));
//		list.add(new Material("烛魔武器15段",new BigDecimal(""),47));
//		list.add(new Material("昆仑元气石1段",new BigDecimal(""),2));
//		list.add(new Material("光辉真气石1段",new BigDecimal(""),3));
//		list.add(new Material("光辉真气石10段",new BigDecimal(""),7));
//		list.add(new Material("昆仑武器1段",new BigDecimal(""),5));
//		list.add(new Material("昆仑武器8段",new BigDecimal(""),18));
//		list.add(new Material("昆仑武器12段",new BigDecimal(""),43));
//		list.add(new Material("昆仑元气石1段",new BigDecimal(""),5));
//		list.add(new Material("昆仑元气石8段",new BigDecimal(""),13));
//		list.add(new Material("昆仑元气石12段",new BigDecimal(""),30));
//		list.add(new Material("光辉真气石10段",new BigDecimal(""),20));
//		list.add(new Material("光辉真气石20段",new BigDecimal(""),36));
//
//		list.add(new Material("青木戒指1段",new BigDecimal(""),2));
//		list.add(new Material("青木戒指8段",new BigDecimal(""),10));
//		list.add(new Material("青木戒指12段",new BigDecimal(""),26));
//
//		list.add(new Material("黑风耳环1段",new BigDecimal(""),2));
//		list.add(new Material("黑风耳环8段",new BigDecimal(""),10));
//		list.add(new Material("黑风耳环12段",new BigDecimal(""),26));
//
//		list.add(new Material("黑风项链1段",new BigDecimal(""),2));
//		list.add(new Material("黑风项链8段",new BigDecimal(""),10));
//		list.add(new Material("黑风项链12段",new BigDecimal(""),26));



//		list.add(new Material("泰天武器1段",new BigDecimal(""),30));





//		list.add(new Material("赤星戒指1段",new BigDecimal(""),2));
//		list.add(new Material("黑星耳环1段",new BigDecimal(""),2));
//		list.add(new Material("黑星项链1段",new BigDecimal(""),2));
//		list.add(new Material("赤星戒指8段",new BigDecimal(""),2));
//		list.add(new Material("黑星耳环8段",new BigDecimal(""),2));
//		list.add(new Material("黑星项链8段",new BigDecimal(""),2));
//		list.add(new Material("赤星戒指12段",new BigDecimal(""),2));
//		list.add(new Material("黑星耳环12段",new BigDecimal(""),2));
//		list.add(new Material("黑星项链12段",new BigDecimal(""),2));

		for (Material material : list){
			material.setCreateTime(new Date());
			material.setDelFlag(false);
			material.setType(1);
			materialService.insert(material);
		}
	}

}
