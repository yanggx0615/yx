<%--
  Created by IntelliJ IDEA.
  User: 杨国祥
  Date: 2020/9/29
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link >
</head>
<body>
<input type="file" name="file">
<button type="submit">上传</button>
</form>
<script>
    const btn=document.querySelector(`button`)
    btn.addEventListener("click",e=>{
        const filesElement = document.querySelector("#file")
        if (filesElement.files.length !== 1){
            layer.msg("必须选择一个文件",{icon:5});
            return ;
        }
    })
</script>

</body>
</html>
