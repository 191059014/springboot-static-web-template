//弹出提示效果
window.Alert = (messages, callback) => {
    let tip = '<div class="swt_tip">' + messages + '</div>';
    $("body").append(tip);
    $(".swt_tip").css({
        "top": "0",
        "left": "0",
        "height": "50px",
        "text-align": "center",
        "background-color": "yellow",
        "position": "absolute",
        "padding-top": "10px",
        "font-size": "larger",
        "font-weight": "bolder"
    });
    //淡出效果并执行回调
    $(".swt_tip").animate({
        "right": "0",
    }, 500, function () {
        $(".swt_tip").animate({
            opacity: 0,
        }, 2500, function () {
            $(".swt_tip").remove();
            callback && callback();
        });
    });
};
