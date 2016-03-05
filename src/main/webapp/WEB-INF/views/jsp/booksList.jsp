<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>My Books Application</title>
<c:url var="home" value="/" scope="request" />
<script	src="<c:url value="/resources/external/js/jquery-2.2.1.min.js" />"></script>
<script src="<c:url value="/resources/external/js/jquery-ui.min.js" />"></script>
<script	src="<c:url value="/resources/external/js/jquery.dataTables.min.js" />"></script>
<script	src="<c:url value="/resources/external/js/dataTables.jqueryui.min.js" />"></script>
<link href="<c:url value="/resources/external/css/jquery-ui.css" />"rel="stylesheet">
<link	href="<c:url value="/resources/external/css/dataTables.jqueryui.min.css" />"rel="stylesheet">
<script src="<c:url value="/resources//js/book_list.js" />"></script>
<script src="<c:url value="/resources//js/add_book.js" />"></script>
<style>
.center {
	width: 80%;
	margin: auto
}

label, input {
	display: block;
}
</style>
<script>
	$(document).ready(function() {
		createBooksList();
	});
	function createBooksList() {
		var booksDiv = $('#books_list_div');
		$.mybooks.myBooksList({
			closeCallback : onAddBookButtonClick
		}, $("<div></div>").appendTo(booksDiv));
	}
	function onBookAdded() {
		removeWidgets();
		createBooksList();
	}
	function onAddBookButtonClick() {
		removeWidgets();
		createBookAddForm();
	}
	function createBookAddForm() {
		var bookFormDiv = $('#books_form_div');
		$.mybooks.addBook({
			closeCallback : onBookAdded
		}, $("<div></div>").appendTo(bookFormDiv));
	}
	function removeWidgets() {
		var bookFormDiv = $('#books_form_div');
		bookFormDiv.empty();
		var booksDiv = $('#books_list_div');
		booksDiv.empty();
	}
</script>
</head>
<body>
	<div id="content" class="ui-widget">
		<h1 class="center">My Books Application</h1>
		<div id="books_list_div"></div>
		<div id="books_form_div"></div>
	</div>
</body>
</html>
