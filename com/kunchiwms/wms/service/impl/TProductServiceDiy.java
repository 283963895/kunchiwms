package com.kunchiwms.wms.service.impl;

import com.kunchiwms.wms.entity.TProduct;
import com.kunchiwms.wms.mapper.TProductDao;
import com.kunchiwms.wms.service.MPTProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Yanghu
 * @since 2018-08-08
 */
@Service
public class TProductServiceDiy extends ServiceImpl<TProductDao, TProduct> implements MPTProductService {

}
