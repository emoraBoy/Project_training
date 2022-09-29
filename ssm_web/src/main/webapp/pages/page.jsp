<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- .box-footer-->
<div class="box-footer">
    <div class="pull-left">
        <div class="form-group form-inline">
            总共${pageInfo.navigateLastPage} 页，共${pageInfo.total} 条数据。 每页
            <select onchange="gotoPage(1)" id="pageSize" class="form-control">
                <option value="2">2</option>
                <option value="5">5</option>
                <option value="10">10</option>
            </select> 条
        </div>
    </div>

    <div class="box-tools pull-right">
        <ul class="pagination">
            <li><a href="javascript:gotoPage(1)" aria-label="Previous">首页</a></li>
            <li><a href="javascript:gotoPage(${pageInfo.prePage})">上一页</a></li>
            <c:forEach var="i" begin="${pageInfo.navigateFirstPage}" end="${pageInfo.navigateLastPage}">
                <c:if test="${pageInfo.pageNum==i}">
                    <li><a href="javascript:gotoPage(${i})"><b>${i}</b></a></li>
                </c:if>
                <c:if test="${pageInfo.pageNum!=i}">
                    <li><a href="javascript:gotoPage(${i})"><b>${i}</b></a></li>
                </c:if>
            </c:forEach>
            <li><a href="javascript:gotoPage(${pageInfo.nextPage})">下一页</a></li>
            <li><a href="javascript:gotoPage(${pageInfo.pageSize})" aria-label="Next">尾页</a></li>
        </ul>
    </div>
</div>

<script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
    $("#pageSize option[value=${pageInfo.pageSize}]").prop("selected", "selected");
    function gotoPage(page) {
        if (page < 1) {
            return;
        }
        if (page > ${pageInfo.pages}) {
            return;
        }
        let pageSize = $("#pageSize").val();
        window.location.href = "${pageContext.request.contextPath}/<%=str%>/findAll?currPage=" + page + "&pageSize=" + pageSize;
    }
</script>