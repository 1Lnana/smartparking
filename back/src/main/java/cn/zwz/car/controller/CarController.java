package cn.zwz.car.controller;

import cn.zwz.basics.utils.PageUtil;
import cn.zwz.basics.utils.ResultUtil;
import cn.zwz.basics.baseVo.PageVo;
import cn.zwz.basics.baseVo.Result;
import cn.zwz.data.entity.User;
import cn.zwz.data.service.IUserRoleService;
import cn.zwz.data.service.IUserService;
import cn.zwz.data.utils.ZwzNullUtils;
import cn.zwz.car.entity.Car;
import cn.zwz.car.service.ICarService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@RestController
@Api(tags = "车辆管理接口")
@RequestMapping("/zwz/car")
@Transactional
public class CarController {

    @Autowired
    private ICarService iCarService;

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    @ApiOperation(value = "查询单条车辆")
    public Result<Car> get(@RequestParam String id){
        return new ResultUtil<Car>().setData(iCarService.getById(id));
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部车辆个数")
    public Result<Long> getCount(){
        return new ResultUtil<Long>().setData(iCarService.count());
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部车辆")
    public Result<List<Car>> getAll(){
        return new ResultUtil<List<Car>>().setData(iCarService.list());
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "查询车辆")
    public Result<IPage<Car>> getByPage(@ModelAttribute Car car ,@ModelAttribute PageVo page){
        QueryWrapper<Car> qw = new QueryWrapper<>();
        if(!ZwzNullUtils.isNull(car.getCode())) {
            qw.like("code",car.getCode());
        }
        if(!ZwzNullUtils.isNull(car.getOwnName())) {
            qw.like("own_name",car.getOwnName());
        }
        IPage<Car> data = iCarService.page(PageUtil.initMpPage(page),qw);
        return new ResultUtil<IPage<Car>>().setData(data);
    }

    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "增改车辆")
    public Result<Car> saveOrUpdate(Car car){
        if(iCarService.saveOrUpdate(car)){
            return new ResultUtil<Car>().setData(car);
        }
        return ResultUtil.error();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增车辆")
    public Result<Car> insert(Car car){
        User u = iUserService.getById(car.getOwnId());
        if(u == null) {
            return  ResultUtil.error("车主不存在");
        }
        car.setOwnName(u.getNickname());
        iCarService.saveOrUpdate(car);
        return new ResultUtil<Car>().setData(car);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "编辑车辆")
    public Result<Car> update(Car car){
        iCarService.saveOrUpdate(car);
        return new ResultUtil<Car>().setData(car);
    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "删除车辆")
    public Result<Object> delByIds(@RequestParam String[] ids){
        for(String id : ids){
            iCarService.removeById(id);
        }
        return ResultUtil.success();
    }
}
