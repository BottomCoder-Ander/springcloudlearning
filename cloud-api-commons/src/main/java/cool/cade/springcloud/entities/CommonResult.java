package cool.cade.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Cade
 * @date 03/11/2021 - 20:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>  {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message){
        this(code, message, null);
    }

}
