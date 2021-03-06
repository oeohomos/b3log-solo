<style type="text/css">
    #top {
        background-image: linear-gradient(top,#FFFFFF,#E5E5E5);
        background-image: -moz-linear-gradient(top,#FFFFFF,#E5E5E5);
        background-image: -ms-linear-gradient(top,#FFFFFF,#E5E5E5);
        background-image: -o-linear-gradient(top,#FFFFFF,#E5E5E5);
        background-image: -webkit-gradient(linear,left top,left bottom,from(#FFFFFF),to(#E5E5E5));
        filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#FFFFFF', endColorstr='#E5E5E5');
        border-bottom: 1px solid #E5E5E5;
        height: 26px;
        line-height: 26px;
        display: none;
    }

    #top a, #top span span {
        border-right: 1px solid #D9D9D9;
        color: #4C4C4C;
        float: left;
        line-height: 14px;
        margin: 6px 0;
        padding: 0 6px;
        text-decoration: none;
        text-shadow: 0 -1px 0 #FFFFFF;
        font-weight: normal;
    }

    #top a:hover, #top a.hover {
        background-color: #EEF2FA;
        border-left-color: #707070;
        border-radius: 0 13px 13px 0;
        margin: 0px;
        line-height: 26px;
    }

    #showTop {
        background-image: url("${contextPath}/images/arrow-right.png");
        cursor: pointer;
        height: 26px;
        right: 0;
        position: absolute;
        top: 0;
        width: 26px;
        border-radius: 0 0 0 15px;
        z-index: 10;
    }

    #showTop:hover {
        background-image: url("${contextPath}/images/arrow-right.gif");
    }

    #top #hideTop {
        background-image: url("${contextPath}/images/arrow-left.png");
        height: 26px;
        margin: 0;
        padding: 0;
        width: 26px;
        border: 0;
    }

    #top #hideTop:hover {
        background-image: url("${contextPath}/images/arrow-left.gif");
        border-radius: 0;    
    }
</style>
<div id="showTop"></div>
<div id="top">
    <a href="https://github.com/b3log/b3log-solo" target="_blank" class="hover">
        B3log Solo
    </a>
    &nbsp;${onlineVisitor1Label}${onlineVisitorCnt}
    <span class="right" id="admin">
        <#if isLoggedIn>
        <span>${userName}</span>
        <#if isAdmin>
        <a href="javascript:Util.clearCache('all');">
            ${clearAllCacheLabel}
        </a>
        <a href="javascript:Util.clearCache();">
            ${clearCacheLabel}
        </a>
        <a href="${contextPath}/admin-index.do#main" title="${adminLabel}">
            ${adminLabel}
        </a>
        <a href="${logoutURL}" title="${logoutLabel}">${logoutLabel}</a>
        </#if>
        <#else>
        <a href="${loginURL}" title="${loginLabel}">${loginLabel}</a>
        </#if>
        <#if isMobileRequest>
        <a href="javascript:void(0)" onclick="Util.switchMobile('mobile');" title="${mobileLabel}">${mobileLabel}</a>
        </#if>
        <a href="javascript:void(0)" id="hideTop"></a>
    </span>
    <div class="clear"></div>
</div>