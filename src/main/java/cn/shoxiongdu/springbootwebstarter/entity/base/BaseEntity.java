package cn.shoxiongdu.springbootwebstarter.entity.base;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author: email@shaoxingdu.cn
 * <p>
 * subClass annotation:
 * <ul>
 *     <li>@EqualsAndHashCode(callSuper = true)</li>
 *     <li>@Data</li>
 *     <li>@ToString(callSuper = true)</li>
 * </ul>
 */
@Data
public class BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    @TableField
    private Integer deleted = 0;
}
