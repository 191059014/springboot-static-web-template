import {findPages} from '../common/api.js';

$(function () {

    findPages("/index/say")
        .then(res => {
            debugger;
            Alert("then" + res);
        })
        .catch(res => {
            debugger;
            Alert("异常" + res);
        });
});