package com.tedu.sp01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	//@Getter,@Setter,@RequiredConstrutor
@NoArgsConstructor	//无参构造方法
@AllArgsConstructor	//全参构造方法
public class Item {
	private Integer id;
	private String name;
	private Integer number;
}