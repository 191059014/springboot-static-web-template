import * as ajax from "./ajax.js"

// 分页查询用户列表
export const findPages = (url) => ajax.get(url);
// 查询单个用户
export const findUser = "";