package com.alibaba.tboss.client.service.resource;

import java.util.List;

import com.alibaba.tboss.client.dto.resource.ResourceQueryDto;
import com.alibaba.tboss.client.dto.resource.ResourceSummaryDto;
import com.alibaba.tboss.client.rpc.RpcResult;

/**
 * Tboss提供资源池查询相关接口
 * @author wb-sunzhouyang
 * @since  2017-08-10
 */
public interface ResourceQueryService {

	/**
	 * 汇总可用的搬迁设备列表
	 * 
	 * @param deviceName 设备名称
	 * @param zoneName 区域(中国、纽约、东京等)
	 * @return
	 */
	public RpcResult<List<ResourceSummaryDto>> summaryAvailableResource(List<String> deviceName, List<String> configModel, List<String> zoneName, boolean config);
	
	/**
	 * 查询可用的搬迁设备列表
	 * 
	 * @param offset 当前查询页
	 * @param limit 每页记录数
	 * @param resourcesType 资源类型(0全部,1:业务池,2:冷池)
	 * @param zoneName 区域(0:全部,1:国内,2:海外,3:未知)
	 * @param pv PV(0:全部,1:物理机,2:虚拟机)
	 * @param siteName 机房名称
	 * @param configModel 配置机型
	 * @param managerStatus 管控状态
	 * @param lock 是否锁定
	 * @return
	 */
	public RpcResult<List<ResourceQueryDto>> queryAvailableResource(Integer offset, Integer limit, byte resourcesType,
			byte zoneName, byte pv, String siteName, String configModel, String managerStatus, Boolean lock);
	
	/**
	 * 锁定可用搬迁的设备
	 * @param source
	 * @param orderId
	 * @param userId
	 * @param snList
	 * @return
	 */
	public RpcResult<Object> lockAvailableResourceDevice(String source, String orderId, String userId, List<String> snList);
	
	/**
	 * 解锁可用搬迁的设备
	 * @param source
	 * @param orderId
	 * @param userId
	 * @param snList
	 * @return
	 */
	public RpcResult<Object> unlockAvailableResourceDevice(String source, String orderId, String userId, List<String> snList);
}
