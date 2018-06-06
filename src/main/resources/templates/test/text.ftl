<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/jstl/xss.tld" prefix="xss" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>猎头审核</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link rel="stylesheet" type="text/css" href="http://admin.zhipin.com/static/src/css/main.css"/>
    <style>
        .page-single {
            background-color: #3D3D3D;
        }

        .page-single #main {
            padding-top: 0;
        }

        .page-single #container {
            margin-left: 0;
        }

        .page-single .page-content {
            width: 1280px;
            margin: 0 auto;
            background-color: #3D3D3D;
        }

        .certification-table {
            min-height: calc(100vh);
        }

        .certification-table td {
            padding: 10px;
            vertical-align: top;
            font-size: 13px;
        }

        .certification-table td.col-content {
            width: 610px;
        }

        .certification-table td.col-info {
            background-color: #E8E8E8;
        }

        .certification-table td.col-op {
            width: 360px;
            background-color: #FAFBFA;
            position: relative;
            padding-bottom: 280px;
        }

        .cert-content .cert-title {
            background-color: #59B3EF;
            color: #fff;
            text-align: center;
            font-weight: normal;
        }

        .cert-sec {
            margin-bottom: 20px;
        }

        .cert-sec:after {
            content: '';
            display: block;
            clear: both;
            overflow: hidden;
            visibility: hidden;
        }

        .cert-item {
            border: 1px #fff solid;
            width: 498px;
            float: left;
        }

        .cert-content .cert-img img {
            max-width: 100%;
            display: block;
        }

        .content-op {
            float: right;
            width: 100px;
        }

        .content-op .labels {
        }

        .content-op .label-cert {
            display: block;
            margin-bottom: 10px;
            border-radius: 5px;
            color: #EF4A44;
            text-align: center;
            font-size: 13px;
            line-height: 18px;
            padding: 5px 3px;
            background-color: #fff;
            border: 1px #EF4A44 solid;
            cursor: pointer;
        }

        .content-op .label-cert:hover {
            background-color: #F7EDED;
        }

        .content-op .label-cert.active {
            background-color: #EF4A44;
            color: #fff;
        }

        .cert-figure {
            text-align: center;
        }

        .cert-figure img {
            max-width: 200px;
            max-height: 200px;
            display: block;
            margin: 0 auto;
        }

        .cert-figure p {
            color: #45ACED;
            font-size: 13px;
            margin-top: 5px;
        }

        .info-table {
            width: 100%;
        }

        .info-table td {
            padding: 5px;
            line-height: 20px;
            text-align: right;
        }

        .info-table td.t {
            color: #9fa3b0;
            text-align: left;
        }

        .certification-table .badge {
            padding: 0 3px;
            margin-right: 5px;
            font-size: 12px;
        }

        .certification-table .badge-danger {
            background-color: #EF4A44;
            color: #fff;
        }

        .certification-table .badge-success {
            background-color: #19AD59;
            color: #fff;
        }

        .certification-table .badge-warning {
            background-color: #FEC02C;
            color: #fff;
        }

        .cert-text {
            margin-top: 10px;
        }

        .cert-text h3 {
            font-size: 15px;
        }

        .cert-text p {
            color: #9fa3b0;
        }

        .cert-other {
            padding: 0 10px;
        }

        .cert-job {
            margin-bottom: 10px;
        }

        .cert-job h3 {
            margin-bottom: 5px;
        }

        .cert-job h3 .badge {
            margin-right: 0;
            margin-left: 5px;
            font-size: 12px;
            font-weight: normal;
        }

        .cert-job a {
            color: #45ACED;
        }

        .cert-job a:hover {
            text-decoration: underline;
        }

        .cert-job .labels a {
            display: inline-block;
            margin-right: 10px;
        }

        .cert-op {
            position: fixed;
            bottom: 0;
            padding-top: 20px;
            padding-left: 20px;
            width: 360px;
            margin-left: -10px;
            background-color: #FAFBFA;
            -webkit-box-shadow: 0 -5px 15px rgba(0, 0, 0, .1);
            box-shadow: 0 -5px 15px rgba(0, 0, 0, .1);
        }

        .cert-op .labels {
            margin-bottom: 5px;
        }

        .cert-op .labels .label-cert {
            display: inline-block;
            margin-right: 5px;
            cursor: pointer;
        }

        .cert-op .labels .label-cert:hover {
            color: #45ACED;
        }

        .cert-op .labels .label-cert.active {
            color: #f00;
        }

        .cert-op .ipt-area {
            width: 318px;
            height: 70px;
            padding-right: 12px;
        }

        .cert-op .btns {
            padding: 20px 0;
        }

        .cert-op .btns .btn-danger {
            width: 120px;
        }

        .cert-op .btns .btn-success {
            width: 208px;
            background-color: #21B261;
        }

        .cert-op .btns .btn-success:hover {
            background-color: #1F9D58;
            border-color: #1F9D58;
        }

        .certification-table td.col-content {
            width: 880px;
        }

        .certification-table td.col-op {
            width: 400px;
        }

        .cert-figure p {
            font-size: 16px;
        }

        .cert-op {
            width: 392px;
        }

        .cert-op .ipt-area {
            width: 348px;
        }

        .cert-op .btns .btn-success {
            width: 238px;
        }

        .hunter-photo {
            width: 100%;
            background: #fff;
            border-collapse: collapse;
        }

        .hunter-photo td {
            vertical-align: middle;
            text-align: center;
            height: 100px;
            border: 1px #E8E8E8 solid;
            width: 50%;
        }

        .hunter-photo td img {
            max-width: 100%;
            display: block;
        }
    </style>
