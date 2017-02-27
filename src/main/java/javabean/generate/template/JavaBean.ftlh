package ${package}


import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ${class} implements Serializable {

	private static final long serialVersionUID = 1L;

	<#list columns as item>
	private ${item.javaType} ${item.name};
	</#list>
	
	<#list columns as item>
	/**
     * 获取${item.name}
     * @return ${item.name}
     */
    public ${item.javaType} get${item.mName}() {
        return ${item.name};
    }

    /**
     * 设置${item.name}
     * @param ${item.name}
     */
	public void set${item.mName}(${item.javaType} ${item.name}) {
		this.${item.name} = ${item.name};
	}
	</#list>
	
	@Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}