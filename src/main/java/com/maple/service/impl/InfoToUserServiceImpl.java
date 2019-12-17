package com.maple.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.maple.entity.InfoToUser;
import com.maple.mapper.InfoToUserMapper;
import com.maple.service.IInfoToUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户电话关系表 服务实现类
 * </p>
 *
 * @author liugh123
 * @since 2018-10-29
 */
@Service
public class InfoToUserServiceImpl extends ServiceImpl<InfoToUserMapper, InfoToUser> implements IInfoToUserService {

}