</head>
<body class="page-single">
<div id="wrap">
    <div id="main">
        <div id="container">
            <div class="page-content">
                <div class="certification-box">
                    <table class="certification-table">
                        <tr>
                            <td class="col-content">
                                <table class="hunter-photo">
                                    <tr>
                                        <c:choose>
                                            <c:when test="${not empty hunter.bodyIdCardFront}">
                                                <td><img src="${hunter.bodyIdCardFront}" title="身份证正面" alt="身份证正面"></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td>身份证正面</td>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${not empty hunter.bodyIdCardReverse}">
                                                <td><img src="${hunter.bodyIdCardReverse}" alt="身份证反面" title="身份证反面">
                                                </td>
                                            </c:when>
                                            <c:otherwise>
                                                <td>身份证反面</td>
                                            </c:otherwise>
                                        </c:choose>
                                    </tr>
                                    <tr>
                                        <c:choose>
                                            <c:when test="${not empty hunter.bodyIdCardHandheld}">
                                                <td><img src="${hunter.bodyIdCardHandheld}" alt="手持身份证" title="手持身份证">
                                                </td>
                                            </c:when>
                                            <c:otherwise>
                                                <td>手持身份证</td>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${not empty hunter.tiny}">
                                                <td><img src="${hunter.tiny}" alt="头像" title="头像"></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td>头像</td>
                                            </c:otherwise>
                                        </c:choose>
                                    </tr>

                                </table>
                                <div class="cert-content">
                                    <div class="cert-img">
                                        <c:choose>
                                            <c:when test="${not empty hunter.bodyLicense}">
                                                <a href="/certification/bigImage?imgsrc=${hunter.bodyLicense}"
                                                   target="_blank">
                                                    <img src="${hunter.bodyLicense}" alt="营业执照" title="营业执照"/>
                                                </a>
                                            </c:when>
                                            <c:otherwise>
                                                营业执照未提供
                                            </c:otherwise>
                                        </c:choose>

                                    </div>
                                </div>
                            </td>
                            <td class="col-op">
                                <div class="cert-figure">
                                    <p>审核状态：<c:choose>
                                        <c:when test="${hunter.certification eq 3}">审核通过</c:when>
                                        <c:when test="${hunter.certification eq 2}">审核驳回</c:when>
                                        <c:otherwise>未审核</c:otherwise>
                                    </c:choose></p>
                                </div>
                                <div class="cert-info">
                                    <table class="info-table">
                                        <tr>
                                            <td class="t">Hunter ID</td>
                                            <td>${hunter.userId}</td>
                                        </tr>
                                        <tr>
                                            <td class="t">姓名</td>
                                            <td>${xss:escapeHtml(hunter.name)}</td>
                                        </tr>
                                        <tr>
                                            <td class="t">目前职位</td>
                                            <td>${xss:escapeHtml(hunter.title)}</td>
                                        </tr>
                                        <tr>
                                            <td class="t">身份证号码</td>
                                            <td>${hunter.bodyIdCardNo}</td>
                                        </tr>
                                        <tr>
                                            <td class="t">邮箱</td>
                                            <td>${hunter.email}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${auditStatus eq 1}">
                                                        <font color="blue">已匹配</font>
                                                    </c:when>
                                                    <c:when test="${auditStatus eq 0}">
                                                        <font color="red">未匹配</font>
                                                    </c:when>
                                                </c:choose>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="t">公司全称</td>
                                            <td>${xss:escapeHtml(hunter.comName)}</td>
                                            <c:if test="${auditStatus eq 0}">
                                                <td class="data-grid">
                                                    <a href="javascript:;"
                                                       data-url="/headhunter/companyemail/${hunter.comId}/detail.json"
                                                       class="op-view ">查看全部后缀</a>
                                                </td>
                                            </c:if>
                                        </tr>
                                        <tr>
                                            <td class="t"></td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${hunter.companyFullInfo.certification eq 0}">
                                                        <font color="blue">[未审核]</font>
                                                    </c:when>
                                                    <c:when test="${hunter.companyFullInfo.certification eq 1}">
                                                        <font color="green">[审核通过]</font>
                                                    </c:when>
                                                    <c:when test="${hunter.companyFullInfo.certification eq 2}">
                                                        <font color="red">[审核不通过]</font>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <font color="red">[状态错误]</font>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <a href="http://www.qichacha.com/search?key=${xss:escapeHtml(hunter.comName)}"
                                                   target="_blank"
                                                   class="text-blue">[${hunter.companyFullInfo.srcFromDesc}]</a></td>
                                        </tr>
                                        <tr>
                                            <td class="t">统一社会信用代码：</td>
                                            <td>${hunter.companyFullInfo.creditCode}</td>
                                        </tr>
                                    </table>
                                    <div class="cert-text">
                                        <h3>认证次数：<span class="red">${hunter.submitCount}</span></h3>
                                    </div>
                                    <div class="cert-text">
                                        <h3>历史记录</h3>
                                        <content>${actionDesc}</content>
                                    </div>
                                    <div class="cert-text">
                                        <h3>营业执照信息</h3>
                                        <p>营业期限:${hunter.companyFullInfo.operatingPeriod}</p>
                                        <p>核准日期:${hunter.companyFullInfo.checkDate}</p>
                                        <p>注册资本:${hunter.companyFullInfo.regCapital}</p>
                                        <p>经营范畴:${hunter.companyFullInfo.businessScope}</p>
                                    </div>
                                </div>
                                <div class="cert-op">
                                    <form action="/headhunter/certification/pass.json"
                                          reject-url="/headhunter/certification/reject.json" method="post" hunterId="${hunter.userId}"
                                          hunterIdentity="${identity}"
                                          id="rejectForm">
                                        <input type="hidden" name="hunterId" value="${hunter.userId}">
                                        <input type="hidden" name="_csrf" value="${_csrf}">
                                        <div class="labels">
                                            <span class="label-cert" data-reason="身份证正面不规范">[身份证正面]</span>
                                            <span class="label-cert" data-reason="身份证背面不规范">[身份证背面]</span>
                                            <span class="label-cert" data-reason="手持身份证照片不规范">[手持身份证]</span>
                                            <span class="label-cert" data-reason="营业执照不规范">[营业执照]</span>
                                        </div>
                                        <div class="ipt-wrap">
                                            <textarea name="message" class="ipt ipt-area" placeholder="原因"></textarea>
                                        </div>
                                        <div>
                                            <a>请选择审核通过的身份：</a><br/>
                                            <input type="radio" value="0" name="hunterIdentity" checked="checked"/>顾问
                                            <c:if test="${identity eq 1}"><input type="radio" value="1" name="hunterIdentity" />PM</c:if>
                                        </div>
                                        <div class="btns">
                                            <button type="button" class="btn btn-danger">驳回</button>
                                            <button type="button" class="btn btn-success" audit_status="${auditStatus}">
                                                通过
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../footer-js.jsp"/>
<script>
    $(function () {
        $('.content-op .label-cert, .cert-op .label-cert').on('click', function () {
            var el = $(this),
                    reason = el.attr('data-reason'),
                    elArea = $('.cert-op .ipt-area'),
                    oldStr = elArea.val(),
                    arr = [];
            if (el.hasClass('active')) {
                el.removeClass('active');
                if (oldStr.indexOf(reason + '；\n') > -1) {
                    arr = oldStr.split(reason + '；\n');
                    elArea.val(arr[0] + arr[1]);
                }

            } else {
                el.addClass('active');
                if (reason) {
                    elArea.val(oldStr + reason + '；\n');
                }
            }
        })
        $('.check-company').on('click', function () {
            var el = $(this),
                    url = el.attr('data-url'),
                    type = 1;//通过type来控制是通过还是撤销通过
            if (el.text() == '撤销') {
                type = 0;
            }
            sendAjax(el, {
                url: url,
                parm: {
                    type: type
                }
            }, function () {
                alert('操作成功');
                if (type == 1) {
                    el.text('撤销');
                } else {
                    el.text('通过');
                }

            });
        })
        /** 点击通过 */
        $('.cert-op .btns .btn').click(function () {
            var btn = $(this);
            formEl = btn.closest('form');
            var hunterId  = formEl.attr('hunterId');
            var identity = formEl.attr('hunterIdentity');
            var formHtml = "<div class='dialog-form'>"
                    + "<form action='/headhunter/certification/pass.json' method='post'>"
                    + " <a>请选择审核通过的身份：</a><br/>"
                    +" <input type='radio' value='0' name='hunterIdentity' checked='checked'/>顾问"
                    + "<input type='radio' value='1' name='hunterIdentity' />PM"
                    +" <input type='hidden' value='"+hunterId+"' name='hunterId' />"
                    + "<br>"
                    +hunterId+":"+identity
                    + "<br>"
                    + "</form>"
                    + "</div>";
            $.dialog({
                content: formHtml,
                wrapClass: 'dialog-prop-default',
                position: 'center',
                btnPosition: 'true',
                onOpen: function (wrap) {
                    Forms.init(wrap);
                },
                onConfirm: function (wrap) {
                    var form = $(".dialog-form form");
                    var data = form.serialize();
                    var url = '/headhunter/certification/pass.json';
                    echo("url:"+url+",data:"+data)
                    $.axPost(url, data, function (result) {
                        if (1 == result.rescode) {
                            $.toast({
                                content: result.resmsg,
                                type: 'success'
                            });
                            // 关闭dialog
                            wrap.remove();
                        } else if (0 == result.rescode) {
                            $.toast({
                                content: result.resmsg,
                                type: 'error'
                            });
                        } else {
                            $.toast({
                                content: '服务错误',
                                type: 'error'
                            });
                        }
                    }, function () {
                    })
                },
                onClose: function (wrap) {

                }
            });
        });
        /*通过和驳回*/
        $('.cert-op .btns .btn').on('click', function () {
            var el = $(this),
                formEl = el.closest('form'),
                url = formEl.attr('action'),
                elArea = $('.cert-op .ipt-area');
            if (el.hasClass('btn-danger')) {
                url = formEl.attr('reject-url');//驳回时的url获取form标签上的 reject-url
            }
            if (elArea.val() == '' && el.hasClass('btn-danger')) {
                alert('请填写原因');
                return false;
            }
            function pass() {
                sendAjax(el, {
                    url: url,
                    parm: formEl.serialize()//序列号表单将表单的所以带name的控件以&key=value的形式生成字符串
                }, function () {
                    alert('操作成功');
                    //接下来可以进行跳转到下一个或者返回列表页
                    window.location.reload();
                })
            }
            if (el.hasClass("btn-success")) {
                if (el.attr("audit_status") == 0) {
                    if (confirm("该猎头的邮箱后缀未能与该公司邮箱后缀匹配,请确认是否通过认证?(通过认证后该猎头的邮箱后缀将维护至该公司邮箱后缀库内)")) {
                        pass();
                    }
                }
                else {
                    pass();
                }
            }
            else{
                pass();
            }
        })


        /*ajax提交*/
        function sendAjax(el, obj, callback) {
            var el = el,
                    url = obj.url || el.attr('data-url');
            el.addClass('disabled');
            $.ajax({
                type: 'POST',
                url: url,
                dataType: 'JSON',
                data: obj.parm || null,
                success: function (data) {
                    el.removeClass('disabled');
                    if (data.success == true || data.result || data.rescode || obj.ignoreResult) {
                        callback(data);
                        return;
                    } else {
                        alert(data.message || '操作失败，请稍后再试');
                    }
                },
                error: function (data) {
                    alert(data.message || '操作失败，请稍后再试')
                    el.removeClass('disabled');
                }
            });
        }
    })
</script>
</body>
</html>

