package com.rhythm.warn.service.impl;

import com.rhythm.warn.entity.UserAccountDO;
import com.rhythm.warn.mapper.UserAccountMapper;
import com.rhythm.warn.service.IUserAccountService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 通知用户账号 服务实现类
 * </p>
 *
 * @author majunjie
 * @since 2018-11-21
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccountDO> implements IUserAccountService {

}
