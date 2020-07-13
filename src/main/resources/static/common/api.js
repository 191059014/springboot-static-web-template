import * as ajax from "./ajax.js"

// 测试get
export const get_say = () => ajax.get("/controller/index/get_say");
// 测试post
export const post_say = (params) => ajax.post("/controller/index/post_say", params);