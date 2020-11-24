package com.cslg.common.controller;

import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cslg.common.domain.ApplyLecturerDO;
import com.cslg.common.domain.UserDO;
import com.cslg.common.service.ApplyLecturerService;
import com.cslg.system.utils.R;

@Controller
public class ApplyLecturerController {

	@Autowired
	private ApplyLecturerService applyLecturerService;
	
	/**
	 * 讲师申请
	 */
	@ResponseBody
	@PostMapping("/applyLecturerData")
	public R applyLecturerData(String advantage,String reason) {
		ApplyLecturerDO applyLecturerDO = new ApplyLecturerDO();
		applyLecturerDO.setAdvantage(advantage);
		applyLecturerDO.setReason(reason);
		UserDO userDO = (UserDO) SecurityUtils.getSubject().getPrincipal();
		applyLecturerDO.setUserId(userDO.getId());
		applyLecturerDO.setUsername(userDO.getUsername());
		applyLecturerDO.setApplyTime(new Date());
		applyLecturerDO.setStatus(0);
		applyLecturerService.applyLecturer(applyLecturerDO);
		return R.ok("申请已提交！");
	}
	
	/**
	 * 查询申请记录
	 */
	@ResponseBody
	@PostMapping("/queryApplyLecturerData")
	public R queryApplyLecturerData(Long id) {
		int count = applyLecturerService.queryApplyLecturerData(id);
		if(count>0) {
			ApplyLecturerDO applyLecturerDO = applyLecturerService.getApplyLecturerByUserId(id);
			if(applyLecturerDO.getStatus() == 0) {
				return R.error(101, "申请正在审批中！");
			}
			if(applyLecturerDO.getStatus() == 1) {
				return R.error(102, "审核通过！");
			}
			if(applyLecturerDO.getStatus() == 2) {
				return R.error(103, "审核不通过！");
			}
		}
		return R.ok("申请已提交！");
	}
	
}
