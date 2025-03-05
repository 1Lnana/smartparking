package cn.zwz.car.entity;

import cn.zwz.basics.baseClass.ZwzBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * 车辆 实体类

 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "a_car")
@TableName("a_car")
@ApiModel(value = "车辆")
public class Car extends ZwzBaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "车牌号")
    private String code;

    @ApiModelProperty(value = "品牌")
    private String brand;

    @ApiModelProperty(value = "车主ID")
    private String ownId;

    @ApiModelProperty(value = "车主姓名")
    private String ownName;

}