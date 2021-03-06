package com.kunchiwms.wms.service.impl;

import com.kunchiwms.wms.entity.TUser;
import com.kunchiwms.wms.mapper.TUserDao;
import com.kunchiwms.wms.service.MPTUserService;
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
public class TUserServiceDiy extends ServiceImpl<TUserDao, TUser> implements MPTUserService {

}
