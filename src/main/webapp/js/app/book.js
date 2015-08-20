
/*
 * 图书的私有js代码
 */
window.url = "";// 用于add与update的转换
function update(id) {
	$.ajax({
		type : "GET",
		url : "get.do",
		dataType : "json",
		data : {
			id : id
		},
		success : function(result) {
			if (result.success) {
				var item = result.item;
				var arr = $('#auModal form input');
				arr.each(function() {
					switch ($(this).attr('id')) {
					case 'id':
						$(this).val(item.id);
						break;
					case 'ISBN':
						$(this).val(item.ISBN);
						break;
					case 'bookName':
						$(this).val(item.bookName);
						break;
					case 'author':
						$(this).val(item.author);
						break;
					case 'publisher':
						$(this).val(item.publisher);
						break;
					case 'publishTime':
						$(this).val(item.publishTime);
						break;
					case 'type':
						$(this).val(item.type);
						break;
					case 'amount':
						$(this).val(item.amount);
						break;
					case 'borrowed':
						$(this).val(item.borrowed);
						break;
					case 'points':
						$(this).val(item.points);
						break;
					case 'brief':
						$(this).val(item.brief);
						break;
					case 'bookState':
						$(this).val(item.bookState);
						break;
					case 'commentNum':
						$(this).val(item.commentNum);
						break;
					case 'bookInputTime':
						$(this).val(DateFormat(item.bookInputTime));
						break;
					}
					$("#brief").text(item.brief);
					$("#type").val(item.type);
					window.url = "update.do";
				});
			}
		},
		error : function(jqXHR) {
			window.Modal.alert({msg:"发生错误：" + jqXHR.status});
		},
	});
}
function setData2Table(bookList) {
	var bookTBody = $('#listTable tbody');
	bookTBody.html('');
	var j=1;
	for (var i = 0; i < bookList.length; i++) {
		var tr = $("<tr/>");
		tr.html('<td>' +j
				+ '</td><td>' + bookList[i].ISBN 
				+ '</td><td>' + bookList[i].bookName
				+ '</td><td>' + bookList[i].author 
				+ '</td><td>' + bookList[i].publisher 
				+ '</td><td>' + bookList[i].publishTime
				+ '</td><td>' + bookList[i].type 
				+ '</td><td>' + bookList[i].amount 
				+ '</td><td>' + bookList[i].borrowed
				+ '</td><td>' + bookList[i].points 
				+ '</td><td>' + window.simplifyBrief(bookList[i].brief,8) + '</td><td>'
				+ '<a title="点击修改" href="#" onclick="javascript:update(\''
				+ bookList[i].id + '\');" data-toggle="modal" data-target="#auModal">修改</a>'
				+ '&nbsp;&nbsp;<a title="点击删除" href="#" onclick="javascript:del(\''
				+ bookList[i].id + '\');">删除</a></td>');
		tr.appendTo(bookTBody);
		j++;
	}
}

