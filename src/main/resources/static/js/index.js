import {get_say, post_say} from '../common/api.js';

$(function () {

    $('#test_get_id_btn').on('click', function () {
        get_say().then(res => {
            Alert("get请求成功");
        });
    });

    $('#test_post_id_btn').on('click', function () {
        let params = {userName: "zhangsan"};
        post_say(params).then(res => {
            Alert("post请求成功");
        });
    })

});