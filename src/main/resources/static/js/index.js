import {get_say, post_say} from '../common/api.js';

$(function () {

    $('#test_get_id_btn').on('click',function () {
        get_say()
            .then(res => {
                debugger;
                Alert("then: " + res);
            })
            .catch(res => {
                debugger;
                Alert("异常: " + res);
            });
    })

});

function testGet() {
    get_say()
        .then(res => {
            debugger;
            Alert("then: " + res);
        })
        .catch(res => {
            debugger;
            Alert("异常: " + res);
        });
}

function testPost() {
    let params = {userName: "zhangsan"};
    post_say(params)
        .then(res => {
            debugger;
            Alert("then: " + res);
        })
        .catch(res => {
            debugger;
            Alert("异常: " + res);
        });
}