$(document).ready(
		function() {
			// $("#name").focus();
			$("#inputForm").validate(
					{
						submitHandler : function(form) {
							loading('正在提交，请稍等...');
							form.submit();
						},
						errorContainer : "#messageBox",
						errorPlacement : function(error, element) {
							$("#messageBox").text("输入有误，请先更正。");
							if (element.is(":checkbox") || element.is(":radio")
									|| element.parent().is(".input-append")) {
								error.appendTo(element.parent().parent());
							} else {
								error.insertAfter(element);
							}
						}
					});
			$('#attcategory').change(function(e) {
				var attrCategoryValue = $(e).val();
				$.getJSON("/shop/shopAttribute/category", function(data) {
					$(this).addClass("done");
				});
			})
		});
