package com.cjw.commom.validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
* Created by 625389, burns lee, on 2015/3/15.
* 值对象验证工厂
*/
public class DTOValidatorHelper {

    private Validator validator;

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    /**
	 * 按值对象属性的约束标签规则进行验证, 并按 "默认约束标签分组" 或 "指定约束标签分组" 验证
	 * 
	 * @param infoInstance 值对象
	 * @param groups 分组class标签, 可不传此参数, 则只校验默认分组
	 * @return 返回null则验证成功, 否则有错误消息
	 * 错误消息格式定义 "{filedName} + errorMessage", 如:"{countyCode} 不能为空"
	 */
	public <T> String validate(T infoInstance, Class<?>... groups){
		StringBuffer result = new StringBuffer();
    	Set<ConstraintViolation<T>> constraintViolations = validator.validate(infoInstance, groups);
        for(ConstraintViolation<T> violation : constraintViolations){
            result.append("{" + violation.getPropertyPath()+ "} " + violation.getMessage());
        }
        return (result.length() == 0 ? null : result.toString());
    }
	
}
