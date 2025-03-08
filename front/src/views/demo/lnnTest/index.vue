<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>导航栏页面</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
    }

    nav {
      background-color: #333;
      overflow: hidden;
    }

    nav a {
      float: left;
      display: block;
      color: white;
      text-align: center;
      padding: 14px 16px;
      text-decoration: none;
    }

    nav a:hover {
      background-color: #ddd;
      color: black;
    }

    .content {
      padding: 20px;
    }
  </style>
</head>

<body>
  <nav>
    <a href="#">首页</a>
    <a href="#">关于我们</a>
    <a href="#">联系我们</a>
  </nav>
  <div class="content">
    <h1>欢迎来到我的网站</h1>
    <p>这是一个带有导航栏的页面示例。</p>
  </div>
</body>

</html>