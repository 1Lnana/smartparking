package cn.zwz.car.serviceimpl;

import cn.zwz.car.mapper.CarMapper;
import cn.zwz.car.entity.Car;
import cn.zwz.car.service.ICarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 车辆 服务层接口实现

 */
@Slf4j
@Service
@Transactional
public class ICarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {

    @Autowired
    private CarMapper carMapper;
}