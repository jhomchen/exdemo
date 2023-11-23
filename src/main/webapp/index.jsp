<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>好听轻音乐下载</title>
</head>
<style type="text/css">
.d1{
  border :1px solid green;
  width:400px;
  height:200px;
  text-align: center;
  line-height: 100px;
  margin: 0 auto;
}
</style>
<body>
    <form action="pageSpider.action" method="post">
         <div class="d1">
             <iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width=330 height=86 src="//music.163.com/outchain/player?type=2&id=5257138&auto=1&height=66"></iframe>
             <label>请选择页面分类：</label>
             <select name ="userName">
               <option value="1">纯音乐</option>
               <option value="2">新世纪</option>
               <option value="3">钢琴曲</option>
               <option value="4">减压放松</option>
               <option value="5">中国音乐</option>
               <option value="6">天籁之音</option>
               <option value="7">影视原声</option>
               <option value="8">电子乐</option>
               <option value="9">背景音乐</option>
               <option value="10">手机铃声</option>
               <option value="12">胎教音乐</option>
               <option value="13">佛乐</option>
             </select>
         <div>
             <input  type="submit"  value="解析" />
         </div>
         </div>
        
    </form>
</body>
</html>
