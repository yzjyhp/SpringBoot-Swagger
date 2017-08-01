package com.yzjyhp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yzjyhp.dao.IScoreDao;
import com.yzjyhp.entity.Score;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/score")
@Api(value = "获取Score信息")
public class ScoreController {
	private static final Logger logger = LoggerFactory.getLogger(ScoreController.class);

	@Autowired
	private IScoreDao scoreService;

	@RequestMapping(value = "/scoreList", method = RequestMethod.GET)
	@ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
	public List<Score> getScoreList() {
		logger.info("从数据库读取Score集合");
		Score s1 = new Score();
		s1.setId(1);
		s1.setScore(1222f);
		s1.setStuId(1234);
		s1.setSubjectName("语文");
		s1 = scoreService.save(s1);
		// 测试更新数据库
		logger.info("更新的行数：" + scoreService.updateScoreById(88.8f, 1));
		return scoreService.getList();
	}
}
