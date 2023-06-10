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

    private LocalDateTime createTime = LocalDateTime.now();

    private LocalDateTime updateTime = LocalDateTime.now();

    @TableField(select = false)
    private byte deleted = 0;

    public void delete() {
        this.deleted = 1;
        update();
    }

    public void update() {
        this.updateTime = LocalDateTime.now();
    }
}
