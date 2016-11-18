/**
 * Created by WunHwanTseng on 2016/11/3.
 */
function Articlejson() {
    $.get("/TsengBlog/article/articleNewList",function (data) {
        var html = "";
        $.each(data,function (i,data) {
            html += '<li><span class="glyphicon glyphicon-star"></span><a target="view_window" href="/TsengBlog/Article?id='+data.id+'">'+data.title+'</a></li>';
        });
        $("#ArticleNew").append(html);
    },"json");

    $.get("/TsengBlog/article/articleHotList",function (data) {
        var html = "";
        $.each(data,function (i,data) {
            html += '<li><span class="glyphicon glyphicon-star"></span><a target="view_window" href="/TsengBlog/Article?id='+data.id+'">'+data.title+'</a></li>';
        });
        $("#ArticleHot").append(html);
    },"json");

}

function checkReplyForm() {
    $("#replyForm").validate({
        submitHandler: function (form) {
            $.get("/TsengBlog/blog/checkUser",function (data) {
                if (data){
                    form.submit();
                }else {
                    window.location.href="/login";
                }
            });
        },
        rule: {
            content:"required"
        },
        messages: {
            content:"请输入内容"
        }
    });
    var form = $("#replyForm");

}