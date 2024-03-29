package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.District;

/**
 * 处理省/市/区数据的持久层接口
 */
public interface DistrictMapper {

	/**
	 * 根据省/市/区的代号，获取省/市/区的详情
	 * @param code 省/市/区的代号
	 * @return 匹配的省/市/区的详情，如果没有匹配的数据，则返回null
	 */
	District findByCode(String code);
	
	/**
	 * 获取全国所有省/某省所有市/某市所有区的列表
	 * @param parent 父级的行政代号，如果获取全国所有省的列表，则使用"86"
	 * @return 全国所有省/某省所有市/某市所有区的列表
	 */
	List<District> findByParent(String parent);
	
}





