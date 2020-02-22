<%@ page import="java.time.LocalDate" %>
<html>
<head>
<title>Home Page</title>
<link rel="stylesheet" href="css/site.css" />
</head>
<body>
	<header>
		<h3 style="text-align:right">
			<%=LocalDate.now() %>
		</h3>
		<h1 style="border-bottom:1px solid black">${appTitle}</h1>
	</header>
	<nav>
		<a href="home">HOME</a>
		<a href="hello">HELLO</a>
		<a href="visitor">VISITOR PAGE</a>
	</nav>

