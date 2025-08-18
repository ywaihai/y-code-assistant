package com.waihai.ycodeassistant.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.waihai.ycodeassistant.model.dto.app.AppQueryRequest;
import com.waihai.ycodeassistant.model.entity.App;
import com.waihai.ycodeassistant.model.entity.User;
import com.waihai.ycodeassistant.model.vo.AppVO;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用服务层
 */
public interface AppService extends IService<App> {

    /**
     * 获取应用封装类
     *
     * @param app
     * @return
     */
    AppVO getAppVO(App app);

    /**
     * 获取应用封装类列表
     *
     * @param appList
     * @return
     */
    List<AppVO> getAppVOList(List<App> appList);

    /**
     * 构造应用查询条件
     *
     * @param appQueryRequest
     * @return
     */
    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    /**
     * 通过对话生成应用代码
     *
     * @param appId 应用 ID
     * @param message 提示词
     * @param loginUser 登录用户
     * @return
     */
    Flux<String> chatToGenCode(Long appId, String message, User loginUser);
}
