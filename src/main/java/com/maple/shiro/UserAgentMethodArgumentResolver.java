package com.maple.shiro;

import com.maple.annotation.UserAgent;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 *  增加方法注入，将含有 @UserAgent 注解的方法参数注入当前登录用户
 * @author liugh
 * @since 2018-05-03
 */
public class UserAgentMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(com.maple.base.UserAgent.class)
                && parameter.hasParameterAnnotation(UserAgent.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return  com.maple.base.UserAgent.resolveAgentInfo(webRequest.getHeader(com.maple.base.UserAgent.UserAgentStr));
    }
}
