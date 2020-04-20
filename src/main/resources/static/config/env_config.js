/**
 * 获取跟环境相关联的配置
 */
import EnvRoute from './env_route.js'

/**
 * 获取http请求基本url
 * @returns 请求的基本url
 */
export const getBaseRequestUrl = () => {
    return EnvRoute.baseUrl;
};
