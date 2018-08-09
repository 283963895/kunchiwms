package com.kunchiwms.wms.service.impl;

import com.kunchiwms.wms.entity.TInventory;
import com.kunchiwms.wms.mapper.TInventoryDao;
import com.kunchiwms.wms.service.MPTInventoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jason
 * @since 2018-08-09
 */
@Service
public class TInventoryServiceDiy extends ServiceImpl<TInventoryDao, TInventory> implements MPTInventoryService {

}
