import {get_say, post_say} from '../common/api.js';

$(function () {

    $('#test_get_id_btn').on('click', function () {
        get_say()
            .then(res => {
                debugger;
                Alert("then: " + res);
            });
    });

    $('#test_post_id_btn').on('click', function () {
        let params = {userName: "zhangsan"};
        post_say(params)
            .then(res => {
                debugger;
                Alert("then: " + res);
            });
    })

});